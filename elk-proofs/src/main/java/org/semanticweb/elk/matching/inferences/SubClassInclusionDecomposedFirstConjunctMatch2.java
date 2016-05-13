package org.semanticweb.elk.matching.inferences;

/*
 * #%L
 * ELK Proofs Package
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2011 - 2016 Department of Computer Science, University of Oxford
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.semanticweb.elk.matching.conclusions.ConclusionMatchExpressionFactory;
import org.semanticweb.elk.matching.conclusions.SubClassInclusionDecomposedMatch2;
import org.semanticweb.elk.matching.subsumers.IndexedObjectIntersectionOfMatch;
import org.semanticweb.elk.owl.interfaces.ElkObjectIntersectionOf;

public class SubClassInclusionDecomposedFirstConjunctMatch2 extends
		AbstractInferenceMatch<SubClassInclusionDecomposedFirstConjunctMatch1> {

	private final ElkObjectIntersectionOf fullSubsumerMatch_;

	private final int premiseSubsumerPrefixLength_;

	SubClassInclusionDecomposedFirstConjunctMatch2(
			SubClassInclusionDecomposedFirstConjunctMatch1 parent,
			SubClassInclusionDecomposedMatch2 premiseMatch) {
		super(parent);
		IndexedObjectIntersectionOfMatch premiseSubsumerMatch = premiseMatch
				.getSubsumerIndexedObjectIntersectionOfMatch();
		this.fullSubsumerMatch_ = premiseSubsumerMatch.getFullValue();
		this.premiseSubsumerPrefixLength_ = premiseSubsumerMatch
				.getPrefixLength();
	}

	public ElkObjectIntersectionOf getFullSubsumerMatch() {
		return fullSubsumerMatch_;
	}

	public int getPremiseSubsumerPrefixLength() {
		return premiseSubsumerPrefixLength_;
	}

	public SubClassInclusionDecomposedMatch2 getConclusionMatch(
			ConclusionMatchExpressionFactory factory) {
		return factory.getSubClassInclusionDecomposedMatch2(
				getParent().getConclusionMatch(factory), fullSubsumerMatch_,
				premiseSubsumerPrefixLength_ - 1);
	}

	@Override
	public <O> O accept(InferenceMatch.Visitor<O> visitor) {
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

		O visit(SubClassInclusionDecomposedFirstConjunctMatch2 inferenceMatch2);

	}

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	public interface Factory {

		SubClassInclusionDecomposedFirstConjunctMatch2 getSubClassInclusionDecomposedFirstConjunctMatch2(
				SubClassInclusionDecomposedFirstConjunctMatch1 parent,
				SubClassInclusionDecomposedMatch2 premiseMatch);

	}

}
