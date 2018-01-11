package org.tc.osgi.bundle.neuronalnetwork.kohonen.ihm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * Controller.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public class Controller implements MouseListener, KeyListener, MouseMotionListener, MouseWheelListener {

    /**
     * Object model.
     */
    public Object model;
    /**
     * View view.
     */
    public View view;

    /**
     * Controller constructor.
     * @param model Object
     */
    public Controller(final Object model) {
        this.model = model;
    }

    /**
     * getModel.
     * @return Object
     */
    public Object getModel() {
        return model;
    }

    /**
     * getView.
     * @return View
     */
    public View getView() {
        return view;
    }

    /**
     * @param e KeyEvent
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e KeyEvent
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e KeyEvent
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e MouseEvent
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e MouseEvent
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseDragged(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e MouseEvent
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e MouseEvent
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e MouseEvent
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseMoved(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e MouseEvent
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e MouseEvent
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(final MouseEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * @param e MouseWheelEvent
     * @see java.awt.event.MouseWheelListener#mouseWheelMoved(java.awt.event.MouseWheelEvent)
     */
    @Override
    public void mouseWheelMoved(final MouseWheelEvent e) {
        // TODO Auto-generated method stub
    }

    /**
     * setModel.
     * @param model Object
     */
    public void setModel(final Object model) {
        this.model = model;
    }

    /**
     * setView.
     * @param view View
     */
    public void setView(final View view) {
        this.view = view;
    }
}
