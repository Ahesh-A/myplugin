package com.ahesh.vault.config;

import hudson.model.AbstractDescribableImpl;
import java.io.Serializable;

public class MyConfig extends AbstractDescribableImpl<MyConfig> implements Serializable {
    private String name;
}
