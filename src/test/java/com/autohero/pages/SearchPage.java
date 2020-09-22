package com.autohero.pages;

import com.autohero.elements.ResultsCollectionElement;
import com.autohero.elements.SelectElement;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage {

    private final SelectElement yearFilterElement = new SelectElement("yearRange.min");
    private final SelectElement sortByElement = new SelectElement("sort");
    private final ResultsCollectionElement resultsListElement = new ResultsCollectionElement("ad-items");
    private final SelenideElement filterYearElement = $("[data-qa-selector='filter-year']");

    private static LocalDate parseRegistrationDate(String registration) {
        @SuppressWarnings("deprecation")
        Date result = new Date(0, Calendar.JANUARY, 0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yyyy");
        try {
            result = dateFormat.parse(registration);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result != null ? result.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
    }

    public SearchPage SelectYearFilter(Integer year){
        filterYearElement.click();
        yearFilterElement
                .SelectValue(year.toString());
        return Selenide.page(SearchPage.class);
    }

    public SearchPage SortResultsBy(String sortValue){
        sortByElement
                .SelectValue(sortValue);
        return Selenide.page(SearchPage.class);
    }

    public List<LocalDate> getCarsRegistrationDates() {
        return resultsListElement.getRegistrationDates().stream()
                .map(SearchPage::parseRegistrationDate).collect(Collectors.toList());
    }

    public List<Float> getCarsPrices(){
        return resultsListElement.getPrices();
    }
}
