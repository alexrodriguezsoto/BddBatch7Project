package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;
import utils.apiUtils;

import java.util.Map;
import static org.apache.http.HttpStatus.SC_OK;

public class MyStepdefs {
    public static Response response;
    apiUtils utils = new apiUtils();
    String endpoint;

//    @Given("I perform {string} request for endpoint {string}")
//    public void iPerformRequestForEndpoint(String requestType, String endpoint) {
////        RestAssured.baseURI = "https://api.octoperf.com";
//        String path = endpoint;
////
////        response = RestAssured.given()
////                .queryParams(utils.createRequestMap(ConfigReader.readProperty("username"),ConfigReader.readProperty("password")))
////                .contentType(ContentType.JSON)
////                .accept(ContentType.JSON)
////                .post(path)
////                .then()
////                .log().ifValidationFails()
////                .statusCode(SC_OK)
////                .extract()
////                .response();
////        System.out.println("verified");
////        System.out.println("Response Body: " + response.getBody().asString());
//
//
//        // Send POST request and get response as a string
//        String responseBody = utils.sendPostRequestAndGetResponseBody(endpoint, requestBody, utils.createRequestMap(ConfigReader.readProperty("username"),ConfigReader.readProperty("password")));
//
//// Send POST request and get response status code
//        int statusCode = utils.sendPostRequestAndGetStatusCode(endpoint, requestBody, utils.createRequestMap(ConfigReader.readProperty("username"),ConfigReader.readProperty("password")));
//
//// Send POST request and get full response object
//        Response response = utils.sendPostRequest(endpoint, requestBody, queryParams);
//
//    }
//
//    @And("I validate status code")
//    public void iValidateStatusCode() {
//        Assert.assertEquals(200, response.statusCode());
//    }
//
//    @Then("the token is saved for subsequent requests")
//    public void theTokenIsSavedForSubsequentRequests() {
//
//    }
//
//    @Given("the user gets an authentication token {string}")
//    public void theUserGetsAnAuthenticationToken(String endpoint) {
//        utils.getTokens(endpoint, utils.createRequestMap(ConfigReader.readProperty("username"),ConfigReader.readProperty("password")));
//    }
}
