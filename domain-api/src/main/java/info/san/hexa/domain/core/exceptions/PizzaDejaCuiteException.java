package info.san.hexa.domain.core.exceptions;

/**
 * Exception indiquant que l'on essaie de cuire plusieurs fois une pizza.
 */
public class PizzaDejaCuiteException extends RuntimeException {

    /**
     * Constructeur par défaut.
     *
     * @param message Le message détaillant l'exception.
     */
    public PizzaDejaCuiteException(final String message) {
        super(message);
    }
}
