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

import net.java.quickcheck.Characteristic;
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

    public static <T> Characteristic<T> they(Matcher<? super T> matcher) {
        return new MatcherCharacteristic<T>(matcher);
    }

    public static <T> Characteristic<T> characteristic(Matcher<? super T> matcher) {
        return new MatcherCharacteristic<T>(matcher);
    }

}
