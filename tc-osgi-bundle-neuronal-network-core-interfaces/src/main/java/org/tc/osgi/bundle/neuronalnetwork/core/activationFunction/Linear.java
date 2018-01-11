package org.tc.osgi.bundle.neuronalnetwork.core.activationFunction;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction;

/**
 * Linear.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class Linear<T extends Number> extends ActivationFunction<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 1251550856628613130L;

    /**
     * Linear constructor.
     */
    public Linear() {
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

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Fonction d'activation de type PositiveLinear ");
        return buff.toString();
    }
}