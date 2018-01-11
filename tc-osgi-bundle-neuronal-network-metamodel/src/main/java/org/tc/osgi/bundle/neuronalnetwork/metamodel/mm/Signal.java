package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;

/**
 * Signal.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class Signal<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -3665398091246956638L;
    /**
     * T value.
     */
    private T value;

    /**
     * Signal constructor.
     */
    public Signal() {
        super();
    }

    /**
     * Signal constructor.
     * @param value T
     */
    public Signal(final T value) {
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
        final StringBuffer buff = new StringBuffer("Signal: ");
        buff.append(this.value);
        return buff.toString();
    }
}
