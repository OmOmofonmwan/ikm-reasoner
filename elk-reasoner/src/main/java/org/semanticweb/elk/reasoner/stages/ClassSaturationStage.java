
package org.semanticweb.elk.reasoner.stages;

import org.semanticweb.elk.reasoner.indexing.model.IndexedClass;
import org.semanticweb.elk.reasoner.saturation.ClassExpressionSaturation;
import org.semanticweb.elk.reasoner.saturation.context.Context;
import org.semanticweb.elk.reasoner.saturation.rules.factories.RuleApplicationAdditionFactory;
import org.semanticweb.elk.reasoner.saturation.rules.factories.RuleApplicationFactory;
import org.semanticweb.elk.reasoner.saturation.rules.factories.RuleApplicationInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link ReasonerStage} which computes saturation for every class of the
 * ontology
 * 
 * @author "Yevgeny Kazakov"
 */
public class ClassSaturationStage extends AbstractReasonerStage {

	// logger for this class
	private static final Logger LOGGER_ = LoggerFactory
			.getLogger(ClassSaturationStage.class);

	/**
	 * the computation used for this stage
	 */
	private ClassExpressionSaturation<IndexedClass> computation_ = null;

	public ClassSaturationStage(AbstractReasonerState reasoner,
			AbstractReasonerStage... preStages) {
		super(reasoner, preStages);
	}

	@Override
	public String getName() {
		return "Class Saturation";
	}

	@Override
	public boolean preExecute() {
		if (!super.preExecute())
			return false;

		RuleApplicationFactory<Context, RuleApplicationInput> ruleFactory = null;

		ruleFactory = new RuleApplicationAdditionFactory<RuleApplicationInput>(
				reasoner.getInterrupter(), reasoner.saturationState);

		this.computation_ = new ClassExpressionSaturation<IndexedClass>(
				reasoner.ontologyIndex.getClasses(),
				reasoner.getProcessExecutor(), workerNo,
				reasoner.getProgressMonitor(), ruleFactory);
		LOGGER_.info("{} using {} workers", this, workerNo);
		return true;
	}

	@Override
	public void executeStage() throws ElkInterruptedException {
		computation_.process();
	}

	@Override
	public boolean postExecute() {
		if (!super.postExecute())
			return false;		
		reasoner.ruleAndConclusionStats.add(computation_
				.getRuleAndConclusionStatistics());
		this.computation_ = null;
		return true;
	}

	@Override
	public void printInfo() {
		if (computation_ != null)
			computation_.printStatistics();
	}

}
