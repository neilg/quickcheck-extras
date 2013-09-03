package com.melessoftware.quickcheck.generators.net;

import static junit.framework.Assert.assertNotNull;
import static net.java.quickcheck.QuickCheck.forAll;

import java.net.URI;

import net.java.quickcheck.characteristic.AbstractCharacteristic;
import org.junit.Before;
import org.junit.Test;

public class OpaqueUriGeneratorTest {

    private static final int ITERATIONS = 100000;

    private OpaqueUriGenerator generatorUnderTest;

    @Before
    public void setup() {
        generatorUnderTest = new OpaqueUriGenerator();
    }

    @Test
    public void shouldNotReturnNull() {
        forAll(ITERATIONS, generatorUnderTest, new AbstractCharacteristic<URI>() {
            @Override
            protected void doSpecify(URI any) throws Throwable {
                assertNotNull(any);
            }
        });
    }
}
