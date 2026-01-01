package info.san.infrastructure.persistence.jpa.pizza.mapper;

import info.san.hexa.domain.core.model.pizza.Pizza;
import info.san.infrastructure.persistence.jpa.pizza.entities.PizzaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {
        IngredientMapper.class
})
public interface PizzaMapper {

    @Mapping(target = "ingredients", ignore = true)
    PizzaEntity mapToEntity(Pizza pizza);

    Pizza mapToDomain(PizzaEntity pizza);

    @ValueMappings(value = {
            @ValueMapping(target = "PETITE", source = "PETITE"),
            @ValueMapping(target = "MOYENNE", source = "MOYENNE"),
            @ValueMapping(target = "GRANDE", source = "GRANDE"),
            @ValueMapping(target = "XXL", source = "TRES_GRANDE"),
    })
    PizzaEntity.Taille map(Pizza.Taille taille);

    @ValueMappings(value = {
            @ValueMapping(target = "PETITE", source = "PETITE"),
            @ValueMapping(target = "MOYENNE", source = "MOYENNE"),
            @ValueMapping(target = "GRANDE", source = "GRANDE"),
            @ValueMapping(target = "TRES_GRANDE", source = "XXL"),
    })
    Pizza.Taille map(PizzaEntity.Taille taille);

    List<Pizza> mapToDomain(Collection<PizzaEntity> pizzas);

}
