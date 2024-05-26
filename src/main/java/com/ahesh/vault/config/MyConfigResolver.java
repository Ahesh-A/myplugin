package com.ahesh.vault.config;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.ExtensionPoint;
import hudson.model.Item;

public abstract class MyConfigResolver implements ExtensionPoint {
    @NonNull
    public abstract MyConfig forJob(@NonNull Item item);
}
