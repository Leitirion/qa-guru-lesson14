package tests;

import config.ConfigApiForTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

class TestsWithApiConfig {

    private ConfigApiForTests configApiForTests = ConfigFactory.create(ConfigApiForTests.class, System.getProperties());

    @Test
    @DisabledIfSystemProperty(named = "url", matches = "localhost")
    @DisabledIfSystemProperty(named = "token", matches = "token2")
    @DisabledIfSystemProperty(named = "conf", matches = "*")
    void getTokenFromFile() {
        final String token = "1293u2983u198u3";

        Assertions.assertEquals("https://google.com", configApiForTests.getUrl());
        Assertions.assertEquals(token, configApiForTests.getToken());
    }

    @Test
    @EnabledIfSystemProperty(named = "url", matches = "localhost")
    @EnabledIfSystemProperty(named = "token", matches = "token2")
    @DisabledIfSystemProperty(named = "conf", matches = "*")
    void getTokenFromSystemProperties() {
        final String expectedToken = "token2",
                Url = "localhost";

        Assertions.assertEquals(expectedToken, configApiForTests.getToken());
        Assertions.assertEquals(Url, configApiForTests.getUrl());
    }
}
