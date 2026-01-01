package info.san.infrastructure.persistence.jpa.pizza.repository;

import info.san.hexa.domain.core.model.pizza.Ingredient;
import info.san.hexa.domain.core.model.pizza.Pizza;
import info.san.hexa.domain.core.ports.out.pizza.IPizzaRepository;
import info.san.infrastructure.persistence.jpa.pizza.dao.IngredientEntityDao;
import info.san.infrastructure.persistence.jpa.pizza.dao.PizzaEntityDao;
import info.san.infrastructure.persistence.jpa.pizza.entities.IngredientEntity;
import info.san.infrastructure.persistence.jpa.pizza.entities.PizzaEntity;
import info.san.infrastructure.persistence.jpa.pizza.mapper.PizzaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PizzaJpaRepository implements IPizzaRepository {

    private final PizzaEntityDao pizzaEntityDao;

    private final IngredientEntityDao ingredientEntityDao;

    private final PizzaMapper pizzaMapper;

    @Override
    @Transactional
    public Pizza creer(Pizza pizza) {
        PizzaEntity entity = pizzaMapper.mapToEntity(pizza);

        List<IngredientEntity> ingredientEntities = ingredientEntityDao.findAllById(pizza.getIngredients()
                .stream().map(Ingredient::id).collect(Collectors.toSet()));

        entity.setIngredients(ingredientEntities);

        entity = pizzaEntityDao.save(entity);

        return pizzaMapper.mapToDomain(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pizzaEntityDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pizza> findById(Long id) {
        return pizzaEntityDao.findById(id).map(pizzaMapper::mapToDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pizza> getPage(int page, int taille) {
        return pizzaMapper.mapToDomain(pizzaEntityDao.findAll(PageRequest.of(page, taille)).getContent());
    }

    @Override
    @Transactional
    public void update(Pizza pizza) {
        PizzaEntity entity = pizzaMapper.mapToEntity(pizza);

        entity.getIngredients().clear();

        entity = pizzaEntityDao.save(entity);

        List<IngredientEntity> ingredientEntities = ingredientEntityDao.findAllById(pizza.getIngredients()
                .stream().map(Ingredient::id).collect(Collectors.toSet()));

        entity.setIngredients(ingredientEntities);

        pizzaEntityDao.save(entity);
    }

}
