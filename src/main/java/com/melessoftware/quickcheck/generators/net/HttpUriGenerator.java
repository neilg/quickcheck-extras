package com.melessoftware.quickcheck.generators.net;

import static com.melessoftware.quickcheck.generators.Generators.chooseFrom;
import static net.java.quickcheck.generator.PrimitiveGenerators.letterStrings;

import java.net.URI;

import net.java.quickcheck.Generator;

public class HttpUriGenerator implements Generator<URI> {

    private final Generator<String> schemeGenerator = chooseFrom("http", "https");
    private final Generator<String> hostnameGenerator = letterStrings(1, 30);

    @Override
    public URI next() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
