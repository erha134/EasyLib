package io.github.erha134.easylib.util.container;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.function.Function;

@Data
@AllArgsConstructor
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
public final class Pair<A, B> {
    private A left;
    private B right;

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
