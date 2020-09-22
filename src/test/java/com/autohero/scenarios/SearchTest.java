package com.autohero.scenarios;

import com.autohero.pages.SearchPage;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(SoftAssertionsExtension.class)
public class SearchTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({"2015, 'Höchster Preis'"})
    void yearFilterAndSortingShouldFilterSearchResults(int year, String sortBy, SoftAssertions softly) {
        SearchPage searchPage = open("/search", SearchPage.class);

        searchPage
                .SelectYearFilter(year)
                .SortResultsBy(sortBy);

        List<LocalDate> carsRegistrationDate = searchPage.getCarsRegistrationDates();
        List<Float> carsPrices = searchPage.getCarsPrices();

        softly.assertThat(carsPrices).isSortedAccordingTo(Comparator.reverseOrder());
        softly.assertThat(carsRegistrationDate.stream().allMatch(date -> date.getYear() > year - 1)).isTrue();
    }
}
