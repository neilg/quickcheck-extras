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
