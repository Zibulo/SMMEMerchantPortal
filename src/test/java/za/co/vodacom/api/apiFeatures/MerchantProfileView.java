package za.co.vodacom.api.apiFeatures;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import vfs.automation.core.api.RestInteractionPoint;
import vfs.automation.core.utilities.SystemUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MerchantProfileView extends SystemUtilities {

    public Response iCanViewMerchantProfile(String userId) throws Exception {

        //JSONBuilder jsonBuilder = new JSONBuilder();
        //JSONObject jsonObject = new JSONObject();
        RestInteractionPoint restInteractionPoint = new RestInteractionPoint();
        String endpoint = getPropertyValue("Environment", "smmeAPIEndpoint").replace("8080", "8084") + "/merchantprofile?userReference=" + userId;


        Header origin = new Header("Origin", "http://localhost:8084");
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(origin);
        Headers headers = new Headers(headerList);

        return restInteractionPoint.get((Map<String, String>) headers, endpoint);

    }
}



