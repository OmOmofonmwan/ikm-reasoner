
package org.semanticweb.elk.reasoner.saturation.rules;



import org.semanticweb.elk.reasoner.saturation.rules.subsumers.SubsumerDecompositionVisitor;

/**
 * A collection of static methods for {@link RuleVisitor}s.
 * 
 * @author "Yevgeny Kazakov"
 *
 */
public class RuleVisitors {

	private static RuleVisitor<Boolean> LOCALITY_CHECKER_ = new RuleTracingCheckingVisitor();

	/**
	 * @param visitor
	 * @return A {@link RuleVisitor} that delegates the calls to the provided
	 *         {@link RuleVisitor} when for the {@link Rule} which accepts this
	 *         visitor, {@link Rule#isTracingRule()} returns {@code true}. Otherwise
	 *         the {@link RuleVisitor} returns {@code null}.
	 * 
	 * @see Rule#isTracingRule()
	 */
	public static <O> RuleVisitor<O> getTracingVisitor(RuleVisitor<O> visitor) {
		return new ConditionalRuleVisitor<O>(visitor, LOCALITY_CHECKER_);
	}

	/**
	 * @param visitor
	 *            the {@link SubsumerDecompositionVisitor} used to execute the
	 *            methods
	 * @param counter
	 *            the {@link RuleCounter} used to count the number of method
	 *            invocations
	 * @return a new {@link RuleVisitor} that delegates all methods to the given
	 *         {@link RuleVisitor} and counts the number of invocations of the
	 *         corresponding methods using the given {@link RuleCounter}.
	 */
	public static <O> RuleVisitor<O> getCountingVisitor(RuleVisitor<O> visitor,
			RuleCounter counter) {
		return new RuleCounterVisitor<O>(visitor, counter);
	}

	/**
	 * @param visitor
	 *            the {@link SubsumerDecompositionVisitor} used to execute the
	 *            methods
	 * @param timer
	 *            the {@link RuleApplicationTimer} used to mesure the time spent
	 *            within the methods
	 * 
	 * @return a new {@link SubsumerDecompositionVisitor} that executes the
	 *         corresponding methods of the given
	 *         {@link SubsumerDecompositionVisitor} and measures the time spent
	 *         within the corresponding methods using the given
	 *         {@link RuleApplicationTimer}.
	 */
	public static <O> RuleVisitor<O> getTimedVisitor(RuleVisitor<O> visitor,
			RuleApplicationTimer timer) {
		return new RuleApplicationTimerVisitor<O>(visitor, timer);
	}
}
