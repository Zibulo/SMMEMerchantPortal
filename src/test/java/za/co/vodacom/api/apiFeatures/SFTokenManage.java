package za.co.vodacom.api.apiFeatures;

import io.restassured.response.Response;

public class SFTokenManage {
    RestClient restClient;
    Response getResponse;

    public void TokenRequest() {
        // Create an instance of the RestClient
        restClient = new RestClient();

        // Base URI for the API
        String baseUri = "https://vodapayapiqa.vodacom.co.za";

        // Send a GET request
        getResponse = restClient.getRequest(baseUri, "/cloud/public-services/financial-services/v1/smme/salesforce/token?isbeUser=true");
        System.out.println(getResponse.prettyPrint());
    }

    public Response getTokenRes()
    {
        TokenRequest();
        return (getResponse != null) ? getResponse : getDefaultResponse();
    }

    private Response getDefaultResponse() {
        return null;  // Or a mocked response if needed.
    }
}
