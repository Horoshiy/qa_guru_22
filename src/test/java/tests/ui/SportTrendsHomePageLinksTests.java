package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.sportvokrug.allure.Layer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Feature("links")
@Story("Home page Sport Trends")
public class SportTrendsHomePageLinksTests extends TestBase {
    @ParameterizedTest
    @ValueSource(strings = {"фигурн", "велоспорт", "легк", "кроссфит", "художественн", "воркаут", "лыжн", "конн", "акробатическ"})
    void checkSportEventsLinks(String sport) {
        final String url = System.getProperty("site.url");

        step("open site", () -> {
            open(url);
            $("#logo").shouldHave(text("спорт"));
        });

        step("open link", () -> {
            $(".sport-type").find(byText(sport)).parent().click();
            $("main div").shouldHave(text(sport));
        });
    }
}
