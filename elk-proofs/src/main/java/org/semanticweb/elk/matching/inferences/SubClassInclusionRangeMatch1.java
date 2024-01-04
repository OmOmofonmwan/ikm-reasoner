
package org.semanticweb.elk.matching.inferences;



import org.semanticweb.elk.matching.conclusions.ConclusionMatchExpressionFactory;
import org.semanticweb.elk.matching.conclusions.PropertyRangeMatch1;
import org.semanticweb.elk.matching.conclusions.PropertyRangeMatch1Watch;
import org.semanticweb.elk.matching.conclusions.SubClassInclusionDecomposedMatch1;
import org.semanticweb.elk.matching.root.IndexedContextRootMatch;
import org.semanticweb.elk.reasoner.saturation.inferences.SubClassInclusionRange;

public class SubClassInclusionRangeMatch1
		extends AbstractInferenceMatch<SubClassInclusionRange>
		implements PropertyRangeMatch1Watch {

	private final IndexedContextRootMatch originMatch_;

	SubClassInclusionRangeMatch1(final SubClassInclusionRange parent,
			SubClassInclusionDecomposedMatch1 conclusionMatch) {
		super(parent);
		originMatch_ = conclusionMatch.getDestinationMatch();
		checkEquals(conclusionMatch, getConclusionMatch(DEBUG_FACTORY));
	}

	public IndexedContextRootMatch getOriginMatch() {
		return originMatch_;
	}

	public PropertyRangeMatch1 getSecondPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory
				.getPropertyRangeMatch1(getParent().getSecondPremise(factory));
	}

	SubClassInclusionDecomposedMatch1 getConclusionMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getSubClassInclusionDecomposedMatch1(
				getParent().getConclusion(factory), originMatch_);
	}

	@Override
	public <O> O accept(InferenceMatch.Visitor<O> visitor) {
		return visitor.visit(this);
	}

	@Override
	public <O> O accept(PropertyRangeMatch1Watch.Visitor<O> visitor) {
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

		O visit(SubClassInclusionRangeMatch1 inferenceMatch1);

	}

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	public interface Factory {

		SubClassInclusionRangeMatch1 getSubClassInclusionRangeMatch1(
				SubClassInclusionRange parent,
				SubClassInclusionDecomposedMatch1 conclusionMatch);

	}

}
