package com.ahesh.vault.config;

import static hudson.Util.fixEmptyAndTrim;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import java.io.Serializable;
import org.jenkinsci.plugins.plaincredentials.StringCredentials;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

public class MyConfig extends AbstractDescribableImpl<MyConfig> implements Serializable {

    private String name;
    private StringCredentials password;

    @DataBoundConstructor
    public MyConfig() {}

    public MyConfig(MyConfig config) {
        this.name = config.name;
        this.password = config.password;
    }

    public String getName() {
        return name;
    }

    @DataBoundSetter
    public void setName(String name) {
        this.name = fixEmptyAndTrim(name);
    }

    public StringCredentials getPassword() {
        return password;
    }

    @DataBoundSetter
    public void setPassword(StringCredentials password) {
        this.password = password;
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<MyConfig> {

        @Override
        @NonNull
        public String getDisplayName() {
            return "My Config";
        }
    }
}
