package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Condition {
    @JsonProperty("text")
    String text;
    @JsonProperty("icon")
    String icon;
    @JsonProperty("code")
    int code;
}
