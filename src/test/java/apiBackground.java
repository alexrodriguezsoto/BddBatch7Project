import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import step_definitions.apiHooks;

public class apiBackground {
    Response response;

    @Given("I perform a POST drequest to {string}")
    public void iPerformAGETdRequestTo(String endpoint) {
        String token = apiHooks.getToken();
        response = RestAssured.given()
                .header("Authorization", token)
                .when()
                .get("/workspaces/member-of")
                .then().log().all()
                .extract().response();
    }

    @Then("the response status dcode is {int}")
    public void theResponseStatdusCodeIs(int code) {
        Assert.assertEquals(code, response.statusCode());
    }


}
