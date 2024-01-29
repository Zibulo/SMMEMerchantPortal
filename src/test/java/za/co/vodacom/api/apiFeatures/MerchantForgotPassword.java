package za.co.vodacom.api.apiFeatures;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.JSONObject;
import vfs.automation.core.api.RestInteractionPoint;
import vfs.automation.core.messageTypes.JSONBuilder;
import vfs.automation.core.utilities.SystemUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MerchantForgotPassword extends SystemUtilities {

    public Response iCanRequestPasswordReset(String userName) throws Exception {

        String endpoint = getPropertyValue("Environment", "smmeAWSAPIEndpoint") + "/authenticate/reset-password";
        RestInteractionPoint restInteractionPoint = new RestInteractionPoint();

        Header origin = new Header("Origin","http://localhost:8080");
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(origin);
        Headers headers = new Headers(headerList);

        return restInteractionPoint.post((Map<String, String>) headers,endpoint, forgetPassword(userName));
    }

    private String forgetPassword(String userId) throws Exception {
        JSONObject SMMEloginBody = new JSONObject();
        JSONBuilder jsonBuilder = new JSONBuilder();
        jsonBuilder.putString(SMMEloginBody, "userName", userId);

        //System.out.println("Request Message\n" + SMMEloginBody.toString());
        return SMMEloginBody.toString();
    }
}

