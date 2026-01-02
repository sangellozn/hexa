package info.san.hexa.domain.core.ports.in.common;

/**
 * Expose des méthodes permettant la suppression d'un élément du domaine.
 *
 * @param <ID> Le type de l'identifiant de l'objet à supprimer.
 */
public interface IDelete<ID> {

    /**
     * Permet la suppression par son identifiant d'un objet du domaine.
     *
     * @param id L'identifiant de l'objet à supprimer.
     */
    void deleteById(ID id);

}
