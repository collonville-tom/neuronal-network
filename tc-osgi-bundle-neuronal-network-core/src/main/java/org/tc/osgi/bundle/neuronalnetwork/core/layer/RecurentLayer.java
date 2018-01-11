package org.tc.osgi.bundle.neuronalnetwork.core.layer;

import java.util.ArrayList;

import org.tc.osgi.bundle.neuronalnetwork.core.factory.LayerFactory;
import org.tc.osgi.bundle.neuronalnetwork.core.inputFunction.Sum;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.exception.ConnectionSynaptiqueException;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Neurone;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Poid;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Signal;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.ReseauNeuronal;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.UnidirectionnalLayer;

/**
 * RecurentLayer.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class RecurentLayer<T extends Number> extends ReseauNeuronal<T> {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -3910076455925085499L;

    /**
     * RecurentLayer constructor.
     * @param nbrInput int
     * @param activationFunction Class
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ConnectionSynaptiqueException
     */
    public RecurentLayer(final int nbrInput, final Class activationFunction) throws InstantiationException, IllegalAccessException, ConnectionSynaptiqueException {
        this(nbrInput, Integer.MAX_VALUE, activationFunction);
    }

    /**
     * RecurentLayer constructor.
     * @param nbrInput int
     * @param nbrIteration int
     * @param activationFunction Class
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ConnectionSynaptiqueException
     */
    public RecurentLayer(final int nbrInput, final int nbrIteration, final Class activationFunction) throws InstantiationException, IllegalAccessException, ConnectionSynaptiqueException {
        this(nbrInput, nbrInput, nbrIteration, activationFunction);
    }

    /**
     * RecurentLayer constructor.
     * @param nbrNeurone int
     * @param nbrInput int
     * @param nbrIteration int
     * @param activationFunction Class
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ConnectionSynaptiqueException
     */
    public RecurentLayer(final int nbrNeurone, final int nbrInput, final int nbrIteration, final Class activationFunction) throws InstantiationException, IllegalAccessException,
    ConnectionSynaptiqueException {
        super();
        final LayerFactory<T> factory = new LayerFactory<T>();
        final UnidirectionnalLayer<T> uni = factory.createUnidirectionnalLayer(nbrNeurone, nbrInput, Sum.class, activationFunction);
        getLayers().add(uni);
        final RecurentPropagation<T> RecurentPropagation = new RecurentPropagation<T>(nbrIteration);
        RecurentPropagation.connect(uni, uni);
        getReseauSynaptiques().add(RecurentPropagation);
        adaptNeuroneList();
    }

    /**
     *
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.ReseauNeuronal#evaluate()
     */
    @Override
    public void evaluate() {
        while (!((RecurentPropagation<T>) getReseauSynaptiques().get(0)).getConvergenceCondition(this)) {
            getReseauSynaptiques().get(0).getFirst().evaluate();
            getReseauSynaptiques().get(0).propagate();
        }
    }

    /**
     * @param signal ArrayList<Signal<T>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.ReseauNeuronal#evaluate(java.util.ArrayList)
     */
    @Override
    public void evaluate(final ArrayList<Signal<T>> signal) {
        getReseauSynaptiques().get(0).getFirst().evaluate(signal);
        getReseauSynaptiques().get(0).propagate();
        this.evaluate();
    }

    /**
     * @return ArrayList<Neurone<T>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Layer#getNeurones()
     */
    @Override
    public ArrayList<Neurone<T>> getNeurones() {
        return getLayers().get(0).getNeurones();
    }

    /**
     * @param poids ArrayList<Poid<T>>
     * @param biais ArrayList<Poid<T>>
     * @see org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.ReseauNeuronal#initLayer(java.util.ArrayList, java.util.ArrayList)
     */
    @Override
    public void initLayer(final ArrayList<Poid<T>> poids, final ArrayList<Poid<T>> biais) {
        getLayers().get(0).initLayer(poids, biais);
    }
}
