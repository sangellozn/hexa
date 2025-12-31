package info.san.domain.core.ports.in;

import info.san.domain.core.model.pizza.Pizza;
import info.san.domain.core.ports.in.common.IDelete;
import info.san.domain.core.ports.in.common.InCreate;
import info.san.domain.core.ports.in.common.InUpdate;

public interface IGestionPizza extends IDelete<Long>, InUpdate<Long, Pizza>, InCreate<Long, Pizza> {

    // no-op

}
