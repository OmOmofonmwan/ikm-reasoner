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
  

package org.semanticweb.elk.reasoner.taxonomy;


import java.util.List;

import org.semanticweb.elk.owl.interfaces.ElkEntity;
import org.semanticweb.elk.reasoner.taxonomy.model.TaxonomyNode;

/**
 * @author Pavel Klinov
 * 
 *         pavel.klinov@uni-ulm.de
 *         
 * @param <T> 
 */
public class TaxonomyLinkConsistencyVisitor<T extends ElkEntity> implements TaxonomyNodeVisitor<T> {

	@Override
	public void visit(TaxonomyNode<T> node,
			List<TaxonomyNode<T>> pathFromStart) {
		// Check parent/child links are consistent
		for (TaxonomyNode<T> parent : node.getDirectSuperNodes()) {
			if (!parent.getDirectSubNodes().contains(node)) {
				String ln = System.getProperty("line.separator");

				throw new InvalidTaxonomyException(
						"Invalid taxonomy: the parent/child relationships between "
								+ ln + parent.toString() + ln + node.toString()
								+ ln + " are inconsistent");
			}
		}
	}
}