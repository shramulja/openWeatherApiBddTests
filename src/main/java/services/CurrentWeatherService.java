package services;

import io.restassured.response.Response;
import models.Request;

public interface CurrentWeatherService extends BaseService {
    Response getResponseCurrent(Request currentRequest);
}
