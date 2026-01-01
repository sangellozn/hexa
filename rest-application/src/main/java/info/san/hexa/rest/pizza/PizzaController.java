package info.san.hexa.rest.pizza;

import info.san.hexa.rest.api.PizzaApi;
import info.san.hexa.rest.api.model.NouvellePizzaDTO;
import info.san.hexa.rest.api.model.PizzaAltereeDTO;
import info.san.hexa.rest.api.model.PizzaDTO;
import info.san.hexa.rest.pizza.adaptaters.PizzaRestAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PizzaController implements PizzaApi {

    private final PizzaRestAdapter pizzaRestAdapter;

    @Override
    public ResponseEntity<Void> createPizza(NouvellePizzaDTO nouvellePizzaDTO) {
        Long id = pizzaRestAdapter.createPizza(nouvellePizzaDTO);
        return ResponseEntity.created(URI.create("pizzas/" + id)).build();
    }

    @Override
    public ResponseEntity<Void> deletePizza(Long pizzaId) {
        pizzaRestAdapter.deletePizza(pizzaId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<PizzaDTO> getPizza(Long pizzaId) {
        return ResponseEntity.of(pizzaRestAdapter.getPizza(pizzaId));
    }

    @Override
    public ResponseEntity<List<PizzaDTO>> getPizzas(Integer page, Integer size) {
        return ResponseEntity.ok(pizzaRestAdapter.getPizzas(page, size));
    }

    @Override
    public ResponseEntity<Void> updatePizza(Long pizzaId, PizzaDTO pizzaDTO) {
        pizzaRestAdapter.updatePizza(pizzaId, pizzaDTO);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> altererPizza(Long pizzaId, PizzaAltereeDTO pizzaAltereeDTO) {
        // FIXME
        return PizzaApi.super.altererPizza(pizzaId, pizzaAltereeDTO);
    }
}
