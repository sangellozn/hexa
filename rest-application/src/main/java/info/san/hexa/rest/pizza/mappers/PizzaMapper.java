package info.san.hexa.rest.pizza.mappers;

import info.san.domain.core.model.pizza.Pizza;
import info.san.rest.api.model.PizzaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = { IngredientMapper.class })
public interface PizzaMapper {

    @Mapping(target = "prix", source = "prix")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "taille", ignore = true)
    @Mapping(target = "ingredients", source = "ingredients")
    PizzaDTO mapToDTO(Pizza pizza);

    List<PizzaDTO> mapToDTO(List<Pizza> pizzas);


    Pizza mapToDomain(PizzaDTO dto);

}
