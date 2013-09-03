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

import static com.melessoftware.quickcheck.generators.Generators.chooseFrom;
import static net.java.quickcheck.QuickCheck.forAll;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.junit.Assert.assertThat;

import net.java.quickcheck.characteristic.AbstractCharacteristic;
import org.junit.Test;

public class GeneratorsTest {

    private static final int ITERATIONS = 100000;

    @Test
    public void choiceShouldBeAProvidedValue() {
        final int numObjects = 1000;
        final Object[] objects = new Object[numObjects];
        for (int i = 0; i < numObjects; i++) {
            objects[i] = new Object();
        }
        forAll(ITERATIONS, chooseFrom(objects), new AbstractCharacteristic<Object>() {
            @Override
            protected void doSpecify(Object object) {
                assertThat(objects, hasItemInArray(object));
            }
        });
    }
}
