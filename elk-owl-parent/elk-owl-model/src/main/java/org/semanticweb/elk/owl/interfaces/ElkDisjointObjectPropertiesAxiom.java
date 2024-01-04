
/**
 * @author Markus Kroetzsch, Aug 8, 2011
 */
package org.semanticweb.elk.owl.interfaces;

import java.util.List;

import org.semanticweb.elk.owl.visitors.ElkDisjointObjectPropertiesAxiomVisitor;

/**
 * Corresponds to an
 * <a href= "http://www.w3.org/TR/owl2-syntax/#Disjoint_Object_Properties">
 * Disjoint Object Properties Axiom<a> in the OWL 2 specification.
 * 
 * @author Markus Kroetzsch
 */
public interface ElkDisjointObjectPropertiesAxiom
		extends ElkObjectPropertyAxiom {

	/**
	 * Get the list of disjoint object property expressions that this axiom
	 * refers to. The order of object property expressions does not affect the
	 * semantics but it is relevant to the syntax of OWL.
	 * 
	 * @return list of disjoint object property expressions
	 */
	public List<? extends ElkObjectPropertyExpression> getObjectPropertyExpressions();

	/**
	 * Accept an {@link ElkDisjointObjectPropertiesAxiomVisitor}.
	 * 
	 * @param visitor
	 *            the visitor that can work with this axiom type
	 * @return the output of the visitor
	 */
	public abstract <O> O accept(
			ElkDisjointObjectPropertiesAxiomVisitor<O> visitor);

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	interface Factory {

		/**
		 * Create an {@link ElkDisjointObjectPropertiesAxiom}.
		 * 
		 * @param first
		 *            the first {@link ElkObjectPropertyExpression} for which
		 *            the axiom should be created
		 * @param second
		 *            the second {@link ElkObjectPropertyExpression} for which
		 *            the axiom should be created
		 * @param other
		 *            other {@link ElkObjectPropertyExpression}s for which the
		 *            axiom should be created
		 * @return an {@link ElkDisjointObjectPropertiesAxiom} corresponding to
		 *         the input
		 */
		public ElkDisjointObjectPropertiesAxiom getDisjointObjectPropertiesAxiom(
				ElkObjectPropertyExpression first,
				ElkObjectPropertyExpression second,
				ElkObjectPropertyExpression... other);

		/**
		 * Create an {@link ElkDisjointObjectPropertiesAxiom}.
		 * 
		 * @param disjointObjectPropertyExpressions
		 *            the {@link ElkObjectPropertyExpression}s for which the
		 *            axiom should be created
		 * @return an {@link ElkDisjointObjectPropertiesAxiom} corresponding to
		 *         the input
		 */
		public ElkDisjointObjectPropertiesAxiom getDisjointObjectPropertiesAxiom(
				List<? extends ElkObjectPropertyExpression> disjointObjectPropertyExpressions);

	}

}
