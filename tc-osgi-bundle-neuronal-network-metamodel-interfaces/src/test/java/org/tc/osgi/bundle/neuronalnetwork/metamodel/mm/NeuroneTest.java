package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.util.ArrayList;

import org.junit.Test;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.activationFunction.NoActivationFunction;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.inputFunction.NoInputFunction;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.ReseauNeuronal;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.UnidirectionnalLayer;

/**
 * NeuroneTest.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 * @req STD_BUNDLE_NN_METAMODEL_010
 * @tack SRS_BUNDLE_NN_METAMODEL_010, SRS_BUNDLE_NN_METAMODEL_020, SRS_BUNDLE_NN_METAMODEL_030, SRS_BUNDLE_NN_METAMODEL_040, SRS_BUNDLE_NN_METAMODEL_050, SRS_BUNDLE_NN_METAMODEL_060
 */
public class NeuroneTest {


	
    /**
     * reseauBase.
     * @throws Exception
     */
    @Test
    public void reseauBase() throws Exception {
        // Reseau de type perceptron 2-couche quelconque
        // creation signaux d'entr�e
        final ArrayList<Signal<Double>> signalInput = new ArrayList<Signal<Double>>();
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        // Creation des couches de neurones
        

        final Neurone<Double> n = new Neurone<Double>();
        n.setBiais(new Biais<Double>());
        n.setEngine(new NeuronalEngine<Double>(new NoInputFunction<Double>(), new NoActivationFunction<Double>()));
        n.setOutputDendrite(new Dendrite<Double>(new Poid<Double>(2.0), new Signal<Double>(1.0)));
        final ArrayList<Dendrite<Double>> inputDendrites = new ArrayList<Dendrite<Double>>();
        for (int i = 0; i < 10; i++) {
            inputDendrites.add(new Dendrite<Double>(new Poid<Double>(2.0), new Signal<Double>(1.0)));
        }
        n.setInputDendrites(inputDendrites);

        final Layer<Double> layer1 = new UnidirectionnalLayer<Double>();
        layer1.getNeurones().add(n);

        // creation du reseau
        final ReseauNeuronal<Double> reseau = new ReseauNeuronal<Double>();
        reseau.putLayer(layer1);
        reseau.evaluate(signalInput);
        System.out.println(reseau.getOutputSignal());
    }

}
