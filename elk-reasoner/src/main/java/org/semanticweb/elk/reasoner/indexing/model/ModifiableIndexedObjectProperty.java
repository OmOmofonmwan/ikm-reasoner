
package org.semanticweb.elk.reasoner.indexing.model;



import org.semanticweb.elk.owl.interfaces.ElkAxiom;
import org.semanticweb.elk.owl.interfaces.ElkObjectProperty;

/**
 * An {@link IndexedObjectProperty} that can be modified as a result of updating
 * the {@link ModifiableOntologyIndex} where this object is stored.
 * 
 * @author "Yevgeny Kazakov"
 *
 */
public interface ModifiableIndexedObjectProperty
		extends
			ModifiableIndexedPropertyChain,
			ModifiableIndexedEntity,
			IndexedObjectProperty {

	/**
	 * Adds the given {@link IndexedComplexPropertyChain} to the list of
	 * {@link IndexedComplexPropertyChain} that contains this
	 * {@link IndexedPropertyChain} in the left-hand-side
	 * 
	 * @param chain
	 *            the {@link IndexedComplexPropertyChain} to be added
	 * @return {@code true} if the operation is successful or {@code false}
	 *         otherwise; if {@code false} is returned, this
	 *         {@link IndexedObjectProperty} does not change
	 */
	boolean addLeftChain(IndexedComplexPropertyChain chain);

	/**
	 * Adds the given {@link IndexedComplexPropertyChain} from the list of
	 * {@link IndexedComplexPropertyChain} that contain this
	 * {@link IndexedPropertyChain} in the left-hand-side
	 * 
	 * @param chain
	 *            the {@link IndexedComplexPropertyChain} to be removed
	 * @return {@code true} if successfully removed
	 */
	boolean removeLeftChain(IndexedComplexPropertyChain chain);

	/**
	 * Adds the given {@link IndexedPropertyChain} as a sub-property of this
	 * {@link IndexedObjectProperty}
	 * 
	 * @param subObjectProperty
	 *            the {@link IndexedPropertyChain} to be added
	 * @param reason
	 *            the {@link ElkAxiom} responsible for the addition of the
	 *            sub-property
	 * @return {@code true} if the operation is successful or {@code false}
	 *         otherwise; if {@code false} is returned, this
	 *         {@link IndexedObjectProperty} does not change
	 */
	boolean addToldSubPropertyChain(IndexedPropertyChain subObjectProperty,
			ElkAxiom reason);

	/**
	 * Removes the given {@link IndexedPropertyChain} from sub-properties of
	 * this {@link IndexedObjectProperty}
	 * 
	 * @param subObjectProperty
	 *            the {@link IndexedPropertyChain} to be removed
	 * @param reason
	 *            the {@link ElkAxiom} responsible for the removal of the
	 *            sub-property
	 * @return {@code true} if the operation is successful or {@code false}
	 *         otherwise; if {@code false} is returned, this
	 *         {@link IndexedObjectProperty} does not change
	 */
	boolean removeToldSubPropertyChain(IndexedPropertyChain subObjectProperty,
			ElkAxiom reason);

	/**
	 * Adds the given {@link IndexedClassExpression} as range of this
	 * {@link IndexedObjectProperty}
	 * 
	 * @param range
	 *            the {@link IndexedClassExpression} to be added as range
	 * @param reason
	 *            the {@link ElkAxiom} responsible for the addition of the range
	 * @return {@code true} if the operation is successful or {@code false}
	 *         otherwise; if {@code false} is returned, this
	 *         {@link IndexedObjectProperty} does not change
	 */
	boolean addToldRange(IndexedClassExpression range, ElkAxiom reason);

	/**
	 * Removes the given {@link IndexedClassExpression} from ranges of this
	 * {@link IndexedObjectProperty}
	 * 
	 * @param range
	 *            the {@link IndexedClassExpression} to be removed
	 * @param reason
	 *            the {@link ElkAxiom} responsible for the removal of the range
	 * @return {@code true} if the operation is successful or {@code false}
	 *         otherwise; if {@code false} is returned, this
	 *         {@link IndexedObjectProperty} does not change
	 */
	boolean removeToldRange(IndexedClassExpression range, ElkAxiom reason);

	/**
	 * A factory for creating instances
	 * 
	 * @author Yevgeny Kazakov
	 *
	 */
	interface Factory {

		ModifiableIndexedObjectProperty getIndexedObjectProperty(
				ElkObjectProperty elkObjectProperty);

	}

}
