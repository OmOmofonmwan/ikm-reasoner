
package org.semanticweb.elk.matching.inferences;



import java.util.Collections;

import org.semanticweb.elk.matching.conclusions.ConclusionMatchExpressionFactory;
import org.semanticweb.elk.matching.conclusions.SubClassInclusionDecomposedMatch1;
import org.semanticweb.elk.matching.conclusions.SubClassInclusionDecomposedMatch2;
import org.semanticweb.elk.matching.root.IndexedContextRootMatch;
import org.semanticweb.elk.owl.interfaces.ElkClassExpression;

public class SubClassInclusionDecomposedEmptyObjectIntersectionOfMatch1
		extends AbstractSubClassInclusionDecomposedCanonizerMatch1 {

	SubClassInclusionDecomposedEmptyObjectIntersectionOfMatch1(
			SubClassInclusionDecomposedMatch1 parent,
			IndexedContextRootMatch extendedDestinationMatch) {
		super(parent, extendedDestinationMatch);
	}

	@Override
	SubClassInclusionDecomposedMatch2 getPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getSubClassInclusionDecomposedMatch2(getParent(),
				getExtendedDestinationMatch(), factory.getObjectIntersectionOf(
						Collections.<ElkClassExpression> emptyList()));

	}

	@Override
	public SubClassInclusionDecomposedMatch2 getConclusionMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getSubClassInclusionDecomposedMatch2(getParent(),
				getExtendedDestinationMatch(), factory.getOwlThing());
	}

	@Override
	public <O> O accept(InferenceMatch.Visitor<O> visitor) {
		return visitor.visit(this);
	}

	/**
	 * The visitor pattern for instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 * @param <O>
	 *            the type of the output
	 */
	public interface Visitor<O> {

		O visit(SubClassInclusionDecomposedEmptyObjectIntersectionOfMatch1 inferenceMatch1);

	}

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	public interface Factory {

		SubClassInclusionDecomposedEmptyObjectIntersectionOfMatch1 getSubClassInclusionDecomposedEmptyObjectIntersectionOfMatch1(
				SubClassInclusionDecomposedMatch1 parent,
				IndexedContextRootMatch extendedDestinationMatch);

	}

}
