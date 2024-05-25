package com.ahesh.vault.config;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.ExtensionList;
import hudson.model.Item;
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

    @Extension(ordinal = 0)
    public static class ForJob extends MyConfigResolver {
        @NonNull
        @Override
        public MyConfig forJob(@NonNull Item item) {
            return MyConfigGlobal.get().getConfig();
        }
    }
}
