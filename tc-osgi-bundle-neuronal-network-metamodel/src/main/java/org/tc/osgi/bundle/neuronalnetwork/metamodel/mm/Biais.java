package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

/**
 * Biais.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class Biais<T extends Number> extends Dendrite<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 1704043265008263395L;

    /**
     * Biais constructor.
     */
    @SuppressWarnings("unchecked")
    public Biais() {
        super(new Poid<T>((T) new Integer(1)), new Signal<T>((T) new Integer(1)));
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Biais: ");
        buff.append(getPoid().toString());
        buff.append(", ");
        if (getSignal() != null) {
            buff.append(getSignal().toString());
        } else {
            buff.append("null");
        }
        buff.append("\n");
        return buff.toString();
    }
}
