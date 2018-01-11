package org.tc.osgi.bundle.neuronalnetwork.core.layer;

import java.util.Iterator;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.exception.ConnectionSynaptiqueException;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Neurone;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ReseauSynaptique;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Synapse;

/**
 * RecurentPropagation.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class RecurentPropagation<T extends Number> extends ReseauSynaptique<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 5196942969193464146L;
    /**
     * int indexIteration.
     */
    private int indexIteration = Integer.MAX_VALUE;

    /**
     * RecurentPropagation constructor.
     */
    public RecurentPropagation() {
        super();
    }

    /**
     * RecurentPropagation constructor.
     * @param iteration int
     */
    public RecurentPropagation(final int iteration) {
        super();
        this.indexIteration = iteration;
    }

    /**
     * @param first Layer<T>
     * @param second Layer<T>
     * @throws ConnectionSynaptiqueException
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ReseauSynaptique#connect(org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer, org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer)
     */
    @Override
    public void connect(final Layer<T> first, final Layer<T> second) throws ConnectionSynaptiqueException {
        // if (second.getClass().equals(DelayLayer.class)) {
        if (first.getNeurones().size() == second.getNeurones().size()) {
            setFirst(first);
            setSecond(second);
            final Iterator<Neurone<T>> itFirst = getFirst().getNeurones().iterator();
            final Iterator<Neurone<T>> itSecond = getSecond().getNeurones().iterator();
            for (; itSecond.hasNext();) {
                final Synapse<T> synapse = new Synapse<T>(itFirst.next().getOutputDendrite(), itSecond.next().getInputDendrites().get(0));
                getSynapses().add(synapse);
            }
        } else {
            throw new ConnectionSynaptiqueException("Les deux layers ne sont pas compatible, la nombre de sortie du premier ne correspond pas au nombre de neurone du second");
        }
    }

    /**
     * getConvergenceCondition.
     * @param layer Layer
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    public boolean getConvergenceCondition(final Layer layer) {
        if (this.indexIteration > 0) {
            return false;
        }
        return true;
    }

    // manque le toString
    /**
     * getIndexIteration.
     * @return int
     */
    public int getIndexIteration() {
        return this.indexIteration;
    }

    /**
     *
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ReseauSynaptique#propagate()
     */
    @Override
    public void propagate() {
        this.indexIteration--;
        super.propagate();
    }

    /**
     * setIndexIteration.
     * @param indexIteration int
     */
    public void setIndexIteration(final int indexIteration) {
        this.indexIteration = indexIteration;
    }
}
