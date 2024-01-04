
package org.semanticweb.elk.matching.inferences;



import org.semanticweb.elk.matching.conclusions.ConclusionMatchExpressionFactory;
import org.semanticweb.elk.matching.conclusions.SubClassInclusionComposedMatch2;
import org.semanticweb.elk.matching.root.IndexedContextRootMatch;

public class SubClassInclusionComposedObjectIntersectionOfMatch3 extends
		AbstractInferenceMatch<SubClassInclusionComposedObjectIntersectionOfMatch2> {

	private final IndexedContextRootMatch extendedExtendedOriginMatch_;

	SubClassInclusionComposedObjectIntersectionOfMatch3(
			SubClassInclusionComposedObjectIntersectionOfMatch2 parent,
			SubClassInclusionComposedMatch2 firstPremiseMatch) {
		super(parent);
		this.extendedExtendedOriginMatch_ = firstPremiseMatch
				.getExtendedDestinationMatch();
		checkEquals(firstPremiseMatch, getFirstPremiseMatch(DEBUG_FACTORY));
	}

	public IndexedContextRootMatch getExtendedExtendedOriginMatch() {
		return extendedExtendedOriginMatch_;
	}

	SubClassInclusionComposedMatch2 getFirstPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getSubClassInclusionComposedMatch2(
				getParent().getFirstPremiseMatch(factory),
				getExtendedExtendedOriginMatch());
	}

	public SubClassInclusionComposedMatch2 getConclusionMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getSubClassInclusionComposedMatch2(
				getParent().getParent().getConclusionMatch(factory),
				getExtendedExtendedOriginMatch());
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

		O visit(SubClassInclusionComposedObjectIntersectionOfMatch3 inferenceMatch3);

	}

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	public interface Factory {

		SubClassInclusionComposedObjectIntersectionOfMatch3 getSubClassInclusionComposedObjectIntersectionOfMatch3(
				SubClassInclusionComposedObjectIntersectionOfMatch2 parent,
				SubClassInclusionComposedMatch2 firstPremiseMatch);

	}

}
