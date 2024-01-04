
package org.semanticweb.elk.matching.inferences;

import org.semanticweb.elk.matching.ElkMatchException;



import org.semanticweb.elk.matching.conclusions.ConclusionMatchExpressionFactory;
import org.semanticweb.elk.matching.conclusions.IndexedEquivalentClassesAxiomMatch2;
import org.semanticweb.elk.matching.conclusions.SubClassInclusionDecomposedMatch1;
import org.semanticweb.elk.matching.conclusions.SubClassInclusionDecomposedMatch1Watch;
import org.semanticweb.elk.owl.interfaces.ElkClass;
import org.semanticweb.elk.owl.interfaces.ElkClassExpression;

public class SubClassInclusionExpandedDefinitionMatch2 extends
		AbstractInferenceMatch<SubClassInclusionExpandedDefinitionMatch1>
		implements SubClassInclusionDecomposedMatch1Watch {

	private final ElkClass definedClassMatch_;

	private final ElkClassExpression definitionMatch_;

	SubClassInclusionExpandedDefinitionMatch2(
			SubClassInclusionExpandedDefinitionMatch1 parent,
			IndexedEquivalentClassesAxiomMatch2 secondPremiseMatch) {
		super(parent);
		ElkClassExpression firstMemberMatch = secondPremiseMatch
				.getFirstMemberMatch();
		if (firstMemberMatch instanceof ElkClass) {
			this.definedClassMatch_ = (ElkClass) secondPremiseMatch
					.getFirstMemberMatch();
		} else {
			throw new ElkMatchException(parent.getParent().getDefinedClass(),
					firstMemberMatch);
		}
		this.definitionMatch_ = secondPremiseMatch.getSecondMemberMatch();
		checkEquals(secondPremiseMatch, getSecondPremiseMatch(DEBUG_FACTORY));
	}

	public ElkClass getDefinedClassMatch() {
		return definedClassMatch_;
	}

	public ElkClassExpression getDefinitionMatch() {
		return definitionMatch_;
	}

	public SubClassInclusionDecomposedMatch1 getFirstPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getSubClassInclusionDecomposedMatch1(
				getParent().getParent().getFirstPremise(factory),
				getParent().getOriginMatch());
	}

	IndexedEquivalentClassesAxiomMatch2 getSecondPremiseMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getIndexedEquivalentClassesAxiomMatch2(
				getParent().getSecondPremiseMatch(factory),
				getDefinedClassMatch(), getDefinitionMatch());
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

		O visit(SubClassInclusionExpandedDefinitionMatch2 inferenceMatch2);

	}

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	public interface Factory {

		SubClassInclusionExpandedDefinitionMatch2 getSubClassInclusionExpandedDefinitionMatch2(
				SubClassInclusionExpandedDefinitionMatch1 parent,
				IndexedEquivalentClassesAxiomMatch2 secondPremiseMatch);

	}

}
