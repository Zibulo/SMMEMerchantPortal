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

public class MerchantChangePassword extends SystemUtilities {

    public Response iCanChangePassword(String userId, String oldPassword, String newPassword ) throws Exception {
        String endpoint = getPropertyValue("Environment", "smmeAWSAPIEndpoint") + "/authenticate/change-password";
        RestInteractionPoint restInteractionPoint = new RestInteractionPoint();

        Header origin = new Header("Origin","http://localhost:8080");
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(origin);
        Headers headers = new Headers(headerList);

        return restInteractionPoint.post((Map<String, String>) headers,endpoint, changePassword(userId,oldPassword,newPassword));
    }

    private String changePassword(String userId,String oldPassword, String newPassword) throws Exception {
        JSONObject SMMEloginBody = new JSONObject();
        JSONBuilder jsonBuilder = new JSONBuilder();
        jsonBuilder.putString(SMMEloginBody, "userId", userId);
        jsonBuilder.putString(SMMEloginBody, "oldPassword", oldPassword);
        jsonBuilder.putString(SMMEloginBody, "newPassword", newPassword);

        //System.out.println("Request Message\n" + SMMEloginBody.toString());

        return SMMEloginBody.toString();
    }
}
