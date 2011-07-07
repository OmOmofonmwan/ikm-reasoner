/*
 * #%L
 * elk-reasoner
 * 
 * $Id$
 * $HeadURL$
 * %%
 * Copyright (C) 2011 Department of Computer Science, University of Oxford
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.semanticweb.elk.reasoner.classification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.semanticweb.elk.reasoner.Reasoner;
import org.semanticweb.elk.reasoner.indexing.IndexedClass;
import org.semanticweb.elk.reasoner.indexing.IndexedClassExpression;
import org.semanticweb.elk.syntax.ElkClass;
import org.semanticweb.elk.util.AbstractConcurrentComputation;

public class ClassTaxonomyComputation
	extends AbstractConcurrentComputation<IndexedClass> {

	private enum HashCodeComparator implements Comparator<IndexedClass> {
		INSTANCE;
		
		public int compare(IndexedClass o1, IndexedClass o2) {
			return o1.hashCode() - o2.hashCode();
		}
	}
	
	protected final ConcurrentClassTaxonomy classTaxonomy;
	
	protected final static Logger logger = Logger.getLogger(Reasoner.class);
	
	private ClassNode topNode, bottomNode;
	
	private final Linker linker;
	
	private final boolean direct;
	
	public ClassTaxonomyComputation(ExecutorService executor, int maxWorkers, boolean direct) {
		super(executor, maxWorkers, 256, 512);
		this.classTaxonomy = new ConcurrentClassTaxonomy();
		this.linker = new Linker();
		this.direct = direct;
	}
	
	
	public ClassTaxonomy computeTaxonomy() {
		waitCompletion();
		
		topNode = classTaxonomy.getNode(ElkClass.ELK_OWL_THING);
		if (topNode == null) {
			topNode = new ClassNode(Collections.singletonList(ElkClass.ELK_OWL_THING));
			classTaxonomy.nodeLookup.put(ElkClass.ELK_OWL_THING, topNode);
		}
		bottomNode = classTaxonomy.getNode(ElkClass.ELK_OWL_NOTHING);
		if (bottomNode == null) {
			bottomNode = new ClassNode(Collections.singletonList(ElkClass.ELK_OWL_NOTHING));
			classTaxonomy.nodeLookup.put(ElkClass.ELK_OWL_NOTHING, bottomNode);
		}
		
		linker.start();
		linker.waitCompletion();
		
		for (ClassNode node : classTaxonomy.getNodes())
			if (node.getChildren().isEmpty() && node != bottomNode) {
				node.addChild(bottomNode);
				bottomNode.addParent(node);
			}
		
		return classTaxonomy;
	}
	
	
	protected ClassNode getNode(IndexedClass indexedClass) {
		return classTaxonomy.getNode(indexedClass.getElkClass());
	}
	
	
	protected void process(IndexedClass root) {
		List<ElkClass> equivalent = new ArrayList<ElkClass>();
		List<IndexedClass> parents = new LinkedList<IndexedClass> ();

		for (IndexedClassExpression superClassExpression : root.getSaturated().getSuperClassExpressions()) {
			if (superClassExpression instanceof IndexedClass) {
				IndexedClass superClass = (IndexedClass) superClassExpression;
				
				if (superClass.getSaturated().getSuperClassExpressions().contains(root)) {
					equivalent.add(superClass.getElkClass());
				} else if (!direct) {
					parents.add(superClass);
				} else {
					boolean addThis = true;
					Iterator<IndexedClass> i = parents.iterator();
					while (i.hasNext()) {
						IndexedClass last = i.next();
						if (last.getSaturated().getSuperClassExpressions().contains(superClass)) {
							addThis = false;
							break;
						}
						if (superClass.getSaturated().getSuperClassExpressions().contains(last)) {
							i.remove();
						}
					}
					if (addThis) {
						parents.add(superClass);
					}
				}
			}
		}
		
		if (!direct) {
			// Remove duplicate ancestors
			Collections.sort(parents, HashCodeComparator.INSTANCE);
			
			Iterator<IndexedClass> i = parents.iterator();
			IndexedClass last = null;
			while (i.hasNext()) {
				IndexedClass current = i.next();
				if (current == null) {
					i.remove();
					logger.error("null item removed from parent list");
				} else if (current.equals(last)) {
					i.remove();
				} else {
					last = current;
				}
			}
		}
		
		ElkClass rootElkClass = root.getElkClass(); 
		for (ElkClass ec : equivalent)
			// TODO comparison shouldn't be on hash code
			if (ec.hashCode() < rootElkClass.hashCode())
				return;
		
		ClassNode node = new ClassNode(equivalent);
		node.parentIndexClasses = parents;
		
		linker.submit(node);
		
		for (ElkClass ec : equivalent)
			classTaxonomy.nodeLookup.put(ec, node);
	}
	
	
	private class Linker extends AbstractConcurrentComputation<ClassNode> {

		public Linker() {
			super(ClassTaxonomyComputation.this.executor, ClassTaxonomyComputation.this.maxWorkers, 0, 0);
		}
		
		@Override 
		public void submit(ClassNode node) {
			buffer.add(node);
		}
		
		public void start() {
			for (int i = 0; i < maxWorkers; i++)
				addWorker();
		}

		@Override
		protected void process(ClassNode node) {
			if (node.parentIndexClasses.isEmpty() && node != topNode) {
				node.addParent(topNode);
				topNode.addChild(node);
			}
			
			for (IndexedClass ic : node.parentIndexClasses) {
				ClassNode parent = getNode(ic);
				node.addParent(parent);
				parent.addChild(node);
			}
			
			node.parentIndexClasses = null;
		}

	}
}