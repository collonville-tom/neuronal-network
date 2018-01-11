package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.exception.ConnectionSynaptiqueException;

/**
 * ReseauSynaptique.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class ReseauSynaptique<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 6525054254945060600L;
    /**
     * Layer<T> first.
     */
    private Layer<T> first;
    /**
     * Layer<T> second.
     */
    private Layer<T> second;
    /**
     * ArrayList<Synapse<T>> synapses.
     */
    private ArrayList<Synapse<T>> synapses = new ArrayList<Synapse<T>>();

    /**
     * ReseauSynaptique constructor.
     */
    public ReseauSynaptique() {
        super();
    }

    /**
     * connect.
     * @param first Layer<T>
     * @param second Layer<T>
     * @throws ConnectionSynaptiqueException
     */
    public void connect(final Layer<T> first, final Layer<T> second) throws ConnectionSynaptiqueException {
        if (first.getNeurones().size() == second.getNeurones().get(0).getInputDendrites().size()) {
            this.first = first;
            this.second = second;
            final Iterator<Neurone<T>> itSecond = this.second.getNeurones().iterator();
            for (; itSecond.hasNext();) {
                final Iterator<Dendrite<T>> it = itSecond.next().getInputDendrites().iterator();
                final Iterator<Neurone<T>> itFirst = this.first.getNeurones().iterator();
                for (; itFirst.hasNext();) {
                    final Synapse<T> synapse = new Synapse<T>(itFirst.next().getOutputDendrite(), it.next());
                    this.synapses.add(synapse);
                }
            }
        } else {
            throw new ConnectionSynaptiqueException("Les deux layers ne sont pas compatible, la nombre de sortie du premier ne correspond pas au nombre d'entree de chaque neurone du second");
        }
    }

    /**
     * getFirst.
     * @return Layer<T>
     */
    public Layer<T> getFirst() {
        return this.first;
    }

    /**
     * getSecond.
     * @return Layer<T>
     */
    public Layer<T> getSecond() {
        return this.second;
    }

    /**
     * getSynapses.
     * @return ArrayList<Synapse<T>>
     */
    public ArrayList<Synapse<T>> getSynapses() {
        return this.synapses;
    }

    /**
     * propagate.
     */
    public void propagate() {
        for (final Synapse<T> synapse : this.synapses) {
            synapse.propagate();
        }
    }

    /**
     * setFirst.
     * @param first Layer<T>
     */
    public void setFirst(final Layer<T> first) {
        this.first = first;
    }

    /**
     * setSecond.
     * @param second Layer<T>
     */
    public void setSecond(final Layer<T> second) {
        this.second = second;
    }

    /**
     * setSynapses.
     * @param synapses ArrayList<Synapse<T>>
     */
    public void setSynapses(final ArrayList<Synapse<T>> synapses) {
        this.synapses = synapses;
    }

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer(" --> Reseau Synaptique: \n");
        final Iterator<Synapse<T>> it = this.synapses.iterator();
        for (; it.hasNext();) {
            buff.append(it.next().toString());
        }
        buff.append("de la couche: \n" + this.first.getClass().toString());
        buff.append(" et de la couche: \n" + this.second.getClass().toString() + "\n");
        return buff.toString();
    }
}
