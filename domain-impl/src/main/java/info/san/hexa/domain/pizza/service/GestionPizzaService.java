package info.san.hexa.domain.pizza.service;

import info.san.hexa.domain.core.exceptions.PizzaNatureException;
import info.san.hexa.domain.core.model.pizza.Pizza;
import info.san.hexa.domain.core.ports.in.IGestionPizza;
import info.san.hexa.domain.core.ports.out.pizza.IPizzaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GestionPizzaService implements IGestionPizza {

    private final IPizzaRepository pizzaRepository;

    @Override
    public void deleteById(Long id) {
        pizzaRepository.delete(id);
    }

    @Override
    public Long create(Pizza pizza) {
        if (CollectionUtils.isEmpty(pizza.getIngredients())) {
            throw new PizzaNatureException("J'aime bien aussi quand c'est light mais quand même...");
        }
        return pizzaRepository.creer(pizza).getId();
    }

    @Override
    public void update(Long id, Pizza pizza) {
        pizzaRepository.update(id, pizza);
    }
}
