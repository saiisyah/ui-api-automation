package APIStepDefinitions;

import API.Endpoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserStepDef {
        private RequestSpecification request;
        private Response response;
        private JSONObject requestBody;
        private static String userID;

        @Given("endpoint create a new user")
        public void endpointCreateANewUser() {
                RestAssured.baseURI = Endpoint.BASE_URL;
                request = RestAssured.given()
                        .header("app-id", Endpoint.APP_ID)
                        .contentType("application/json");
        }

        @And("prepares valid data")
        public void preparesValidData() {
                requestBody = new JSONObject();
                requestBody.put("firstName", "Lalice");
                requestBody.put("lastName", "Manoban");
                requestBody.put("email", "LaliceMan" + System.currentTimeMillis() + "@mail.com");

                request.body(requestBody.toString());
               
        }

        @When("send Request POST create user")
        public void sendRequestPOSTCreateUser() {
                response = request.post(Endpoint.CREATE_USER);
        if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
                userID = response.jsonPath().getString("id");
                System.out.println("user successfully created by ID: " + userID);
                }
        }

        @Then("response status should be {int}")
        public void responseStatusShouldBe(int statusCode) {
                response.then().statusCode(statusCode);
        }

        @Then("response body should contain created user data")
        public void responseBodyShouldContainCreatedUserData() {
                response.then().body("firstName", equalTo("Lalice"));
                response.then().body("lastName", equalTo("Manoban"));
                response.then().body("id", notNullValue());
        }

        @Given("endpoint has created a new user")
        public void endpointHasCreatedANewUser() {
                RestAssured.baseURI = Endpoint.BASE_URL;
                request = RestAssured.given()
                        .header("app-id", Endpoint.APP_ID)
                        .contentType("application/json");
                if (userID == null) {
                        userID = "63a804408eb0cb069b57e43a";
                }
        }

        @When("user send Request GET user by id")
        public void userSendRequestGETUserById() {
                String targetUrl = Endpoint.GET_USER.replace(":id", userID);
                response = request.get(targetUrl);
        }

        @Then("response body should show user details")
        public void responseBodyShouldShowUserDetails() {
                response.prettyPrint();
                response.then().body("id", equalTo(userID));
        }

        @Given("endpoint has created a user")
        public void endpointHasCreatedAUser() {
                RestAssured.baseURI = Endpoint.BASE_URL;
                request = RestAssured.given()
                        .header("app-id", Endpoint.APP_ID)
                        .contentType("application/json");
                if (userID == null) {
                        userID = "63a804408eb0cb069b57e43a";
                }


        }

        @And("user prepare an update data")
        public void userPrepareAnUpdateData() {
                requestBody = new JSONObject();
                requestBody.put("firstName", "Oliver");
                requestBody.put("lastName", "Manoban");

                request.body(requestBody.toString());
        }

        @When("send Request PUT update user")
        public void sendRequestPUTUpdateUser() {
                String targetUrl = Endpoint.UPDATE_USER.replace(":id", userID);
                response = request.put(targetUrl);
                response.prettyPrint();
        }

        @Then("response body should contain created update user data")
        public void responseBodyShouldContainCreatedUpdateUserData() {
                response.then().body("firstName", equalTo("Oliver"));
        }

        @When("user send Request DELETE user")
        public void userSendRequestDELETEUser() {
                String targetUrl = Endpoint.DELETE_USER.replace(":id", userID);
                response = request.delete(targetUrl);
                response.prettyPrint();
        }

        @Then("data user should be deleted")
        public void dataUserShouldBeDeleted() {
                response.then().body("id", equalTo(userID));
                System.out.println("User with ID" + userID + "delete successful");
        }
    }

