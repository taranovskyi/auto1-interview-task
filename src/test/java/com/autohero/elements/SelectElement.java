package com.autohero.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class SelectElement implements ISelectElement {

    private final SelenideElement rootElement;

    public SelectElement(String elementNameSelector){
        rootElement = $(format("[data-qa-selector='select'][name='%s']", elementNameSelector));
    }

    @Override
    public void SelectValue(String value){
        rootElement.click();
        rootElement.$x(format("./option[contains(text(), '%s')]", value)).click();
        rootElement.click();
    }
}
