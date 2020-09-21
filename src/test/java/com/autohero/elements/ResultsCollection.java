package com.autohero.elements;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class ResultsCollection {

    private final List<SelenideElement> elements;

    public ResultsCollection(String selector){
        SelenideElement rootElement = $(format("[data-qa-selector='%s']", selector));
        elements = rootElement.$$x("./div");
    }

    public List<String> getRegistrationDates(){
        return getSpecElements()
                .stream().map(elem -> {
                    SelenideElement element = elem.$x(".//li", 0);
                    return element.getText().replace("•\n", "");
                }).collect(Collectors.toList());
    }

    public List<Float> getPrices(){
        return elements.stream().map(element -> Float.parseFloat(element.$("span[data-qa-selector='price']").getText().replace(" €", "")))
                .collect(Collectors.toList());
    }

    private List<SelenideElement> getSpecElements(){
            return elements.stream().map(element -> element.$("ul[data-qa-selector='spec-list']")).collect(Collectors.toList());
    }
}
