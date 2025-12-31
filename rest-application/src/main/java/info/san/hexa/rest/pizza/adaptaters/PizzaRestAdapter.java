package info.san.hexa.rest.pizza.adaptaters;

import info.san.domain.core.ports.in.IGestionPizza;
import info.san.domain.core.ports.in.IRecuperationPizza;
import info.san.hexa.rest.pizza.mappers.PizzaMapper;
import info.san.rest.api.model.PizzaDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PizzaRestAdapter {

    private final IRecuperationPizza recuperationPizza;

    private final IGestionPizza gestionPizza;

    private final PizzaMapper pizzaMapper;

    public void updatePizza(Long id, PizzaDTO pizzaDTO) {
        gestionPizza.update(id, pizzaMapper.mapToDomain(pizzaDTO));
    }

    public Long createPizza(PizzaDTO pizzaDTO) {
        return gestionPizza.create(pizzaMapper.mapToDomain(pizzaDTO));
    }

    public void deletePizza(Long pizzaId) {
        gestionPizza.deleteById(pizzaId);
    }

    public Optional<PizzaDTO> getPizza(Long pizzaId) {
        return recuperationPizza.findById(pizzaId).map(pizzaMapper::mapToDTO);
    }

    public List<PizzaDTO> getPizzas(int page, int size) {
        return pizzaMapper.mapToDTO(recuperationPizza.findPage(page, size).getContenu());
    }

}
