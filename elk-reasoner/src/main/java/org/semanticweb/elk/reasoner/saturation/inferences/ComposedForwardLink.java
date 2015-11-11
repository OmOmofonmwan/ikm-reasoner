/**
 * 
 */
package org.semanticweb.elk.reasoner.saturation.inferences;

/*
 * #%L
 * ELK Reasoner
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2013 Department of Computer Science, University of Oxford
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

import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedComplexPropertyChain;
import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedContextRoot;
import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedObjectProperty;
import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedPropertyChain;
import org.semanticweb.elk.reasoner.saturation.conclusions.interfaces.BackwardLink;
import org.semanticweb.elk.reasoner.saturation.conclusions.interfaces.ForwardLink;
import org.semanticweb.elk.reasoner.saturation.conclusions.interfaces.SubPropertyChain;
import org.semanticweb.elk.reasoner.saturation.inferences.visitors.ForwardLinkInferenceVisitor;

/**
 * A {@link ForwardLink} produced by a {@link LinkComposition} inference
 * 
 * @author "Yevgeny Kazakov"
 * 
 * @param <R>
 *            The type of the forward relation
 */
public class ComposedForwardLink extends
		AbstractForwardLinkInference<IndexedComplexPropertyChain> implements
		LinkComposition {

	private final IndexedObjectProperty backwardRelation_;

	private final IndexedContextRoot inferenceRoot_;

	private final IndexedPropertyChain forwardChain_;

	public ComposedForwardLink(IndexedContextRoot originRoot,
			IndexedObjectProperty backwardRelation,
			IndexedContextRoot inferenceRoot,
			IndexedPropertyChain forwardChain, IndexedContextRoot targetRoot,
			IndexedComplexPropertyChain composition) {
		super(originRoot, composition, targetRoot);
		this.backwardRelation_ = backwardRelation;
		this.inferenceRoot_ = inferenceRoot;
		this.forwardChain_ = forwardChain;
	}

	@Override
	public IndexedObjectProperty getPremiseBackwardRelation() {
		return backwardRelation_;
	}

	@Override
	public IndexedPropertyChain getPremiseForwardChain() {
		return forwardChain_;
	}

	@Override
	public IndexedComplexPropertyChain getComposition() {
		return getForwardChain();
	}

	@Override
	public IndexedContextRoot getInferenceRoot() {
		return inferenceRoot_;
	}

	@Override
	public BackwardLink getFirstPremise(BackwardLink.Factory factory) {
		return factory.getBackwardLink(getInferenceRoot(), backwardRelation_,
				getConclusionRoot());
	}

	@Override
	public SubPropertyChain getSecondPremise(SubPropertyChain.Factory factory) {
		return factory.getSubPropertyChain(backwardRelation_, getComposition()
				.getFirstProperty());
	}

	@Override
	public ForwardLink getThirdPremise(ForwardLink.Factory factory) {
		return factory.getForwardLink(getInferenceRoot(), forwardChain_,
				getTarget());
	}

	@Override
	public SubPropertyChain getFourthPremise(SubPropertyChain.Factory factory) {
		return factory.getSubPropertyChain(forwardChain_,
				getComposition().getSuffixChain());
	}

	@Override
	public String toString() {
		return super.toString() + " (composition)";
	}

	@Override
	public <I, O> O accept(ForwardLinkInferenceVisitor<I, O> visitor, I input) {
		return visitor.visit(this, input);
	}

}
