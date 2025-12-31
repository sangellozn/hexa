package info.san.domain.core.model.pizza;

import info.san.domain.core.exceptions.PizzaDejaCuiteException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

@Getter
@Setter
public class Pizza {

    private Long id;

    private final Collection<Ingredient> ingredients;

    private boolean isCalzone;

    @Setter(AccessLevel.NONE)
    private boolean isCuite;

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
                .orElse(BigDecimal.ZERO);
    }

}
