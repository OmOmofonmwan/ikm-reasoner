
package org.semanticweb.elk.matching.inferences;



import org.semanticweb.elk.matching.conclusions.BackwardLinkMatch3;
import org.semanticweb.elk.matching.conclusions.BackwardLinkMatch3Watch;
import org.semanticweb.elk.matching.conclusions.ConclusionMatchExpressionFactory;
import org.semanticweb.elk.matching.conclusions.ForwardLinkMatch4;
import org.semanticweb.elk.matching.root.IndexedContextRootMatchChain;

public class BackwardLinkCompositionMatch8
		extends AbstractInferenceMatch<BackwardLinkCompositionMatch7>
		implements BackwardLinkMatch3Watch {

	private final IndexedContextRootMatchChain forwardChainExtendedDomains_;

	BackwardLinkCompositionMatch8(BackwardLinkCompositionMatch7 parent,
			ForwardLinkMatch4 thirdPremiseMatch) {
		super(parent);
		this.forwardChainExtendedDomains_ = thirdPremiseMatch
				.getExtendedDomains();
		checkEquals(thirdPremiseMatch, getThirdPremiseMatch(DEBUG_FACTORY));
	}

	public IndexedContextRootMatchChain getForwardChainExtendedDomains() {
		return forwardChainExtendedDomains_;
	}

	public BackwardLinkMatch3 getFirstPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getBackwardLinkMatch3(
				getParent().getParent().getParent().getParent().getParent()
						.getFirstPremiseMatch(factory),
				getForwardChainExtendedDomains().getHead());
	}

	ForwardLinkMatch4 getThirdPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getForwardLinkMatch4(
				getParent().getThirdPremiseMatch(factory),
				getForwardChainExtendedDomains());
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

		O visit(BackwardLinkCompositionMatch8 inferenceMatch8);

	}

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	public interface Factory {

		BackwardLinkCompositionMatch8 getBackwardLinkCompositionMatch8(
				BackwardLinkCompositionMatch7 parent,
				ForwardLinkMatch4 thirdPremiseMatch);

	}

}
