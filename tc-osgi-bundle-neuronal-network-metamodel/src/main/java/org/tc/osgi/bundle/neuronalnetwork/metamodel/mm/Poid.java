package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;

/**
 * Poid.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class Poid<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 732710789666512773L;
    /**
     * T value.
     */
    private T value;

    /**
     * Poid constructor.
     */
    public Poid() {
        super();
    }

    /**
     * Poid constructor.
     * @param value T
     */
    public Poid(final T value) {
        super();
        this.value = value;
    }

    /**
     * getValue.
     * @return T
     */
    public T getValue() {
        return this.value;
    }

    /**
     * setValue.
     * @param value T
     */
    public void setValue(final T value) {
        this.value = value;
    }

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Poid: ");
        buff.append(this.value.toString());
        return buff.toString();
    }
}
