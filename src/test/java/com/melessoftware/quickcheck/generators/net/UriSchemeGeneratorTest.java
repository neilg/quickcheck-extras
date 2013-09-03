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

import static junit.framework.Assert.assertNotNull;
import static net.java.quickcheck.QuickCheck.forAll;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import net.java.quickcheck.characteristic.AbstractCharacteristic;
import org.junit.Before;
import org.junit.Test;

public class UriSchemeGeneratorTest {

    private static final int ITERATIONS = 100000;

    private UriSchemeGenerator generatorUnderTest;

    @Before
    public void setup() {
        generatorUnderTest = new UriSchemeGenerator();
    }

    @Test
    public void shouldNotReturnNull() {
        forAll(ITERATIONS, generatorUnderTest, new AbstractCharacteristic<String>() {
            @Override
            protected void doSpecify(String any) {
                assertNotNull(any);
            }
        });
    }

    @Test
    public void shouldHaveNonZeroLength() {
        forAll(ITERATIONS, generatorUnderTest, new AbstractCharacteristic<String>() {
            @Override
            protected void doSpecify(String scheme) {
                assertThat(scheme.length(), greaterThan(0));
            }
        });
    }

    @Test
    public void shouldStartWithAlpha() {
        forAll(ITERATIONS, generatorUnderTest, new AbstractCharacteristic<String>() {
            @Override
            protected void doSpecify(String scheme) {

            }
        });
    }
}
