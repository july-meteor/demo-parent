package com.meteor.demo.lambda.function;

import java.util.Objects;

/**
 * Created  meteor on 2020/4/21
 **/
@FunctionalInterface
public interface Function<T, R>  {

    R apply(T t);
    //生成了function的参数类型同before一样
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }
    //新生成的function的返回值类型要after一样
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
    //
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
