package info.san.hexa.domain.core.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Page<T> {

    private final List<T> contenu;

    private final int page;

    private final int taille;


}
