
package org.semanticweb.elk.reasoner.saturation.rules.factories;

import org.semanticweb.elk.ModifiableReference;
import org.semanticweb.elk.reasoner.saturation.SaturationStatistics;
import org.semanticweb.elk.reasoner.saturation.context.Context;
import org.semanticweb.elk.reasoner.saturation.context.ContextStatistics;
import org.semanticweb.elk.reasoner.saturation.inferences.ClassInference;
import org.semanticweb.elk.util.concurrent.computation.InterruptMonitor;
import org.semanticweb.elk.util.logging.CachedTimeThread;

/**
 * An {@link AbstractRuleEngine} which additionally accumulates the statistics
 * about the processed {@link Context}s and adds it to the provided
 * {@link SaturationStatistics} when finished (i.e., when {@link #finish()} is
 * called).
 * 
 * @author "Yevgeny Kazakov"
 * 
 * @param <I> 
 */
public abstract class AbstractRuleEngineWithStatistics<I extends RuleApplicationInput> extends
		AbstractRuleEngine<I> {

	/**
	 * The global {@link SaturationStatistics} in which the aggregated
	 * statistics over all workers is accumulated
	 */
	private final SaturationStatistics aggregatedStats_;

	/**
	 * The local {@link SaturationStatistics} used by this worker; it does not
	 * require synchronization when modified
	 */
	final SaturationStatistics localStatistics;

	/**
	 * The reference to {@link ContextStatistics} of local
	 * {@link SaturationStatistics} for frequent access
	 */
	protected final ContextStatistics localContextStatistics;

	public AbstractRuleEngineWithStatistics(
			ModifiableReference<Context> activeContext,
			ClassInference.Visitor<?> inferenceProcessor,
			WorkerLocalTodo localTodo, InterruptMonitor interrupter,
			SaturationStatistics aggregatedStats,
			SaturationStatistics localStatistics) {
		super(activeContext, inferenceProcessor, localTodo, interrupter);
		this.aggregatedStats_ = aggregatedStats;
		this.localStatistics = localStatistics;
		this.localContextStatistics = localStatistics.getContextStatistics();
	}

	@Override
	public void process() throws InterruptedException {
		localContextStatistics.timeContextProcess -= CachedTimeThread
				.getCurrentTimeMillis();
		super.process();
		localContextStatistics.timeContextProcess += CachedTimeThread
				.getCurrentTimeMillis();
	}

	@Override
	protected void process(Context context) {
		localContextStatistics.countProcessedContexts++;
		super.process(context);
	}

	@Override
	public void finish() {
		aggregatedStats_.add(localStatistics);
		localStatistics.reset();
	}

}
