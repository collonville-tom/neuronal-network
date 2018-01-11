package org.tc.osgi.bundle.neuronalnetwork.metamodel.exception;

/**
 * ConnectionSynaptiqueException.java.
 * @author Collonvillé Thomas
 * @version 0.0.1
 */
@SuppressWarnings("serial")
public class ConnectionSynaptiqueException extends Exception {

    /**
     * long serialVersionUID.
     */
    private static final long serialVersionUID = -1520325736579336439L;

    /**
     * ConnectionSynaptiqueException constructor.
     * @param msg String
     */
    public ConnectionSynaptiqueException(final String msg) {
        super(msg);
    }

    /**
     * ConnectionSynaptiqueException constructor.
     * @param msg String
     * @param cause Throwable
     */
    public ConnectionSynaptiqueException(final String msg, final Throwable cause) {
        super(msg, cause);
    }
}
