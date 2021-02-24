package com.policyexpert.automation.core.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigResolver {

    private static final String BUILD_CONF = "conf/defaults";

    private static final Config CONFIG = ConfigFactory.load(BUILD_CONF);

    private ConfigResolver() {

    }

    public static Config getConfig() {
        return CONFIG;
    }
}
