package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import annotations.Layer;
import tests.api.models.AccountData;

import static helpers.FileUtils.readStringFromFile;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("rest")
@Feature("register")
@Story("Account requests")
@Tag("api")
public class AccountApiTests {
    final String url = System.getProperty("api.url");

    @Test
    @DisplayName("GetUserInfo graphql request")
    void accountInfo() {
        final String email = System.getProperty("site.user");
        final String sid = System.getProperty("api.sid");
        final String uid = System.getProperty("api.uid");

        final String body = format(readStringFromFile("./src/test/resources/data/accountData.json"), uid, sid);

        AccountData response = given()
                .filter(new AllureRestAssured())
                .body(body)
                .headers("Content-Type", ContentType.JSON,
                        "Accept", ContentType.JSON)
                .when()
                .post(url)
                .then()
                .statusCode(200)
                .extract()
                .as(AccountData.class);

        assertEquals(email, response.getData().getUserInfo().getUser().getEmail());
    }
}
