package org.tc.osgi.bundle.neuronalnetwork.metamodel.factory;

import java.util.ArrayList;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ActivationFunction;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.InputFunction;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Neurone;

/**
 * NeuroneFactory.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public class NeuroneFactory<T extends Number> {
    /**
     * NeuroneFactory constructor.
     */
    public NeuroneFactory() {
    }

    /**
     * createNeurone.
     * @param nbrInput int
     * @param inputFunction Class
     * @param activationFunction Class
     * @return Neurone<T>
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
    public Neurone<T> createNeurone(final int nbrInput, final Class inputFunction, final Class activationFunction) throws InstantiationException, IllegalAccessException {
        final Neurone<T> neurone = new Neurone<T>();
        for (int i = 0; i < nbrInput; i++) {
            neurone.getInputDendrites().add(new Dendrite<T>());
        }
        if (activationFunction != null) {
            neurone.getEngine().setActivationFunction((ActivationFunction) activationFunction.newInstance());
        }
        if (activationFunction != null) {
            neurone.getEngine().setInputFunction((InputFunction) inputFunction.newInstance());
        }
        return neurone;
    }

    /**
     * createNeuroneList.
     * @param nbrNeurone int
     * @param nbrInput int
     * @param inputFunction Class
     * @param activationFunction Class
     * @return ArrayList<Neurone<T>>
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public ArrayList<Neurone<T>> createNeuroneList(final int nbrNeurone, final int nbrInput, final Class inputFunction, final Class activationFunction) throws InstantiationException,
    IllegalAccessException {
        final ArrayList<Neurone<T>> list = new ArrayList<Neurone<T>>();
        for (int i = 0; i < nbrNeurone; i++) {
            list.add(this.createNeurone(nbrInput, inputFunction, activationFunction));
        }
        return list;
    }

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Permet la creation d'un neurone\n";
    }
}
