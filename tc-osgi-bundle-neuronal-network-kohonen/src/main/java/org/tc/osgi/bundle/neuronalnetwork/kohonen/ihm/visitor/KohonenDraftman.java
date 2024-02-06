package org.tc.osgi.bundle.neuronalnetwork.kohonen.ihm.visitor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Iterator;

import org.tc.osgi.bundle.neuronalnetwork.kohonen.layer.Kohonen;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Dendrite;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.mm.Neurone;
import org.tc.osgi.bundle.utils.interf.pattern.draftman.AbstractDraftman;
import org.tc.osgi.bundle.utils.interf.pattern.visitor.IVisitable;

/**
 * KohonenDraftman.java.
 * 
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public class KohonenDraftman extends AbstractDraftman {
	/**
	 * int NEURONESIZE.
	 */
	private final int NEURONESIZE = 16;
	/**
	 * int ZOOM.
	 */
	private final int ZOOM = 1;

	/**
	 * KohonenDraftman constructor.
	 * 
	 * @param g Graphics
	 */
	public KohonenDraftman(final Graphics g) {
		super(g);
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.pattern.visitor.AbstractVisitor#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}

	/**
	 * @param object IVisitable
	 * @see org.tc.osgi.bundle.utils.pattern.visitor.AbstractVisitor#visit(org.tc.osgi.bundle.utils.pattern.visitor.IVisitable)
	 */
	@Override
	public void visit(final IVisitable object) {
		if (object instanceof Kohonen) {
			final Kohonen kohonen = (Kohonen) object;
			final Graphics2D g2d = (Graphics2D) getGraphics();
			final Iterator<Neurone> itn = kohonen.getNeurones().iterator();
			for (; itn.hasNext();) {
				final Neurone n = itn.next();
				if (n.getInputDendrites().size() != 2) {
					try {
						throw new Exception(" la cate de kohonen ne peut etre que de dimension 2 dans ce framework, le vecteur d'entr�e doit etre de dimension 2.");
					} catch (final Exception e) {
						e.printStackTrace();
					}
				}
				final Iterator<Dendrite> itd = n.getInputDendrites().iterator();
				final float x = itd.next().getPoid().getValue().floatValue();
				final float y = itd.next().getPoid().getValue().floatValue();
				g2d.draw(new Ellipse2D.Float(x * ZOOM, y * ZOOM, NEURONESIZE, NEURONESIZE));
			}
			final Neurone[][] neurones = kohonen.getMatrixVoisinage();
			for (int ligne = 0; ligne < neurones.length; ligne++) {
				for (int colonne = 0; colonne < neurones.length; colonne++) {
					if ((colonne + 1) < neurones.length) {
						int x1, x2, y1, y2;
						final Neurone n1 = neurones[ligne][colonne];
						final Neurone n2 = neurones[ligne][colonne + 1];
						final Iterator<Dendrite> itd1 = n1.getInputDendrites().iterator();
						x1 = itd1.next().getPoid().getValue().intValue();
						y1 = itd1.next().getPoid().getValue().intValue();
						final Iterator<Dendrite> itd2 = n2.getInputDendrites().iterator();
						x2 = itd2.next().getPoid().getValue().intValue();
						y2 = itd2.next().getPoid().getValue().intValue();
						g2d.drawLine((x1 * ZOOM) + 8, (y1 * ZOOM) + 8, (x2 * ZOOM) + 8, (y2 * ZOOM) + 8);
					}
					if ((ligne + 1) < neurones.length) {
						int x1, x2, y1, y2;
						final Neurone n1 = neurones[ligne][colonne];
						final Neurone n2 = neurones[ligne + 1][colonne];
						final Iterator<Dendrite> itd1 = n1.getInputDendrites().iterator();
						x1 = itd1.next().getPoid().getValue().intValue();
						y1 = itd1.next().getPoid().getValue().intValue();
						final Iterator<Dendrite> itd2 = n2.getInputDendrites().iterator();
						x2 = itd2.next().getPoid().getValue().intValue();
						y2 = itd2.next().getPoid().getValue().intValue();
						g2d.drawLine((x1 * ZOOM) + 8, (y1 * ZOOM) + 8, (x2 * ZOOM) + 8, (y2 * ZOOM) + 8);
					}
				}
			}
		}
	}
}
