package info.san.domain.core.ports.in.common;

public interface InUpdate<ID, I> {

    void update(ID id, I item);

}
