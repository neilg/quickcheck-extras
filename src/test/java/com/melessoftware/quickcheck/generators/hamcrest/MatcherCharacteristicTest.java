package com.melessoftware.quickcheck.generators.hamcrest;

import static net.java.quickcheck.generator.PrimitiveGenerators.objects;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
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
        when(alwaysFail.matches(any())).thenReturn(false);

        alwaysPass = mock(Matcher.class);
        when(alwaysPass.matches(any())).thenReturn(true);
    }

    @Test
    public void forAllShouldFailIfMatchFails() {
        expectedException.expect(CharacteristicException.class);
        MatcherCharacteristic.forAll(objects(), alwaysFail);
    }

    @Test
    public void shouldPassIfMatchPasses() {
        MatcherCharacteristic.forAll(objects(), alwaysPass);
    }

    @Test
    public void forAllShouldMakeSpecifiedNumberOfRuns() {
        int runs = 13543;
        MatcherCharacteristic.forAll(runs, objects(), alwaysPass);
        verify(alwaysPass, times(runs)).matches(any());
        verifyNoMoreInteractions(alwaysPass);
    }

}
