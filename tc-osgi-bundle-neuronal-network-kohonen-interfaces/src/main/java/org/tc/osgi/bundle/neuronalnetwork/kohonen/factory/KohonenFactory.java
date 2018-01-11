package org.tc.osgi.bundle.neuronalnetwork.kohonen.factory;

import org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.PositiveLinear;
import org.tc.osgi.bundle.neuronalnetwork.core.factory.LayerFactory;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.layer.Kohonen;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.exception.ConnectionSynaptiqueException;

/**
 * KohonenFactory.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public class KohonenFactory<T extends Number> extends LayerFactory<T> {
    /**
     * KohonenFactory constructor.
     */
    public KohonenFactory() {
        super();
    }

    /**
     * kohonen.
     * @param nbrNeurone int
     * @param nbrInput int
     * @param name Class<PositiveLinear
     * @return Kohonen<Double>
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ConnectionSynaptiqueException
     */
    @SuppressWarnings("unchecked")
    public Kohonen<Double> kohonen(final int nbrNeurone, final int nbrInput, final Class<PositiveLinear> name) throws InstantiationException, IllegalAccessException, ConnectionSynaptiqueException {
        return new Kohonen(nbrNeurone, nbrInput, name);
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.core.factory.LayerFactory#toString()
     */
    @Override
    public String toString() {
        return "Permet la creation de Layer\n";
    }
}
