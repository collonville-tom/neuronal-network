package org.tc.osgi.bundle.neuronalnetwork.core.activationFunction;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction;

/**
 * Limiter.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class Limiter<T extends Number> extends ActivationFunction<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -222282433688493469L;
    /**
     * int activatedAt.
     */
    private int activatedAt = 0;
    /**
     * int seuilPositif.
     */
    private int seuilPositif = 1;

    /**
     * Limiter constructor.
     */
    public Limiter() {
        super();
    }

    /**
     * Limiter constructor.
     * @param activatedAt int
     * @param seuil int
     */
    public Limiter(final int activatedAt, final int seuil) {
        super();
        this.activatedAt = activatedAt;
        this.seuilPositif = seuil;
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
            return (T) new Float(this.seuilPositif);
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
     * getSeuilPositif.
     * @return int
     */
    public int getSeuilPositif() {
        return this.seuilPositif;
    }

    /**
     * setActivatedAt.
     * @param activatedAt int
     */
    public void setActivatedAt(final int activatedAt) {
        this.activatedAt = activatedAt;
    }

    /**
     * setSeuilPositif.
     * @param seuilPositif int
     */
    public void setSeuilPositif(final int seuilPositif) {
        this.seuilPositif = seuilPositif;
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Fonction d'activation de type limiteur de seuil: ");
        buff.append(this.seuilPositif);
        buff.append(" et de seuil d'activation: ");
        buff.append(this.activatedAt);
        return buff.toString();
    }
}
