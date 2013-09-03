package com.melessoftware.quickcheck.generators.net;

import static net.java.quickcheck.generator.PrimitiveGenerators.characters;
import static net.java.quickcheck.generator.PrimitiveGenerators.strings;

import net.java.quickcheck.Generator;

public class UriSchemeGenerator implements Generator<String> {

    private final Generator<String> headCharGenerator = strings("A", 1, 1)
            .add(characters('a', 'z'))
            .add(characters('B', 'Z'));

    private final Generator<String> tailStringGenerator = strings('a', 'z')
            .add(characters('A', 'Z'))
            .add(characters("+-."));

    @Override
    public String next() {
        final String head = headCharGenerator.next();
        final String tail = tailStringGenerator.next();
        return head + tail;
    }

    public static Generator<String> schemes() {
        return new UriSchemeGenerator();
    }
}
