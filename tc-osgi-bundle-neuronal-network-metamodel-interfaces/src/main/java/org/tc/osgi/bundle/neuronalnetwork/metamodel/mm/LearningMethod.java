package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * LearningMethod.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public abstract class LearningMethod<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 3223563117132202829L;

    /**
     * learn.
     * @param layer Layer<T>
     */
    public abstract void learn(Layer<T> layer);

    /**
     * learn.
     * @param layer Layer<T>
     * @param learningValue ArrayList<Signal<T>>
     */
    public abstract void learn(Layer<T> layer, ArrayList<Signal<T>> learningValue);

    /**
     * learn.
     * @param layer Layer<T>
     * @param learningValue HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>>
     */
    public abstract void learn(Layer<T> layer, HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>> learningValue);

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public abstract String toString();
}
