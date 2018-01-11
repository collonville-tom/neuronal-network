package org.tc.osgi.bundle.neuronalnetwork.kohonen.ihm;

import javax.swing.JPanel;

/**
 * View.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public abstract class View extends JPanel {

    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = 14113380580628914L;
    /**
     * Controller controller.
     */
    private Controller controller;
    /**
     * Object model.
     */
    private Object model;

    /**
     * View constructor.
     * @param model Object
     */
    public View(final Object model) {
        super();
        this.model = model;
        defaultController(model);
        controller.setView(this);
        addMouseListener(controller);
        addKeyListener(controller);
        addMouseMotionListener(controller);
        addMouseWheelListener(controller);
    }

    /**
     * defaultController.
     * @param model Object
     */
    public void defaultController(final Object model) {
        controller = new Controller(model);
    }

    /**
     * getController.
     * @return Controller
     */
    public Controller getController() {
        return controller;
    }

    /**
     * getModel.
     * @return Object
     */
    public Object getModel() {
        return model;
    }

    /**
     * setController.
     * @param controller Controller
     */
    public void setController(final Controller controller) {
        this.controller = controller;
    }

    /**
     * setModel.
     * @param model Object
     */
    public void setModel(final Object model) {
        this.model = model;
    }
}
