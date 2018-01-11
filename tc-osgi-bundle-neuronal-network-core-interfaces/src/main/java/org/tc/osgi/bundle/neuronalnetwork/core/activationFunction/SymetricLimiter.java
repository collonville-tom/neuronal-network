package org.tc.osgi.bundle.neuronalnetwork.core.activationFunction;

/**
 * SymetricLimiter.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class SymetricLimiter<T extends Number> extends Limiter<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 2963836565345003127L;
    /**
     * int seuilNegatif.
     */
    private int seuilNegatif = -1;

    /**
     * SymetricLimiter constructor.
     */
    public SymetricLimiter() {
        super();
    }

    /**
     * SymetricLimiter constructor.
     * @param activatedAt int
     * @param seuilPositif int
     * @param seuilNegatif int
     */
    public SymetricLimiter(final int activatedAt, final int seuilPositif, final int seuilNegatif) {
        super(activatedAt, seuilPositif);
        this.seuilNegatif = seuilNegatif;
    }

    /**
     * @param value T
     * @return T
     * @see org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.Limiter#evaluate(java.lang.Number)
     */
    @Override
    @SuppressWarnings("unchecked")
    public T evaluate(final T value) {
        if (getActivatedAt() > value.floatValue()) {
            return (T) new Float(this.seuilNegatif);
        } else {
            return (T) new Float(getSeuilPositif());
        }
    }

    /**
     * getSeuilNegatif.
     * @return int
     */
    public int getSeuilNegatif() {
        return this.seuilNegatif;
    }

    /**
     * setSeuilNegatif.
     * @param seuilNegatif int
     */
    public void setSeuilNegatif(final int seuilNegatif) {
        this.seuilNegatif = seuilNegatif;
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.Limiter#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Fonction d'activation de type Limiteur symetrique de seuil negatif: ");
        buff.append(this.seuilNegatif);
        buff.append(" de seuil negatif: ");
        buff.append(getSeuilPositif());
        buff.append(" et d'activation �: ");
        buff.append(getActivatedAt());
        return buff.toString();
    }
}
