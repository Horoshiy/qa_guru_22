package tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CheckFooterLinksTests extends TestBase {
    final String homePage = System.getProperty("site.url");

    @Test
    @DisplayName("check terms link")
    void checkTermsLinkTest() {
        final String title = "СОГЛАШЕНИЕ О ПРЕДОСТАВЛЕНИИ ДОСТУПА К САЙТУ";
        step("open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("click on terms link", () -> {
            $(by("href", "/terms/")).click();
            switchTo().window(1);
            $("#content").shouldHave(text(title));
        });
    }

    @Test
    @DisplayName("check offer link")
    void checkOfferLinkTest() {
        final String title = "ДОГОВОР НА ОРГАНИЗАЦИЮ МЕРОПРИЯТИЯ";
        step("open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("click on offer link", () -> {
            $(by("href", "/offer/")).click();
            switchTo().window(1);
            $("#content").shouldHave(text(title));
        });
    }

    @Test
    @DisplayName("contract agent link")
    void checkContractAgentLinkTest() {
        final String title = "АГЕНТСКИЙ ДОГОВОР";
        step("open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("click on offer link", () -> {
            $(by("href", "/contract-agent/")).click();
            switchTo().window(title);
            $("#content").shouldHave(text(title));
        });
    }

    @Test
    @DisplayName("info link")
    void checkInfoLinkTest() {
        final String title = "Информация";
        step("open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("click on info link", () -> {
            $(by("href", "/info/")).click();
            switchTo().window(title);
            $("#content").shouldHave(text(title));
        });
    }

    @Test
    @DisplayName("projects link")
    void checkProjectsLinkTest() {
        final String title = "Наши проекты";
        step("open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("click on projects link", () -> {
            $(by("href", "/projects/")).click();
            switchTo().window(title());
            $("#content").shouldHave(text(title));
        });
    }

}
