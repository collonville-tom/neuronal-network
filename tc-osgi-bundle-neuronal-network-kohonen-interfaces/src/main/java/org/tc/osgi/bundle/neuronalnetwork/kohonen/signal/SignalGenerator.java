package org.tc.osgi.bundle.neuronalnetwork.kohonen.signal;

import java.awt.Dimension;
import java.util.ArrayList;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Signal;

/**
 * SignalGenerator.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public class SignalGenerator<T extends Number> {
    private ArrayList<Signal<T>> signals = new ArrayList<Signal<T>>();

    /**
     * SignalGenerator constructor.
     * @param nbr int
     * @param dim Dimension
     * @param type int
     */
    @SuppressWarnings("unchecked")
    public SignalGenerator(final int nbr, final Dimension dim, final int type) {
        if (type == 0) {
            this.rectangularGenerator(nbr, dim);
        }
        if (type == 1) {
            this.triangularGenerator(nbr, dim);
        }
        if (type == 2) {
            this.circularGenerator(nbr, dim);
        }
        if (type == 3) {
            this.demicircularGenerator(nbr, dim);
        }
        if (type == 4) {
            this.quatercircularGenerator(nbr, dim);
        }

    }

    /**
     * circularGenerator.
     * @param nbr int
     * @param dim Dimension
     */
    public void circularGenerator(final int nbr, final Dimension dim) {
        final double Xcenter = dim.width / 2;
        final double Ycenter = dim.height / 2;
        for (int i = 0; i < nbr; i++) {
            final double x = Math.random() * dim.width;
            final double y = Math.random() * dim.height;
            final double d = Math.sqrt(((x - Xcenter) * (x - Xcenter)) + ((y - Ycenter) * (y - Ycenter)));
            if (d < Xcenter) {
                this.signals.add(new Signal(x));
                this.signals.add(new Signal(y));
            }
        }

    }

    /**
     * demicircularGenerator.
     * @param nbr int
     * @param dim Dimension
     */
    public void demicircularGenerator(final int nbr, final Dimension dim) {
        final double Xcenter = dim.width / 2;
        final double Ycenter = dim.height / 2;
        for (int i = 0; i < nbr; i++) {
            final double x = Math.random() * dim.width;
            final double y = Math.random() * dim.height;
            final double d = Math.sqrt(((x - Xcenter) * (x - Xcenter)) + ((y) * (y)));
            if (d < Xcenter) {
                this.signals.add(new Signal(x));
                this.signals.add(new Signal(y));
            }
        }

    }

    /**
     * getSignals.
     * @return ArrayList<Signal<T>>
     */
    public ArrayList<Signal<T>> getSignals() {
        return this.signals;
    }

    /**
     * quatercircularGenerator.
     * @param nbr int
     * @param dim Dimension
     */
    public void quatercircularGenerator(final int nbr, final Dimension dim) {
        final double Xcenter = dim.width / 2;
        final double Ycenter = dim.height / 2;
        for (int i = 0; i < nbr; i++) {
            final double x = Math.random() * dim.width;
            final double y = Math.random() * dim.height;
            final double d = Math.sqrt(((x) * (x)) + ((y) * (y)));
            if (d < Xcenter) {
                this.signals.add(new Signal(x));
                this.signals.add(new Signal(y));
            }
        }

    }

    /**
     * rectangularGenerator.
     * @param nbr int
     * @param dim Dimension
     */
    private void rectangularGenerator(final int nbr, final Dimension dim) {
        for (int i = 0; i < nbr; i++) {
            this.signals.add(new Signal(Math.random() * dim.width));
            this.signals.add(new Signal(Math.random() * dim.height));
        }
    }

    /**
     * setSignals.
     * @param signals ArrayList<Signal<T>>
     */
    public void setSignals(final ArrayList<Signal<T>> signals) {
        this.signals = signals;
    }

    /**
     * triangularGenerator.
     * @param nbr int
     * @param dim Dimension
     */
    public void triangularGenerator(final int nbr, final Dimension dim) {
        for (int i = 0; i < nbr; i++) {
            final double x = Math.random() * dim.width;
            final double y = Math.random() * dim.height;
            if (y < x) {
                this.signals.add(new Signal(x));
                this.signals.add(new Signal(y));
            }
        }

    }
}
