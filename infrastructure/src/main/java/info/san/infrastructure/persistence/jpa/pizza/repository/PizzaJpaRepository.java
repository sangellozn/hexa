package info.san.infrastructure.persistence.jpa.pizza.repository;

import info.san.domain.core.model.pizza.Pizza;
import info.san.domain.core.ports.out.pizza.IPizzaRepository;
import info.san.infrastructure.persistence.jpa.pizza.dao.PizzaEntityDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PizzaJpaRepository implements IPizzaRepository {

    private final PizzaEntityDao pizzaEntityDao;

    @Override
    public Pizza creer(Pizza item) {
        return null;
    }

    @Override
    public void delete(Long id) {
        pizzaEntityDao.deleteById(id);
    }

    @Override
    public Optional<Pizza> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Pizza update(Pizza item) {
        return null;
    }

}
