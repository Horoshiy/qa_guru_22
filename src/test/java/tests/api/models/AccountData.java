package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountData {
    @JsonProperty("data")
    private UserData data;

    @JsonProperty("data")
    public UserData getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(UserData data) {
        this.data = data;
    }

}
