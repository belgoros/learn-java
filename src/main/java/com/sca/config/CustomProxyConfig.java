package com.sca.config;

import org.aeonbits.owner.Config;

/**
 * Created by Serguei on 13/02/2018.
 * Properties are read from the below files top-to-bottom
 * The corresponding environment variables with the same name as those between
 * braces should be declared on the server-side
 *
 */
@Config.Sources({
        "file:${STORES_CONFIG_PATH}StoresConfig.properties",
        "classpath:StoresConfig.${APPL_ENV}.${SODA_ZONE_ID}.properties",
        "classpath:StoresConfig.${APPL_ENV}.properties",
        "classpath:StoresConfig.default.properties"
})
public interface CustomProxyConfig extends ApiProxyConfig {
}
