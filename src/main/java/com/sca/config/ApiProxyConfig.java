package com.sca.config;

import org.aeonbits.owner.Config;

/**
 * Created by Serguei on 13/02/2018.
 */
public interface ApiProxyConfig extends Config {

    String authUrl();
    String clientId();
    String clientSecret();
    String username();
    String password();
    String apiKey();
    String apiUrl();

}
