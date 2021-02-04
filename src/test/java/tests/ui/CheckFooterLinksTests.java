package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import annotations.Layer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Feature("links")
@Story("Footer links")
@Tag("web")
public class CheckFooterLinksTests extends TestBase {
    final String homePage = System.getProperty("site.url");

    @Test
    @DisplayName("Check terms link")
    void checkTermsLinkTest() {
        final String title = "СОГЛАШЕНИЕ О ПРЕДОСТАВЛЕНИИ ДОСТУПА К САЙТУ";
        step("Open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("Click on terms link", () -> {
            $(by("href", "/terms/")).click();
            switchTo().window(1);
            $("#content").shouldHave(text(title));
        });
    }

    @Test
    @DisplayName("Check offer link")
    void checkOfferLinkTest() {
        final String title = "ДОГОВОР НА ОРГАНИЗАЦИЮ МЕРОПРИЯТИЯ";
        step("Open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("Click on offer link", () -> {
            $(by("href", "/offer/")).click();
            switchTo().window(1);
            $("#content").shouldHave(text(title));
        });
    }

    @Test
    @DisplayName("Contract agent link")
    void checkContractAgentLinkTest() {
        final String title = "АГЕНТСКИЙ ДОГОВОР";
        step("Open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("Click on offer link", () -> {
            $(by("href", "/contract-agent/")).click();
            switchTo().window(title);
            $("#content").shouldHave(text(title));
        });
    }

    @Test
    @DisplayName("Info link")
    void checkInfoLinkTest() {
        final String title = "Информация";
        step("Open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("Click on info link", () -> {
            $(by("href", "/info/")).click();
            switchTo().window(title);
            $("#content").shouldHave(text(title));
        });
    }

    @Test
    @DisplayName("projects link")
    void checkProjectsLinkTest() {
        final String title = "Наши проекты";
        step("Open site", () -> {
            open(homePage);
            $("#logo").shouldHave(text("спорт"));
        });

        step("Click on projects link", () -> {
            $(by("href", "/projects/")).click();
            switchTo().window(title());
            $("#content").shouldHave(text(title));
        });
    }

}
