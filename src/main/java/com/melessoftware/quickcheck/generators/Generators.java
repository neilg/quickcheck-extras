package com.melessoftware.quickcheck.generators;

import net.java.quickcheck.Generator;

public class Generators {

    public static <T> Generator<T> chooseFrom(T... chooseFrom) {
        return new ChoiceGenerator<T>(chooseFrom);
    }
}
