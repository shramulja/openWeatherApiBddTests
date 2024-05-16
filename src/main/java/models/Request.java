package responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Request {
    @JsonProperty("q")
    public String query;
    @JsonProperty("lang")
    public String lang;
}
