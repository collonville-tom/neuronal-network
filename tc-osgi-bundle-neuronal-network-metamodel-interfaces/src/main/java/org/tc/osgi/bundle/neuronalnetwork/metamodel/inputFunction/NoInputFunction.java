package org.tc.osgi.bundle.neuronalnetwork.metamodel.inputFunction;

import java.util.ArrayList;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Biais;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.InputFunction;

/**
 * NoInputFunction.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class NoInputFunction<T extends Number> extends InputFunction<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 1312401521294890966L;

    /**
     * NoInputFunction constructor.
     */
    public NoInputFunction() {
        super();
    }

    /**
     * @param dendriteList ArrayList<Dendrite<T>>
     * @param biais Biais<T>
     * @return T
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.InputFunction#evaluate(java.util.ArrayList, org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Biais)
     */
    @Override
    public T evaluate(final ArrayList<Dendrite<T>> dendriteList, final Biais<T> biais) {
        return null;
    }
}