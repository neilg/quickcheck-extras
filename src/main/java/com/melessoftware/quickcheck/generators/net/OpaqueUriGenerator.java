/*
 * Meles Quickcheck Extras
 * Copyright (C) 2013  Neil Green
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
