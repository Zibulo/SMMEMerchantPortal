package za.co.vodacom.api.apiFeatures;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.w3c.dom.stylesheets.LinkStyle;
import vfs.automation.core.api.RestInteractionPoint;
import vfs.automation.core.messageTypes.JSONBuilder;
import vfs.automation.core.utilities.SystemUtilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class MerchantLogin extends SystemUtilities {



    public Response iCanLoginToSMMESite(String userName, String passWord, String appChannel) throws Exception {
        RestInteractionPoint restInteractionPoint = new RestInteractionPoint();
        String endpoint = getPropertyValue("Environment", "smmeAWSAPIEndpoint") + "/authenticate/login";

        Header origin = new Header("Origin","http://localhost:8080");
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(origin);
        Headers headers = new Headers(headerList);

        return restInteractionPoint.post(headers, endpoint, LoginToSMMEPortal(userName,passWord,appChannel));
    }

    private String LoginToSMMEPortal(String userName, String passWord, String appChannel) throws Exception {
        JSONObject loginBody = new JSONObject();
        JSONBuilder jsonBuilder = new JSONBuilder();
        jsonBuilder.putString(loginBody, "username", userName);
        jsonBuilder.putString(loginBody, "password", passWord);
        jsonBuilder.putString(loginBody, "channel", appChannel);

        System.out.println("Request Message\n" + loginBody.toString());


        return loginBody.toString();
    }

}
