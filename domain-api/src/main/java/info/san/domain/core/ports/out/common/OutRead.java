package info.san.domain.core.ports.out.common;

import java.util.Optional;

public interface OutRead<ID, I> {

    Optional<I> findById(ID id);

}
