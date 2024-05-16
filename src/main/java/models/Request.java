package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Request {
    @JsonProperty("q")
    public String query;

    @JsonProperty("lang")
    public String lang;

    @JsonProperty("key")
    public String key;

    public Request(String query, String key) {
        this.query = query;
        this.key = key;
    }

    public Request(String key) {
        this.key = key;
    }
}
