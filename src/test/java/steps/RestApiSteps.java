package steps;

import impl.CurrentWeatherImpl;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import models.ErrorRoot;
import models.Location;
import models.Request;
import models.Root;

import static config.EnvConfig.BAD_KEY;
import static config.EnvConfig.KEY;
import static org.junit.Assert.assertEquals;

public class RestApiSteps {
    private Scenario scenario;
    Request currentRequest;
    Response response;
    CurrentWeatherImpl currentWeather = new CurrentWeatherImpl();

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("Request current weather for {string}, {string}")
    public void getCurrentWeatherForCityResponse(String city, String lang) {
        currentRequest = new Request(city, lang, KEY);
        response = currentWeather.getResponseCurrent(currentRequest);
    }

    @Given("Request negative for city {string} with disabled API key")
    public void getNegativeWeatherForCityResponseWithoutAccessKey(String city) {
        currentRequest = new Request(city, BAD_KEY);
        response = currentWeather.getResponseCurrent(currentRequest);
    }

    @Given("Request negative without query")
    public void getRequestNegativeWithoutQuery() {
        currentRequest = new Request(KEY);
        response = currentWeather.getResponseCurrent(currentRequest);
    }

    @Given("Request negative for non existent city {string}")
    public void getRequestNegativeForNonExistentCity(String city) {
        currentRequest = new Request(city, KEY);
        response = currentWeather.getResponseCurrent(currentRequest);
    }

    @Then("Error Response is {int}")
    public void errorResponseIs(int statusCode) {
        ErrorRoot errorRoot = response.then().extract().body().as(ErrorRoot.class);
        int actualResponseStatusCode = errorRoot.error.getCode();
        assertEquals("Expected statusCode " + statusCode + " not Equals actual statusCode " +
                actualResponseStatusCode, statusCode, actualResponseStatusCode);
    }

    @Then("Data are {string}, {string}, {string}")
    public void dataAre(String name, String timezoneId, String country) {
        Location location = response.then().extract().body().as(Root.class).getLocation();
        String actualName = location.getName();
        String actualTimeZoneId = location.getTimezoneId();
        String actualCountry = location.getCountry();

        assertEquals("Expected name " + name + " not Equals actual name " + actualName, name, actualName);
        assertEquals("Expected time zone Id " + timezoneId + " not Equals actual time zone Id " + actualTimeZoneId, timezoneId, actualTimeZoneId);
        assertEquals("Expected country " + country + " not Equals actual country " + actualCountry, country, actualCountry);
    }

}
