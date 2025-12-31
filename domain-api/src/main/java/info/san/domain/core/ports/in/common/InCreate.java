package info.san.domain.core.ports.in.common;

public interface InCreate<ID, I> {

    ID create(I item);

}
