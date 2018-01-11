package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Neurone.java.
 * @author Collonvillé Thomas
 * @version
 */
@SuppressWarnings("serial")
public class Neurone<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 7032948202929490029L;
    /**
     * Biais<T> biais.
     */
    private Biais<T> biais = new Biais<T>();
    /**
     * NeuronalEngine<T> engine.
     */
    private NeuronalEngine<T> engine = new NeuronalEngine<T>();
    /**
     * ArrayList<Dendrite<T>> inputDendrites.
     */
    private ArrayList<Dendrite<T>> inputDendrites = new ArrayList<Dendrite<T>>();
    /**
     * Dendrite<T> outputDendrite.
     */
    private Dendrite<T> outputDendrite = new Dendrite<T>();

    /**
     * Neurone constructor.
     */
    public Neurone() {
        super();
    }

    /**
     * evaluate.
     */
    @SuppressWarnings("unchecked")
    public void evaluate() {
        this.outputDendrite.setSignal(new Signal(this.engine.evaluate(this)));
    }

    /**
     * getBiais.
     * @return Biais<T>
     */
    public Biais<T> getBiais() {
        return this.biais;
    }

    /**
     * getEngine.
     * @return NeuronalEngine<T>
     */
    public NeuronalEngine<T> getEngine() {
        return this.engine;
    }

    /**
     * getInputDendrites.
     * @return ArrayList<Dendrite<T>>
     */
    public ArrayList<Dendrite<T>> getInputDendrites() {
        return this.inputDendrites;
    }

    /**
     * getOutputDendrite.
     * @return Dendrite<T>
     */
    public Dendrite<T> getOutputDendrite() {
        return this.outputDendrite;
    }

    /**
     * setBiais.
     * @param biais Biais<T>
     */
    public void setBiais(final Biais<T> biais) {
        this.biais = biais;
    }

    /**
     * setEngine.
     * @param engine NeuronalEngine<T>
     */
    public void setEngine(final NeuronalEngine<T> engine) {
        this.engine = engine;
    }

    /**
     * setInputDendrites.
     * @param inputDendrites ArrayList<Dendrite<T>>
     */
    public void setInputDendrites(final ArrayList<Dendrite<T>> inputDendrites) {
        this.inputDendrites = inputDendrites;
    }

    /**
     * setOutputDendrite.
     * @param outputDendrite Dendrite<T>
     */
    public void setOutputDendrite(final Dendrite<T> outputDendrite) {
        this.outputDendrite = outputDendrite;
    }

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Neurone:(Nombre de dendrite d'entrée : ");
        buff.append(this.inputDendrites.size());
        buff.append("): \n");
        final Iterator<Dendrite<T>> it = this.inputDendrites.iterator();
        int i = 1;
        for (; it.hasNext();) {
            buff.append(i++);
            buff.append(": ");
            buff.append(it.next().toString());
        }
        buff.append("de sortie: \n" + this.outputDendrite.toString());
        buff.append("de biais: \n" + this.biais.toString());
        buff.append("de moteur d'execution: \n" + this.engine.toString());
        return buff.toString();
    }
}
