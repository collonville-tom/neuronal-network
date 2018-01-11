package org.tc.osgi.bundle.neuronalnetwork.core.supervisedFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Biais;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Neurone;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Poid;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Signal;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.ReseauNeuronal;

/**
 * PerceptronMonoCoucheLearning.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class PerceptronMonoCoucheLearning<T extends Number> extends LearningMethod<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 1745772370950863522L;

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
        // TODO Auto-generated method stub
    }

    /**
     * @param layer Layer<T>
     * @param learningValue HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#learn(org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer, java.util.HashMap)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void learn(final Layer<T> layer, final HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>> learningValue) {
        final Iterator<ArrayList<Signal<T>>> it = learningValue.keySet().iterator();
        for (; it.hasNext();) {
            final ArrayList<Signal<T>> key = it.next();
            layer.evaluate(key);
            final Iterator<Neurone<T>> itNeurone = ((ReseauNeuronal<T>) layer).getLayers().get(0).getNeurones().iterator();
            final Iterator<Signal<T>> outputsLearning = learningValue.get(key).iterator();
            for (; itNeurone.hasNext();) {
                final Neurone<T> neurone = itNeurone.next();
                final Biais<T> biais = neurone.getBiais();
                final Signal<T> outputLearning = outputsLearning.next();
                final Iterator<Dendrite<T>> itDendrite = neurone.getInputDendrites().iterator();
                final Dendrite<T> outputDendrite = neurone.getOutputDendrite();
                // correction du biais
                biais.setPoid(new Poid<T>((T) new Float(biais.getPoid().getValue().floatValue()
                    + (((outputLearning.getValue().floatValue()) - (outputDendrite.getSignal().getValue().floatValue())) * (biais.getSignal().getValue().floatValue())))));
                // correction du poid de la dendrite
                for (; itDendrite.hasNext();) {
                    final Dendrite<T> dendrite = itDendrite.next();
                    dendrite.setPoid(new Poid<T>((T) new Float(dendrite.getPoid().getValue().floatValue()
                        + (((outputLearning.getValue().floatValue()) - (outputDendrite.getSignal().getValue().floatValue())) * (dendrite.getSignal().getValue().floatValue())))));
                }
            }
        }
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#toString()
     */
    @Override
    public String toString() {
        return "PerceptronMonoCoucheLearning :Apprentissage de type w(new)=w(old)+(t-a)p";
    }
}
