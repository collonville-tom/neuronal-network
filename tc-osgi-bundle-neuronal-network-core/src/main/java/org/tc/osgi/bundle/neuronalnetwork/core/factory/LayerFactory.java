package org.tc.osgi.bundle.neuronalnetwork.core.factory;

import org.tc.osgi.bundle.neuronalnetwork.core.layer.RecurentLayer;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.exception.ConnectionSynaptiqueException;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.factory.NeuroneFactory;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.ReseauNeuronal;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.UnidirectionnalLayer;

/**
 * LayerFactory.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public class LayerFactory<T extends Number> {
    /**
     * LayerFactory constructor.
     */
    public LayerFactory() {
    }

    /**
     * createNetwork.
     * @return ReseauNeuronal<T>
     */
    public ReseauNeuronal<T> createNetwork() {
        return new ReseauNeuronal<T>();
    }

    /**
     * createUnidirectionnalLayer.
     * @param nbrNeurone int
     * @param nbrInput int
     * @param inputFunction Class
     * @param activationFunction Class
     * @return UnidirectionnalLayer<T>
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public UnidirectionnalLayer<T> createUnidirectionnalLayer(final int nbrNeurone, final int nbrInput, final Class inputFunction, final Class activationFunction) throws InstantiationException,
    IllegalAccessException {
        final UnidirectionnalLayer<T> layer = new UnidirectionnalLayer<T>();
        final NeuroneFactory<T> neuroneFactory = new NeuroneFactory<T>();
        for (int i = 0; i < nbrNeurone; i++) {
            layer.getNeurones().add(neuroneFactory.createNeurone(nbrInput, inputFunction, activationFunction));
        }
        return layer;
    }

    /**
     * recurentLayer.
     * @param nbrInput int
     * @param classe Class
     * @return RecurentLayer<T>
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ConnectionSynaptiqueException
     */
    public RecurentLayer<T> recurentLayer(final int nbrInput, final Class classe) throws InstantiationException, IllegalAccessException, ConnectionSynaptiqueException {
        return new RecurentLayer<T>(nbrInput, classe);
    }

    /**
     * recurentLayer.
     * @param nbrInput int
     * @param nbrIteration int
     * @param classe Class
     * @return RecurentLayer<T>
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ConnectionSynaptiqueException
     */
    public RecurentLayer<T> recurentLayer(final int nbrInput, final int nbrIteration, final Class classe) throws InstantiationException, IllegalAccessException, ConnectionSynaptiqueException {
        return new RecurentLayer<T>(nbrInput, nbrIteration, classe);
    }

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Permet la creation de Layer\n";
    }

}
