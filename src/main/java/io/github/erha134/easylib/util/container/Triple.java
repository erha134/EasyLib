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
public final class Triple<A, B, C> {
    private A left;
    private B middle;
    private C right;

    public boolean isLeftPresent() {
        return this.left != null;
    }

    public boolean isMiddlePresent() {
        return this.middle != null;
    }

    public boolean isRightPresent() {
        return this.right != null;
    }

    public <D, E, F> Triple<D, E, F> map(Function<A, D> aMappingFunction,
                                         Function<B, E> bMappingFunction,
                                         Function<C, F> cMappingFunction) {
        return new Triple<>(aMappingFunction.apply(this.left),
                bMappingFunction.apply(this.middle),
                cMappingFunction.apply(this.right));
    }
}
