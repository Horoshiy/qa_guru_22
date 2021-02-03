package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventItem {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("count_sportsmen")
    private int countSportsmen;

    @JsonProperty("canceled")
    private boolean canceled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountSportsmen() {
        return countSportsmen;
    }

    public void setCountSportsmen(int countSportsmen) {
        this.countSportsmen = countSportsmen;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public String toString() {
        return "EventItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", countSportsmen=" + countSportsmen +
                ", canceled=" + canceled +
                '}';
    }
}
