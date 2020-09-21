package com.autohero.pages;

import com.autohero.common.BasePage;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {

    public SearchPage goToSearchPage(){
        open("/search");
        return Selenide.page(SearchPage.class);
    }
}
