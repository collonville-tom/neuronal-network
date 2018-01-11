package org.tc.osgi.bundle.neuronalnetwork.core;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;
import org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.Limiter;
import org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.Linear;
import org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.LinearLimiter;
import org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.PositiveLinear;
import org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.SymetricLimiter;
import org.tc.osgi.bundle.neuronalnetwork.core.factory.LayerFactory;
import org.tc.osgi.bundle.neuronalnetwork.core.inputFunction.Sum;
import org.tc.osgi.bundle.neuronalnetwork.core.layer.RecurentLayer;
import org.tc.osgi.bundle.neuronalnetwork.core.supervisedFunction.PerceptronMonoCoucheLearning;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Poid;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Signal;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.ReseauNeuronal;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.UnidirectionnalLayer;

/**
 * NeuronalNetworkTest.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 * @req STD_BUNDLE_NN_CORE_010
 * @tack SRS_BUNDLE_NN_CORE_010, SRS_BUNDLE_NN_CORE_020, SRS_BUNDLE_NN_CORE_030, SRS_BUNDLE_NN_CORE_040
 */
public class NeuronalNetworkTest {

    /**
     * hammingLayer.
     * @throws Exception
     */
    @Test
    public void hammingLayer() throws Exception {
        // Reseau de type Hamming
        final LayerFactory<Double> layerfactory = new LayerFactory<Double>();
        // couche1 //ici le nombre de neurone est en coherence avec le nombre de
        // patron que l'on souhaite reconnaitre
        // 3 neurones pour deux entr�e
        final UnidirectionnalLayer<Double> layer1 = layerfactory.createUnidirectionnalLayer(2, 3, Sum.class, Linear.class);
        // creation des inits des poids du layer1
        final ArrayList<Poid<Double>> poids1 = new ArrayList<Poid<Double>>();
        final ArrayList<Poid<Double>> biais1 = new ArrayList<Poid<Double>>();
        // neurone1
        poids1.add(new Poid<Double>(new Double(1)));
        poids1.add(new Poid<Double>(new Double(-1)));
        poids1.add(new Poid<Double>(new Double(-1)));
        biais1.add(new Poid<Double>(new Double(3)));
        // neurone2
        poids1.add(new Poid<Double>(new Double(1)));
        poids1.add(new Poid<Double>(new Double(1)));
        poids1.add(new Poid<Double>(new Double(-1)));
        biais1.add(new Poid<Double>(new Double(3)));
        layer1.initLayer(poids1, biais1);
        // couche 2
        final RecurentLayer<Double> layer2 = layerfactory.recurentLayer(2, 10, PositiveLinear.class);
        // creation des inits des poids du layer2
        final ArrayList<Poid<Double>> poids = new ArrayList<Poid<Double>>();
        final ArrayList<Poid<Double>> biais = new ArrayList<Poid<Double>>();
        // neurone1
        poids.add(new Poid<Double>(new Double(1)));
        poids.add(new Poid<Double>(new Double(-0.5)));
        biais.add(new Poid<Double>(new Double(0)));
        // neurone2
        poids.add(new Poid<Double>(new Double(-0.5)));
        poids.add(new Poid<Double>(new Double(1)));
        biais.add(new Poid<Double>(new Double(0)));
        layer2.initLayer(poids, biais);
        // creation du reseau global
        final ReseauNeuronal<Double> reseau = layerfactory.createNetwork();
        reseau.putLayer(layer1);
        reseau.putLayer(layer2);
        // creation signaux d'entr�e
        final ArrayList<Signal<Double>> signalInput = new ArrayList<Signal<Double>>();
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(-1)));
        signalInput.add(new Signal<Double>(new Double(-1)));
        reseau.evaluate(signalInput);
        System.out.println(reseau.getOutputSignal());
        // a tendance a diverger.... du au framework...???
    }

    /**
     * perceptron1.
     * @throws Exception
     */
    @Test
    public void perceptron1() throws Exception {
        // Reseau de type perceptron 2-couche quelconque
        // creation signaux d'entr�e
        final ArrayList<Signal<Double>> signalInput = new ArrayList<Signal<Double>>();
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(-1)));
        signalInput.add(new Signal<Double>(new Double(-1)));
        // Creation des couches de neurones
        final LayerFactory<Double> layerfactory = new LayerFactory<Double>();
        Layer<Double> layer1 = null;
        Layer<Double> layer2 = null;
        layer1 = layerfactory.createUnidirectionnalLayer(2, 3, Sum.class, SymetricLimiter.class);
        layer2 = layerfactory.createUnidirectionnalLayer(1, 2, Sum.class, SymetricLimiter.class);
        // creation des inits des poids du layer1
        final ArrayList<Poid<Double>> poids = new ArrayList<Poid<Double>>();
        poids.add(new Poid<Double>(new Double(0)));
        poids.add(new Poid<Double>(new Double(1)));
        poids.add(new Poid<Double>(new Double(0)));
        poids.add(new Poid<Double>(new Double(1)));
        poids.add(new Poid<Double>(new Double(1)));
        poids.add(new Poid<Double>(new Double(0)));
        final ArrayList<Poid<Double>> biais = new ArrayList<Poid<Double>>();
        biais.add(new Poid<Double>(new Double(0)));
        biais.add(new Poid<Double>(new Double(0)));
        layer1.initLayer(poids, biais);
        // creation des inits des poids du layer2
        final ArrayList<Poid<Double>> poids2 = new ArrayList<Poid<Double>>();
        poids2.add(new Poid<Double>(new Double(0)));
        poids2.add(new Poid<Double>(new Double(1)));
        final ArrayList<Poid<Double>> biais2 = new ArrayList<Poid<Double>>();
        biais2.add(new Poid<Double>(new Double(0)));
        layer2.initLayer(poids2, biais2);
        // creation du reseau
        final ReseauNeuronal<Double> reseau = layerfactory.createNetwork();
        reseau.putLayer(layer1);
        reseau.putLayer(layer2);
        reseau.evaluate(signalInput);
        System.out.println(reseau.getOutputSignal());
    }

    /**
     * perceptron2.
     * @throws Exception
     */
    @Test
    public void perceptron2() throws Exception {
        // Reseau de type perceptron 2 couche realisant la fonction ou-exclusif
        final LayerFactory<Double> layerfactory = new LayerFactory<Double>();
        // creation du reseau
        final ReseauNeuronal<Double> reseau = layerfactory.createNetwork();
        // Creation des couches de neurones
        final Layer<Double> layer1 = layerfactory.createUnidirectionnalLayer(2, 2, Sum.class, Limiter.class);
        final Layer<Double> layer2 = layerfactory.createUnidirectionnalLayer(1, 2, Sum.class, Limiter.class);
        reseau.putLayer(layer1);
        reseau.putLayer(layer2);
        // creation des inits des poids du layer1
        final ArrayList<Poid<Double>> poids = new ArrayList<Poid<Double>>();
        final ArrayList<Poid<Double>> biais = new ArrayList<Poid<Double>>();
        // neurone1
        poids.add(new Poid<Double>(new Double(2)));
        poids.add(new Poid<Double>(new Double(2)));
        biais.add(new Poid<Double>(new Double(-1)));
        // neurone2
        poids.add(new Poid<Double>(new Double(-1)));
        poids.add(new Poid<Double>(new Double(-1)));
        biais.add(new Poid<Double>(new Double(1.5)));
        layer1.initLayer(poids, biais);
        // creation des inits des poids du layer2
        final ArrayList<Poid<Double>> poids2 = new ArrayList<Poid<Double>>();
        final ArrayList<Poid<Double>> biais2 = new ArrayList<Poid<Double>>();
        poids2.add(new Poid<Double>(new Double(1)));
        poids2.add(new Poid<Double>(new Double(1)));
        biais2.add(new Poid<Double>(new Double(-1.5)));
        layer2.initLayer(poids2, biais2);
        // creation signaux d'entr�e
        final ArrayList<Signal<Double>> signalInput = new ArrayList<Signal<Double>>();
        signalInput.add(new Signal<Double>(new Double(1)));
        signalInput.add(new Signal<Double>(new Double(1)));
        reseau.evaluate(signalInput);
        System.out.println(reseau.getOutputSignal());
    }

    /**
     * perceptron3.
     * @throws Exception
     */
    @Test
    public void perceptron3() throws Exception {
        // Reseau de type perceptron 1 couche realisant une separation par
        // apprentissage
        final LayerFactory<Double> layerfactory = new LayerFactory<Double>();
        // creation du reseau
        final ReseauNeuronal<Double> reseau = layerfactory.createNetwork();
        // Creation des couches de neurones
        final Layer<Double> layer1 = layerfactory.createUnidirectionnalLayer(1, 2, Sum.class, Limiter.class);
        reseau.putLayer(layer1);
        // creation des inits des poids du layer1
        final ArrayList<Poid<Double>> poids = new ArrayList<Poid<Double>>();
        final ArrayList<Poid<Double>> biais = new ArrayList<Poid<Double>>();
        // neurone1
        poids.add(new Poid<Double>(new Double(1)));
        poids.add(new Poid<Double>(new Double(-0.8)));
        biais.add(new Poid<Double>(new Double(0)));
        layer1.initLayer(poids, biais);
        // apprentissage
        // value1
        final ArrayList<Signal<Double>> signalInput1 = new ArrayList<Signal<Double>>();
        signalInput1.add(new Signal<Double>(new Double(1)));
        signalInput1.add(new Signal<Double>(new Double(2)));
        final ArrayList<Signal<Double>> signalOutput1 = new ArrayList<Signal<Double>>();
        signalOutput1.add(new Signal<Double>(new Double(1)));
        // value2
        final ArrayList<Signal<Double>> signalInput2 = new ArrayList<Signal<Double>>();
        signalInput2.add(new Signal<Double>(new Double(-1)));
        signalInput2.add(new Signal<Double>(new Double(2)));
        final ArrayList<Signal<Double>> signalOutput2 = new ArrayList<Signal<Double>>();
        signalOutput2.add(new Signal<Double>(new Double(0)));
        // value3
        final ArrayList<Signal<Double>> signalInput3 = new ArrayList<Signal<Double>>();
        signalInput3.add(new Signal<Double>(new Double(0)));
        signalInput3.add(new Signal<Double>(new Double(-1)));
        final ArrayList<Signal<Double>> signalOutput3 = new ArrayList<Signal<Double>>();
        signalOutput3.add(new Signal<Double>(new Double(0)));
        final HashMap<ArrayList<Signal<Double>>, ArrayList<Signal<Double>>> map = new HashMap<ArrayList<Signal<Double>>, ArrayList<Signal<Double>>>();
        map.put(signalInput1, signalOutput1);
        map.put(signalInput2, signalOutput2);
        map.put(signalInput3, signalOutput3);
        reseau.setLearningMethod(new PerceptronMonoCoucheLearning<Double>());
        reseau.learn(map);
        // test du reseau
        // creation signaux d'entr�e
        final ArrayList<Signal<Double>> signalInput = new ArrayList<Signal<Double>>();
        signalInput.add(new Signal<Double>(new Double(-1)));
        signalInput.add(new Signal<Double>(new Double(2)));
        reseau.evaluate(signalInput);
        System.out.println(reseau.getOutputSignal());
    }

    /**
     * recurrentLayer.
     * @throws Exception
     */
    @Test
    public void recurrentLayer() throws Exception {
        // Reseau de type hopfield 2 couche realisant une competition
        final LayerFactory<Double> layerfactory = new LayerFactory<Double>();
        // creation du reseau de type recurrent
        final RecurentLayer<Double> reseau = layerfactory.recurentLayer(3, 10, LinearLimiter.class);
        // creation des inits des poids du layer1
        final ArrayList<Poid<Double>> poids = new ArrayList<Poid<Double>>();
        final ArrayList<Poid<Double>> biais = new ArrayList<Poid<Double>>();
        // neurone1
        poids.add(new Poid<Double>(new Double(0.2)));
        poids.add(new Poid<Double>(new Double(0)));
        poids.add(new Poid<Double>(new Double(0)));
        biais.add(new Poid<Double>(new Double(0.9)));
        // neurone2
        poids.add(new Poid<Double>(new Double(0)));
        poids.add(new Poid<Double>(new Double(1.2)));
        poids.add(new Poid<Double>(new Double(0)));
        biais.add(new Poid<Double>(new Double(0)));
        // neurone3
        poids.add(new Poid<Double>(new Double(0)));
        poids.add(new Poid<Double>(new Double(0)));
        poids.add(new Poid<Double>(new Double(0.2)));
        biais.add(new Poid<Double>(new Double(-0.9)));
        reseau.initLayer(poids, biais);
        // creation signaux d'entr�e
        final ArrayList<Signal<Double>> signalInput = new ArrayList<Signal<Double>>();
        signalInput.add(new Signal<Double>(new Double(-1)));
        signalInput.add(new Signal<Double>(new Double(-1)));
        signalInput.add(new Signal<Double>(new Double(-1)));
        reseau.evaluate(signalInput);
        System.out.println(reseau.getOutputSignal());
    }
}
