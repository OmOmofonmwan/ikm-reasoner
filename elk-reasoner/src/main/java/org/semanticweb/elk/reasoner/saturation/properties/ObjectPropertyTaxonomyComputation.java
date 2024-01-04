
package org.semanticweb.elk.reasoner.saturation.properties;

import java.util.Collection;

import org.semanticweb.elk.owl.interfaces.ElkObjectProperty;
import org.semanticweb.elk.owl.predefined.PredefinedElkObjectPropertyFactory;
import org.semanticweb.elk.reasoner.ProgressMonitor;
import org.semanticweb.elk.reasoner.ReasonerComputationWithInputs;
import org.semanticweb.elk.reasoner.indexing.model.IndexedObjectProperty;
import org.semanticweb.elk.reasoner.indexing.model.OntologyIndex;
import org.semanticweb.elk.util.concurrent.computation.ConcurrentExecutor;
import org.semanticweb.elk.util.concurrent.computation.InterruptMonitor;

/**
 * A {@link ReasonerComputationWithInputs} that computes object property
 * taxonomy. All sub-properties must be already computed.
 * 
 * @author Peter Skocovsky
 */
public class ObjectPropertyTaxonomyComputation extends
		ReasonerComputationWithInputs<IndexedObjectProperty, ObjectPropertyTaxonomyComputationFactory> {

	public ObjectPropertyTaxonomyComputation(final OntologyIndex ontIndex,
			final InterruptMonitor interrupter,
			final TransitiveReductionOutputVisitor<ElkObjectProperty> outputProcessor,
			final PredefinedElkObjectPropertyFactory predefinedFactory,
			final ConcurrentExecutor executor, final int maxWorkers,
			final ProgressMonitor progressMonitor) {
		this(ontIndex.getObjectProperties(),
				new ObjectPropertyTaxonomyComputationFactory(interrupter,
						outputProcessor, ontIndex, predefinedFactory),
				executor, maxWorkers, progressMonitor);
	}

	ObjectPropertyTaxonomyComputation(
			final Collection<? extends IndexedObjectProperty> inputs,
			final ObjectPropertyTaxonomyComputationFactory inputProcessorFactory,
			final ConcurrentExecutor executor, final int maxWorkers,
			final ProgressMonitor progressMonitor) {
		super(inputs, inputProcessorFactory, executor, maxWorkers,
				progressMonitor);
	}

}
