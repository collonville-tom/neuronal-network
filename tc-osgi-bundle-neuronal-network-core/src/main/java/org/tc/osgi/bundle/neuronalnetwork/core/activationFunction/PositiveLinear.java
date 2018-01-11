package org.tc.osgi.bundle.neuronalnetwork.core.activationFunction;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction;

/**
 * PositiveLinear.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class PositiveLinear<T extends Number> extends ActivationFunction<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -2011729114304321282L;
    /**
     * int activatedAt.
     */
    private int activatedAt = 0;

    /**
     * PositiveLinear constructor.
     */
    public PositiveLinear() {
        super();
    }

    /**
     * PositiveLinear constructor.
     * @param activatedAt int
     */
    public PositiveLinear(final int activatedAt) {
        super();
        this.activatedAt = activatedAt;
    }

    /**
     * @param value T
     * @return T
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction#evaluate(java.lang.Number)
     */
    @Override
    @SuppressWarnings("unchecked")
    public T evaluate(final T value) {
        if (this.activatedAt > value.floatValue()) {
            return (T) new Float(0);
        } else {
            return value;
        }
    }

    /**
     * getActivatedAt.
     * @return int
     */
    public int getActivatedAt() {
        return this.activatedAt;
    }

    /**
     * setActivatedAt.
     * @param activatedAt int
     */
    public void setActivatedAt(final int activatedAt) {
        this.activatedAt = activatedAt;
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Fonction d'activation de type PositiveLinear de seuil d'activation: ");
        buff.append(this.activatedAt);
        return buff.toString();
    }
}
