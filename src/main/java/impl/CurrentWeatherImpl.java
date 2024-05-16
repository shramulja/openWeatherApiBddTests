package impl;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Request;
import models.ResponseCurrent;
import services.RealTimeService;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static specification.APIRequestSpecification.aPIRequestSpecification;

public class CurrentServiceImpl implements RealTimeService {
    private final String CURRENT = "current.json?key=";

    @Override
    public Response getResponseCurrentService(Request currentRequest) {

        String url = URI + CURRENT;

        return given().spec(aPIRequestSpecification())
                .when()
                .get(url + currentRequest.getKey() + "&q=" + currentRequest.getQuery()
                        + "&lang=" + currentRequest.getLang());
    }
}

