
package org.semanticweb.elk.reasoner.saturation.inferences;



import org.semanticweb.elk.reasoner.indexing.model.IndexedClassExpression;
import org.semanticweb.elk.reasoner.indexing.model.IndexedContextRoot;
import org.semanticweb.elk.reasoner.indexing.model.IndexedObjectIntersectionOf;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.SubClassInclusionComposed;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.SubClassInclusionDecomposed;
import org.semanticweb.elk.reasoner.tracing.Conclusion;
import org.semanticweb.elk.reasoner.tracing.Conclusion.Factory;

/**
 * A {@link ClassInference} producing a {@link SubClassInclusionDecomposed} from
 * a {@link SubClassInclusionDecomposed} with
 * {@link SubClassInclusionComposed#getSubsumer()} instance of
 * {@link IndexedObjectIntersectionOf}:<br>
 * 
 * <pre>
 *  [C] ⊑ -(D1 ⊓ D2)
 * ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯ D = D1 or D = D2
 *      [C] ⊑ -D
 * </pre>
 * 
 * @see IndexedObjectIntersectionOf#getFirstConjunct()
 * @see IndexedObjectIntersectionOf#getSecondConjunct()
 * 
 * @author Pavel Klinov
 * 
 *         pavel.klinov@uni-ulm.de
 * 
 * @author Yevgeny Kazakov
 */
public abstract class SubClassInclusionDecomposedConjunct
		extends AbstractSubClassInclusionDecomposedInference {

	private final IndexedObjectIntersectionOf conjunction_;

	public SubClassInclusionDecomposedConjunct(IndexedContextRoot root,
			IndexedObjectIntersectionOf premiseSubsumer,
			IndexedClassExpression conclusionSubsumer) {
		super(root, conclusionSubsumer);
		conjunction_ = premiseSubsumer;
	}

	public IndexedObjectIntersectionOf getConjunction() {
		return conjunction_;
	}

	@Override
	public IndexedContextRoot getOrigin() {
		return getDestination();
	}

	public SubClassInclusionDecomposed getPremise(
			SubClassInclusionDecomposed.Factory factory) {
		return factory.getSubClassInclusionDecomposed(getOrigin(),
				conjunction_);
	}

	@Override
	public int getPremiseCount() {
		return 1;
	}

	@Override
	public Conclusion getPremise(int index, Factory factory) {
		switch (index) {
		case 0:
			return getPremise(factory);
		default:
			return failGetPremise(index);
		}
	}

}
