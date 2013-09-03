package com.melessoftware.quickcheck.generators.net;

import static junit.framework.Assert.assertNotNull;
import static net.java.quickcheck.QuickCheck.forAll;

import java.net.InetAddress;

import net.java.quickcheck.characteristic.AbstractCharacteristic;
import org.junit.Before;
import org.junit.Test;

public class IpV4GeneratorTest {

    private static final int ITERATIONS = 1000000;

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
        forAll(ITERATIONS, generatorUnderTest, new AbstractCharacteristic<InetAddress>() {
            @Override
            protected void doSpecify(InetAddress any) throws Throwable {
                assertNotNull(any);
            }
        });
    }

}
