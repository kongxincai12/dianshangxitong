package com.jcd.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Activates the factory profile before Spring Boot loads profile-specific
 * configuration and creates the datasource.
 */
public class FactoryEnvironmentPostProcessor  implements EnvironmentPostProcessor{
//implements EnvironmentPostProcessor, Ordered
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.setProperty("FACTORY_CODE", "SZ");
        FactoryCode factoryCode = FactoryCodeResolver.resolve(environment.getProperty("FACTORY_CODE"));
        //assertNoConflictingFactoryProfile(environment, factoryCode);
        //environment.addActiveProfile(factoryCode.getProfileName());
    }

    private void assertNoConflictingFactoryProfile(ConfigurableEnvironment environment, FactoryCode factoryCode) {
        for (String activeProfile : environment.getActiveProfiles()) {
            if (("ts".equalsIgnoreCase(activeProfile) || "sz".equalsIgnoreCase(activeProfile))
                    && !factoryCode.getProfileName().equalsIgnoreCase(activeProfile)) {
                throw new IllegalStateException(
                        "Detected factory conflicts with the active factory profile. "
                                + "Use only FACTORY_CODE=TS or FACTORY_CODE=SZ to select a factory.");
            }
        }
    }

    //@Override
    //public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

    //}

    //@Override
    //public int getOrder() {
    //    return Ordered.HIGHEST_PRECEDENCE;
    //}
}
