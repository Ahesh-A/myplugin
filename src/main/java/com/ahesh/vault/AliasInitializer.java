package com.ahesh.vault;

import hudson.init.InitMilestone;
import hudson.init.Initializer;
import hudson.model.Items;

public class AliasInitializer {

    @Initializer(before = InitMilestone.PLUGINS_STARTED)
    @SuppressWarnings("unused")
    public static void addAliases() {
        Items.XSTREAM2.alias("ZvInjectBuildWrapper", ZvInjectBuildWrapper.class);
    }
}
