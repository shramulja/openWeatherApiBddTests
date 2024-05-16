package impl;

import io.restassured.response.Response;
import models.Request;
import services.CurrentWeatherService;

import static io.restassured.RestAssured.given;
import static specification.APIRequestSpecification.aPIRequestSpecification;

public class CurrentWeatherImpl implements CurrentWeatherService {
    private final String CURRENT = "current.json?key=";

    @Override
    public Response getResponseCurrent(Request currentRequest) {

        String url = URI + CURRENT + currentRequest.getKey();
        if (currentRequest.getLang() != null) {
            url = url + "&lang=" + currentRequest.getLang();
        }
        if (currentRequest.getQuery() != null) {
            url = url + "&q=" + currentRequest.getQuery();
        }
        return given().spec(aPIRequestSpecification())
                .when()
                .get(url);
    }
}

