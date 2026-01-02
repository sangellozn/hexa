package info.san.hexa.domain.core.model.pizza;

import info.san.hexa.domain.core.exceptions.PizzaDejaCuiteException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

@Getter
@Setter
public class Pizza {

    /**
     * Les tailles des pizzas que peut fabriquer le restaurant.
     */
    @Getter
    public enum Taille {

        /**
         * Une petite pizza.
         */
        PETITE(BigDecimal.ONE),

        /**
         * Une pizza de taille standard.
         */
        MOYENNE(BigDecimal.valueOf(1.5)),

        /**
         * Une grande pizza pour les gros mangeurs ou à partager.
         */
        GRANDE(BigDecimal.valueOf(2)),

        /**
         * Quand on fait une pizza party !
         */
        TRES_GRANDE(BigDecimal.valueOf(3));

        private final BigDecimal multiplicateurPrix;

        Taille(final BigDecimal multiplicateurPrix) {
            this.multiplicateurPrix = multiplicateurPrix;
        }

    }

    private Long id;

    private final Collection<Ingredient> ingredients;

    private boolean isCalzone;

    @Setter(AccessLevel.NONE)
    private boolean isCuite;

    private Taille taille;

    /**
     * Constructeur par défaut, crée une pizza "nature".
     */
    public Pizza() {
        this.ingredients = new HashSet<>();
    }

    /**
     * Cuit la pizza.
     */
    public void cuire() {
        if (this.isCuite) {
            throw new PizzaDejaCuiteException("La pizza est déjà cuite, elle va être cramée !");
        }

        this.isCuite = true;
    }

    /**
     * Ajoute un ingrédient à la pizza.
     *
     * @param ingredient L'ingrédient à ajouter.
     *
     * @return {@code true} si l'ajout à était effectué, {@code false} si l'ingrédient existait déjà.
     */
    public boolean ajouterIngredient(final Ingredient ingredient) {
        return this.ingredients.add(ingredient);
    }

    /**
     * Récupère le prix de la pizza en ajoutant tous les prix unitaires des ingrédients et applique
     * un multiplicateur en fonction de la taille de la pizza.
     *
     * @return Le prix final de la pizza.
     */
    public BigDecimal getPrix() {
        return this.ingredients.stream()
                .map(Ingredient::prixUnitaire)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .multiply(this.getTaille().getMultiplicateurPrix());
    }

}
