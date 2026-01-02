package info.san.hexa.domain.core.ports.in.common;

import info.san.hexa.domain.core.model.common.Page;

import java.util.Optional;

/**
 * Expose des méthodes pour le requêtage du domaine métier pour un type d'objet.
 *
 * @param <ID> Le type de l'identifiant de l'objet métier.
 * @param <I> Le type de l'objet métier.
 */
public interface InRead<ID, I> {

    /**
     * Permet la récupération d'un objet par son identifiant.
     *
     * @param id L'identifiant de l'objet à rechercher.
     *
     * @return L'objet trouvé ou un Optional vide si aucun objet de ce type existe pour l'identifiant fourni.
     */
    Optional<I> findById(ID id);

    /**
     * Récupère tous les objets de manière paginées.
     *
     * @param numeroPage Le numéro de la page que l'on recherche (doit être >= à 0).
     * @param taille La taille de la page voulue (doit être >= à 1).
     *
     * @return La page contenant les objets.
     */
    Page<I> findPage(int numeroPage, int taille);

}
