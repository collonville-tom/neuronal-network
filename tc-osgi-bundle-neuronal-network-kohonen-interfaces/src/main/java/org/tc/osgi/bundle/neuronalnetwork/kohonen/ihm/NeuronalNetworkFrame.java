package org.tc.osgi.bundle.neuronalnetwork.kohonen.ihm;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

/**
 * NeuronalNetworkFrame.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class NeuronalNetworkFrame extends JFrame {

    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -2298433664543434601L;
    /**
     * JSplitPane jSplitPane1.
     */
    private JSplitPane jSplitPane1;
    /**
     * JTextArea jTextArea1.
     */
    private JTextArea jTextArea1;
    /**
     * JScrollPane upPane.
     */
    private JScrollPane upPane, downPane;
    /**
     * View view.
     */
    private View view;

    /**
     * NeuronalNetworkFrame constructor.
     * @param view View
     */
    public NeuronalNetworkFrame(final View view) {
        super();
        this.view = view;
        initComponents();
    }

    /**
     * NeuronalNetworkFrame constructor.
     * @param view View
     * @param title String
     */
    public NeuronalNetworkFrame(final View view, final String title) {
        super(title);
        this.view = view;
        initComponents();
    }

    /**
     * initComponents.
     */
    private void initComponents() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent arg0) {
                System.exit(0);
            }
        });

        jTextArea1 = new JTextArea();
        jTextArea1.setText(view.getModel().toString());
        downPane = new JScrollPane(jTextArea1);
        upPane = new JScrollPane(view);
        jSplitPane1 = new JSplitPane();
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setLeftComponent(downPane);
        jSplitPane1.setRightComponent(upPane);
        getContentPane().add(jSplitPane1);
    }

    /**
     * setView.
     * @param view View
     */
    public void setView(final View view) {
        this.view = view;
        initComponents();
    }

}
