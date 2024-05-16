package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Error {
    @JsonProperty("code")
    public int code;
    @JsonProperty("message")
    public String message;
}
