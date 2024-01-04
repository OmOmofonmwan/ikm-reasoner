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


package org.semanticweb.elk.reasoner.stages;


import org.semanticweb.elk.owl.interfaces.ElkClassExpression;
import org.semanticweb.elk.owl.interfaces.ElkObjectProperty;
import org.semanticweb.elk.owl.interfaces.ElkSubObjectPropertyExpression;
import org.semanticweb.elk.reasoner.indexing.model.IndexedClassExpression;
import org.semanticweb.elk.reasoner.indexing.model.IndexedObjectProperty;
import org.semanticweb.elk.reasoner.indexing.model.IndexedPropertyChain;
import org.semanticweb.elk.reasoner.saturation.context.Context;

/**
 * Provides access to package protected methods of {@link AbstractReasonerState}
 * for testing purposes.
 * 
 * @author Pavel Klinov
 * 
 *         pavel.klinov@uni-ulm.de
 */
public class ReasonerStateAccessor {
			
	@Deprecated
	public static IndexedClassExpression transform(AbstractReasonerState reasoner, ElkClassExpression ce) {
		return reasoner.transform(ce);
	}
	
	@Deprecated
	public static IndexedObjectProperty transform(AbstractReasonerState reasoner, ElkObjectProperty ce) {
		return reasoner.transform(ce);
	}
	
	@Deprecated
	public static IndexedPropertyChain transform(AbstractReasonerState reasoner, ElkSubObjectPropertyExpression ce) {
		return reasoner.transform(ce);
	}
	
	public static Context getContext(AbstractReasonerState reasoner, IndexedClassExpression ice) {
		return reasoner.saturationState.getContext(ice);
	}
	
}
