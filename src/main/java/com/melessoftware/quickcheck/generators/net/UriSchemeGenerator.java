package com.melessoftware.quickcheck.generators.net;

import static net.java.quickcheck.generator.PrimitiveGenerators.characters;
import static net.java.quickcheck.generator.PrimitiveGenerators.strings;

import net.java.quickcheck.Generator;

public class UriSchemeGenerator implements Generator<String> {

    private final Generator<String> firstChar = strings(1, 1)
            .add(characters('a', 'z'))
            .add(characters('A', 'Z'));

    private final Generator<String> rest = strings('a', 'z')
            .add(characters('A', 'Z'))
            .add(characters("+-."));

    @Override
    public String next() {
        return firstChar.next() + rest.next();
    }
}
