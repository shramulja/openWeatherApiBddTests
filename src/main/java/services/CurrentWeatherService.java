package services;

import io.restassured.response.Response;
import models.Request;

public interface RealTimeService extends BaseService {
    Response getResponseCurrent(Request currentRequest);
}
