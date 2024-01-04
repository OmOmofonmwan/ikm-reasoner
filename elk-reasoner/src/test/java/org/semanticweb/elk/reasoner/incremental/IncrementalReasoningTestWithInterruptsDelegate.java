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
  
package org.semanticweb.elk.reasoner.incremental;

import org.semanticweb.elk.reasoner.ReasoningTestWithInterruptsDelegate;

/**
 * Test delegate for incremental tests with interrupts.
 * 
 * @author Peter Skocovsky
 *
 * @param <A>
 *            The type of axioms that are added or removed from the input
 *            ontology.
 * @param <O>
 *            The type of test output.
 */
public interface IncrementalReasoningTestWithInterruptsDelegate<A, O>
		extends IncrementalReasoningTestDelegate<A, O>,
		ReasoningTestWithInterruptsDelegate<O> {

	// combined interface
	
}
