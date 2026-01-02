package info.san.hexa.rest.pizza.adaptaters;

import info.san.hexa.domain.core.ports.in.IGestionPizza;
import info.san.hexa.domain.core.ports.in.IRecuperationPizza;
import info.san.hexa.rest.api.model.NouvellePizzaDTO;
import info.san.hexa.rest.api.model.PizzaDTO;
import info.san.hexa.rest.api.model.PizzaModifieeDTO;
import info.san.hexa.rest.pizza.mappers.PizzaDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PizzaRestAdapter {

    private final IRecuperationPizza recuperationPizza;

    private final IGestionPizza gestionPizza;

    private final PizzaDtoMapper pizzaDtoMapper;

    public void updatePizza(Long id, PizzaModifieeDTO pizzaDTO) {
        gestionPizza.update(id, pizzaDtoMapper.mapToDomain(pizzaDTO));
    }

    public Long createPizza(NouvellePizzaDTO pizzaDTO) {
        return gestionPizza.create(pizzaDtoMapper.mapToDomain(pizzaDTO));
    }

    public void deletePizza(Long pizzaId) {
        gestionPizza.deleteById(pizzaId);
    }

    public Optional<PizzaDTO> getPizza(Long pizzaId) {
        return recuperationPizza.findById(pizzaId).map(pizzaDtoMapper::mapToDTO);
    }

    public List<PizzaDTO> getPizzas(int page, int size) {
        return pizzaDtoMapper.mapToDTO(recuperationPizza.findPage(page, size).getContenu());
    }

}
