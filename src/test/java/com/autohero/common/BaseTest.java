package com.autohero.common;

import com.autohero.helpers.ConfigHelper;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeAll
    static void setupClass() throws IOException {
        ConfigHelper.loadSelenideProperties();
        open("/");
        WebDriverRunner.driver().getWebDriver().manage().window().maximize();
    }

    @AfterAll
    static void cleanupClass() {
        if (WebDriverRunner.hasWebDriverStarted())
            WebDriverRunner.closeWebDriver();
    }
}
