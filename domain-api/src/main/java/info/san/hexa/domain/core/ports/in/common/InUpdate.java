package info.san.hexa.domain.core.ports.in.common;

public interface InUpdate<ID, I> {

    void update(ID id, I item);

}
