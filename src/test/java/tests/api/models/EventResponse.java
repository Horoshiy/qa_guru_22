package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventResponse {
    @JsonProperty("events")
    private EventEdge event;

    @JsonProperty("events")
    public EventEdge getEvent() {
        return event;
    }

    @JsonProperty("events")
    public void setData(EventEdge event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "EventResponse{" +
                "event=" + event +
                '}';
    }
}
