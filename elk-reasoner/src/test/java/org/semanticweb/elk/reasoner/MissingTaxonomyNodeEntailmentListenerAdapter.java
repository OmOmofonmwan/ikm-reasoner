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
package org.semanticweb.elk.reasoner;



import org.semanticweb.elk.owl.interfaces.ElkEntity;
import org.semanticweb.elk.reasoner.taxonomy.model.TaxonomyNode;

class MissingTaxonomyNodeEntailmentListenerAdapter<M extends ElkEntity>
		implements TaxonomyNodeEntailment.Listener<M> {

	private final TaxonomyNode<M> node_;
	private final TaxonomyEntailment.Listener<M> listener_;

	MissingTaxonomyNodeEntailmentListenerAdapter(TaxonomyNode<M> node,
			TaxonomyEntailment.Listener<M> listener) {
		this.node_ = node;
		this.listener_ = listener;
	}

	@Override
	public void reportMissingMember(M member) {
		listener_.reportMissingEquivalence(node_.getCanonicalMember(), member);
	}

	@Override
	public void reportMissingDirectSubsumer(M subsumer) {
		listener_.reportMissingSubsumption(node_.getCanonicalMember(),
				subsumer);
	}

}
