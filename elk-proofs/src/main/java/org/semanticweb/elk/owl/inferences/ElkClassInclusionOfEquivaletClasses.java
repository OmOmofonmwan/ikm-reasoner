
package org.semanticweb.elk.owl.inferences;



import java.util.ArrayList;
import java.util.List;

import org.semanticweb.elk.owl.interfaces.ElkAxiom;
import org.semanticweb.elk.owl.interfaces.ElkClassExpression;
import org.semanticweb.elk.owl.interfaces.ElkEquivalentClassesAxiom;
import org.semanticweb.elk.owl.interfaces.ElkObject;
import org.semanticweb.elk.owl.interfaces.ElkSubClassOfAxiom;

/**
 * Represents the inference:
 * 
 * <pre>
 *  EquivalentClasses(C0 C1 ... Cn)
 * ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
 *           Ci ⊑ Cj
 * </pre>
 * 
 * @author Yevgeny Kazakov
 *
 */
public class ElkClassInclusionOfEquivaletClasses extends AbstractElkInference {

	public final static String NAME = "Equivalent Classes Decomposition";

	private final List<? extends ElkClassExpression> expressions_;

	/**
	 * positions for sub-class and super-class within class equivalence
	 */
	private final int subPos_, superPos_;

	ElkClassInclusionOfEquivaletClasses(
			List<? extends ElkClassExpression> expressions, int subPos,
			int superPos) {
		this.expressions_ = expressions;
		this.subPos_ = subPos;
		this.superPos_ = superPos;
	}

	ElkClassInclusionOfEquivaletClasses(ElkClassExpression first,
			ElkClassExpression second, boolean sameOrder) {
		List<ElkClassExpression> expressions = new ArrayList<ElkClassExpression>(
				2);
		expressions.add(first);
		expressions.add(second);
		this.expressions_ = expressions;
		if (sameOrder) {
			subPos_ = 0;
			superPos_ = 1;
		} else {
			subPos_ = 1;
			superPos_ = 0;
		}
	}

	public List<? extends ElkClassExpression> getExpressions() {
		return expressions_;
	}

	public int getSubPos() {
		return subPos_;
	}

	public int getSuperPos() {
		return superPos_;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getPremiseCount() {
		return 1;
	}

	@Override
	public ElkAxiom getPremise(int index, ElkObject.Factory factory) {
		if (index == 0) {
			return getPremise(factory);
		}
		// else
		return failGetPremise(index);
	}

	public ElkEquivalentClassesAxiom getPremise(ElkObject.Factory factory) {
		return factory.getEquivalentClassesAxiom(expressions_);
	}

	@Override
	public ElkSubClassOfAxiom getConclusion(ElkObject.Factory factory) {
		return factory.getSubClassOfAxiom(expressions_.get(subPos_),
				expressions_.get(superPos_));
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

		ElkClassInclusionOfEquivaletClasses getElkClassInclusionOfEquivaletClasses(
				List<? extends ElkClassExpression> expressions, int subPos,
				int superPos);

		ElkClassInclusionOfEquivaletClasses getElkClassInclusionOfEquivaletClasses(
				ElkClassExpression first, ElkClassExpression second,
				boolean sameOrder);

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

		O visit(ElkClassInclusionOfEquivaletClasses inference);

	}

}
