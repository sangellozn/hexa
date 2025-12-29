package info.san.domain.core.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@Getter
@RequiredArgsConstructor
public class Page<T> {

    private final Collection<T> contenu;

    private final int index;

}
