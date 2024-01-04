
package org.semanticweb.elk.reasoner.taxonomy.model;

import java.util.Set;

import org.semanticweb.elk.owl.interfaces.ElkEntity;

/**
 * Type node with parameterized type of nodes with which it may be associated.
 * 
 * @author Peter Skocovsky
 *
 * @param <T>
 *            The type of members of this node.
 * @param <I>
 *            The type of members of the related instance nodes.
 * @param <TN>
 *            The type of type nodes with which this node may be associated.
 * @param <IN>
 *            The type of instance nodes with which this node may be associated.
 */
public interface GenericTypeNode<
				T extends ElkEntity,
				I extends ElkEntity,
				TN extends GenericTypeNode<T, I, TN, IN>,
				IN extends GenericInstanceNode<T, I, TN, IN>
		>
		extends TypeNode<T, I>, GenericTaxonomyNode<T, TN> {

	@Override
	Set<? extends IN> getDirectInstanceNodes();

	@Override
	Set<? extends IN> getAllInstanceNodes();

	@Override
	Set<? extends TN> getDirectSuperNodes();

	@Override
	Set<? extends TN> getAllSuperNodes();

	@Override
	Set<? extends TN> getDirectSubNodes();

	@Override
	Set<? extends TN> getAllSubNodes();

	public static interface Projection<T extends ElkEntity, I extends ElkEntity>
			extends GenericTypeNode<
					T,
					I,
					Projection<T, I>,
					GenericInstanceNode.Projection<T, I>
			> {
		// Empty.
	}
	
}
