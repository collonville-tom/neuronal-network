package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers;

import java.util.ArrayList;
import java.util.Iterator;

import org.tc.osgi.bundle.neuronalnetwork.metamodel.activationFunction.NoActivationFunction;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.exception.ConnectionSynaptiqueException;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.factory.NeuroneFactory;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.inputFunction.NoInputFunction;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Neurone;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Poid;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.ReseauSynaptique;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Signal;

/**
 * ReseauNeuronal.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class ReseauNeuronal<T extends Number> extends Layer<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 6298371705312896897L;
    /**
     * ArrayList<Layer<T>> layers.
     */
    private ArrayList<Layer<T>> layers = new ArrayList<Layer<T>>();
    /**
     * ArrayList<ReseauSynaptique<T>> reseauSynaptiques.
     */
    private ArrayList<ReseauSynaptique<T>> reseauSynaptiques = new ArrayList<ReseauSynaptique<T>>();

    /**
     * ReseauNeuronal constructor.
     */
    public ReseauNeuronal() {
        super();
    }

    /**
     * adaptNeuroneList.
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    protected void adaptNeuroneList() throws InstantiationException, IllegalAccessException {
        final int nbrOutput = this.layers.get(this.layers.size() - 1).getNeurones().size();
        final NeuroneFactory<T> factory = new NeuroneFactory<T>();
        final ArrayList<Neurone<T>> inibNeurones = factory.createNeuroneList(nbrOutput, 0, NoInputFunction.class, NoActivationFunction.class);
        final Iterator<Neurone<T>> itInib = inibNeurones.iterator();
        final Iterator<Neurone<T>> itSortie = this.layers.get(this.layers.size() - 1).getNeurones().iterator();
        final Iterator<Neurone<T>> itEntree = this.layers.get(0).getNeurones().iterator();
        for (; itInib.hasNext();) {
            final Neurone<T> nInib = itInib.next();
            nInib.setOutputDendrite(itSortie.next().getOutputDendrite());
            final Iterator<Dendrite<T>> itDendEntree = itEntree.next().getInputDendrites().iterator();
            for (; itDendEntree.hasNext();) {
                nInib.getInputDendrites().add((itDendEntree.next()));
            }
        }
        setNeurones(inibNeurones);
    }

    /**
     *
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer#evaluate()
     */
    @Override
    public void evaluate() {
        final Iterator<ReseauSynaptique<T>> itSynaptique = this.reseauSynaptiques.iterator();
        ReseauSynaptique<T> res = null;
        for (; itSynaptique.hasNext();) {
            res = itSynaptique.next();
            res.getFirst().evaluate();
            res.propagate();
        }
        res.getSecond().evaluate();
    }

    /**
     * @param signal ArrayList<Signal<T>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer#evaluate(java.util.ArrayList)
     */
    @Override
    public void evaluate(final ArrayList<Signal<T>> signal) {
        if (this.layers.size() > 1) {
            final Iterator<ReseauSynaptique<T>> itSynaptique = this.reseauSynaptiques.iterator();
            ReseauSynaptique<T> res = itSynaptique.next();
            res.getFirst().evaluate(signal);
            res.propagate();
            for (; itSynaptique.hasNext();) {
                res = itSynaptique.next();
                res.getFirst().evaluate();
                res.propagate();
            }
            res.getSecond().evaluate();
        } else {
            this.layers.get(0).evaluate(signal);
        }
    }

    /**
     * getLayers.
     * @return ArrayList<Layer<T>>
     */
    public ArrayList<Layer<T>> getLayers() {
        return this.layers;
    }

    /**
     * @return ArrayList<Signal<T>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer#getOutputSignal()
     */
    @Override
    public ArrayList<Signal<T>> getOutputSignal() {
        final ArrayList<Signal<T>> array = new ArrayList<Signal<T>>();
        for (final Neurone<T> n : this.layers.get(this.layers.size() - 1).getNeurones()) {
            array.add(n.getOutputDendrite().getSignal());
        }
        return array;
    }

    /**
     * getReseauSynaptiques.
     * @return ArrayList<ReseauSynaptique<T>>
     */
    public ArrayList<ReseauSynaptique<T>> getReseauSynaptiques() {
        return this.reseauSynaptiques;
    }

    /**
     * @param poids
     * @param biais
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer#initLayer(java.util.ArrayList, java.util.ArrayList)
     */
    @Override
    public void initLayer(final ArrayList<Poid<T>> poids, final ArrayList<Poid<T>> biais) {
    }

    /**
     * initLayer.
     * @param numLayer int
     * @param poids ArrayList<Poid<T>>
     * @param biais ArrayList<Poid<T>>
     */
    public void initLayer(final int numLayer, final ArrayList<Poid<T>> poids, final ArrayList<Poid<T>> biais) {
        this.layers.get(numLayer).initLayer(poids, biais);
    }

    /**
     * putLayer.
     * @param layer Layer<T>
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ConnectionSynaptiqueException
     */
    public void putLayer(final Layer<T> layer) throws InstantiationException, IllegalAccessException, ConnectionSynaptiqueException {
        this.layers.add(layer);
        this.adaptNeuroneList();
        if (this.layers.size() >= 2) {
            final ReseauSynaptique<T> reseauSynaptique = new ReseauSynaptique<T>();
            reseauSynaptique.connect(this.layers.get(this.layers.size() - 2), this.layers.get(this.layers.size() - 1));
            this.reseauSynaptiques.add(reseauSynaptique);
        }
    }

    /**
     * setLayers.
     * @param layers ArrayList<Layer<T>>
     */
    public void setLayers(final ArrayList<Layer<T>> layers) {
        this.layers = layers;
    }

    /**
     * setReseauSynaptiques.
     * @param reseauSynaptiques ArrayList<ReseauSynaptique<T>>
     */
    public void setReseauSynaptiques(final ArrayList<ReseauSynaptique<T>> reseauSynaptiques) {
        this.reseauSynaptiques = reseauSynaptiques;
    }

    /**
     * @return String
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buff = new StringBuffer("Reseau de neurone(Nombre de couche: ");
        buff.append(this.layers.size());
        buff.append("): \n");
        final Iterator<ReseauSynaptique<T>> it = this.reseauSynaptiques.iterator();
        for (; it.hasNext();) {
            buff.append(it.next().toString());
        }
        if (this.layers.size() <= 1) {
            buff.append(" et ");
            final Iterator<Layer<T>> it2 = this.layers.iterator();
            for (; it2.hasNext();) {
                buff.append(it2.next().toString());
            }
        }
        return buff.toString();
    }
}
