package APIStepDefinitions;

import API.Endpoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.notNullValue;

public class TagsStepDef {

    private RequestSpecification request;
    private Response response;


    @Given("prepare endpoint for get Tags")
    public void prepareEndpointForGetTags() {
        RestAssured.baseURI = Endpoint.BASE_URL;
        request = RestAssured.given()
                .header("app-id", Endpoint.APP_ID)
                .contentType("application/json");

    }

    @When("send Request for get Tags")
    public void sendRequestForGetTags() {
        response = request.get("/tag");
    }

    @Then("response should be {int}")
    public void responseShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("response body should contain tag lists")
    public void responseBodyShouldContainTagLists() {
        response.prettyPrint();
        response.then().body("data", notNullValue());
    }
}
