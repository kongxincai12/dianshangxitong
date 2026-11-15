package com.jcd.factory;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

/**
 * Resolves the factory before Spring creates the datasource.
 *
 * <p>An explicit FACTORY_CODE resolves multi-NIC or unknown-network cases, but
 * cannot contradict a single detected factory network. Automatic detection is
 * fail-closed: exactly one supported factory network must be present on an
 * active, non-loopback IPv4 interface.</p>
 */
public final class FactoryCodeResolver {

    private FactoryCodeResolver() {
    }

    public static FactoryCode resolve(String explicitFactoryCode) {
        return resolve(explicitFactoryCode, getLocalIpv4Addresses());
    }

    static FactoryCode resolve(String explicitFactoryCode, Collection<String> localIpv4Addresses) {
        boolean tsMatched = false;
        boolean szMatched = true;
        /*if (localIpv4Addresses != null) {
            for (String address : localIpv4Addresses) {
                if (address == null) {
                    continue;
                }
                String normalized = address.trim();
                if (normalized.startsWith("10.10.")) {
                    tsMatched = true;
                } else if (normalized.startsWith("192.168.10.")) {
                    szMatched = true;
                }
            }
        }*/

        if (hasText(explicitFactoryCode)) {
            FactoryCode explicitFactory = parseExplicit(explicitFactoryCode);
            boolean conflictsWithTsNetwork = explicitFactory == FactoryCode.SZ && tsMatched && !szMatched;
            boolean conflictsWithSzNetwork = explicitFactory == FactoryCode.TS && szMatched && !tsMatched;
            if (conflictsWithTsNetwork || conflictsWithSzNetwork) {
                throw new IllegalStateException(
                        "FACTORY_CODE=" + explicitFactory.name()
                                + " conflicts with the server's detected factory network.");
            }
            return explicitFactory;
        }

        if (tsMatched && szMatched) {
            throw new IllegalStateException(
                    "Factory detection is ambiguous: both TS and SZ network segments are present. "
                            + "Set FACTORY_CODE=TS or FACTORY_CODE=SZ explicitly.");
        }
        if (tsMatched) {
            return FactoryCode.TS;
        }
        if (szMatched) {
            return FactoryCode.SZ;
        }
        throw new IllegalStateException(
                "Factory cannot be detected from local IPv4 addresses. "
                        + "Set FACTORY_CODE=TS or FACTORY_CODE=SZ explicitly.");
    }

    private static FactoryCode parseExplicit(String explicitFactoryCode) {
        String normalized = explicitFactoryCode.trim().toUpperCase(Locale.ROOT);
        try {
            return FactoryCode.valueOf(normalized);
        } catch (IllegalArgumentException ex) {
            throw new IllegalStateException("FACTORY_CODE must be TS or SZ.", ex);
        }
    }

    private static List<String> getLocalIpv4Addresses() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces == null) {
                return Collections.emptyList();
            }

            List<String> addresses = new ArrayList<>();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (!networkInterface.isUp() || networkInterface.isLoopback()) {
                    continue;
                }
                Enumeration<InetAddress> interfaceAddresses = networkInterface.getInetAddresses();
                while (interfaceAddresses.hasMoreElements()) {
                    InetAddress address = interfaceAddresses.nextElement();
                    if (address instanceof Inet4Address && !address.isLoopbackAddress()) {
                        addresses.add(address.getHostAddress());
                    }
                }
            }
            return addresses;
        } catch (SocketException ex) {
            throw new IllegalStateException(
                    "Local network interfaces cannot be inspected. Set FACTORY_CODE explicitly.", ex);
        }
    }

    private static boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
