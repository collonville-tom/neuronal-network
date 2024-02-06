package org.tc.osgi.bundle.neuronalnetwork.kohonen.layer;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import org.tc.osgi.bundle.neuronalnetwork.core.inputFunction.Sum;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.factory.KohonenFactory;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Neurone;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Signal;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.ReseauNeuronal;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.layers.UnidirectionnalLayer;
import org.tc.osgi.bundle.utils.interf.pattern.visitor.IVisitable;
import org.tc.osgi.bundle.utils.interf.pattern.visitor.IVisitor;

/**
 * Kohonen.java.
 * 
 * @author collonville thomas
 * @version 0.0.1
 */
public class Kohonen<T extends Number> extends ReseauNeuronal<T> implements IVisitable {

	/**
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = -7564382981250063487L;
	/**
	 * Neurone<T>[][] matrixVoisinage.
	 */
	private Neurone<T>[][] matrixVoisinage;

	/**
	 * Kohonen constructor.
	 * 
	 * @param nbrNeurone    int
	 * @param nbrInput      int
	 * @param functionRecur Class
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("unchecked")
	public Kohonen(final int nbrNeurone, final int nbrInput, final Class functionRecur) throws InstantiationException, IllegalAccessException {
		super();
		final KohonenFactory<T> factory = new KohonenFactory<T>();
		final UnidirectionnalLayer<T> uni = factory.createUnidirectionnalLayer(nbrNeurone, nbrInput, Sum.class, functionRecur);
		getLayers().add(uni);
		final Iterator<Neurone<T>> itn = uni.getNeurones().iterator();
		final int dimension = (int) Math.round(Math.sqrt(uni.getNeurones().size()));
		this.matrixVoisinage = new Neurone[dimension][dimension];
		int ligne = 0;
		int colonne = 0;
		for (; itn.hasNext();) {
			this.matrixVoisinage[ligne++][colonne] = itn.next();
			if (ligne == dimension) {
				ligne = 0;
				colonne++;
			}
		}
		adaptNeuroneList();
	}

	/**
	 * @param man AbstractVisitor
	 * @see org.tc.osgi.bundle.utils.pattern.visitor.IVisitable#accept(org.tc.osgi.bundle.utils.pattern.visitor.AbstractVisitor)
	 */
	@Override
	public void accept(final IVisitor man) {
		man.visit(this);
	}

	/**
	 * getMatrixVoisinage.
	 * 
	 * @return Neurone<T>[][]
	 */
	public Neurone<T>[][] getMatrixVoisinage() {
		return this.matrixVoisinage;
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
	 * initLayer.
	 * 
	 * @param dim Dimension
	 */
	@SuppressWarnings("unchecked")
	public void initLayer(final Dimension dim) {
		for (final Neurone<T> n : getLayers().get(0).getNeurones()) {
			final float valueX = (float) (Math.random() + (dim.width / 2));
			final float valueY = (float) (Math.random() + (dim.height / 2));
			if (n.getInputDendrites().size() != 2) {
				try {
					throw new Exception(" la cate de kohonen ne peut etre que de dimension 2 dans ce framework, le vecteur d'entr�e doit etre de dimension 2.");
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
			final Iterator<Dendrite<T>> itd = n.getInputDendrites().iterator();
			itd.next().getPoid().setValue((T) new Float(valueX));
			itd.next().getPoid().setValue((T) new Float(valueY));
		}
	}

	/**
	 * learn.
	 * 
	 * @param learningValue ArrayList<Signal<T>>
	 */
	public void learn(final ArrayList<Signal<T>> learningValue) {
		getLearningMethod().learn(this, learningValue);
	}

	/**
	 * setMatrixVoisinage.
	 * 
	 * @param matrixVoisinage Neurone<T>[][]
	 */
	public void setMatrixVoisinage(final Neurone<T>[][] matrixVoisinage) {
		this.matrixVoisinage = matrixVoisinage;
	}

}
