package org.tc.osgi.bundle.neuronalnetwork.kohonen.ihm;

import java.awt.Graphics;

import org.tc.osgi.bundle.neuronalnetwork.kohonen.ihm.visitor.KohonenDraftman;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.layer.Kohonen;

/**
 * KohonenView.java.
 * 
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class KohonenView extends View {
	/**
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = 8603581105287899638L;

	/**
	 * KohonenView constructor.
	 * 
	 * @param model Kohonen
	 */
	public KohonenView(final Kohonen model) {
		super(model);
	}

	/**
	 * @param g Graphics
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		final KohonenDraftman draftman = new KohonenDraftman(g);
		((Kohonen) getModel()).accept(draftman);
	}
}
