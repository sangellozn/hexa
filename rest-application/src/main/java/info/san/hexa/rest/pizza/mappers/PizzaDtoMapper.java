package info.san.hexa.rest.pizza.mappers;

import info.san.hexa.domain.core.model.pizza.Pizza;
import info.san.hexa.rest.api.model.NouvellePizzaDTO;
import info.san.hexa.rest.api.model.PizzaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = { IngredientDtoMapper.class })
public interface PizzaDtoMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "ingredients", source = "ingredients")
    PizzaDTO mapToDTO(Pizza pizza);

    List<PizzaDTO> mapToDTO(List<Pizza> pizzas);

    @Mapping(target = "calzone", ignore = true)
    Pizza mapToDomain(PizzaDTO dto);

    @Mapping(target = "calzone", ignore = true)
    @Mapping(target = "id", ignore = true)
    Pizza mapToDomain(NouvellePizzaDTO dto);

    @ValueMappings(value = {
            @ValueMapping(target = "GRANDE", source = "LARGE"),
            @ValueMapping(target = "MOYENNE", source = "MEDIUM"),
            @ValueMapping(target = "PETITE", source = "ENFANT"),
            @ValueMapping(target = "TRES_GRANDE", source = "TRES_GROS_MANGEUR")
    })
    Pizza.Taille map(NouvellePizzaDTO.TailleEnum taille);

    @ValueMappings(value = {
            @ValueMapping(target = "GRANDE", source = "LARGE"),
            @ValueMapping(target = "MOYENNE", source = "MEDIUM"),
            @ValueMapping(target = "PETITE", source = "ENFANT"),
            @ValueMapping(target = "TRES_GRANDE", source = "TRES_GROS_MANGEUR")
    })
    Pizza.Taille map(PizzaDTO.TailleEnum taille);

    @ValueMappings(value = {
            @ValueMapping(target = "LARGE", source = "GRANDE"),
            @ValueMapping(target = "MEDIUM", source = "MOYENNE"),
            @ValueMapping(target = "ENFANT", source = "PETITE"),
            @ValueMapping(target = "TRES_GROS_MANGEUR", source = "TRES_GRANDE")
    })
    PizzaDTO.TailleEnum map(Pizza.Taille taille);
}
