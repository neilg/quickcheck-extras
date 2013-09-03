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

import static org.hamcrest.MatcherAssert.assertThat;

import net.java.quickcheck.Generator;
import net.java.quickcheck.QuickCheck;
import net.java.quickcheck.characteristic.AbstractCharacteristic;
import org.hamcrest.Matcher;

public class MatcherCharacteristic<T> extends AbstractCharacteristic<T> {

    private final Matcher<? super T> matcher;

    public MatcherCharacteristic(Matcher<? super T> matcher) {
        this.matcher = matcher;
    }

    @Override
    protected void doSpecify(T any) {
        assertThat(any, matcher);
    }

    public static <T> void forAll(Generator<T> generator, Matcher<? super T> matcher) {
        QuickCheck.forAll(generator, new MatcherCharacteristic<T>(matcher));
    }

    public static <T> void forAll(int runs, Generator<T> generator, Matcher<? super T> matcher) {
        QuickCheck.forAll(runs, generator, new MatcherCharacteristic<T>(matcher));
    }
}
