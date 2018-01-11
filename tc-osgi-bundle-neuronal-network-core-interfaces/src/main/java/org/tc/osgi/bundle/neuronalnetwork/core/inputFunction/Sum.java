package org.tc.osgi.bundle.neuronalnetwork.core.inputFunction;

import java.util.ArrayList;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Biais;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.InputFunction;

/**
 * Sum.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class Sum<T extends Number> extends InputFunction<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -8534205402278032127L;

    /**
     * Sum constructor.
     */
    public Sum() {
        super();
    }

    /**
     * @param dendriteList ArrayList<Dendrite<T>>
     * @param biais Biais<T>
     * @return T
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.InputFunction#evaluate(java.util.ArrayList, org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Biais)
     */
    @Override
    @SuppressWarnings("unchecked")
    public T evaluate(final ArrayList<Dendrite<T>> dendriteList, final Biais<T> biais) {
        float f = 0;
        for (final Dendrite<T> d : dendriteList) {
            f = f + d.evaluate().floatValue();
        }
        f = f + biais.evaluate().floatValue();
        return (T) new Float(f);
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.InputFunction#toString()
     */
    @Override
    public String toString() {
        return "Fonction d'entree realisant la sommation des entrees du neurone\n";
    }
}
