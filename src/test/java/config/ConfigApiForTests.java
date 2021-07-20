package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/test/resources/config/creds.config"
})
public interface ConfigApiForTests extends  Config{

    @Config.Key("url")
    String getUrl();

    @Config.Key("token")
    String getToken();
}
