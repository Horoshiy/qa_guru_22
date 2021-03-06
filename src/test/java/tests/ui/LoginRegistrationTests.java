package tests.ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import annotations.Layer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Feature("register")
@Story("Login and registration")
@Tag("web")
public class LoginRegistrationTests extends TestBase {

    @Test
    @DisplayName("login")
    void login() {
        final String url = System.getProperty("site.url");
        final String name = System.getProperty("site.user");
        final String password = System.getProperty("site.password");

        step("open site", () -> {
            open(url);
            $("#logo").shouldHave(text("спорт"));
        });

        step("click on singIn/registration link", () -> {
            $(".alter_login").click();
            $(".inner_auth_popup").shouldHave(text("Пожалуйста, авторизуйтесь"));
        });

        step("fill login information", () -> {
            $(byName("auth.email")).val(name);
            $(byName("auth.passwd")).val(password);
            $("#auth_email a.submit").click();
            $(".logout-user-link").shouldHave(text("выход"));
        });
    }

    @Test
    @AllureId("1542")
    @DisplayName("Site registration")
    void registration() {
        final String url = System.getProperty("site.url");
        final String name = System.getProperty("site.user");
        final String password = System.getProperty("site.password");
        final String firstName = "Иван";
        final String lastName = "Иванов";

        step("Open site", () -> {
            open(url);
            $("#logo").shouldHave(text("спорт"));
        });

        step("Click on login link", () -> {
            $(".alter_login").click();
            $(".inner_auth_popup").shouldHave(text("Пожалуйста, авторизуйтесь"));
        });

        step("Click on register link", () -> {
           $("a.change_template").click();
           $("#auth_email_regustration").shouldBe(visible);
        });

        step("Fill fields and press submit button", () -> {
            $(byName("auth.email")).val(name);
            $(byName("auth.passwd")).val(password);
            $(byName("auth.first_name")).val(firstName);
            $(byName("auth.last_name")).val(lastName);
            $("#auth_email_regustration a.submit").click();
            $(".inner_auth_popup").shouldHave(text("Вы регистрировались на «Спорт вокруг.» ранее."));
        });
    }
}
