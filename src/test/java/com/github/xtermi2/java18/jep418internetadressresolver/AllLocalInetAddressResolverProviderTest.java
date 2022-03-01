package com.github.xtermi2.java18.jep418internetadressresolver;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.assertj.core.api.Assertions.assertThat;

class AllLocalInetAddressResolverProviderTest {
    @Test
    void resolve_IP() throws UnknownHostException {
        final InetAddress byName = InetAddress.getByName("github.com");

        assertThat(byName.getAddress())
                .isEqualTo(new byte[]{(byte) 127, 0, 0, 1});
    }
}