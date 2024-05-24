package com.ahesh.vault.config;

import hudson.model.AbstractDescribableImpl;
import java.io.Serializable;
import org.jenkinsci.plugins.plaincredentials.StringCredentials;
import org.kohsuke.stapler.DataBoundConstructor;

public class MyConfig extends AbstractDescribableImpl<MyConfig> implements Serializable {

    private String name;
    private StringCredentials password;

    @DataBoundConstructor
    public MyConfig(){}

    public MyConfig(MyConfig config) {
        this.name = config.name;
        this.password = config.password;
    }

}
