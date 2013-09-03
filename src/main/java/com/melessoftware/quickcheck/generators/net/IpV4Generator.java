package com.melessoftware.quickcheck.generators.net;

import static net.java.quickcheck.generator.PrimitiveGenerators.bytes;

import java.net.InetAddress;
import java.net.UnknownHostException;

import net.java.quickcheck.Generator;

public class IpV4Generator implements Generator<InetAddress> {

    private final Generator<Byte> bytes1;
    private final Generator<Byte> bytes2;
    private final Generator<Byte> bytes3;
    private final Generator<Byte> bytes4;

    public IpV4Generator() {
        this(bytes());
    }

    public IpV4Generator(Generator<Byte> byteGenerator) {
        this(byteGenerator, byteGenerator, byteGenerator, byteGenerator);
    }

    public IpV4Generator(Generator<Byte> bytes1, Generator<Byte> bytes2, Generator<Byte> bytes3, Generator<Byte> bytes4) {
        this.bytes1 = bytes1;
        this.bytes2 = bytes2;
        this.bytes3 = bytes3;
        this.bytes4 = bytes4;
    }

    @Override
    public InetAddress next() {
        final byte[] bytes = {
                bytes1.next(),
                bytes2.next(),
                bytes3.next(),
                bytes4.next()
        };
        try {
            return InetAddress.getByAddress(bytes);
        } catch (UnknownHostException e) {
            throw new RuntimeException("unexpected exception", e);
        }
    }
}
