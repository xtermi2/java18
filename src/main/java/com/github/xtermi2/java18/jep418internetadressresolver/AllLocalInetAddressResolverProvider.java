package com.github.xtermi2.java18.jep418internetadressresolver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.spi.InetAddressResolver;
import java.net.spi.InetAddressResolverProvider;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * this impl is loaded via service loader: java.net.spi.InetAddressResolverProvider
 */
public class AllLocalInetAddressResolverProvider extends InetAddressResolverProvider {

    @Override
    public InetAddressResolver get(Configuration configuration) {
        return new InetAddressResolver() {

            @Override
            public Stream<InetAddress> lookupByName(String host, LookupPolicy lookupPolicy) throws UnknownHostException {
                System.out.println("MyInetAddressResolverProvider - lookupByName " + host + " with policy " + lookupPolicy);
                return Stream.of(InetAddress.getLoopbackAddress());
            }

            @Override
            public String lookupByAddress(byte[] addr) throws UnknownHostException {
                System.out.println("MyInetAddressResolverProvider - lookupByAddress " + Arrays.toString(addr));
                return "localhost";
            }
        };
    }

    @Override
    public String name() {
        return "MyInetAddressResolverProvider";
    }
}
