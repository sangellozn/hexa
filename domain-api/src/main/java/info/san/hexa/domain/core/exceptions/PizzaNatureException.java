package info.san.hexa.domain.core.exceptions;

/**
 * Classe pour indiquer un soucis d'ingrédient avec la pizza.
 */
public class PizzaNatureException extends RuntimeException {

    /**
     * Constructeur par défaut.
     *
     * @param message Le message détaillant l'exception.
     */
    public PizzaNatureException(final String message) {
        super(message);
    }
}
