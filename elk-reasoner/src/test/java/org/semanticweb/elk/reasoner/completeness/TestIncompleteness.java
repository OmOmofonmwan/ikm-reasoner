package org.semanticweb.elk.reasoner.completeness;

/*-
 * #%L
 * ELK Reasoner Core
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2020 Department of Computer Science, University of Oxford
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

/**
 * Collection of additional static methods to work with incomplete reasoning
 * results
 * 
 * @author Yevgeny Kazakov
 * @see Incompleteness
 */
public class TestIncompleteness {

	/**
	 * Returns the value of the given {@link IncompleteResult} without producing
	 * warning messages
	 * 
	 * @param <R>
	 * @param result
	 * @return the value of the incomplete result without producing any log
	 *         messages
	 */
	public static <R> R getValue(IncompleteResult<? extends R> result) {
		return result.getValue();
	}

}
