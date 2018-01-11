package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers;

import java.util.ArrayList;
import java.util.Iterator;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Neurone;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Poid;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Signal;

/**
 * @author tom
 * @param <T>
 */
@SuppressWarnings("serial")
public class UnidirectionnalLayer<T extends Number> extends Layer<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 4555458541085441894L;

    @Override
    public void evaluate() {
        for (final Neurone<T> n : getNeurones()) {
            n.evaluate();
        }
        System.out.println(getOutputSignal());
    }

    // TODO manque le toString

    @Override
    public void evaluate(final ArrayList<Signal<T>> signal) {
        for (final Neurone<T> n : getNeurones()) {
            final Iterator<Signal<T>> itSignal = signal.iterator();
            final Iterator<Dendrite<T>> itDendrite = n.getInputDendrites().iterator();
            for (; itDendrite.hasNext();) {
                itDendrite.next().setSignal(itSignal.next());
            }
        }
        this.evaluate();
    }

    @Override
    public void initLayer(final ArrayList<Poid<T>> poids, final ArrayList<Poid<T>> biais) {
        final Iterator<Poid<T>> itBiais = biais.iterator();
        final Iterator<Poid<T>> itPoids = poids.iterator();
        for (final Neurone<T> n : getNeurones()) {
            n.getBiais().setPoid(itBiais.next());
            final Iterator<Dendrite<T>> itDendrite = n.getInputDendrites().iterator();
            for (; itDendrite.hasNext();) {
                itDendrite.next().setPoid(itPoids.next());
            }
        }
    }
}
