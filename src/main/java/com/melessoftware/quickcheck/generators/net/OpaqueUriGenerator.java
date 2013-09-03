package com.melessoftware.quickcheck.generators.net;

import static com.melessoftware.quickcheck.generators.net.UriSchemeGenerator.schemes;
import static net.java.quickcheck.generator.PrimitiveGenerators.letterStrings;

import java.net.URI;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.support.StringGenerator;

public class OpaqueUriGenerator implements Generator<URI> {

    private final Generator<String> schemeGenerator;
    private final Generator<String> specificPartGenerator;

    public OpaqueUriGenerator() {
        this(schemes(), letterStrings(1, StringGenerator.MAX_LENGTH));
    }

    public OpaqueUriGenerator(Generator<String> schemeGenerator, Generator<String> specificPartGenerator) {
        this.schemeGenerator = schemeGenerator;
        this.specificPartGenerator = specificPartGenerator;
    }


    @Override
    public URI next() {
        String scheme = schemeGenerator.next();
        String specificPart = specificPartGenerator.next();
        return URI.create(scheme + ":" + specificPart);
    }
}
