package info.san.hexa.rest.pizza.mappers;

import info.san.hexa.domain.core.model.pizza.Ingredient;
import info.san.rest.api.model.IngredientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "prix", source = "prixUnitaire")
    @Mapping(target = "nom", source = "nom")
    IngredientDTO map(Ingredient ingredient);

    List<IngredientDTO> map(Collection<Ingredient> ingredients);


    Ingredient mapToDomain(IngredientDTO dto);

}
