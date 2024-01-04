
package org.semanticweb.elk.reasoner.saturation.inferences;



import org.semanticweb.elk.owl.interfaces.ElkAxiom;
import org.semanticweb.elk.reasoner.indexing.model.IndexedContextRoot;
import org.semanticweb.elk.reasoner.indexing.model.IndexedObjectProperty;
import org.semanticweb.elk.reasoner.indexing.model.IndexedPropertyChain;
import org.semanticweb.elk.reasoner.indexing.model.IndexedSubObjectPropertyOfAxiom;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.BackwardLink;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.ForwardLink;
import org.semanticweb.elk.reasoner.tracing.Conclusion;
import org.semanticweb.elk.reasoner.tracing.Conclusion.Factory;

/**
 * A {@link ClassInference} producing a {@link BackwardLink} from a
 * {@link ForwardLink} and an {@link IndexedSubObjectPropertyOfAxiom}:<br>
 * 
 * <pre>
 *      (1)         (2)
 *  [C] ⊑ <∃P>.D  [P ⊑ R]
 * ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
 *       C ⊑ <∃R>.[D]
 * </pre>
 * 
 * The parameters can be obtained as follows:<br>
 * 
 * C = {@link #getOrigin()} = {@link #getConclusionSource()} <br>
 * P = {@link #getSubChain()}<br>
 * R = {@link #getConclusionRelation()}<br>
 * D = {@link #getDestination()}<br>
 * 
 * @see ForwardLink#getChain()
 * 
 * @author "Yevgeny Kazakov"
 * 
 */
public class BackwardLinkReversedExpanded
		extends AbstractBackwardLinkInference {

	/**
	 * The sub chain of the property of this link that occurs in the premise
	 * forward link
	 */
	private final IndexedPropertyChain subChain_;

	/**
	 * The {@link ElkAxiom} that yields the inclusion between {@link #subChain_}
	 * and backward relation
	 */
	private final ElkAxiom reason_;

	public BackwardLinkReversedExpanded(ForwardLink premise,
			IndexedObjectProperty superProperty, ElkAxiom reason) {
		super(premise.getTarget(), superProperty, premise.getDestination());
		this.subChain_ = premise.getChain();
		this.reason_ = reason;
	}

	@Override
	public IndexedContextRoot getOrigin() {
		return getTraceRoot();
	}

	public IndexedPropertyChain getSubChain() {
		return this.subChain_;
	}

	public ElkAxiom getReason() {
		return this.reason_;
	}

	public ForwardLink getFirstPremise(ForwardLink.Factory factory) {
		return factory.getForwardLink(getOrigin(), subChain_, getDestination());
	}

	public IndexedSubObjectPropertyOfAxiom getSecondPremise(
			IndexedSubObjectPropertyOfAxiom.Factory factory) {
		return factory.getIndexedSubObjectPropertyOfAxiom(reason_, subChain_,
				getConclusionRelation());
	}

	@Override
	public int getPremiseCount() {
		return 2;
	}

	@Override
	public Conclusion getPremise(int index, Factory factory) {
		switch (index) {
		case 0:
			return getFirstPremise(factory);
		case 1:
			return getSecondPremise(factory);
		default:
			return failGetPremise(index);
		}
	}

	@Override
	public final <O> O accept(BackwardLinkInference.Visitor<O> visitor) {
		return visitor.visit(this);
	}

	/**
	 * Visitor pattern for instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 * @param <O>
	 *            the type of the output
	 */
	public static interface Visitor<O> {

		public O visit(BackwardLinkReversedExpanded inference);

	}

}
