package com.autohero.scenarios;

import com.autohero.common.BaseTest;
import com.autohero.pages.MainPage;
import com.autohero.pages.SearchPage;
import com.google.common.collect.Ordering;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {

    @Test
    void yearFilterAndSortingShouldFilterSearchResults() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = mainPage.goToSearchPage();
        int year = 2015;

        searchPage
                .SelectYearFilter(year)
                .SortResultsBy("Höchster Preis");

        List<LocalDate> carsRegistrationDate = searchPage.getCarsRegistrationDates();
        List<Float> carsPrices = searchPage.getCarsPrices();

        assertTrue(Ordering.natural().reverse().isOrdered(carsPrices),
                "Car prices are not sorted in Descending order!");
        assertTrue(carsRegistrationDate.stream().allMatch(date -> date.getYear() > year - 1),
                String.format("Car registration dates are not filtered after %d year", year));
    }
}
