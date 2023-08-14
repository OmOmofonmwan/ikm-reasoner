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
package org.semanticweb.elk.reasoner;

import org.semanticweb.elk.exceptions.ElkException;

/**
 * Thrown when irrelevant reasoning methods are called for an ontology that is
 * inconsistent. Most reasoning tasks also have well-defined results for
 * inconsistent ontologies, so it is not required that this exception is used in
 * all cases. Callers should not rely on this exception being thrown as a method
 * for checking inconsistency; there are dedicated methods for this purpose.
 * 
 * @author Markus Kroetzsch
 * @author "Yevgeny Kazakov"
 * 
 */
public class ElkInconsistentOntologyException extends ElkException {

	private static final long serialVersionUID = -8696304480425201859L;

	public ElkInconsistentOntologyException() {
		super();
	}

	public ElkInconsistentOntologyException(String message) {
		super(message);
	}

	public ElkInconsistentOntologyException(String message, Throwable cause) {
		super(message, cause);
	}

	public ElkInconsistentOntologyException(Throwable cause) {
		super(cause);
	}

}
