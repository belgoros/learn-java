package com.sca.config;

import org.aeonbits.owner.ConfigFactory;

/**
 * Created by Serguei on 13/09/2017.
 */
public class CheckOwnerConfig {

    public static void main(String[] args) {
        OwnerConfig cfg = ConfigFactory.create(OwnerConfig.class, System.getenv());
        System.out.println("ENV_PHRASE_AUTHTOKEN: " + cfg.authToken());
        System.out.println("ENV_PHRASE_PROJECTID: " + cfg.projectId());
        System.out.println("ENV_PHRASE_LOCALEID_EN: " + cfg.localeId());

    }
}
