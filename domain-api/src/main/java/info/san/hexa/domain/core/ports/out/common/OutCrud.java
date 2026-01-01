package info.san.hexa.domain.core.ports.out.common;

public interface OutCrud<ID, I> extends OutCreate<I>, OutRead<ID, I>, OutUpdate<I>, OutDelete<ID> {
}
