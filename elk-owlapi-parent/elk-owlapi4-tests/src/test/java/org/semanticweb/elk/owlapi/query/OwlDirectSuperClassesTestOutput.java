/*
 * Copyright © 2023 Integrated Knowledge Management (support@ikm.dev)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.semanticweb.elk.owlapi.query;



import java.util.Collection;

import org.semanticweb.elk.owlapi.ElkReasoner;
import org.semanticweb.elk.reasoner.completeness.IncompleteResult;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.NodeSet;

import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

public class OwlDirectSuperClassesTestOutput extends
		OwlDirectRelatedEntitiesTestOutput<OWLClass, OwlDirectSuperClassesTestOutput> {

	private static OWLDataFactory FACTORY_ = new OWLDataFactoryImpl();

	private final OWLClassExpression query_;

	OwlDirectSuperClassesTestOutput(OWLClassExpression query,
			IncompleteResult<? extends Collection<? extends Node<OWLClass>>> incompleteDisjointNodes) {
		super(incompleteDisjointNodes);
		this.query_ = query;
	}

	OwlDirectSuperClassesTestOutput(OWLClassExpression query,
			Collection<? extends Node<OWLClass>> disjointNodes) {
		super(disjointNodes);
		this.query_ = query;
	}

	OwlDirectSuperClassesTestOutput(ElkReasoner reasoner,
			OWLClassExpression query) {
		this(query, reasoner.computeSuperClasses(query, true)
				.map(NodeSet::getNodes));
	}

	@Override
	protected OwlDirectRelatedEntitiesDiffable.Listener<OWLClass> adaptListener(
			Listener<OWLAxiom> listener) {
		return new OwlDirectRelatedEntitiesDiffable.Listener<OWLClass>() {

			@Override
			public void missingCanonical(OWLClass canonical) {
				listener.missing(
						FACTORY_.getOWLSubClassOfAxiom(query_, canonical));
			}

			@Override
			public void missingMember(OWLClass canonical, OWLClass member) {
				listener.missing(FACTORY_
						.getOWLEquivalentClassesAxiom(canonical, member));
			}

		};
	}

}
