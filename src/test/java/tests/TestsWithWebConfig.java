package tests;

import config.ConfigWebForTests;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

class TestsWithWebConfig {

    private ConfigWebForTests configWebForTests = ConfigFactory.create(ConfigWebForTests.class, System.getProperties());

    @Test
    @DisabledIfSystemProperty(named = "conf", matches = "remote")
    void testWithLocalConfigFile() {
        Assertions.assertEquals("chrome", configWebForTests.getBrowserName());
        Assertions.assertEquals( "91.0" , configWebForTests.getBrowserVersion());
        Assertions.assertEquals(false, configWebForTests.isRemote());
    }


    @Test
    @DisabledIfSystemProperty(named = "conf", matches = "local")
    void testWithRemoteConfigFile() {
        Assertions.assertEquals("firefox", configWebForTests.getBrowserName());
        Assertions.assertEquals( "87.0" , configWebForTests.getBrowserVersion());
        Assertions.assertEquals(true, configWebForTests.isRemote());
    }
}
