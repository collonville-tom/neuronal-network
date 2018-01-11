package org.tc.osgi.bundle.neuronalnetwork.core.supervisedFunction;

import java.util.ArrayList;

/**
 * LinearDegressiveFunction.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public class LinearDegressiveFunction<T extends Number> extends VoisinageFunction<T> {
    /**
     * LinearDegressiveFunction constructor.
     * @param nbrIteration int
     * @param penteSurNiveau double
     * @param nbrNiveau int
     * @param coefAmmortissement double
     * @param coefEfficacite double
     */
    public LinearDegressiveFunction(final int nbrIteration, final double penteSurNiveau, final int nbrNiveau, final double coefAmmortissement, final double coefEfficacite) {
        super(nbrIteration, penteSurNiveau, nbrNiveau, coefAmmortissement, coefEfficacite);
    }

    /**
     *
     * @see org.tc.osgi.bundle.neuronalnetwork.core.supervisedFunction.VoisinageFunction#evaluate()
     */
    @SuppressWarnings("unchecked")
    @Override
    public void evaluate() {
        setValueX(new ArrayList<T>());
        setValueY(new ArrayList<T>());
        for (int i = 0; i < getNbrNiveau(); i++) {
            if ((i * getPenteSurNiveau()) > getCoefEfficacite()) {
                this.getValueX().add((T) new Float(0));
                this.getValueY().add((T) new Float(0));
            } else {
                this.getValueX().add((T) new Float(getCoefEfficacite() - (i * getPenteSurNiveau())));
                this.getValueY().add((T) new Float(getCoefEfficacite() - (i * getPenteSurNiveau())));
            }
        }
        setCoefEfficacite(getCoefEfficacite() - getCoefAmmortissement());
    }
}
