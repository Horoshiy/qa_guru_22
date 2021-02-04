package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sportvokrug.allure.Layer;
import tests.api.models.AccountData;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("rest")
@Feature("register")
@Story("Account requests")
public class AccountApiTests {
    final String url = System.getProperty("api.url");

    @Test
    @DisplayName("GetUserInfo graphql request")
    void accountInfo() {
        final String email = System.getProperty("site.user");
        final String sid = System.getProperty("api.sid");
        final String uid = System.getProperty("api.uid");

        final String body = "{\"operationName\":\"GetUserInfo\",\"variables\":{\"uid\":\"" + uid + "\",\"sid\":\"" + sid + "\"}," +
                "\"query\":\"query GetUserInfo($uid: String!, $sid: String!) {\\n" +
                "  getUserInfo(uid: $uid, sid: $sid) {\\n" +
                "    user {\\n" +
                "      auser_id\\n" +
                "      display_name\\n" +
                "      email\\n" +
                "      phone\\n" +
                "      roles {\\n" +
                "        is_admin\\n" +
                "        is_moderator\\n" +
                "        is_federator\\n" +
                "        is_super_federator\\n" +
                "        has_organizations\\n" +
                "        organization_tree {\\n" +
                "          organization_id\\n" +
                "          parent_organization1_id\\n" +
                "          sport_type\\n" +
                "          level\\n" +
                "          __typename\\n" +
                "        }\\n" +
                "        __typename\\n" +
                "      }\\n" +
                "      __typename\\n" +
                "    }\\n" +
                "    self {\\n" +
                "      auser_id\\n" +
                "      roles {\\n" +
                "        is_admin\\n" +
                "        is_moderator\\n" +
                "        __typename\\n" +
                "      }\\n" +
                "      __typename\\n" +
                "    }\\n" +
                "    __typename\\n" +
                "  }\\n" +
                "}\\n" +
                "\"}";

        AccountData response = given()
                .filter(new AllureRestAssured())
                .body(body)
                .headers(
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .post(url)
                .then()
                .statusCode(200)
                .extract()
                .as(AccountData.class);

        assertEquals(email, response.getData().getUserInfo().getUser().getEmail());
    }
}
