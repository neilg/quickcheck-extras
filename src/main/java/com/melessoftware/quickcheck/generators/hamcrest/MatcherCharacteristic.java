package com.melessoftware.quickcheck.generators.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;

import net.java.quickcheck.Generator;
import net.java.quickcheck.QuickCheck;
import net.java.quickcheck.characteristic.AbstractCharacteristic;
import org.hamcrest.Matcher;

public class MatcherCharacteristic<T> extends AbstractCharacteristic<T> {

    private final Matcher<? super T> matcher;

    public MatcherCharacteristic(Matcher<? super T> matcher) {
        this.matcher = matcher;
    }

    @Override
    protected void doSpecify(T any) {
        assertThat(any, matcher);
    }

    public static <T> void forAll(Generator<T> generator, Matcher<? super T> matcher) {
        QuickCheck.forAll(generator, new MatcherCharacteristic<T>(matcher));
    }

    public static <T> void forAll(int runs, Generator<T> generator, Matcher<? super T> matcher) {
        QuickCheck.forAll(runs, generator, new MatcherCharacteristic<T>(matcher));
    }
}
