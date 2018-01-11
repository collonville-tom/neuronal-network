package org.tc.osgi.bundle.neuronalnetwork.core.activationFunction;

/**
 * LinearLimiter.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class LinearLimiter<T extends Number> extends SymetricLimiter<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -6041820640114402260L;

    /**
     * LinearLimiter constructor.
     */
    public LinearLimiter() {
        super();
    }

    /**
     * LinearLimiter constructor.
     * @param activatedAt int
     * @param seuilPositif int
     * @param seuilNegatif int
     */
    public LinearLimiter(final int activatedAt, final int seuilPositif, final int seuilNegatif) {
        super(activatedAt, seuilPositif, seuilNegatif);
    }

    /**
     * @param value T
     * @return T
     * @see org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.SymetricLimiter#evaluate(java.lang.Number)
     */
    @Override
    @SuppressWarnings("unchecked")
    public T evaluate(final T value) {
        if (-1 > value.floatValue()) {
            return (T) new Float(-1);
        } else {
            if (1 < value.floatValue()) {
                return (T) new Float(1);
            } else {
                return value;
            }
        }
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.SymetricLimiter#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Fonction d'activation de type LinearLimiter ");
        return buff.toString();
    }
}