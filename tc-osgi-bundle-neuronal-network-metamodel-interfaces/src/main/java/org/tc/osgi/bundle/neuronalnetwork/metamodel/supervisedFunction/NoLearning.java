package org.tc.osgi.bundle.neuronalnetwork.metamodel.supervisedFunction;

import java.util.ArrayList;
import java.util.HashMap;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Signal;

/**
 * NoLearning.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class NoLearning<T extends Number> extends LearningMethod<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 5978631158534591850L;

    /**
     * @param layer Layer<T>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#learn(org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer)
     */
    @Override
    public void learn(final Layer<T> layer) {
    }

    /**
     * @param layer Layer<T>
     * @param learningValue ArrayList<Signal<T>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#learn(org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer, java.util.ArrayList)
     */
    @Override
    public void learn(final Layer<T> layer, final ArrayList<Signal<T>> learningValue) {
    }

    /**
     * @param layer  Layer<T>
     * @param learningValue HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#learn(org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer, java.util.HashMap)
     */
    @Override
    public void learn(final Layer<T> layer, final HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>> learningValue) {
    }

    /**
     * @return
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#toString()
     */
    @Override
    public String toString() {
        return "NoLearning";
    }
}
