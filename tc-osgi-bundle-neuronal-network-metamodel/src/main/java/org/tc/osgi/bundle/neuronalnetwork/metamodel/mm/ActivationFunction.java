package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;

/**
 * ActivationFunction.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public abstract class ActivationFunction<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -1207650548450723014L;

    /**
     * evaluate.
     * @param value T
     * @return T
     */
    public abstract T evaluate(T value);

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Defini la fonction d'activation d'un neurone\n";
    }
}
