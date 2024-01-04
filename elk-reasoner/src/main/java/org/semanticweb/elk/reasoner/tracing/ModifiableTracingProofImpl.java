
package org.semanticweb.elk.reasoner.tracing;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * An implementation of {@link ModifiableTracingProof} backed by a
 * {@link Multimap}.
 * 
 * @author "Yevgeny Kazakov"
 *
 * @param <I>
 *            the type of inferences stored in this
 *            {@link ModifiableTracingProof}
 */
public class ModifiableTracingProofImpl<I extends TracingInference>
		implements ModifiableTracingProof<I> {

	// logger for this class
	private static final Logger LOGGER_ = LoggerFactory
			.getLogger(ModifiableTracingProofImpl.class);

	private final Multimap<Conclusion, I> inferenceMap_ = ArrayListMultimap
			.create();

	@Override
	public void produce(I inference) {
		LOGGER_.trace("{}: inference produced", inference);
		inferenceMap_.put(new TracingInferenceConclusion(inference), inference);
	}

	@Override
	public void clear() {
		inferenceMap_.clear();
	}

	@Override
	public Collection<? extends I> getInferences(Object conclusion) {
		if (conclusion instanceof Conclusion) {
			return inferenceMap_.get((Conclusion) conclusion);
		} // else
		return Collections.emptySet();
	}

	@Override
	public Set<? extends Conclusion> getAllConclusions() {
		return inferenceMap_.keySet();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Conclusion key : inferenceMap_.keySet()) {
			for (TracingInference inf : inferenceMap_.get(key)) {
				sb.append(inf.toString());
				sb.append('\n');
			}
		}
		return sb.toString();
	}

}
