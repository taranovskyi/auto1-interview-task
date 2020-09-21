package com.autohero.common;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.SelenidePageFactory;

public abstract class BasePage extends SelenidePageFactory {

    protected BasePage() {
        this.page(WebDriverRunner.driver(), this);
    }
}
