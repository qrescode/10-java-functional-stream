package com.example.task01;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task01Main {
    public static void main(String[] args) throws IOException {

        Predicate<Object> condition = obj -> Objects.isNull(obj);
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = (c) -> c.length();
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        safeStringLength.apply("Hello");
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        Objects.requireNonNull(condition);
        Objects.requireNonNull(ifTrue);
        Objects.requireNonNull(ifFalse);

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }
}
