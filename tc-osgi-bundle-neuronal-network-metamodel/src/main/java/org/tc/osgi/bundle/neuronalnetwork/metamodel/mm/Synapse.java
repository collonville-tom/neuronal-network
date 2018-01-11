package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;

/**
 * Synapse.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class Synapse<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -2876888332206433535L;
    /**
     * Dendrite<T> inputDendrite.
     */
    private Dendrite<T> inputDendrite;
    /**
     * Dendrite<T> outputDendrite.
     */
    private Dendrite<T> outputDendrite;

    /**
     * Synapse constructor.
     */
    public Synapse() {
        super();
    }

    /**
     * Synapse constructor.
     * @param inputDendrite Dendrite<T>
     * @param outputDendrite Dendrite<T>
     */
    public Synapse(final Dendrite<T> inputDendrite, final Dendrite<T> outputDendrite) {
        super();
        this.inputDendrite = inputDendrite;
        this.outputDendrite = outputDendrite;
    }

    /**
     * getInputDendrite.
     * @return Dendrite<T>
     */
    public Dendrite<T> getInputDendrite() {
        return this.inputDendrite;
    }

    /**
     * getOutputDendrite.
     * @return Dendrite<T>
     */
    public Dendrite<T> getOutputDendrite() {
        return this.outputDendrite;
    }

    /**
     * propagate.
     */
    public void propagate() {
        if (this.inputDendrite.getSignal() != null) {
            this.outputDendrite.setSignal(this.inputDendrite.getSignal());
        }
    }

    /**
     * setInputDendrite.
     * @param inputDendrite Dendrite<T>
     */
    public void setInputDendrite(final Dendrite<T> inputDendrite) {
        this.inputDendrite = inputDendrite;
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
        final StringBuffer buff = new StringBuffer("Synapse: \n");
        buff.append(this.inputDendrite.toString());
        buff.append(this.outputDendrite.toString());
        return buff.toString();
    }
}
