/*
 * #%L
 * ELK Reasoner
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
package org.semanticweb.elk.owl.interfaces;

import org.semanticweb.elk.owl.visitors.ElkDataComplementOfVisitor;

/**
 * Corresponds to the
 * <a href= "http://www.w3.org/TR/owl2-syntax/#Complement_of_Data_Ranges" >
 * complement of a data range<a> in the OWL 2 specification.
 * 
 * @author Markus Kroetzsch
 */
public interface ElkDataComplementOf extends ElkDataRange {

	/**
	 * Get the data range that this expression refers to.
	 * 
	 * @return data range
	 */
	public ElkDataRange getDataRange();

	/**
	 * Accept an {@link ElkDataComplementOfVisitor}.
	 * 
	 * @param visitor
	 *            the visitor that can work with this object type
	 * @return the output of the visitor
	 */
	public abstract <O> O accept(ElkDataComplementOfVisitor<O> visitor);

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	interface Factory {

		/**
		 * Create an {@link ElkDataComplementOf}.
		 * 
		 * @param range
		 *            the {@link ElkDataRange} for which the object should be
		 *            created
		 * @return an {@link ElkDataComplementOf} corresponding to the input
		 */
		public ElkDataComplementOf getDataComplementOf(ElkDataRange range);

	}

}
