package com.ahesh.vault.config;

import hudson.Extension;
import hudson.ExtensionList;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.StaplerRequest;

@Extension
public class MyConfigGlobal extends GlobalConfiguration {
    private MyConfig config;

    public static MyConfigGlobal get() {
        return ExtensionList.lookupSingleton(MyConfigGlobal.class);
    }

    public MyConfigGlobal() {
        load();
    }

    public MyConfig getConfig() {
        return config;
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
        req.bindJSON(this, json);
        return true;
    }

    @DataBoundSetter
    public void setConfig(MyConfig config) {
        this.config = config;
        save();
    }
}
