
package org.semanticweb.elk.owl.interfaces;

import java.util.List;

import org.semanticweb.elk.owl.visitors.ElkDatatypeRestrictionVisitor;

/**
 * Corresponds to an <a href=
 * "http://www.w3.org/TR/owl2-syntax/#Datatype_Restrictions">Datatype
 * Restrictions<a> in the OWL 2 specification.
 * 
 * @author Markus Kroetzsch
 */
public interface ElkDatatypeRestriction extends ElkDataRange {

	/**
	 * Get the main datatype of this datatype restriction.
	 * 
	 * @return The datatype of this datatype restriction.
	 */
	public ElkDatatype getDatatype();

	/**
	 * Get the facet restrictions of this datatype restriction.
	 * 
	 * @return The facet restrictions of this datatype restriction.
	 */
	public List<? extends ElkFacetRestriction> getFacetRestrictions();

	/**
	 * Accept an {@link ElkDatatypeRestrictionVisitor}.
	 * 
	 * @param visitor
	 *            the visitor that can work with this object type
	 * @return the output of the visitor
	 */
	public <O> O accept(ElkDatatypeRestrictionVisitor<O> visitor);

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	interface Factory {

		/**
		 * Create an {@link ElkDatatypeRestriction}.
		 * 
		 * @param datatype
		 *            the {@link ElkDatatype} for which the object should be created
		 * @param restrictions
		 *            the {@link ElkFacetRestriction}s for which the object should
		 *            be created
		 * @return an {@link ElkDatatypeRestriction} corresponding to the input
		 */
		public ElkDatatypeRestriction getDatatypeRestriction(ElkDatatype datatype,
				List<ElkFacetRestriction> restrictions);

	}
	
}
