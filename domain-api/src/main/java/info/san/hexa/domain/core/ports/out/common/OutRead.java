package info.san.hexa.domain.core.ports.out.common;

import java.util.List;
import java.util.Optional;

public interface OutRead<ID, I> {

    Optional<I> findById(ID id);

    List<I> getPage(int page, int taille);

}
