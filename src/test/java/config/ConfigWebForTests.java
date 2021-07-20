package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/test/resources/config/${conf}.config"
})
public interface ConfigWebForTests extends Config {

    @Key("browser.name")
    String getBrowserName();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("browser.remote.run")
    Boolean isRemote();

}
