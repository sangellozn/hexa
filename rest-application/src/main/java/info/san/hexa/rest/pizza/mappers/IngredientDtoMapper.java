package info.san.hexa.rest.pizza.mappers;

import info.san.hexa.domain.core.model.pizza.Ingredient;
import info.san.hexa.rest.api.model.IngredientDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface IngredientDtoMapper {

    default IngredientDTO map(Collection<Ingredient> ingredients) {
        IngredientDTO dto = new IngredientDTO();

        dto.setIds(ingredients.stream()
                .map(ingredient -> ingredient.id().intValue()).toList());

        return dto;
    }

    default Collection<Ingredient> map(IngredientDTO value) {
        return value.getIds().stream().map(id -> new Ingredient(Long.valueOf(id),
                null, null)).toList();
    }

}
