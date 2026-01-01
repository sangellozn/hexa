package info.san.hexa.domain.core.ports.in.common;

public interface IDelete<ID> {

    void deleteById(ID id);

}
