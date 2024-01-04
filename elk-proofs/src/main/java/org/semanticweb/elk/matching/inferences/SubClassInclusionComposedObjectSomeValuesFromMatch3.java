
package org.semanticweb.elk.matching.inferences;

import org.semanticweb.elk.matching.conclusions.BackwardLinkMatch3;
import org.semanticweb.elk.matching.conclusions.BackwardLinkMatch3Watch;



import org.semanticweb.elk.matching.conclusions.ConclusionMatchExpressionFactory;
import org.semanticweb.elk.matching.conclusions.PropagationMatch2;
import org.semanticweb.elk.matching.root.IndexedContextRootMatch;

public class SubClassInclusionComposedObjectSomeValuesFromMatch3 extends
		AbstractInferenceMatch<SubClassInclusionComposedObjectSomeValuesFromMatch2>
		implements BackwardLinkMatch3Watch {

	private final IndexedContextRootMatch extendedOriginMatch_;

	SubClassInclusionComposedObjectSomeValuesFromMatch3(
			SubClassInclusionComposedObjectSomeValuesFromMatch2 parent,
			PropagationMatch2 secondPremiseMatch) {
		super(parent);
		this.extendedOriginMatch_ = secondPremiseMatch
				.getExtendedDestinationMatch();
		checkEquals(secondPremiseMatch, getSecondPremiseMatch(DEBUG_FACTORY));
	}

	public IndexedContextRootMatch getExtendedOriginMatch() {
		return extendedOriginMatch_;
	}

	public BackwardLinkMatch3 getFirstPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getBackwardLinkMatch3(
				getParent().getFirstPremiseMatch(factory),
				getExtendedOriginMatch());
	}

	PropagationMatch2 getSecondPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getPropagationMatch2(
				getParent().getSecondPremiseMatch(factory),
				getExtendedOriginMatch());
	}

	@Override
	public <O> O accept(InferenceMatch.Visitor<O> visitor) {
		return visitor.visit(this);
	}

	@Override
	public <O> O accept(BackwardLinkMatch3Watch.Visitor<O> visitor) {
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

		O visit(SubClassInclusionComposedObjectSomeValuesFromMatch3 inferenceMatch3);

	}

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	public interface Factory {

		SubClassInclusionComposedObjectSomeValuesFromMatch3 getSubClassInclusionComposedObjectSomeValuesFromMatch3(
				SubClassInclusionComposedObjectSomeValuesFromMatch2 parent,
				PropagationMatch2 secondPremiseMatch);

	}

}
