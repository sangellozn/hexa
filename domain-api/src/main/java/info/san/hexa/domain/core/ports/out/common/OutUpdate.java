package info.san.hexa.domain.core.ports.out.common;

public interface OutUpdate<ID, I> {

    void update(ID id, I item);

}
