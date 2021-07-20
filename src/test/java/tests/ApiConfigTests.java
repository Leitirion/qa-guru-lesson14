package tests;

import config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

class ApiConfigTests {

    private ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

    @Test
    @DisabledIfSystemProperty(named = "base.url", matches = "localhost")
    @DisabledIfSystemProperty(named = "token", matches = "token23")
    @DisabledIfSystemProperty(named = "conf", matches = "*")
    void getTokenFromFile() {
        final String token = "1293u2983u198u3";

        Assertions.assertEquals("production", apiConfig.getBaseUrl());
        Assertions.assertEquals(token, apiConfig.getToken());
    }

    @Test
    @EnabledIfSystemProperty(named = "base.url", matches = "localhost")
    @EnabledIfSystemProperty(named = "token", matches = "token23")
    @DisabledIfSystemProperty(named = "conf", matches = "*")
    void getTokenFromSystemProperties() {
        final String expectedToken = "token23",
                baseUrl = "localhost";

        Assertions.assertEquals(expectedToken, apiConfig.getToken());
        Assertions.assertEquals(baseUrl, apiConfig.getBaseUrl());
    }
}
