package info.san.hexa.domain.core.ports.out.pizza;

import info.san.hexa.domain.core.model.pizza.Pizza;
import info.san.hexa.domain.core.ports.out.common.OutCrud;

public interface IPizzaRepository extends OutCrud<Long, Pizza> {

    // no-op

}
