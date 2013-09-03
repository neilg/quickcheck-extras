package com.melessoftware.quickcheck.generators.net;

import static net.java.quickcheck.generator.PrimitiveGenerators.characters;
import static net.java.quickcheck.generator.PrimitiveGenerators.strings;

import java.net.URI;

import net.java.quickcheck.Generator;

public class OpaqueUriGenerator implements Generator<URI> {

    private final Generator<String> schemeGenerator;

    public OpaqueUriGenerator() {
        this(strings('a', 'z')
                .add(characters('A', 'Z'))
                .add(characters('0', '9'))
                .add(characters("+-.")));
    }

    public OpaqueUriGenerator(Generator<String> schemeGenerator) {
        this.schemeGenerator = schemeGenerator;
    }


    @Override
    public URI next() {
        String scheme = schemeGenerator.next();
        return URI.create(scheme+":");
    }
}
