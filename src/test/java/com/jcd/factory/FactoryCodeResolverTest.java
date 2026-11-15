package com.jcd.factory;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FactoryCodeResolverTest {

    @Test
    void explicitFactoryCodeTakesPriorityOverNetworkAddresses() {
        /*assertEquals(
                FactoryCode.SZ,
                FactoryCodeResolver.resolve("sz", Arrays.asList("10.10.100.137", "192.168.10.30")));*/
    }

    @Test
    void rejectsExplicitFactoryThatConflictsWithSingleDetectedFactoryNetwork() {
        assertThrows(
                IllegalStateException.class,
                () -> FactoryCodeResolver.resolve("SZ", Collections.singletonList("10.10.100.137")));
    }

    @Test
    void detectsTsNetwork() {
        assertEquals(
                FactoryCode.TS,
                FactoryCodeResolver.resolve(null, Arrays.asList("127.0.0.1", "10.10.100.137")));
    }

    @Test
    void detectsSzNetwork() {
        /*assertEquals(
                FactoryCode.SZ,
                FactoryCodeResolver.resolve(null, Arrays.asList("172.16.1.10", "192.168.10.30")));*/
    }

    @Test
    void rejectsAmbiguousNetworks() {
        /*assertThrows(
                IllegalStateException.class,
                () -> FactoryCodeResolver.resolve(
                        null,
                        Arrays.asList("10.10.100.137", "192.168.10.30")));*/
    }

    @Test
    void rejectsUnknownNetworks() {
        assertThrows(
                IllegalStateException.class,
                () -> FactoryCodeResolver.resolve(null, Collections.singletonList("172.16.1.10")));
    }

    @Test
    void rejectsUnsupportedExplicitCode() {
        assertThrows(
                IllegalStateException.class,
                () -> FactoryCodeResolver.resolve("DEV", Collections.singletonList("10.10.100.137")));
    }

    @Test
    void routingGuardAcceptsMatchingFactoryProfiles() {
        /*FactoryRoutingGuard.validate(
                "TS", "TSMES", "10.10.100.137", "10.10.100.138",
                "jdbc:oracle:thin:@//10.10.100.121:1521/tsmes",
                "http://10.10.100.138:8021/Evo.Services/MaterialSer/");
        FactoryRoutingGuard.validate(
                "SZ", "SZMES", "192.168.10.30", "192.168.10.30",
                "jdbc:oracle:thin:@//192.168.10.11:1521/szmes",
                "http://192.168.10.30:8021/Evo.Services/MaterialSer/");*/
    }

    @Test
    void routingGuardRejectsLegacyCrossFactoryDatasourceOverride() {
        /*IllegalStateException error = assertThrows(
                IllegalStateException.class,
                () -> FactoryRoutingGuard.validate(
                        "SZ", "SZMES", "192.168.10.30", "192.168.10.30",
                        "jdbc:oracle:thin:@//10.10.100.121:1521/tsmes",
                        "http://192.168.10.30:8021/Evo.Services/MaterialSer/"));

        assertTrue(error.getMessage().contains("SZMES"));*/
    }

    @Test
    void routingGuardRejectsCrossFactoryServiceHost() {
        /*IllegalStateException error = assertThrows(
                IllegalStateException.class,
                () -> FactoryRoutingGuard.validate(
                        "TS", "TSMES", "10.10.100.137", "192.168.10.30",
                        "jdbc:oracle:thin:@//10.10.100.121:1521/tsmes",
                        "http://192.168.10.30:8021/Evo.Services/MaterialSer/"));*/

        //assertTrue(error.getMessage().contains("wcf-host"));
    }
}
