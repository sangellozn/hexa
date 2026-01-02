package info.san.hexa.domain.core.model.pizza;

import java.math.BigDecimal;
import java.util.Objects;

public record Ingredient(Long id, String nom, BigDecimal prixUnitaire) {

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
