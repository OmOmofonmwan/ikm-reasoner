
package org.semanticweb.elk.reasoner.taxonomy;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.semanticweb.elk.owl.interfaces.ElkEntity;
import org.semanticweb.elk.reasoner.taxonomy.impl.AbstractTaxonomy;
import org.semanticweb.elk.reasoner.taxonomy.model.ComparatorKeyProvider;
import org.semanticweb.elk.reasoner.taxonomy.model.NodeStore;
import org.semanticweb.elk.reasoner.taxonomy.model.Taxonomy;
import org.semanticweb.elk.reasoner.taxonomy.model.TaxonomyNodeFactory;

/**
 * A {@link Taxonomy} consisting of a single node = top node = bottom node.
 * Typically, this is used to represent an inconsistent taxonomy.
 * 
 * @author "Yevgeny Kazakov"
 * @author Peter Skocovsky
 * 
 * @param <T>
 *            the type of objects stored in this taxonomy
 * @param <N>
 *            the type of the node of this taxonomy
 * 
 * @see OrphanTaxonomyNode
 */
public class SingletoneTaxonomy<T extends ElkEntity, N extends OrphanTaxonomyNode<T>>
		extends AbstractTaxonomy<T> {

	private final ComparatorKeyProvider<? super T> keyProvider_;

	final N node;

	// TODO: let taxonomy implement node directly
	
	public SingletoneTaxonomy(
			final ComparatorKeyProvider<? super T> keyProvider,
			final Collection<? extends T> allMembers,
			final TaxonomyNodeFactory<T, N, Taxonomy<T>> nodeFactory) {
		this.keyProvider_ = keyProvider;
		this.node = nodeFactory.createNode(allMembers, allMembers.size(), this);
	}

	@Override
	public ComparatorKeyProvider<? super T> getKeyProvider() {
		return keyProvider_;
	}

	@Override
	public N getNode(T elkEntity) {
		if (node.contains(elkEntity)) {
			return node;
		}
		// else
		return null;
	}

	@Override
	public Set<? extends N> getNodes() {
		return Collections.singleton(node);
	}

	@Override
	public N getTopNode() {
		return node;
	}

	@Override
	public N getBottomNode() {
		return node;
	}

	@Override
	public boolean addListener(final NodeStore.Listener<T> listener) {
		// No events are ever fired.
		return true;
	}

	@Override
	public boolean removeListener(final NodeStore.Listener<T> listener) {
		// No events are ever fired.
		return true;
	}

	@Override
	public boolean addListener(final Taxonomy.Listener<T> listener) {
		// No events are ever fired.
		return true;
	}

	@Override
	public boolean removeListener(final Taxonomy.Listener<T> listener) {
		// No events are ever fired.
		return true;
	}

}
