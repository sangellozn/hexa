package info.san.hexa.infrastructure.persistence.jpa.repository.pizza;

import info.san.hexa.domain.core.model.pizza.Ingredient;
import info.san.hexa.domain.core.model.pizza.Pizza;
import info.san.hexa.domain.core.ports.out.pizza.IPizzaRepository;
import info.san.hexa.infrastructure.persistence.jpa.dao.pizza.IngredientEntityDao;
import info.san.hexa.infrastructure.persistence.jpa.dao.pizza.PizzaEntityDao;
import info.san.hexa.infrastructure.persistence.jpa.entities.pizza.IngredientEntity;
import info.san.hexa.infrastructure.persistence.jpa.entities.pizza.PizzaEntity;
import info.san.hexa.infrastructure.persistence.jpa.mapper.pizza.PizzaEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PizzaJpaRepository implements IPizzaRepository {

    private final PizzaEntityDao pizzaEntityDao;

    private final IngredientEntityDao ingredientEntityDao;

    private final PizzaEntityMapper pizzaEntityMapper;

    @Override
    public Pizza creer(Pizza pizza) {
        PizzaEntity entity = pizzaEntityMapper.mapToEntity(pizza);

        List<IngredientEntity> ingredientEntities = ingredientEntityDao.findAllById(pizza.getIngredients()
                .stream().map(Ingredient::id).collect(Collectors.toSet()));

        entity.setIngredients(ingredientEntities);

        entity = pizzaEntityDao.save(entity);

        return pizzaEntityMapper.mapToDomain(entity);
    }

    @Override
    public void delete(Long id) {
        pizzaEntityDao.deleteById(id);
    }

    @Override
    public Optional<Pizza> findById(Long id) {
        return pizzaEntityDao.findById(id).map(pizzaEntityMapper::mapToDomain);
    }

    @Override
    public List<Pizza> getPage(int page, int taille) {
        return pizzaEntityMapper.mapToDomain(pizzaEntityDao.findAll(PageRequest.of(page, taille)).getContent());
    }

    @Override
    public void update(Pizza pizza) {
        PizzaEntity entity = pizzaEntityMapper.mapToEntity(pizza);

        entity.getIngredients().clear();

        entity = pizzaEntityDao.save(entity);

        List<IngredientEntity> ingredientEntities = ingredientEntityDao.findAllById(pizza.getIngredients()
                .stream().map(Ingredient::id).collect(Collectors.toSet()));

        entity.setIngredients(ingredientEntities);

        pizzaEntityDao.save(entity);
    }

}
