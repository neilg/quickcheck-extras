package com.melessoftware.quickcheck.generators;

import static net.java.quickcheck.generator.PrimitiveGenerators.integers;

import java.util.Arrays;

import net.java.quickcheck.Generator;

public class ChoiceGenerator<T> implements Generator<T> {

    private final T[] chooseFrom;
    private final Generator<Integer> positionGenerator;

    public ChoiceGenerator(T... chooseFrom) {
        this.chooseFrom = Arrays.copyOf(chooseFrom, chooseFrom.length);
        positionGenerator = integers(0, chooseFrom.length - 1);
    }

    @Override
    public T next() {
        return chooseFrom[positionGenerator.next()];
    }
}
