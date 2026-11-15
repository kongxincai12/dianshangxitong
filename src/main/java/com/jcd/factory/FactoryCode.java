package com.jcd.factory;

public enum FactoryCode {
    TS("ts"),
    SZ("sz");

    private final String profileName;

    FactoryCode(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
