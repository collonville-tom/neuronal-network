package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;

/**
 * NeuronalEngine.java.
 * @author Collonvillé Thomas
 * @version
 */
@SuppressWarnings("serial")
public class NeuronalEngine<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 879087862275436293L;
    /**
     * ActivationFunction<T> activationFunction.
     */
    private ActivationFunction<T> activationFunction;
    /**
     * InputFunction<T> inputFunction.
     */
    private InputFunction<T> inputFunction;

    /**
     * NeuronalEngine constructor.
     */
    public NeuronalEngine() {
        super();
    }

    /**
     * NeuronalEngine constructor.
     * @param inputFunction InputFunction<T>
     * @param activationFunction ActivationFunction<T>
     */
    public NeuronalEngine(final InputFunction<T> inputFunction, final ActivationFunction<T> activationFunction) {
        super();
        this.activationFunction = activationFunction;
        this.inputFunction = inputFunction;
    }

    /**
     * evaluate.
     * @param neurone Neurone<T>
     * @return T
     */
    public T evaluate(final Neurone<T> neurone) {
        return this.activationFunction.evaluate(this.inputFunction.evaluate(neurone.getInputDendrites(), neurone.getBiais()));
    }

    /**
     * getActivationFunction.
     * @return ActivationFunction<T>
     */
    public ActivationFunction<T> getActivationFunction() {
        return this.activationFunction;
    }

    /**
     * getInputFunction.
     * @return InputFunction<T>
     */
    public InputFunction<T> getInputFunction() {
        return this.inputFunction;
    }

    /**
     * setActivationFunction.
     * @param activationFunction ActivationFunction<T>
     */
    public void setActivationFunction(final ActivationFunction<T> activationFunction) {
        this.activationFunction = activationFunction;
    }

    /**
     * setInputFunction.
     * @param inputFunction InputFunction<T>
     */
    public void setInputFunction(final InputFunction<T> inputFunction) {
        this.inputFunction = inputFunction;
    }

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Moteur de calcul du neurone: ");
        buff.append(this.inputFunction.toString());
        buff.append(" et ");
        buff.append(this.activationFunction.toString());
        buff.append("\n");
        return buff.toString();
    }
}
