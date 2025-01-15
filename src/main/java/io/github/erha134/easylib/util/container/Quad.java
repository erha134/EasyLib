package io.github.erha134.easylib.util.container;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.function.Function;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public final class Quad<A, B, C, D> {
    private final A first;
    private final B second;
    private final C third;
    private final D fourth;

    public boolean isFirstPresent() {
        return this.first != null;
    }

    public boolean isSecondPresent() {
        return this.second != null;
    }

    public boolean isThirdPresent() {
        return this.third != null;
    }

    public boolean isFourthPresent() {
        return this.fourth != null;
    }

    public <E, F, G, H> Quad<E, F, G, H> map(Function<A, E> aMappingFunction,
                                             Function<B, F> bMappingFunction,
                                             Function<C, G> cMappingFunction,
                                             Function<D, H> dMappingFunction) {
        return new Quad<>(aMappingFunction.apply(this.first),
                bMappingFunction.apply(this.second),
                cMappingFunction.apply(this.third),
                dMappingFunction.apply(this.fourth));
    }
}
