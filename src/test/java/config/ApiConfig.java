package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/test/resources/config/creds.config"
})
public interface ApiConfig extends  Config{

    @Config.Key("base.url")
    String getBaseUrl();

    @Config.Key("token")
    String getToken();
}
