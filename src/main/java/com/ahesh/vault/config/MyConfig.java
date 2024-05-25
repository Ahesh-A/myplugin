package com.ahesh.vault.config;

import static hudson.Util.fixEmptyAndTrim;

import com.cloudbees.plugins.credentials.common.StandardListBoxModel;
import com.cloudbees.plugins.credentials.domains.DomainRequirement;
import com.cloudbees.plugins.credentials.domains.URIRequirementBuilder;
import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import java.io.Serializable;
import hudson.model.Item;
import hudson.security.ACL;
import hudson.util.ListBoxModel;
import jenkins.model.Jenkins;
import org.jenkinsci.plugins.plaincredentials.StringCredentials;
import org.kohsuke.stapler.AncestorInPath;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.QueryParameter;
import java.util.List;

public class MyConfig extends AbstractDescribableImpl<MyConfig> implements Serializable {

    private String name;
    private StringCredentials password;
    private String passwordId;

    @DataBoundConstructor
    public MyConfig() {}

    public MyConfig(MyConfig config) {
        this.name = config.name;
        this.passwordId = config.passwordId;
    }
    public StringCredentials getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getPasswordId(){
        return passwordId;
    }
    @DataBoundSetter
    public void setName(String name) {
        this.name = fixEmptyAndTrim(name);
    }
    @DataBoundSetter
    public void setPassword(StringCredentials password) {
        this.password = password;
    }
    @DataBoundSetter
    public void setPasswordId(String passwordId) {
        this.passwordId = passwordId;
    }


    @Extension
    public static class DescriptorImpl extends Descriptor<MyConfig> {

        @Override
        @NonNull
        public String getDisplayName() {
            return "My Config";
        }

        public ListBoxModel doFillPasswordIdItems(@AncestorInPath Item item, @QueryParameter String uri) {
            Jenkins.get().checkPermission(Jenkins.ADMINISTER);
            List<DomainRequirement> domainRequirements = URIRequirementBuilder.fromUri(uri).build();
            return new StandardListBoxModel().includeEmptyValue().includeAs(ACL.SYSTEM2, item, StringCredentials.class, domainRequirements);
        }
    }
}
