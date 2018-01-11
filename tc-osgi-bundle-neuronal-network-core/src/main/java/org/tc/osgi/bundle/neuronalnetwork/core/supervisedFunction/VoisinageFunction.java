package org.tc.osgi.bundle.neuronalnetwork.core.supervisedFunction;

import java.util.ArrayList;

/**
 * VoisinageFunction.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public abstract class VoisinageFunction<T extends Number> {
    /**
     * double coefAmmortissement.
     */
    private double coefAmmortissement = Double.MIN_VALUE;
    /**
     * double coefEfficacite.
     */
    private double coefEfficacite = 1;
    /**
     * int nbrNiveau.
     */
    private int nbrNiveau;
    /**
     * double penteSurNiveau.
     */
    private double penteSurNiveau = 0;
    /**
     * ArrayList<T> valueX.
     */
    private ArrayList<T> valueX;
    /**
     * ArrayList<T> valueY.
     */
    private ArrayList<T> valueY;

    /**
     * VoisinageFunction constructor.
     * @param nbrIteration int
     * @param penteSurNiveau double
     * @param nbrNiveau int
     * @param coefAmortisement double
     * @param coefEfficacite double
     */
    public VoisinageFunction(final int nbrIteration, final double penteSurNiveau, final int nbrNiveau, final double coefAmortisement, final double coefEfficacite) {
        this.penteSurNiveau = penteSurNiveau;
        this.nbrNiveau = nbrNiveau;
        this.coefAmmortissement = coefAmortisement;
        this.coefEfficacite = coefEfficacite;
    }

    /**
     * evaluate.
     */
    public abstract void evaluate();

    /**
     * getCoefAmmortissement.
     * @return double
     */
    public double getCoefAmmortissement() {
        return this.coefAmmortissement;
    }

    /**
     * getCoefEfficacite.
     * @return double
     */
    public double getCoefEfficacite() {
        return this.coefEfficacite;
    }

    /**
     * getNbrNiveau.
     * @return int
     */
    public int getNbrNiveau() {
        return this.nbrNiveau;
    }

    /**
     * getPenteSurNiveau.
     * @return double
     */
    public double getPenteSurNiveau() {
        return this.penteSurNiveau;
    }

    /**
     * getValueX.
     * @return ArrayList<T>
     */
    public ArrayList<T> getValueX() {
        return this.valueX;
    }

    /**
     * getValueX.
     * @param niveau int
     * @return T
     */
    public T getValueX(final int niveau) {
        return this.valueX.get(niveau);
    }

    /**
     * getValueY.
     * @return ArrayList<T>
     */
    public ArrayList<T> getValueY() {
        return this.valueY;
    }

    /**
     * getValueY.
     * @param niveau int
     * @return T
     */
    public T getValueY(final int niveau) {
        return this.valueY.get(niveau);
    }

    /**
     * setCoefAmmortissement.
     * @param coefAmmortissement double
     */
    public void setCoefAmmortissement(final double coefAmmortissement) {
        this.coefAmmortissement = coefAmmortissement;
    }

    /**
     * setCoefEfficacite.
     * @param coefEfficacite double
     */
    public void setCoefEfficacite(final double coefEfficacite) {
        this.coefEfficacite = coefEfficacite;
    }

    /**
     * setNbrNiveau.
     * @param nbrNiveau int
     */
    public void setNbrNiveau(final int nbrNiveau) {
        this.nbrNiveau = nbrNiveau;
    }

    /**
     * setPenteSurNiveau.
     * @param penteSurNiveau double
     */
    public void setPenteSurNiveau(final double penteSurNiveau) {
        this.penteSurNiveau = penteSurNiveau;
    }

    /**
     * setValueX.
     * @param valueX ArrayList<T>
     */
    public void setValueX(final ArrayList<T> valueX) {
        this.valueX = valueX;
    }

    /**
     * setValueY.
     * @param valueY ArrayList<T>
     */
    public void setValueY(final ArrayList<T> valueY) {
        this.valueY = valueY;
    }
}
