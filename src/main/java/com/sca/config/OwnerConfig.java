package com.sca.config;

import org.aeonbits.owner.Config;

/**
 * Created by Serguei on 13/09/2017.
 */
interface OwnerConfig extends Config {

    @DefaultValue("${ENV_PHRASE_AUTHTOKEN}")
    String authToken();

    @DefaultValue("${ENV_PHRASE_PROJECTID}")
    String projectId();

    @DefaultValue("${ENV_PHRASE_LOCALEID_EN}")
    String localeId();
}
