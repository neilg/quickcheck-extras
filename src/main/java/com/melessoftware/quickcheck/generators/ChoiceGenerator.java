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
