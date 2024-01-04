 
package org.semanticweb.elk.matching.inferences;

import org.semanticweb.elk.matching.ElkMatchException;



import org.semanticweb.elk.matching.conclusions.ConclusionMatchExpressionFactory;
import org.semanticweb.elk.matching.conclusions.ForwardLinkMatch1;
import org.semanticweb.elk.matching.conclusions.SubClassInclusionDecomposedMatch1;
import org.semanticweb.elk.matching.conclusions.SubClassInclusionDecomposedMatch1Watch;
import org.semanticweb.elk.matching.root.IndexedContextRootMatch;
import org.semanticweb.elk.owl.interfaces.ElkObjectProperty;
import org.semanticweb.elk.owl.interfaces.ElkSubObjectPropertyExpression;
import org.semanticweb.elk.reasoner.saturation.inferences.ForwardLinkOfObjectHasSelf;

public class ForwardLinkOfObjectHasSelfMatch1
		extends AbstractInferenceMatch<ForwardLinkOfObjectHasSelf>
		implements SubClassInclusionDecomposedMatch1Watch {

	private final IndexedContextRootMatch originMatch_;

	private final ElkObjectProperty forwardRelationMatch_;

	ForwardLinkOfObjectHasSelfMatch1(ForwardLinkOfObjectHasSelf parent,
			ForwardLinkMatch1 conclusionMatch) {
		super(parent);
		this.originMatch_ = conclusionMatch.getDestinationMatch();
		ElkSubObjectPropertyExpression fullChainMatch = conclusionMatch
				.getFullChainMatch();
		int startPos = conclusionMatch.getChainStartPos();
		if (fullChainMatch instanceof ElkObjectProperty
				&& conclusionMatch.getChainStartPos() == 0) {
			this.forwardRelationMatch_ = (ElkObjectProperty) fullChainMatch;
		} else {
			throw new ElkMatchException(
					getParent().getDecomposedExistential().getProperty(),
					fullChainMatch, startPos);
		}
		checkEquals(conclusionMatch, getConclusionMatch(DEBUG_FACTORY));
	}

	IndexedContextRootMatch getOriginMatch() {
		return originMatch_;
	}

	public ElkObjectProperty getForwardRelationMatch() {
		return forwardRelationMatch_;
	}

	ForwardLinkMatch1 getConclusionMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getForwardLinkMatch1(getParent().getConclusion(factory),
				getOriginMatch(), getForwardRelationMatch(), 0);
	}

	public SubClassInclusionDecomposedMatch1 getPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getSubClassInclusionDecomposedMatch1(
				getParent().getPremise(factory), originMatch_);
	}

	@Override
	public <O> O accept(InferenceMatch.Visitor<O> visitor) {
		return visitor.visit(this);
	}

	@Override
	public <O> O accept(
			SubClassInclusionDecomposedMatch1Watch.Visitor<O> visitor) {
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

		O visit(ForwardLinkOfObjectHasSelfMatch1 inferenceMatch1);

	}

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	public interface Factory {

		ForwardLinkOfObjectHasSelfMatch1 getForwardLinkOfObjectHasSelfMatch1(
				ForwardLinkOfObjectHasSelf parent,
				ForwardLinkMatch1 conclusionMatch);

	}

}
