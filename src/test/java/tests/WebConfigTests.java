package tests;

import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;

class WebConfigTests {

    private WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    @Test
    @DisabledIfSystemProperty(named = "conf", matches = "remote")
    void runWithLocalConfigFile() {
        Assertions.assertEquals("chrome", webConfig.getBrowserName());
        Assertions.assertEquals( "91.0" ,webConfig.getBrowserVersion());
        Assertions.assertEquals(false, webConfig.isRemote());
    }


    @Test
    @DisabledIfSystemProperty(named = "conf", matches = "local")
    void runWithRemoteConfigFile() {
        Assertions.assertEquals("firefox", webConfig.getBrowserName());
        Assertions.assertEquals( "87.0" ,webConfig.getBrowserVersion());
        Assertions.assertEquals(true, webConfig.isRemote());
    }
}
