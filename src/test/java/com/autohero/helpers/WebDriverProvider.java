package com.autohero.helpers;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverProvider {

    public static WebDriver driver() {
        return WebDriverRunner.driver().getWebDriver();
    }

    public static WebDriverWait waiter(){
        return new WebDriverWait(driver(), 30);
    }

    public static void waitForPageLoad(){
        waiter().until((ExpectedCondition<Boolean>) wdriver -> ((JavascriptExecutor) driver()).executeScript(
                "return document.readyState"
        ).equals("complete"));
    }
}
