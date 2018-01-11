package org.tc.osgi.bundle.neuronalnetwork.metamodel.mm;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * InputFunction.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
public abstract class InputFunction<T extends Number> implements Serializable {
    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -133101643174548397L;

    /**
     * evaluate.
     * @param dendriteList ArrayList<Dendrite<T>>
     * @param biais Biais<T>
     * @return T
     */
    public abstract T evaluate(ArrayList<Dendrite<T>> dendriteList, Biais<T> biais);

    /**
     * @return String
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Permet de definir des fonctions d'entr�es dans le neurone\n";
    }
}
