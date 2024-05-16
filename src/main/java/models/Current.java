package responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Current{
    @JsonProperty("last_updated_epoch")
    int lastUpdatedEpoch;

    @JsonProperty("last_updated")
    String lastUpdated;

    @JsonProperty("temp_c")
    double tempC;

    @JsonProperty("temp_f")
    double tempF;

    @JsonProperty("is_day")
    int isDay;

    @JsonProperty("condition")
    Condition condition;

    @JsonProperty("wind_mph")
    double windMph;

    @JsonProperty("wind_kph")
    double windKph;

    @JsonProperty("wind_degree")
    int windDegree;

    @JsonProperty("wind_dir")
    String windDir;

    @JsonProperty("pressure_mb")
    int pressureMb;

    @JsonProperty("pressure_in")
    double pressureIn;

    @JsonProperty("precip_mm")
    int precipMm;

    @JsonProperty("precip_in")
    int precipIn;

    @JsonProperty("humidity")
    int humidity;

    @JsonProperty("cloud")
    int cloud;

    @JsonProperty("feelslike_c")
    int feelslikeC;

    @JsonProperty("feelslike_f")
    double feelslikeF;

    @JsonProperty("vis_km")
    int visKm;

    @JsonProperty("vis_miles")
    int visMiles;

    @JsonProperty("uv")
    int uv;

    @JsonProperty("gust_mph")
    double gustMph;

    @JsonProperty("gust_kph")
    double gustKph;
}