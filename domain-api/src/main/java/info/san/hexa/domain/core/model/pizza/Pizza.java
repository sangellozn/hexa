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

    public enum Taille {
        PETITE(BigDecimal.ONE),

        MOYENNE(BigDecimal.valueOf(1.5)),

        GRANDE(BigDecimal.valueOf(2)),

        TRES_GRANDE(BigDecimal.valueOf(3));

        @Getter
        private final BigDecimal multiplicateurPrix;

        Taille(BigDecimal multiplicateurPrix) {
            this.multiplicateurPrix = multiplicateurPrix;
        }

    }

    private Long id;

    private final Collection<Ingredient> ingredients;

    private boolean isCalzone;

    @Setter(AccessLevel.NONE)
    private boolean isCuite;

    private Taille taille;

    public Pizza() {
        this.ingredients = new HashSet<>();
    }

    public void cuire() {
        if (this.isCuite) {
            throw new PizzaDejaCuiteException("La pizza est déjà cuite, elle va être cramée !");
        }

        this.isCuite = true;
    }

    public boolean ajouterIngredient(Ingredient ingredient) {
        return this.ingredients.add(ingredient);
    }

    public BigDecimal getPrix() {
        return this.ingredients.stream()
                .map(Ingredient::prixUnitaire)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .multiply(this.getTaille().getMultiplicateurPrix());
    }

}
