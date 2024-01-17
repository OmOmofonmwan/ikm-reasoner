package org.semanticweb.elk.reasoner.indexing.classes;

/*-
 * #%L
 * ELK Reasoner Core
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2017 Department of Computer Science, University of Oxford
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

import org.semanticweb.elk.owl.interfaces.ElkObjectProperty;
import org.semanticweb.elk.reasoner.completeness.Feature;
import org.semanticweb.elk.reasoner.indexing.model.CachedIndexedOwlTopObjectProperty;
import org.semanticweb.elk.reasoner.indexing.model.ModifiableOntologyIndex;
import org.semanticweb.elk.reasoner.indexing.model.OccurrenceIncrement;

/**
 * Implements {@link CachedIndexedOwlTopObjectProperty}.
 * 
 * @author Peter Skocovsky
 */
public class CachedIndexedOwlTopObjectPropertyImpl
		extends CachedIndexedObjectPropertyImpl
		implements CachedIndexedOwlTopObjectProperty {

	CachedIndexedOwlTopObjectPropertyImpl(final ElkObjectProperty entity) {
		super(entity);
	}

	@Override
	public final boolean updateOccurrenceNumbers(
			final ModifiableOntologyIndex index,
			final OccurrenceIncrement increment) {
		if (super.updateOccurrenceNumbers(index, increment)) {

			// negative occurrences are unsupported
			index.occurrenceChanged(
					Feature.TOP_OBJECT_PROPERTY_NEGATIVE,
					increment.negativeIncrement);

			return true;
		}
		// else
		return false;
	}

}
