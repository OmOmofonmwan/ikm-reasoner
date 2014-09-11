/**
 * 
 */
package org.semanticweb.elk.reasoner.saturation.rules;

import org.semanticweb.elk.owl.interfaces.ElkAxiom;
import org.semanticweb.elk.owl.interfaces.ElkDisjointClassesAxiom;
import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedDisjointnessAxiom;
import org.semanticweb.elk.reasoner.indexing.hierarchy.IndexedSubClassOfAxiom;
import org.semanticweb.elk.reasoner.indexing.hierarchy.ModifiableOntologyIndex;
import org.semanticweb.elk.reasoner.saturation.rules.subsumers.ContradictionFromDisjointnessRule;
import org.semanticweb.elk.reasoner.saturation.rules.subsumers.DisjointSubsumerFromMemberRule;
import org.semanticweb.elk.reasoner.saturation.rules.subsumers.SuperClassFromSubClassRule;

/**
 * Adds rules without axiom binding to the index.
 * 
 * @author Pavel Klinov
 * 
 *         pavel.klinov@uni-ulm.de
 */
public class SimpleRuleToIndexWriter implements RuleToIndexWriter {

	@Override
	public void addSuperClassFromSubClassRule(
			IndexedSubClassOfAxiom indexedAxiom, ModifiableOntologyIndex index,
			ElkAxiom originalAxiom) {
		SuperClassFromSubClassRule.addRuleFor(indexedAxiom, index);
	}

	@Override
	public void addDisjointSubsumerRule(IndexedDisjointnessAxiom indexedAxiom,
			ModifiableOntologyIndex index, ElkDisjointClassesAxiom originalAxiom) {
		DisjointSubsumerFromMemberRule.addRulesFor(indexedAxiom, index);
	}

	@Override
	public void addContradictionFromDisjointnessRule(
			IndexedDisjointnessAxiom indexedAxiom,
			ModifiableOntologyIndex index, ElkDisjointClassesAxiom originalAxiom) {
		ContradictionFromDisjointnessRule.addRulesFor(indexedAxiom, index);
	}

	@Override
	public void removeSuperClassFromSubClassRule(
			IndexedSubClassOfAxiom indexedAxiom, ModifiableOntologyIndex index) {
		SuperClassFromSubClassRule.removeRuleFor(indexedAxiom, index);
	}

	@Override
	public void removeContradictionFromDisjointnessRule(
			IndexedDisjointnessAxiom indexedAxiom, ModifiableOntologyIndex index) {
		ContradictionFromDisjointnessRule.removeRulesFor(indexedAxiom, index);
	}

	@Override
	public void removeDisjointSubsumerRule(
			IndexedDisjointnessAxiom indexedAxiom, ModifiableOntologyIndex index) {
		DisjointSubsumerFromMemberRule.removeRulesFor(indexedAxiom, index);
	}

}
