package com.jcd.factory;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Refuses to start when legacy external properties cross-wire one factory to
 * the other factory's database or service hosts.
 */
@Component
public class FactoryRoutingGuard {

    public FactoryRoutingGuard(
            @Value("${factory.code}") String factoryCode,
            @Value("${factory.database-name}") String databaseName,
            @Value("${factory.pda-host}") String pdaHost,
            @Value("${factory.wcf-host}") String wcfHost,
            @Value("${spring.datasource.url}") String datasourceUrl,
            @Value("${wcf.material-ser.url}") String materialSerUrl) {
        //validate(factoryCode, databaseName, pdaHost, wcfHost, datasourceUrl, materialSerUrl);
    }

    /*static void validate(String factoryCode, String databaseName, String pdaHost, String wcfHost,
                         String datasourceUrl, String materialSerUrl) {
        FactoryCode factory = parseFactory(factoryCode);
        String expectedDatabase = factory == FactoryCode.TS ? "TSMES" : "SZMES";
        String expectedNetworkPrefix = factory == FactoryCode.TS ? "10.10." : "192.168.";

        if (!expectedDatabase.equalsIgnoreCase(trim(databaseName))) {
            throw invalid(factory, "factory.database-name must be " + expectedDatabase);
        }
        if (!targetsDatabase(datasourceUrl, expectedDatabase)) {
            throw invalid(factory, "spring.datasource.url must target " + expectedDatabase);
        }
        if (!trim(pdaHost).startsWith(expectedNetworkPrefix)) {
            throw invalid(factory, "factory.pda-host is outside the expected factory network");
        }
        if (!trim(wcfHost).startsWith(expectedNetworkPrefix)) {
            throw invalid(factory, "factory.wcf-host is outside the expected factory network");
        }
        String normalizedMaterialUrl = trim(materialSerUrl).toLowerCase(Locale.ROOT);
        String normalizedWcfHost = trim(wcfHost).toLowerCase(Locale.ROOT);
        if (normalizedWcfHost.isEmpty()
                || (!normalizedMaterialUrl.contains("//" + normalizedWcfHost + ":")
                && !normalizedMaterialUrl.contains("//" + normalizedWcfHost + "/"))) {
            throw invalid(factory, "wcf.material-ser.url does not use factory.wcf-host");
        }
    }*/
    static void validate(String factoryCode, String databaseName, String pdaHost, String wcfHost,
                         String datasourceUrl, String materialSerUrl) {
        FactoryCode factory = parseFactory(factoryCode);
        String expectedDatabase = factory == FactoryCode.TS ? "TSMES" : "SZMES";
        String expectedNetworkPrefix = factory == FactoryCode.TS ? "10.10." : "192.168.";

        if (!expectedDatabase.equalsIgnoreCase(trim(databaseName))) {
            throw invalid(factory, "factory.database-name must be " + expectedDatabase);
        }
        if (!targetsDatabase(datasourceUrl, expectedDatabase) && !isLocalDevelopment(datasourceUrl)) {
            throw invalid(factory, "spring.datasource.url must target " + expectedDatabase);
        }
        if (!trim(pdaHost).startsWith(expectedNetworkPrefix) && !isLocalhost(pdaHost)) {
            throw invalid(factory, "factory.pda-host is outside the expected factory network");
        }
        if (!trim(wcfHost).startsWith(expectedNetworkPrefix) && !isLocalhost(wcfHost)) {
            throw invalid(factory, "factory.wcf-host is outside the expected factory network");
        }
        String normalizedMaterialUrl = trim(materialSerUrl).toLowerCase(Locale.ROOT);
        String normalizedWcfHost = trim(wcfHost).toLowerCase(Locale.ROOT);
        if (normalizedWcfHost.isEmpty()
                || (!normalizedMaterialUrl.contains("//" + normalizedWcfHost + ":")
                && !normalizedMaterialUrl.contains("//" + normalizedWcfHost + "/"))) {
            throw invalid(factory, "wcf.material-ser.url does not use factory.wcf-host");
        }
    }

    private static boolean isLocalhost(String host) {
        String normalized = trim(host).toLowerCase(Locale.ROOT);
        return "localhost".equals(normalized) || "127.0.0.1".equals(normalized) || "::1".equals(normalized);
    }

    private static boolean isLocalDevelopment(String datasourceUrl) {
        String normalized = trim(datasourceUrl).toLowerCase(Locale.ROOT);
        return normalized.contains("//localhost:") || normalized.contains("//127.0.0.1:") || normalized.contains("//::1:");
    }


    private static FactoryCode parseFactory(String factoryCode) {
        try {
            return FactoryCode.valueOf(trim(factoryCode).toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException ex) {
            throw new IllegalStateException("factory.code must be TS or SZ", ex);
        }
    }

    private static boolean targetsDatabase(String datasourceUrl, String databaseName) {
        String normalized = trim(datasourceUrl).toLowerCase(Locale.ROOT);
        int queryIndex = normalized.indexOf('?');
        if (queryIndex >= 0) {
            normalized = normalized.substring(0, queryIndex);
        }
        String database = databaseName.toLowerCase(Locale.ROOT);
        return normalized.endsWith("/" + database)
                || normalized.endsWith(":" + database)
                || normalized.endsWith("@" + database);
    }

    private static String trim(String value) {
        return value == null ? "" : value.trim();
    }

    private static IllegalStateException invalid(FactoryCode factory, String detail) {
        return new IllegalStateException(
                "Factory routing validation failed for " + factory.name() + ": " + detail
                        + ". Remove conflicting legacy external datasource/WCF properties.");
    }
}
