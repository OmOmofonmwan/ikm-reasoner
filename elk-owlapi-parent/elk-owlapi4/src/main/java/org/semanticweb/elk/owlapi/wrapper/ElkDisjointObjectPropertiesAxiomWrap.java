/*
 * This product is dual-licensed under Apache 2.0 License for two organizations due to forking.
 *
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
 *
 * ======================================================================
 *
 * Copyright © 2011 - 2023 Department of Computer Science, University of Oxford
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
package org.semanticweb.elk.owlapi.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.semanticweb.elk.owl.interfaces.ElkDisjointObjectPropertiesAxiom;
import org.semanticweb.elk.owl.interfaces.ElkObjectPropertyExpression;
import org.semanticweb.elk.owl.visitors.ElkDisjointObjectPropertiesAxiomVisitor;
import org.semanticweb.elk.owl.visitors.ElkObjectPropertyAxiomVisitor;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;

/**
 * Implements the {@link ElkDisjointObjectPropertiesAxiom} interface by wrapping
 * instances of {@link OWLDisjointObjectPropertiesAxiom}
 * 
 * @author Yevgeny Kazakov
 * 
 * @param <T>
 *            the type of the wrapped object
 */
public class ElkDisjointObjectPropertiesAxiomWrap<T extends OWLDisjointObjectPropertiesAxiom>
		extends ElkObjectPropertyAxiomWrap<T> implements
		ElkDisjointObjectPropertiesAxiom {

	public ElkDisjointObjectPropertiesAxiomWrap(
			T owlDisjointObjectPropertiesAxiom) {
		super(owlDisjointObjectPropertiesAxiom);
	}

	@Override
	public List<? extends ElkObjectPropertyExpression> getObjectPropertyExpressions() {
		List<ElkObjectPropertyExpression> result = new ArrayList<ElkObjectPropertyExpression>();
		for (OWLObjectPropertyExpression ope : this.owlObject.getProperties()) {
			result.add(converter.convert(ope));
		}
		return result;
	}

	@Override
	public <O> O accept(ElkObjectPropertyAxiomVisitor<O> visitor) {
		return accept((ElkDisjointObjectPropertiesAxiomVisitor<O>) visitor);
	}

	@Override
	public <O> O accept(ElkDisjointObjectPropertiesAxiomVisitor<O> visitor) {
		return visitor.visit(this);
	}

}
