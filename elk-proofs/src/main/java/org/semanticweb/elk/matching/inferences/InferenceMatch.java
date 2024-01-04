
package org.semanticweb.elk.matching.inferences;

public interface InferenceMatch {

	<O> O accept(Visitor<O> visitor);

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	interface Factory extends BackwardLinkCompositionMatch1.Factory,
			BackwardLinkCompositionMatch2.Factory,
			BackwardLinkCompositionMatch3.Factory,
			BackwardLinkCompositionMatch4.Factory,
			BackwardLinkCompositionMatch5.Factory,
			BackwardLinkCompositionMatch6.Factory,
			BackwardLinkCompositionMatch7.Factory,
			BackwardLinkCompositionMatch8.Factory,
			BackwardLinkCompositionMatch9.Factory,
			BackwardLinkOfObjectHasSelfMatch1.Factory,
			BackwardLinkOfObjectHasSelfMatch2.Factory,
			BackwardLinkOfObjectHasSelfMatch3.Factory,
			BackwardLinkOfObjectSomeValuesFromMatch1.Factory,
			BackwardLinkOfObjectSomeValuesFromMatch2.Factory,
			BackwardLinkOfObjectSomeValuesFromMatch3.Factory,
			BackwardLinkReversedExpandedMatch1.Factory,
			BackwardLinkReversedExpandedMatch2.Factory,
			BackwardLinkReversedExpandedMatch3.Factory,
			BackwardLinkReversedExpandedMatch4.Factory,
			BackwardLinkReversedExpandedMatch5.Factory,
			ClassInconsistencyOfDisjointSubsumersMatch1.Factory,
			ClassInconsistencyOfDisjointSubsumersMatch2.Factory,
			ClassInconsistencyOfDisjointSubsumersMatch3.Factory,
			ClassInconsistencyOfObjectComplementOfMatch1.Factory,
			ClassInconsistencyOfObjectComplementOfMatch2.Factory,
			ClassInconsistencyOfObjectComplementOfMatch3.Factory,
			ClassInconsistencyOfOwlNothingMatch1.Factory,
			ClassInconsistencyOfOwlNothingMatch2.Factory,
			ClassInconsistencyPropagatedMatch1.Factory,
			ClassInconsistencyPropagatedMatch2.Factory,
			ClassInconsistencyPropagatedMatch3.Factory,
			ClassInconsistencyPropagatedMatch4.Factory,
			DisjointSubsumerFromSubsumerMatch1.Factory,
			DisjointSubsumerFromSubsumerMatch2.Factory,
			DisjointSubsumerFromSubsumerMatch3.Factory,
			ElkClassAssertionAxiomConversionMatch1.Factory,
			ElkDifferentIndividualsAxiomNaryConversionMatch1.Factory,
			ElkDifferentIndividualsAxiomBinaryConversionMatch1.Factory,
			ElkDisjointClassesAxiomBinaryConversionMatch1.Factory,
			ElkDisjointClassesAxiomNaryConversionMatch1.Factory,
			ElkDisjointUnionAxiomBinaryConversionMatch1.Factory,
			ElkDisjointUnionAxiomEquivalenceConversionMatch1.Factory,
			ElkDisjointUnionAxiomNaryConversionMatch1.Factory,
			ElkDisjointUnionAxiomOwlNothingConversionMatch1.Factory,
			ElkDisjointUnionAxiomSubClassConversionMatch1.Factory,
			ElkEquivalentClassesAxiomEquivalenceConversionMatch1.Factory,
			ElkEquivalentClassesAxiomSubClassConversionMatch1.Factory,
			ElkEquivalentObjectPropertiesAxiomConversionMatch1.Factory,
			ElkObjectPropertyAssertionAxiomConversionMatch1.Factory,
			ElkObjectPropertyDomainAxiomConversionMatch1.Factory,
			ElkObjectPropertyRangeAxiomConversionMatch1.Factory,
			ElkReflexiveObjectPropertyAxiomConversionMatch1.Factory,
			ElkSameIndividualAxiomConversionMatch1.Factory,
			ElkSubClassOfAxiomConversionMatch1.Factory,
			ElkSubObjectPropertyOfAxiomConversionMatch1.Factory,
			ElkTransitiveObjectPropertyAxiomConversionMatch1.Factory,
			ForwardLinkCompositionMatch1.Factory,
			ForwardLinkCompositionMatch2.Factory,
			ForwardLinkCompositionMatch3.Factory,
			ForwardLinkCompositionMatch4.Factory,
			ForwardLinkCompositionMatch5.Factory,
			ForwardLinkCompositionMatch6.Factory,
			ForwardLinkCompositionMatch7.Factory,
			ForwardLinkCompositionMatch8.Factory,
			ForwardLinkOfObjectHasSelfMatch1.Factory,
			ForwardLinkOfObjectHasSelfMatch2.Factory,
			ForwardLinkOfObjectHasSelfMatch3.Factory,
			ForwardLinkOfObjectSomeValuesFromMatch1.Factory,
			ForwardLinkOfObjectSomeValuesFromMatch2.Factory,
			ForwardLinkOfObjectSomeValuesFromMatch3.Factory,
			PropagationGeneratedMatch1.Factory,
			PropagationGeneratedMatch2.Factory,
			PropagationGeneratedMatch3.Factory,
			PropertyRangeInheritedMatch1.Factory,
			PropertyRangeInheritedMatch2.Factory,
			PropertyRangeInheritedMatch3.Factory,
			SubClassInclusionComposedDefinedClassMatch1.Factory,
			SubClassInclusionComposedDefinedClassMatch2.Factory,
			SubClassInclusionComposedDefinedClassMatch3.Factory,
			SubClassInclusionComposedEmptyObjectIntersectionOfMatch1.Factory,
			SubClassInclusionComposedEmptyObjectIntersectionOfMatch2.Factory,
			SubClassInclusionComposedEmptyObjectOneOfMatch1.Factory,
			SubClassInclusionComposedEmptyObjectOneOfMatch2.Factory,
			SubClassInclusionComposedEmptyObjectUnionOfMatch1.Factory,
			SubClassInclusionComposedEmptyObjectUnionOfMatch2.Factory,
			SubClassInclusionComposedEntityMatch1.Factory,
			SubClassInclusionComposedEntityMatch2.Factory,
			SubClassInclusionComposedObjectHasValueMatch1.Factory,
			SubClassInclusionComposedObjectHasValueMatch2.Factory,
			SubClassInclusionComposedObjectIntersectionOfMatch1.Factory,
			SubClassInclusionComposedObjectIntersectionOfMatch2.Factory,
			SubClassInclusionComposedObjectIntersectionOfMatch3.Factory,
			SubClassInclusionComposedObjectSomeValuesFromMatch1.Factory,
			SubClassInclusionComposedObjectSomeValuesFromMatch2.Factory,
			SubClassInclusionComposedObjectSomeValuesFromMatch3.Factory,
			SubClassInclusionComposedObjectSomeValuesFromMatch4.Factory,
			SubClassInclusionComposedObjectUnionOfMatch1.Factory,
			SubClassInclusionComposedObjectUnionOfMatch2.Factory,
			SubClassInclusionComposedSingletonObjectIntersectionOfMatch1.Factory,
			SubClassInclusionComposedSingletonObjectIntersectionOfMatch2.Factory,
			SubClassInclusionComposedSingletonObjectOneOfMatch1.Factory,
			SubClassInclusionComposedSingletonObjectOneOfMatch2.Factory,
			SubClassInclusionComposedSingletonObjectUnionOfMatch1.Factory,
			SubClassInclusionComposedSingletonObjectUnionOfMatch2.Factory,
			SubClassInclusionDecomposedEmptyObjectIntersectionOfMatch1.Factory,
			SubClassInclusionDecomposedEmptyObjectOneOfMatch1.Factory,
			SubClassInclusionDecomposedEmptyObjectUnionOfMatch1.Factory,
			SubClassInclusionDecomposedFirstConjunctMatch1.Factory,
			SubClassInclusionDecomposedFirstConjunctMatch2.Factory,
			SubClassInclusionDecomposedObjectHasValueMatch1.Factory,
			SubClassInclusionDecomposedSecondConjunctMatch1.Factory,
			SubClassInclusionDecomposedSecondConjunctMatch2.Factory,
			SubClassInclusionDecomposedSingletonObjectIntersectionOfMatch1.Factory,
			SubClassInclusionDecomposedSingletonObjectOneOfMatch1.Factory,
			SubClassInclusionDecomposedSingletonObjectUnionOfMatch1.Factory,
			SubClassInclusionExpandedDefinitionMatch1.Factory,
			SubClassInclusionExpandedDefinitionMatch2.Factory,
			SubClassInclusionExpandedDefinitionMatch3.Factory,
			SubClassInclusionExpandedFirstEquivalentClassMatch1.Factory,
			SubClassInclusionExpandedFirstEquivalentClassMatch2.Factory,
			SubClassInclusionExpandedFirstEquivalentClassMatch3.Factory,
			SubClassInclusionExpandedSecondEquivalentClassMatch1.Factory,
			SubClassInclusionExpandedSecondEquivalentClassMatch2.Factory,
			SubClassInclusionExpandedSecondEquivalentClassMatch3.Factory,
			SubClassInclusionExpandedSubClassOfMatch1.Factory,
			SubClassInclusionExpandedSubClassOfMatch2.Factory,
			SubClassInclusionExpandedSubClassOfMatch3.Factory,
			SubClassInclusionObjectHasSelfPropertyRangeMatch1.Factory,
			SubClassInclusionObjectHasSelfPropertyRangeMatch2.Factory,
			SubClassInclusionObjectHasSelfPropertyRangeMatch3.Factory,
			SubClassInclusionOwlThingMatch1.Factory,
			SubClassInclusionRangeMatch1.Factory,
			SubClassInclusionRangeMatch2.Factory,
			SubClassInclusionTautologyMatch1.Factory,
			SubPropertyChainExpandedSubObjectPropertyOfMatch1.Factory,
			SubPropertyChainExpandedSubObjectPropertyOfMatch2.Factory,
			SubPropertyChainExpandedSubObjectPropertyOfMatch3.Factory,
			SubPropertyChainTautologyMatch1.Factory {

		// combined interface

	}

	/**
	 * The visitor pattern for instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 * @param <O>
	 *            the type of the output
	 */
	interface Visitor<O> extends BackwardLinkCompositionMatch1.Visitor<O>,
			BackwardLinkCompositionMatch2.Visitor<O>,
			BackwardLinkCompositionMatch3.Visitor<O>,
			BackwardLinkCompositionMatch4.Visitor<O>,
			BackwardLinkCompositionMatch5.Visitor<O>,
			BackwardLinkCompositionMatch6.Visitor<O>,
			BackwardLinkCompositionMatch7.Visitor<O>,
			BackwardLinkCompositionMatch8.Visitor<O>,
			BackwardLinkCompositionMatch9.Visitor<O>,
			BackwardLinkOfObjectHasSelfMatch1.Visitor<O>,
			BackwardLinkOfObjectHasSelfMatch2.Visitor<O>,
			BackwardLinkOfObjectHasSelfMatch3.Visitor<O>,
			BackwardLinkOfObjectSomeValuesFromMatch1.Visitor<O>,
			BackwardLinkOfObjectSomeValuesFromMatch2.Visitor<O>,
			BackwardLinkOfObjectSomeValuesFromMatch3.Visitor<O>,
			BackwardLinkReversedExpandedMatch1.Visitor<O>,
			BackwardLinkReversedExpandedMatch2.Visitor<O>,
			BackwardLinkReversedExpandedMatch3.Visitor<O>,
			BackwardLinkReversedExpandedMatch4.Visitor<O>,
			BackwardLinkReversedExpandedMatch5.Visitor<O>,
			ClassInconsistencyOfDisjointSubsumersMatch1.Visitor<O>,
			ClassInconsistencyOfDisjointSubsumersMatch2.Visitor<O>,
			ClassInconsistencyOfDisjointSubsumersMatch3.Visitor<O>,
			ClassInconsistencyOfObjectComplementOfMatch1.Visitor<O>,
			ClassInconsistencyOfObjectComplementOfMatch2.Visitor<O>,
			ClassInconsistencyOfObjectComplementOfMatch3.Visitor<O>,
			ClassInconsistencyOfOwlNothingMatch1.Visitor<O>,
			ClassInconsistencyOfOwlNothingMatch2.Visitor<O>,
			ClassInconsistencyPropagatedMatch1.Visitor<O>,
			ClassInconsistencyPropagatedMatch2.Visitor<O>,
			ClassInconsistencyPropagatedMatch3.Visitor<O>,
			ClassInconsistencyPropagatedMatch4.Visitor<O>,
			DisjointSubsumerFromSubsumerMatch1.Visitor<O>,
			DisjointSubsumerFromSubsumerMatch2.Visitor<O>,
			DisjointSubsumerFromSubsumerMatch3.Visitor<O>,
			ElkClassAssertionAxiomConversionMatch1.Visitor<O>,
			ElkDifferentIndividualsAxiomBinaryConversionMatch1.Visitor<O>,
			ElkDifferentIndividualsAxiomNaryConversionMatch1.Visitor<O>,
			ElkDisjointClassesAxiomBinaryConversionMatch1.Visitor<O>,
			ElkDisjointUnionAxiomBinaryConversionMatch1.Visitor<O>,
			ElkDisjointClassesAxiomNaryConversionMatch1.Visitor<O>,
			ElkDisjointUnionAxiomEquivalenceConversionMatch1.Visitor<O>,
			ElkDisjointUnionAxiomNaryConversionMatch1.Visitor<O>,
			ElkDisjointUnionAxiomOwlNothingConversionMatch1.Visitor<O>,
			ElkDisjointUnionAxiomSubClassConversionMatch1.Visitor<O>,
			ElkEquivalentClassesAxiomEquivalenceConversionMatch1.Visitor<O>,
			ElkEquivalentClassesAxiomSubClassConversionMatch1.Visitor<O>,
			ElkEquivalentObjectPropertiesAxiomConversionMatch1.Visitor<O>,
			ElkObjectPropertyAssertionAxiomConversionMatch1.Visitor<O>,
			ElkObjectPropertyDomainAxiomConversionMatch1.Visitor<O>,
			ElkObjectPropertyRangeAxiomConversionMatch1.Visitor<O>,
			ElkReflexiveObjectPropertyAxiomConversionMatch1.Visitor<O>,
			ElkSameIndividualAxiomConversionMatch1.Visitor<O>,
			ElkSubClassOfAxiomConversionMatch1.Visitor<O>,
			ElkSubObjectPropertyOfAxiomConversionMatch1.Visitor<O>,
			ElkTransitiveObjectPropertyAxiomConversionMatch1.Visitor<O>,
			ForwardLinkCompositionMatch1.Visitor<O>,
			ForwardLinkCompositionMatch2.Visitor<O>,
			ForwardLinkCompositionMatch3.Visitor<O>,
			ForwardLinkCompositionMatch4.Visitor<O>,
			ForwardLinkCompositionMatch5.Visitor<O>,
			ForwardLinkCompositionMatch6.Visitor<O>,
			ForwardLinkCompositionMatch7.Visitor<O>,
			ForwardLinkCompositionMatch8.Visitor<O>,
			ForwardLinkOfObjectHasSelfMatch1.Visitor<O>,
			ForwardLinkOfObjectHasSelfMatch2.Visitor<O>,
			ForwardLinkOfObjectHasSelfMatch3.Visitor<O>,
			ForwardLinkOfObjectSomeValuesFromMatch1.Visitor<O>,
			ForwardLinkOfObjectSomeValuesFromMatch2.Visitor<O>,
			ForwardLinkOfObjectSomeValuesFromMatch3.Visitor<O>,
			PropagationGeneratedMatch1.Visitor<O>,
			PropagationGeneratedMatch2.Visitor<O>,
			PropagationGeneratedMatch3.Visitor<O>,
			PropertyRangeInheritedMatch1.Visitor<O>,
			PropertyRangeInheritedMatch2.Visitor<O>,
			PropertyRangeInheritedMatch3.Visitor<O>,
			SubClassInclusionComposedDefinedClassMatch1.Visitor<O>,
			SubClassInclusionComposedDefinedClassMatch2.Visitor<O>,
			SubClassInclusionComposedDefinedClassMatch3.Visitor<O>,
			SubClassInclusionComposedEmptyObjectIntersectionOfMatch1.Visitor<O>,
			SubClassInclusionComposedEmptyObjectIntersectionOfMatch2.Visitor<O>,
			SubClassInclusionComposedEmptyObjectOneOfMatch1.Visitor<O>,
			SubClassInclusionComposedEmptyObjectOneOfMatch2.Visitor<O>,
			SubClassInclusionComposedEmptyObjectUnionOfMatch1.Visitor<O>,
			SubClassInclusionComposedEmptyObjectUnionOfMatch2.Visitor<O>,
			SubClassInclusionComposedEntityMatch1.Visitor<O>,
			SubClassInclusionComposedEntityMatch2.Visitor<O>,
			SubClassInclusionComposedObjectHasValueMatch1.Visitor<O>,
			SubClassInclusionComposedObjectHasValueMatch2.Visitor<O>,
			SubClassInclusionComposedObjectIntersectionOfMatch1.Visitor<O>,
			SubClassInclusionComposedObjectIntersectionOfMatch2.Visitor<O>,
			SubClassInclusionComposedObjectIntersectionOfMatch3.Visitor<O>,
			SubClassInclusionComposedObjectSomeValuesFromMatch1.Visitor<O>,
			SubClassInclusionComposedObjectSomeValuesFromMatch2.Visitor<O>,
			SubClassInclusionComposedObjectSomeValuesFromMatch3.Visitor<O>,
			SubClassInclusionComposedObjectSomeValuesFromMatch4.Visitor<O>,
			SubClassInclusionComposedObjectUnionOfMatch1.Visitor<O>,
			SubClassInclusionComposedObjectUnionOfMatch2.Visitor<O>,
			SubClassInclusionComposedSingletonObjectIntersectionOfMatch1.Visitor<O>,
			SubClassInclusionComposedSingletonObjectIntersectionOfMatch2.Visitor<O>,
			SubClassInclusionComposedSingletonObjectOneOfMatch1.Visitor<O>,
			SubClassInclusionComposedSingletonObjectOneOfMatch2.Visitor<O>,
			SubClassInclusionComposedSingletonObjectUnionOfMatch1.Visitor<O>,
			SubClassInclusionComposedSingletonObjectUnionOfMatch2.Visitor<O>,
			SubClassInclusionDecomposedEmptyObjectIntersectionOfMatch1.Visitor<O>,
			SubClassInclusionDecomposedEmptyObjectOneOfMatch1.Visitor<O>,
			SubClassInclusionDecomposedEmptyObjectUnionOfMatch1.Visitor<O>,
			SubClassInclusionDecomposedFirstConjunctMatch1.Visitor<O>,
			SubClassInclusionDecomposedFirstConjunctMatch2.Visitor<O>,
			SubClassInclusionDecomposedObjectHasValueMatch1.Visitor<O>,
			SubClassInclusionDecomposedSecondConjunctMatch1.Visitor<O>,
			SubClassInclusionDecomposedSecondConjunctMatch2.Visitor<O>,
			SubClassInclusionDecomposedSingletonObjectIntersectionOfMatch1.Visitor<O>,
			SubClassInclusionDecomposedSingletonObjectOneOfMatch1.Visitor<O>,
			SubClassInclusionDecomposedSingletonObjectUnionOfMatch1.Visitor<O>,
			SubClassInclusionExpandedDefinitionMatch1.Visitor<O>,
			SubClassInclusionExpandedDefinitionMatch2.Visitor<O>,
			SubClassInclusionExpandedDefinitionMatch3.Visitor<O>,
			SubClassInclusionExpandedFirstEquivalentClassMatch1.Visitor<O>,
			SubClassInclusionExpandedFirstEquivalentClassMatch2.Visitor<O>,
			SubClassInclusionExpandedFirstEquivalentClassMatch3.Visitor<O>,
			SubClassInclusionExpandedSecondEquivalentClassMatch1.Visitor<O>,
			SubClassInclusionExpandedSecondEquivalentClassMatch2.Visitor<O>,
			SubClassInclusionExpandedSecondEquivalentClassMatch3.Visitor<O>,
			SubClassInclusionExpandedSubClassOfMatch1.Visitor<O>,
			SubClassInclusionExpandedSubClassOfMatch2.Visitor<O>,
			SubClassInclusionExpandedSubClassOfMatch3.Visitor<O>,
			SubClassInclusionObjectHasSelfPropertyRangeMatch1.Visitor<O>,
			SubClassInclusionObjectHasSelfPropertyRangeMatch2.Visitor<O>,
			SubClassInclusionObjectHasSelfPropertyRangeMatch3.Visitor<O>,
			SubClassInclusionOwlThingMatch1.Visitor<O>,
			SubClassInclusionRangeMatch1.Visitor<O>,
			SubClassInclusionRangeMatch2.Visitor<O>,
			SubClassInclusionTautologyMatch1.Visitor<O>,
			SubPropertyChainExpandedSubObjectPropertyOfMatch1.Visitor<O>,
			SubPropertyChainExpandedSubObjectPropertyOfMatch2.Visitor<O>,
			SubPropertyChainExpandedSubObjectPropertyOfMatch3.Visitor<O>,
			SubPropertyChainTautologyMatch1.Visitor<O> {

		// combined interface

	}

}
