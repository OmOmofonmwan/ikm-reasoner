
package org.semanticweb.elk.reasoner.saturation.conclusions.classes;

import org.semanticweb.elk.reasoner.indexing.model.IndexedClassExpression;
import org.semanticweb.elk.reasoner.indexing.model.IndexedClassExpressionList;
import org.semanticweb.elk.reasoner.indexing.model.IndexedContextRoot;
import org.semanticweb.elk.reasoner.indexing.model.IndexedObjectProperty;
import org.semanticweb.elk.reasoner.indexing.model.IndexedObjectSomeValuesFrom;
import org.semanticweb.elk.reasoner.indexing.model.IndexedPropertyChain;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.BackwardLink;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.ClassInconsistency;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.ContextInitialization;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.DisjointSubsumer;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.ForwardLink;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.Propagation;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.PropertyRange;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.SaturationConclusion;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.SubClassInclusionComposed;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.SubClassInclusionDecomposed;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.SubContextInitialization;
import org.semanticweb.elk.reasoner.saturation.conclusions.model.SubPropertyChain;

public class SaturationConclusionBaseFactory
		implements
			SaturationConclusion.Factory {

	private static final SaturationConclusion.Factory INSTANCE_ = new SaturationConclusionBaseFactory();

	public static SaturationConclusion.Factory getInstance() {
		return INSTANCE_;
	}

	@Override
	public BackwardLink getBackwardLink(IndexedContextRoot root,
			IndexedObjectProperty relation, IndexedContextRoot source) {
		return new BackwardLinkImpl(root, relation, source);
	}

	@Override
	public ContextInitialization getContextInitialization(
			IndexedContextRoot root) {
		return new ContextInitializationImpl(root);
	}

	@Override
	public ClassInconsistency getContradiction(IndexedContextRoot destination) {
		return new ClassInconsistencyImpl(destination);
	}

	@Override
	public DisjointSubsumer getDisjointSubsumer(IndexedContextRoot root,
			IndexedClassExpressionList disjointExpressions, int position) {
		return new DisjointSubsumerImpl(root, disjointExpressions, position);
	}

	@Override
	public ForwardLink getForwardLink(IndexedContextRoot root,
			IndexedPropertyChain forwardChain, IndexedContextRoot target) {
		return new ForwardLinkImpl<IndexedPropertyChain>(root, forwardChain,
				target);
	}

	@Override
	public Propagation getPropagation(IndexedContextRoot root,
			IndexedObjectProperty relation, IndexedObjectSomeValuesFrom carry) {
		return new PropagationImpl(root, relation, carry);
	}

	@Override
	public PropertyRange getPropertyRange(IndexedObjectProperty property,
			IndexedClassExpression range) {
		return new PropertyRangeImpl(property, range);
	}

	@Override
	public SubClassInclusionComposed getSubClassInclusionComposed(
			IndexedContextRoot subExpression,
			IndexedClassExpression superExpression) {
		return new SubClassInclusionComposedImpl<IndexedClassExpression>(
				subExpression, superExpression);
	}

	@Override
	public SubClassInclusionDecomposed getSubClassInclusionDecomposed(
			IndexedContextRoot subExpression,
			IndexedClassExpression superExpression) {
		return new SubClassInclusionDecomposedImpl(subExpression,
				superExpression);
	}

	@Override
	public SubContextInitialization getSubContextInitialization(
			IndexedContextRoot root, IndexedObjectProperty subRoot) {
		return new SubContextInitializationImpl(root, subRoot);
	}

	@Override
	public SubPropertyChain getSubPropertyChain(IndexedPropertyChain subChain,
			IndexedPropertyChain superChain) {
		return new SubPropertyChainImpl(subChain, superChain);
	}

}
