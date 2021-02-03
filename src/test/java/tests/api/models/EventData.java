package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventData {
    @JsonProperty("data")
    private EventResponse data;

    @JsonProperty("data")
    public EventResponse getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(EventResponse data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EventData{" +
                "data=" + data +
                '}';
    }
}
