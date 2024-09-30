package za.co.vodacom.api.apiFeatures;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RestClient {

    // Method to send a GET request
    public Response getRequest(String baseUri, String endpoint) {
        return given().
                baseUri(baseUri).
                when().
                get(endpoint);
    }

    // Method to send a POST request with a JSON body
    public Response postRequest(String baseUri, String endpoint, String jsonBody) {
        return given().
                header("Content-Type", "application/json").
                baseUri(baseUri).
                body(jsonBody).
                when().
                post(endpoint);
    }

    // Method to print the response body (for debugging)
    public void printResponseBody(Response response) {
        System.out.println("Response Body: " + response.getBody().asString());
    }

    // Method to get a specific field from the JSON response
    public String getJsonField(Response response, String jsonPath) {
        return response.jsonPath().getString(jsonPath);
    }

    // Method to get the status code of the response
    public int getStatusCode(Response response) {
        return response.getStatusCode();
    }
}
