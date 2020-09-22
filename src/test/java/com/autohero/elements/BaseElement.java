package com.autohero.elements;

import com.autohero.helpers.ConfigHelper;

public abstract class BaseElement {
    protected int defaultTimeout(){
        return ConfigHelper.getDefaultSelenideTimeout();
    }
}
