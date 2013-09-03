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

package com.melessoftware.quickcheck.characteristics;

import static com.melessoftware.quickcheck.characteristics.MatcherCharacteristic.characteristic;
import static com.melessoftware.quickcheck.characteristics.MatcherCharacteristic.they;
import static net.java.quickcheck.QuickCheck.forAll;
import static net.java.quickcheck.generator.PrimitiveGenerators.objects;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import net.java.quickcheck.CharacteristicException;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MatcherCharacteristicTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Matcher<Object> alwaysFail;
    private Matcher<Object> alwaysPass;

    @Before
    public void setup() {
        alwaysFail = mock(Matcher.class);
        alwaysPass = mock(Matcher.class);

        when(alwaysFail.matches(any())).thenReturn(false);
        when(alwaysPass.matches(any())).thenReturn(true);
    }

    @Test
    public void forAllShouldFailIfMatchFailsWithThey() {
        expectedException.expect(CharacteristicException.class);
        forAll(objects(), they(alwaysFail));
    }

    @Test
    public void shouldPassIfMatchPassesWithThey() {
        forAll(objects(), they(alwaysPass));
    }

    @Test
    public void forAllShouldFailIfMatchFailsWithCharacteristic() {
        expectedException.expect(CharacteristicException.class);
        forAll(objects(), characteristic(alwaysFail));
    }

    @Test
    public void shouldPassIfMatchPassesWithCharacteristic() {
        forAll(objects(), characteristic(alwaysPass));
    }

}
