
package org.semanticweb.elk.reasoner.indexing.classes;

import org.semanticweb.elk.owl.interfaces.ElkAxiom;
import org.semanticweb.elk.owl.printers.OwlFunctionalStylePrinter;
import org.semanticweb.elk.owl.visitors.ElkAxiomProcessor;
import org.semanticweb.elk.reasoner.completeness.OccurrenceListener;
import org.semanticweb.elk.reasoner.indexing.conversion.ElkAxiomConverter;
import org.semanticweb.elk.reasoner.indexing.conversion.ElkIndexingUnsupportedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basically an adapter from {@link ElkAxiomConverter} to
 * {@link ElkAxiomProcessor} specifically for classes which index axioms.
 * 
 * @author Pavel Klinov
 * 
 *         pavel.klinov@uni-ulm.de
 */
public class ChangeIndexingProcessor implements ElkAxiomProcessor {

	// logger for this class
	private static final Logger LOGGER_ = LoggerFactory
			.getLogger(ChangeIndexingProcessor.class);

	private final ElkAxiomConverter indexer_;

	private final int increment_; // deletion < 0, addition > 0

	private final OccurrenceListener occurrenceTracker_;

	public ChangeIndexingProcessor(ElkAxiomConverter indexer, int increment,
			final OccurrenceListener indexingListener) {
		this.indexer_ = indexer;
		this.increment_ = increment;
		this.occurrenceTracker_ = indexingListener;
	}

	@Override
	public void visit(ElkAxiom elkAxiom) {
		try {
			if (LOGGER_.isTraceEnabled())
				LOGGER_.trace("$$ indexing "
						+ OwlFunctionalStylePrinter.toString(elkAxiom) + " for "
						+ (increment_ > 0 ? "addition" : "deletion"));
			elkAxiom.accept(indexer_);
		} catch (ElkIndexingUnsupportedFeature e) {
			occurrenceTracker_.occurrenceChanged(e.getFeature(), increment_);
		}
	}
}
