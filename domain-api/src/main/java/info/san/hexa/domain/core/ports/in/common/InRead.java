package info.san.hexa.domain.core.ports.in.common;

import info.san.hexa.domain.core.model.common.Page;

import java.util.Optional;

public interface InRead<ID, I> {

    Optional<I> findById(ID id);

    Page<I> findPage(int numeroPage, int taille);

}
