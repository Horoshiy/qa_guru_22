package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("UI")
@Story("Login and registration")
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
}
