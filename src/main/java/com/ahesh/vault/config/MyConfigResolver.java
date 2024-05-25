package com.ahesh.vault.config;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import hudson.ExtensionPoint;
import hudson.model.Descriptor;
import hudson.model.Item;

public abstract class MyConfigResolver implements ExtensionPoint {
    @NonNull
    public abstract MyConfig forJob(@NonNull Item item);

}
