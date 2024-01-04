
package org.semanticweb.elk.owl.inferences;



import java.util.ArrayList;
import java.util.List;

import org.semanticweb.elk.owl.interfaces.ElkClassExpression;
import org.semanticweb.elk.owl.interfaces.ElkObject;
import org.semanticweb.elk.owl.interfaces.ElkSubClassOfAxiom;

/**
 * Represents the inference:
 * 
 * <pre>
 * ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯ if L2 ⊆ L1
 *  ObjectIntersectionOf(L1) ⊑ ObjectIntersectionOf(L2)
 * </pre>
 * 
 * @author Yevgeny Kazakov
 *
 */
public class ElkClassInclusionObjectIntersectionOfInclusion
		extends AbstractElkInference {

	public final static String NAME = "Super-Intersection";

	/**
	 * list L1 that contain all class expressions
	 */
	private final List<? extends ElkClassExpression> subClasses_;

	/**
	 * corresponding positions of elements in L2 within L1
	 */
	private final List<Integer> superPositions_;

	ElkClassInclusionObjectIntersectionOfInclusion(
			List<? extends ElkClassExpression> subClasses,
			List<Integer> superPositions) {
		this.subClasses_ = subClasses;
		this.superPositions_ = superPositions;
	}

	public List<? extends ElkClassExpression> getSubClasses() {
		return subClasses_;
	}

	public List<Integer> getSuperPositions() {
		return superPositions_;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getPremiseCount() {
		return 0;
	}

	@Override
	public ElkSubClassOfAxiom getPremise(int index, ElkObject.Factory factory) {
		return failGetPremise(index);
	}

	@Override
	public ElkSubClassOfAxiom getConclusion(ElkObject.Factory factory) {
		List<ElkClassExpression> superClasses = new ArrayList<ElkClassExpression>(
				superPositions_.size());
		for (int pos : superPositions_) {
			superClasses.add(subClasses_.get(pos));
		}
		return factory.getSubClassOfAxiom(
				factory.getObjectIntersectionOf(subClasses_),
				factory.getObjectIntersectionOf(superClasses));
	}

	@Override
	public <O> O accept(ElkInference.Visitor<O> visitor) {
		return visitor.visit(this);
	}

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	public interface Factory {

		ElkClassInclusionObjectIntersectionOfInclusion getElkClassInclusionObjectIntersectionOfInclusion(
				List<? extends ElkClassExpression> subClasses,
				List<Integer> superPositions);

	}

	/**
	 * The visitor pattern for instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 * @param <O>
	 *            the type of the output
	 */
	interface Visitor<O> {

		O visit(ElkClassInclusionObjectIntersectionOfInclusion inference);

	}

}
