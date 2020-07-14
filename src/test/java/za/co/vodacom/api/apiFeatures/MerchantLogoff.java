package za.co.vodacom.api.apiFeatures;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import net.bytebuddy.implementation.bind.annotation.Origin;
import org.json.JSONObject;
import vfs.automation.core.api.RestInteractionPoint;
import vfs.automation.core.messageTypes.JSONBuilder;
import vfs.automation.core.utilities.SystemUtilities;

import java.util.ArrayList;
import java.util.List;


public class MerchantLogoff extends SystemUtilities {

    public Response iCanLogoffToSMMESite(String userId) throws Exception {
        String endpoint = getPropertyValue("Environment", "smmeAPIEndpoint") + "/authenticate/logoff";
        RestInteractionPoint restInteractionPoint = new RestInteractionPoint();

        //String loginBody = "{\"password\": \"UEA1NXcwcmQxMjMh\", \"channel\": \"Web\", \"username\": \"VPS336059736980\"}";
        //String loginEndpoint = "http://52.49.210.189:8080/public-services/financial_services/authenticate/login";



        Header origin = new Header("Origin","http://localhost:8080");
        List<Header> headerList = new ArrayList<Header>();

        //headerList.remove(origin);
        headerList.add(origin);
        Headers headers = new Headers(headerList);


        //
        //
        // String headers = "Origin,http://localhost:8080";

        return restInteractionPoint.post(headers,endpoint,LogoffToSMMEPortal(userId));
    }

    private String LogoffToSMMEPortal(String userId) {

        JSONObject SMMElogoffBody = new JSONObject();
        JSONBuilder jsonBuilder = new JSONBuilder();
        jsonBuilder.putString(SMMElogoffBody,"userId",userId);

        System.out.println("Itu Message for logoff \n" + userId+"\n");
        //System.out.println("Itu Message for logoff \n" + SMMElogoffBody.toString());

        return SMMElogoffBody.toString();


    }
}
