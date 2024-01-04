
package org.semanticweb.elk.owl.inferences;



import java.util.ArrayList;
import java.util.List;

import org.semanticweb.elk.owl.interfaces.ElkClassExpression;
import org.semanticweb.elk.owl.interfaces.ElkEquivalentClassesAxiom;
import org.semanticweb.elk.owl.interfaces.ElkObject;
import org.semanticweb.elk.owl.interfaces.ElkSubClassOfAxiom;

/**
 * Represents the inference:
 * 
 * <pre>
 *    (1)           (n)     (n+1)
 *  C0 ⊑ C1 ... Cn-1 ⊑ Cn  Cn ⊑ C0
 * ⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
 *  EquivalentClasses(C0 C1 ... Cn)
 * </pre>
 * 
 * @author Yevgeny Kazakov
 *
 */
public class ElkEquivalentClassesCycle extends AbstractElkInference {

	public final static String NAME = "Class Inclusion Cycle";

	private final List<? extends ElkClassExpression> expressions_;

	ElkEquivalentClassesCycle(List<? extends ElkClassExpression> expressions) {
		this.expressions_ = expressions;
	}

	ElkEquivalentClassesCycle(ElkClassExpression first,
			ElkClassExpression second) {
		List<ElkClassExpression> expressions = new ArrayList<ElkClassExpression>(
				3);
		expressions.add(first);
		expressions.add(second);
		this.expressions_ = expressions;
	}

	public List<? extends ElkClassExpression> getExpressions() {
		return expressions_;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public int getPremiseCount() {
		return expressions_.size();
	}

	@Override
	public ElkSubClassOfAxiom getPremise(int index, ElkObject.Factory factory) {
		checkPremiseIndex(index);
		int first = index, second = index + 1;
		if (second == expressions_.size()) {
			second = 0;
		}
		return factory.getSubClassOfAxiom(expressions_.get(first),
				expressions_.get(second));
	}

	@Override
	public ElkEquivalentClassesAxiom getConclusion(ElkObject.Factory factory) {
		return factory.getEquivalentClassesAxiom(expressions_);
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

		ElkEquivalentClassesCycle getElkEquivalentClassesCycle(
				List<? extends ElkClassExpression> expressions);

		ElkEquivalentClassesCycle getElkEquivalentClassesCycle(
				ElkClassExpression first, ElkClassExpression second);

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

		O visit(ElkEquivalentClassesCycle inference);

	}

}
