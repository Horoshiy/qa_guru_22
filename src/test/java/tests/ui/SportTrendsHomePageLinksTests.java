package tests.ui;

import annotations.JiraIssue;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import annotations.Layer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Feature("links")
@Story("Home page Sport Trends")
@Tag("web")
public class SportTrendsHomePageLinksTests extends TestBase {
    @JiraIssue("QC3-1")
    @ParameterizedTest
    @ValueSource(strings = {"фигурн", "велоспорт", "легк", "кроссфит", "художественн", "воркаут", "лыжн", "конн", "акробатическ"})
    @DisplayName("Check links to events from sports")
    void checkSportEventsLinks(String sport) {
        final String url = System.getProperty("site.url");
        parameter("event", sport);

        step("Open site", () -> {
            open(url);
            $("#logo").shouldHave(text("спорт"));
        });

        step("Open link", () -> {
            $("#sport-types-list").find(withText(sport)).parent().click();
            $("main div").shouldHave(text(sport));
        });
    }
}
