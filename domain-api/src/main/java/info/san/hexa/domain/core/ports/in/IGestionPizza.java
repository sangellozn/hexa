package info.san.hexa.domain.core.ports.in;

import info.san.hexa.domain.core.model.pizza.Pizza;
import info.san.hexa.domain.core.ports.in.common.IDelete;
import info.san.hexa.domain.core.ports.in.common.InCreate;
import info.san.hexa.domain.core.ports.in.common.InUpdate;

public interface IGestionPizza extends IDelete<Long>, InUpdate<Long, Pizza>, InCreate<Long, Pizza> {

    // no-op

}
