package info.san.hexa.domain.core.ports.in.common;

/**
 * Expose des méthodes pour la création d'un objet dans le domaine.
 *
 * @param <ID> Le type de l'identifiant de l'objet métier.
 * @param <I> Le type de l'objet métier.
 */
public interface InCreate<ID, I> {

    /**
     * Crée un objet métier dans le domaine.
     *
     * @param item L'objet à créer.
     *
     * @return L'identifiant de l'objet nouvellement créé.
     */
    ID create(I item);

}
