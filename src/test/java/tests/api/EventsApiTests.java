package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sportvokrug.allure.Layer;
import tests.api.models.EventData;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Layer("rest")
@Feature("events")
@Story("Events test")
public class EventsApiTests {
    final String url = System.getProperty("api.url");

    @Test
    @DisplayName("GetAllEvents graphql request")
    void allEvents() {
        final String body;
        body = "{\"operationName\":\"GetAllEvents\"," +
                "\"variables\":{\"sport_id\":75,\"first\":50," +
                "\"filter\":{\"dates\":\"now_and_future\"}}," +
                "\"query\":\"query GetAllEvents($first: Int, $after: Int, $sport_id: Int, $calendar_id: ID, $filter: EventsListFilter) {\\n" +
                "  events(first: $first, after: $after, sport_id: $sport_id, calendar_id: $calendar_id, filter: $filter) {\\n" +
                "    ...EventsList " +
                "    __typename " +
                "  } " +
                "} " +
                " " +
                "fragment EventsList on EventConnection { " +
                "  edges { " +
                "    id " +
                "    name " +
                "    deleted " +
                "    canceled " +
                "    count_regions " +
                "    count_sportsmen " +
                "    region_id " +
                "    white_list " +
                "    status " +
                "    shared_link " +
                "    show_ath_list " +
                "    sport_type { " +
                "      id " +
                "      federation_filter " +
                "      title " +
                "      __typename " +
                "    } " +
                "    avatar { " +
                "      id " +
                "      uri " +
                "      __typename " +
                "    } " +
                "    calendar_logo { " +
                "      id " +
                "      uri " +
                "      __typename " +
                "    } " +
                "    region { " +
                "      id " +
                "      display_name " +
                "      __typename " +
                "    } " +
                "    title " +
                "    dt_start " +
                "    dt_end " +
                "    app_info { " +
                "      id " +
                "      dt_end " +
                "      dt_start " +
                "      closed " +
                "      user_can_apply " +
                "      payment_button_title " +
                "      reg_type " +
                "      reg_link " +
                "      app_from_schools " +
                "      __typename " +
                "    } " +
                "    disciplines { " +
                "      id " +
                "      title " +
                "      short_title " +
                "      ranks { " +
                "        id " +
                "        title " +
                "        short_title " +
                "        __typename " +
                "      } " +
                "      __typename " +
                "    } " +
                "    responsible { " +
                "      is_responsible " +
                "      __typename " +
                "    } " +
                "    __typename " +
                "  } " +
                "  total " +
                "  filtered_total " +
                "  __typename " +
                "} " +
                "\"}";

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
