package com.jcd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system")
public class SystemFactoryController {

    private final FactoryIdentity factoryIdentity;

    public SystemFactoryController(
            @Value("${factory.code}") String factoryCode,
            @Value("${factory.database-name}") String databaseName,
            @Value("${factory.pda-host}") String pdaHost,
            @Value("${factory.pda-port}") int pdaPort,
            @Value("${factory.wcf-host}") String wcfHost,
            @Value("${wcf.material-ser.url}") String wcfMaterialSerUrl) {
        this.factoryIdentity = new FactoryIdentity(
                factoryCode,
                databaseName,
                pdaHost,
                pdaPort,
                wcfHost,
                wcfMaterialSerUrl);
    }

    @GetMapping("/factory")
    public FactoryIdentity getFactoryIdentity() {
        return factoryIdentity;
    }

    public static final class FactoryIdentity {
        private final String factoryCode;
        private final String databaseName;
        private final String pdaHost;
        private final int pdaPort;
        private final String pdaBaseUrl;
        private final String wcfHost;
        private final String wcfMaterialSerUrl;

        FactoryIdentity(
                String factoryCode,
                String databaseName,
                String pdaHost,
                int pdaPort,
                String wcfHost,
                String wcfMaterialSerUrl) {
            this.factoryCode = factoryCode;
            this.databaseName = databaseName;
            this.pdaHost = pdaHost;
            this.pdaPort = pdaPort;
            this.pdaBaseUrl = "http://" + pdaHost + ":" + pdaPort;
            this.wcfHost = wcfHost;
            this.wcfMaterialSerUrl = wcfMaterialSerUrl;
        }

        public String getFactoryCode() {
            return factoryCode;
        }

        public String getDatabaseName() {
            return databaseName;
        }

        public String getPdaHost() {
            return pdaHost;
        }

        public int getPdaPort() {
            return pdaPort;
        }

        public String getPdaBaseUrl() {
            return pdaBaseUrl;
        }

        public String getWcfHost() {
            return wcfHost;
        }

        public String getWcfMaterialSerUrl() {
            return wcfMaterialSerUrl;
        }
    }
}
