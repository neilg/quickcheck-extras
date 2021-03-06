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

import static com.melessoftware.quickcheck.Extras.are;
import static com.melessoftware.quickcheck.characteristics.MatcherCharacteristic.they;
import static net.java.quickcheck.QuickCheck.forAll;
import static org.hamcrest.Matchers.notNullValue;

import java.net.InetAddress;

import org.junit.Before;
import org.junit.Test;

public class IpV4GeneratorTest {

    private static final int ITERATIONS = 100000;

    private IpV4Generator generatorUnderTest;

    @Before
    public void setup() {
        generatorUnderTest = new IpV4Generator();
    }

    @Test
    public void shouldNotThrowExceptions() {
        for (int i = 0; i < ITERATIONS; i++) {
            generatorUnderTest.next();
        }
    }

    @Test
    public void shouldNotReturnNull() {
        forAll(ITERATIONS, generatorUnderTest, they(are(notNullValue(InetAddress.class))));
    }

}
