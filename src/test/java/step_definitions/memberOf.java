package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.createProjectPojos;
import step_definitions.apiHooks;
import utils.TestData;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class memberOf {
    Response response;
    HashMap<String, String> actualFields;
    HashMap<String, String> actualValues;

    @Given("I perform a POST request to log in and retrieve token")
    public void iPerformAPOSTRequestToLogInAndRetrieveToken() {
        apiHooks.retrieveToken();
    }

    @Given("I perform a GET request to {string}")
    public void iPerformAGETRequestTo(String endpoint) {
        String token = apiHooks.getToken();
        if (token != null) {
            response = RestAssured.given()
                    .header("Authorization", token)
                    .when()
                    .get(endpoint)
                    .then().log().all()
                    .extract().response();
        } else {
            System.out.println("Token is null");
        }
    }

    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int code) {
        Assert.assertEquals(code, response.statusCode());
    }


    @And("the response headers contains {string}")
    public void theResponseHeadersContains(String responseContent) {
        String contentType = response.getHeader("Content-Type");
        Assert.assertEquals(contentType, responseContent);

    }

    @And("the response body contains {string} field")
    public void theResponseBodyContainsField(String value) {
        Assert.assertEquals(value, response.jsonPath().getString("name[0]"));
    }

    @And("the response body contains the following fields:")
    public void theResponseBodyContainsTheFollowingFields(Map<String, String> expectedFields) {
        String responseBody = response.getBody().asString();
//        actualFields = JsonPath.from(responseBody).get("[0]");
//        for (String key : expectedFields.keySet()) {
//            String expectedValue = expectedFields.get(key);
//            String actualValue = actualFields.get(key);
//            Assert.assertEquals("Value for " + key + " field does not match", expectedValue, actualValue);
//        }

        if(responseBody.startsWith("[")) {
            actualFields = JsonPath.from(responseBody).get("[0]");
        } else {
            actualFields = JsonPath.from(responseBody).get();
        }
        for (String key : expectedFields.keySet()) {
            String expectedValue = expectedFields.get(key);
            String actualValue = actualFields.get(key);
            Assert.assertEquals("Value for " + key + " field does not match", expectedValue, actualValue);
        }

//        HashMap<String, String> actualFields = response.getBody().jsonPath().get("data");
        actualValues = new HashMap<>();
        for (String key : expectedFields.keySet()) {
            String actualValue = actualFields.get(key).toString();
            actualValues.put(key, actualValue);
        }
        TestData.actualValues.putAll(actualValues);
        System.out.println(actualFields);
        System.out.println(TestData.actualValues.get("id"));
    }

    @Given("I perform a POST request to {string}")
    public void iPerformAPOSTRequestTo(String endpoint) {
        String token = apiHooks.getToken();
        System.out.println(TestData.actualValues.get("id"));
        System.out.println(TestData.actualValues.get("userId"));

        createProjectPojos project = new createProjectPojos();
        project.setId("");
        project.setCreated("2021-03-11T10:15:20.845Z");
        project.setLastModified("2021-03-11T06:15:20.845Z");
        project.setUserId(TestData.actualValues.get("userId"));
        project.setWorkspaceId(TestData.actualValues.get("id"));
        project.setName("seleniumAPI2");
        project.setDescription("testing via Selenium");
        project.setType("DESIGN");
        project.setTags(new ArrayList<>());

        if (token != null) {
            response = RestAssured.given()
                    .headers("Content-type", "application/json")
                    .header("Authorization", token)
                    .and()
                    .body(project)
                    .when()
                    .post(endpoint)
                    .then().log().all()
                    .extract().response();
        } else {
            System.out.println("Token is null");
        }
    }
}
