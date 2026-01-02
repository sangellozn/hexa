package info.san.hexa.domain.core.exceptions;

/**
 * Exception permettant d'indiquer que le numéro ou la taille d'une page demandée est invalide (< 0 ou trop grande par
 * rapport aux limites fixées).
 */
public class NumeroPageOuTailleInvalideException extends RuntimeException {

    /**
     * Constructeur par défaut.
     *
     * @param message Le message détaillant l'exception.
     */
    public NumeroPageOuTailleInvalideException(final String message) {
        super(message);
    }
}
