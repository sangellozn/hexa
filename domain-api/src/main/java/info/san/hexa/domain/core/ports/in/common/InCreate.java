package info.san.hexa.domain.core.ports.in.common;

public interface InCreate<ID, I> {

    ID create(I item);

}
