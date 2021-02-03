package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventEdge {
    @JsonProperty("edges")
    private List<EventItem> items;

    @JsonProperty("edges")
    public List<EventItem> getItems() {
        return items;
    }

    @JsonProperty("edges")
    public void setItems(List<EventItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "EventEdge{" +
                "items=" + items +
                '}';
    }
}
