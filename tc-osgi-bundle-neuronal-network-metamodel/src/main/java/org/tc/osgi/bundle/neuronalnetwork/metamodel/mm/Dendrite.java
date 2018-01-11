package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;

/**
 * Dendrite.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class Dendrite<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 559866134774849246L;
    /**
     * Poid<T> poid.
     */
    @SuppressWarnings("unchecked")
    private Poid<T> poid = new Poid<T>((T) new Integer(1));
    /**
     * Signal<T> signal.
     */
    private Signal<T> signal;

    /**
     * Dendrite constructor.
     */
    public Dendrite() {
        super();
    }

    /**
     * Dendrite constructor.
     * @param poid Poid<T>
     * @param signal Signal<T>
     */
    public Dendrite(final Poid<T> poid, final Signal<T> signal) {
        super();
        this.poid = poid;
        this.signal = signal;
    }

    /**
     * evaluate.
     * @return T
     */
    @SuppressWarnings("unchecked")
    public T evaluate() {
        return (T) new Double(this.poid.getValue().doubleValue() * this.signal.getValue().doubleValue());
    }

    /**
     * getPoid.
     * @return Poid<T>
     */
    public Poid<T> getPoid() {
        return this.poid;
    }

    /**
     * getSignal.
     * @return Signal<T>
     */
    public Signal<T> getSignal() {
        return this.signal;
    }

    /**
     * setPoid.
     * @param poid Poid<T>
     */
    public void setPoid(final Poid<T> poid) {
        this.poid = poid;
    }

    /**
     * setSignal.
     * @param signal Signal<T>
     */
    public void setSignal(final Signal<T> signal) {
        this.signal = signal;
    }

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Dendrite: ");
        buff.append(this.poid.toString());
        buff.append(", ");
        if (this.signal != null) {
            buff.append(this.signal.toString());
        } else {
            buff.append("null");
        }
        buff.append("\n");
        return buff.toString();
    }
}
