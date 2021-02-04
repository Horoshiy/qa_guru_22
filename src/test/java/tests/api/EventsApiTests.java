package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import annotations.Layer;
import tests.api.models.EventData;

import static helpers.FileUtils.readStringFromFile;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Layer("rest")
@Feature("events")
@Story("Events test")
@Tag("api")
public class EventsApiTests {
    final String url = System.getProperty("api.url");

    @Test
    @DisplayName("GetAllEvents graphql request")
    void allEvents() {
        final String body = readStringFromFile("./src/test/resources/data/eventsData.json");

        EventData response = given()
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
                .as(EventData.class);

        assertTrue(response.getData().getEvent().getItems().size() > 0);
    }
}
