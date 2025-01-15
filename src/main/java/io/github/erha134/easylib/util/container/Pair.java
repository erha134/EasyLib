package io.github.erha134.easylib.util.container;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.function.Function;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public final class Pair<A, B> {
    private final A left;
    private final B right;

    public boolean isLeftPresent() {
        return this.left != null;
    }

    public boolean isRightPresent() {
        return this.right != null;
    }

    public <C, D> Pair<C, D> map(Function<A, C> aMappingFunction,
                                 Function<B, D> bMappingFunction) {
        return new Pair<>(aMappingFunction.apply(this.left),
                bMappingFunction.apply(this.right));
    }
}
