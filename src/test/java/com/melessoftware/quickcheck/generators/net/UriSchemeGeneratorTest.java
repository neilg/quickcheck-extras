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
