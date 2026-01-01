package info.san.hexa.infrastructure.persistence.jpa.mapper.pizza;

import info.san.hexa.domain.core.model.pizza.Pizza;
import info.san.hexa.infrastructure.persistence.jpa.entities.pizza.PizzaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {
        IngredientEntityMapper.class
})
public interface PizzaEntityMapper {

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
