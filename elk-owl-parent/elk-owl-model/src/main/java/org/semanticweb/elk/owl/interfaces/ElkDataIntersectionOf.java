
/**
 * @author Markus Kroetzsch, Aug 8, 2011
 */
package org.semanticweb.elk.owl.interfaces;

import java.util.List;

import org.semanticweb.elk.owl.visitors.ElkDataIntersectionOfVisitor;

/**
 * Corresponds to an
 * <a href= "http://www.w3.org/TR/owl2-syntax/#Intersection_of_Data_Ranges" >
 * Intersection of Data Ranges<a> in the OWL 2 specification.
 * 
 * @author Markus Kroetzsch
 */
public interface ElkDataIntersectionOf extends ElkDataRange {

	/**
	 * Get the list of data ranges that this expression refers to. The order of
	 * data ranges does not affect the semantics but it is relevant to the
	 * syntax of OWL.
	 * 
	 * @return list of data ranges
	 */
	public List<? extends ElkDataRange> getDataRanges();

	/**
	 * Accept an {@link ElkDataIntersectionOfVisitor}.
	 * 
	 * @param visitor
	 *            the visitor that can work with this object type
	 * @return the output of the visitor
	 */
	public <O> O accept(ElkDataIntersectionOfVisitor<O> visitor);

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	interface Factory {

		/**
		 * Create an {@link ElkDataIntersectionOf}.
		 * 
		 * @param first
		 *            the first {@link ElkDataRange} for which the object should
		 *            be created
		 * @param second
		 *            the second {@link ElkDataRange} for which the object
		 *            should be created
		 * @param other
		 *            the {@link ElkDataRange} for which the object should be
		 *            created
		 * @return an {@link ElkDataIntersectionOf} corresponding to the input
		 */
		public ElkDataIntersectionOf getDataIntersectionOf(
				ElkDataRange first, ElkDataRange second,
				ElkDataRange... other);

		/**
		 * Create an {@link ElkDataIntersectionOf}.
		 * 
		 * @param ranges
		 *            the {@link ElkDataRange}s for which the object should be
		 *            created
		 * @return an {@link ElkDataIntersectionOf} corresponding to the input
		 */
		public ElkDataIntersectionOf getDataIntersectionOf(
				List<? extends ElkDataRange> ranges);

	}

}
