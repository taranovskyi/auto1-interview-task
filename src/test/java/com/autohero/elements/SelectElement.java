package com.autohero.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class SelectElement extends BaseElement implements ISelectElement {

    private final SelenideElement rootElement;
    private final SelenideElement resultsAmountElement = $("div[data-qa-selector='results-amount']");

    public SelectElement(String elementNameSelector){
        rootElement = $(format("[data-qa-selector='select'][name='%s']", elementNameSelector));
    }

    @Override
    public void SelectValue(String value){
        rootElement.click();
        rootElement.$x(format("./option[contains(text(), '%s')]", value)).click();
        rootElement.click();
        resultsAmountElement.waitUntil(Condition.text("Lädt..."), defaultTimeout(), 10);
        resultsAmountElement.waitUntil(Condition.matchText("\\d+ Treffer"), defaultTimeout());
    }
}
