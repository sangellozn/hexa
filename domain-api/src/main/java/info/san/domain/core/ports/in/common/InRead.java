package info.san.domain.core.ports.in.common;

import info.san.domain.core.model.common.Page;
import info.san.domain.core.model.pizza.Pizza;

import java.util.Optional;

public interface InRead<ID, I> {

    Optional<I> findById(ID id);

    Page<I> findPage(int numeroPage, int taille);

}
