package org.tc.osgi.bundle.neuronalnetwork.kohonen;

import java.awt.Dimension;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Test;
import org.tc.osgi.bundle.neuronalnetwork.core.activationFunction.PositiveLinear;
import org.tc.osgi.bundle.neuronalnetwork.core.supervisedFunction.LinearDegressiveFunction;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.factory.KohonenFactory;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.ihm.KohonenView;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.ihm.NeuronalNetworkFrame;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.layer.Kohonen;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.signal.SignalGenerator;
import org.tc.osgi.bundle.neuronalnetwork.kohonen.supervisedFunction.KohonenLearning;
import org.tc.osgi.bundle.neuronalnetwork.metamodel.exception.ConnectionSynaptiqueException;

/**
 * KohonenTest.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 * @req STD_BUNDLE_NN_KOHONEN_010
 * @tack SRS_BUNDLE_NN_KOHONEN_010, SRS_BUNDLE_NN_KOHONEN_020, SRS_BUNDLE_NN_KOHONEN_030
 */
public class KohonenTest extends FestSwingJUnitTestCase {

    /**
     * Kohonen<Double> reseau.
     */
    private static Kohonen<Double> reseau = null;

    /**
     * createNewEditor.
     * @return NeuronalNetworkFrame
     */
    @RunsInEDT
    private static NeuronalNetworkFrame createNewEditor() {
        final GuiQuery<NeuronalNetworkFrame> query = new GuiQuery<NeuronalNetworkFrame>() {
            @Override
            protected NeuronalNetworkFrame executeInEDT() {

                final int nbrNeurone = 20 * 20;

                // Kohonen<Double> reseau = null;
                try {

                    final KohonenFactory<Double> layerfactory = new KohonenFactory<Double>();
                    KohonenTest.reseau = layerfactory.kohonen(nbrNeurone, 2, PositiveLinear.class);
                } catch (final InstantiationException e) {
                    e.printStackTrace();
                } catch (final IllegalAccessException e) {
                    e.printStackTrace();
                } catch (final ConnectionSynaptiqueException e) {
                    e.printStackTrace();
                }

                final NeuronalNetworkFrame app = new NeuronalNetworkFrame(new KohonenView(KohonenTest.reseau));
                // app.setVisible(true);
                // app.pack();
                return app;
            }
        };
        return GuiActionRunner.execute(query);

    }

    /**
     * FrameFixture editor.
     */
    private FrameFixture editor;

    @Test
    public void kohonenLayer() throws InstantiationException, IllegalAccessException, ConnectionSynaptiqueException {
        // Configuration du reseau de kohonen
        final int iteration = 100000; // represente l'echelle de temps
        final double pente = 0.15;// 0.15; // represente la pente de la fonction
        // d'activation
        // (le degre de modification des poids en fonction de
        // la distance au vainqueur)
        final int nbrNiveau = 5; // represente le perimetre sur lequel les
        // modification sur les poids auront lieu
        final double amortissement = 0.0001; // represente l'importance des
        // modifications au cour du temps
        final double coefEfficacite = 1.1;// valeur du deplacement du neurone
        // vainqueur a l'instand t=0
        final Dimension dim = new Dimension(500, 500);

        // Reseau de type kohonen attention pour l etude tout a etait restraint
        // a la dimension 2
        // 2 entree et carte de type carre

        KohonenTest.reseau.initLayer(dim);

        KohonenTest.reseau.setLearningMethod(new KohonenLearning<Double>(new LinearDegressiveFunction<Double>(iteration, pente, nbrNiveau, amortissement, coefEfficacite)));
        final SignalGenerator<Double> generator = new SignalGenerator<Double>(iteration, dim, 2);
        KohonenTest.reseau.learn(generator.getSignals());

    }

    /**
     *
     * @see org.fest.swing.junit.testcase.FestSwingJUnitTestCase#onSetUp()
     */
    @Override
    protected void onSetUp() {

        editor = new FrameFixture(robot(), KohonenTest.createNewEditor());
        editor.show();
    }

}
