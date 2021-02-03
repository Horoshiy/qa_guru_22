package tests.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.api.models.EventData;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventsApiTests {
    final String url = System.getProperty("api.url");

    @Test
    @DisplayName("GetAllEvents graphql request")
    void allEvents() {
        final String body = "{\"operationName\":\"GetAllEvents\",\"variables\":{\"sport_id\":75,\"first\":50,\"filter\":{\"dates\":\"now_and_future\"}},\"query\":\"query GetAllEvents($first: Int, $after: Int, $sport_id: Int, $calendar_id: ID, $filter: EventsListFilter) {\\n  events(first: $first, after: $after, sport_id: $sport_id, calendar_id: $calendar_id, filter: $filter) {\\n    ...EventsList\\n    __typename\\n  }\\n}\\n\\nfragment EventsList on EventConnection {\\n  edges {\\n    id\\n    name\\n    deleted\\n    canceled\\n    count_regions\\n    count_sportsmen\\n    region_id\\n    white_list\\n    status\\n    shared_link\\n    show_ath_list\\n    sport_type {\\n      id\\n      federation_filter\\n      title\\n      __typename\\n    }\\n    avatar {\\n      id\\n      uri\\n      __typename\\n    }\\n    calendar_logo {\\n      id\\n      uri\\n      __typename\\n    }\\n    region {\\n      id\\n      display_name\\n      __typename\\n    }\\n    title\\n    dt_start\\n    dt_end\\n    app_info {\\n      id\\n      dt_end\\n      dt_start\\n      closed\\n      user_can_apply\\n      payment_button_title\\n      reg_type\\n      reg_link\\n      app_from_schools\\n      __typename\\n    }\\n    disciplines {\\n      id\\n      title\\n      short_title\\n      ranks {\\n        id\\n        title\\n        short_title\\n        __typename\\n      }\\n      __typename\\n    }\\n    responsible {\\n      is_responsible\\n      __typename\\n    }\\n    __typename\\n  }\\n  total\\n  filtered_total\\n  __typename\\n}\\n\"}";

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
