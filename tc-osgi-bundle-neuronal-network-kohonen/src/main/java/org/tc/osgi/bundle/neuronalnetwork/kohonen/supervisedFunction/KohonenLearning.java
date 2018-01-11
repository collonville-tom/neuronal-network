package org.tc.osgi.bundle.neuronalnetwork.kohonen.supervisedFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.tc.osgi.bundle.neuronalnetwork.core.supervisedFunction.VoisinageFunction;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.layer.Kohonen;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Neurone;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Signal;

/**
 * KohonenLearning.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class KohonenLearning<T extends Number> extends LearningMethod<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -4298067967218845987L;
    // private JFrame frame;
    /**
     * VoisinageFunction<T> function.
     */
    private final VoisinageFunction<T> function;

    /**
     * KohonenLearning constructor.
     * @param function VoisinageFunction<T>
     */
    public KohonenLearning(final VoisinageFunction<T> function) {
        // this.frame = frame;
        this.function = function;
    }

    /**
     * getWinner.
     * @param layer Layer<T>
     * @param signal ArrayList<Signal<T>>
     * @return Neurone<T>
     */
    @SuppressWarnings("unchecked")
    public Neurone<T> getWinner(final Layer<T> layer, final ArrayList<Signal<T>> signal) {
        final Iterator<Neurone<T>> itn = ((Kohonen) layer).getNeurones().iterator();
        Neurone<T> winner = null;
        double valueForWinner = Double.MAX_VALUE;
        final T value1 = signal.get(0).getValue();
        final T value2 = signal.get(1).getValue();
        for (; itn.hasNext();) {
            final Neurone<T> n = itn.next();
            final T poid1 = n.getInputDendrites().get(0).getPoid().getValue();
            final T poid2 = n.getInputDendrites().get(1).getPoid().getValue();
            final double currentValue = Math.sqrt(Math.pow(value1.doubleValue() - poid1.doubleValue(), 2) + Math.pow(value2.doubleValue() - poid2.doubleValue(), 2));
            if (currentValue < valueForWinner) {
                winner = n;
                valueForWinner = currentValue;
            }
        }
        return winner;
    }

    /**
     * @param layer  Layer<T>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#learn(org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer)
     */
    @Override
    public void learn(final Layer<T> layer) {
    }

    /**
     * @param layer  Layer<T>
     * @param learningValue ArrayList<Signal<T>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#learn(org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer, java.util.ArrayList)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void learn(final Layer<T> layer, final ArrayList<Signal<T>> learningValue) {
        final Iterator<Signal<T>> its = learningValue.iterator();
        for (; its.hasNext();) {
            final ArrayList<Signal<T>> signal = new ArrayList<Signal<T>>();
            signal.add(its.next());
            signal.add(its.next());
            final Neurone<T> n = this.getWinner(layer, signal);
            this.upGrade(n, signal, ((Kohonen) layer).getMatrixVoisinage());
            // this.frame.repaint();
        }
    }

    /**
     * @param layer Layer<T>
     * @param learningValue HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#learn(org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer, java.util.HashMap)
     */
    @Override
    public void learn(final Layer<T> layer, final HashMap<ArrayList<Signal<T>>, ArrayList<Signal<T>>> learningValue) {
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.LearningMethod#toString()
     */
    @Override
    public String toString() {
        return "KohonenLearning :Apprentissage de type ";
    }

    /**
     * upGrade.
     * @param n Neurone<T>
     * @param signal ArrayList<Signal<T>>
     * @param matrix Neurone[][]
     */
    @SuppressWarnings("unchecked")
    private void upGrade(final Neurone<T> n, final ArrayList<Signal<T>> signal, final Neurone[][] matrix) {
        final Iterator<Signal<T>> its = signal.iterator();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (n.equals(matrix[i][j])) {
                    this.function.evaluate();
                    final T valueX = its.next().getValue();
                    final T valueY = its.next().getValue();
                    int taille;
                    if (this.function.getNbrNiveau() >= matrix.length) {
                        taille = matrix.length;
                    } else {
                        taille = this.function.getNbrNiveau();
                    }

                    for (int l = (-1 * taille) + 1; l < taille; l++) {
                        for (int c = (-1 * taille) + 1; c < taille; c++) {
                            if (((i + l) >= 0) && ((i + l) < matrix.length) && ((j + c) >= 0) && ((j + c) < matrix.length)) {
                                final Iterator<Dendrite<T>> it = matrix[i + l][j + c].getInputDendrites().iterator();
                                final Dendrite<T> d1 = it.next();
                                final Dendrite<T> d2 = it.next();
                                int niveau;
                                if (Math.abs(c) < Math.abs(l)) {
                                    niveau = Math.abs(l);
                                } else {
                                    niveau = Math.abs(c);
                                }
                                d1.getPoid()
                                .setValue(
                                    (T) new Float(d1.getPoid().getValue().floatValue()
                                        + (this.function.getValueX(niveau).floatValue() * (valueX.floatValue() - d1.getPoid().getValue().floatValue()))));
                                d2.getPoid()
                                .setValue(
                                    (T) new Float(d2.getPoid().getValue().floatValue()
                                        + (this.function.getValueY(niveau).floatValue() * (valueY.floatValue() - d2.getPoid().getValue().floatValue()))));
                            }
                        }
                    }
                }
            }
        }
    }
}
