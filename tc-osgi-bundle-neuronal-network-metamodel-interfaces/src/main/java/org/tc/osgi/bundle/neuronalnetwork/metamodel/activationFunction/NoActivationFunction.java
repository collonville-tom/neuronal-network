package org.tc.osgi.bundle.neuronalnetwork.metamodel.activationFunction;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction;

/**
 * NoActivationFunction.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class NoActivationFunction<T extends Number> extends ActivationFunction<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -6830598206429328112L;

    /**
     * NoActivationFunction constructor.
     */
    public NoActivationFunction() {
        super();
    }

    /**
     * @param value T
     * @return T
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction#evaluate(java.lang.Number)
     */
    @Override
    @SuppressWarnings("unchecked")
    public T evaluate(final T value) {
        return value;
    }
}