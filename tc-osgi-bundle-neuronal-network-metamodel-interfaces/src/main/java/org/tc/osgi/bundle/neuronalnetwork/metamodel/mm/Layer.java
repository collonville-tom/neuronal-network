package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.supervisedFunction.NoLearning;

/**
 * Layer.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public abstract class Layer<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 1272712903780114147L;
    /**
     * LearningMethod<T> learningMethod.
     */
    private LearningMethod<T> learningMethod = new NoLearning<T>();
    /**
     * ArrayList<Neurone<T>> neurones.
     */
    private ArrayList<Neurone<T>> neurones = new ArrayList<Neurone<T>>();

    /**
     * evaluate.
     */
    public abstract void evaluate();

    /**
     * evaluate.
     * @param signal ArrayList<Signal<T>>
     */
    public abstract void evaluate(ArrayList<Signal<T>> signal);

    /**
     * getLearningMethod.
     * @return LearningMethod<T>
     */
    public LearningMethod<T> getLearningMethod() {
        return this.learningMethod;
    }

    /**
     * getNeurones.
     * @return ArrayList<Neurone<T>>
     */
    public ArrayList<Neurone<T>> getNeurones() {
        return this.neurones;
    }

    /**
     * getOutputSignal.
     * @return ArrayList<Signal<T>>
     */
    public ArrayList<Signal<T>> getOutputSignal() {
        final ArrayList<Signal<T>> array = new ArrayList<Signal<T>>();
        for (final Neurone<T> n : this.neurones) {
            array.add(n.getOutputDendrite().getSignal());
        }
        return array;
    }

    /**
     * initLayer.
     * @param poids ArrayList<Poid<T>>
     * @param biais ArrayList<Poid<T>>
     */
    public abstract void initLayer(ArrayList<Poid<T>> poids, ArrayList<Poid<T>> biais);

    /**
     * learn.
     */
    public void learn() {
        this.learningMethod.learn(this);
    }

    /**
     * learn.
     * @param learningValue HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>>
     */
    public void learn(final HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>> learningValue) {
        this.learningMethod.learn(this, learningValue);
    }

    /**
     * setLearningMethod.
     * @param learningMethod LearningMethod<T>
     */
    public void setLearningMethod(final LearningMethod<T> learningMethod) {
        this.learningMethod = learningMethod;
    }

    /**
     * setNeurones.
     * @param neurones ArrayList<Neurone<T>>
     */
    public void setNeurones(final ArrayList<Neurone<T>> neurones) {
        this.neurones = neurones;
    }

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Couche du reseau(Nombre de neurone: ");
        buff.append(this.neurones.size());
        buff.append("): \n");
        final Iterator<Neurone<T>> it = this.neurones.iterator();
        for (; it.hasNext();) {
            buff.append(it.next().toString());
        }
        return buff.toString();
    }
}
