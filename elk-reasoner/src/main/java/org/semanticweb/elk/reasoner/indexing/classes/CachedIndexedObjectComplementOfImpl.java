
package org.semanticweb.elk.reasoner.indexing.classes;

import org.semanticweb.elk.reasoner.completeness.Feature;
import org.semanticweb.elk.reasoner.indexing.model.CachedIndexedClassExpression;
import org.semanticweb.elk.reasoner.indexing.model.CachedIndexedObjectComplementOf;
import org.semanticweb.elk.reasoner.indexing.model.IndexedClassExpression;
import org.semanticweb.elk.reasoner.indexing.model.ModifiableIndexedClassExpression;
import org.semanticweb.elk.reasoner.indexing.model.ModifiableOntologyIndex;
import org.semanticweb.elk.reasoner.indexing.model.OccurrenceIncrement;
import org.semanticweb.elk.reasoner.saturation.rules.subsumers.ContradictionFromNegationRule;

/**
 * Implements {@link CachedIndexedObjectComplementOf}
 * 
 * @author "Yevgeny Kazakov"
 * 
 */
class CachedIndexedObjectComplementOfImpl extends
		CachedIndexedComplexClassExpressionImpl<CachedIndexedObjectComplementOf>
		implements CachedIndexedObjectComplementOf {

	private final ModifiableIndexedClassExpression negated_;

	CachedIndexedObjectComplementOfImpl(
			ModifiableIndexedClassExpression negated) {
		super(CachedIndexedObjectComplementOf.Helper
				.structuralHashCode(negated));
		this.negated_ = negated;
	}

	@Override
	public final ModifiableIndexedClassExpression getNegated() {
		return negated_;
	}

	@Override
	public final CachedIndexedObjectComplementOf structuralEquals(
			Object other) {
		return CachedIndexedObjectComplementOf.Helper.structuralEquals(this,
				other);
	}

	@Override
	public final boolean updateOccurrenceNumbers(ModifiableOntologyIndex index,
			OccurrenceIncrement increment) {
		if (positiveOccurrenceNo == 0 && increment.positiveIncrement > 0) {
			// first positive occurrence of this expression
			if (!ContradictionFromNegationRule.addRulesFor(this, index))
				return false;
		}

		positiveOccurrenceNo += increment.positiveIncrement;
		negativeOccurrenceNo += increment.negativeIncrement;

		checkOccurrenceNumbers();

		if (positiveOccurrenceNo == 0 && increment.positiveIncrement < 0) {
			// no positive occurrences of this expression left
			if (!ContradictionFromNegationRule.removeRulesFor(this, index)) {
				// revert all changes
				positiveOccurrenceNo -= increment.positiveIncrement;
				negativeOccurrenceNo -= increment.negativeIncrement;
				return false;
			}
		}

		// negative occurrences not supported
		index.occurrenceChanged(
				Feature.OBJECT_COMPLEMENT_OF_NEGATIVE,
				increment.negativeIncrement);
		
		// positive occurrences may cause unsatisfiability of properties, which
		// is currently undetected
		index.occurrenceChanged(Feature.OBJECT_COMPLEMENT_OF_POSITIVE,
				increment.positiveIncrement);
		
		return true;
	}

	@Override
	public final <O> O accept(IndexedClassExpression.Visitor<O> visitor) {
		return visitor.visit(this);
	}

	@Override
	public CachedIndexedObjectComplementOf accept(
			CachedIndexedClassExpression.Filter filter) {
		return filter.filter(this);
	}

}
