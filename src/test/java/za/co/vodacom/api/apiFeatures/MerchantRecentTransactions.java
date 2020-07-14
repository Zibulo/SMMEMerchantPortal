package za.co.vodacom.api.apiFeatures;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import vfs.automation.core.api.RestInteractionPoint;
import vfs.automation.core.utilities.SystemUtilities;

import java.util.ArrayList;
import java.util.List;

public class MerchantRecentTransactions extends SystemUtilities {


    //public ResponseBody iCanViewDatedDashboard(String userId,String userName,String appChannel) throws Exception {

        //RestInteractionPoint restInteractionPoint = new RestInteractionPoint();
        //String endpoint = getPropertyValue("Environment", "smmeAPIEndpoint").replace("8080","8084")+ "/merchantprofile?userReference=";

        //String endpoint = getPropertyValue("Environment", "smmeAWSAPIEndpoint").replace("8080", "8085") + "dashboard/recent_transactions?userReference=" + userId + "&merchantId=" + userName + "&channelId=" + appChannel + "&channelName=Vodacom";


        //Header origin = new Header("Origin","http://localhost:8085");
        //List<Header> headerList = new ArrayList<Header>();

        //headerList.add(origin);
        //Headers headers = new Headers(headerList);
        //return  restInteractionPoint.get(headers,endpoint);

   // }

    public Response iCanViewRecentDashboard(String userId,String userName,String appChannel ) throws Exception {

        RestInteractionPoint restInteractionPoint = new RestInteractionPoint();

        //String endpoint = getPropertyValue("Environment", "smmeAWSAPIEndpoint").replace("8080", "8085") + "dashboard/recent_transactions?userReference=" + userId + "&merchantId=" + userName + "&channelId=" + appChannel + "&channelName=Vodacom";

        //String endpoint = ("https://tjvwxwxc0b.execute-api.eu-west-1.amazonaws.com/public-services/financial_services/dashboard/recent_transactions?userReference= " + userId + "&merchantId=VPS475074793423&channelId=WEB&channelName=Vodacom");
        String endpoint = getPropertyValue("Environment", "smmeAWSAPIEndpoint").replace("8080","8085") + "/dashboard/recent_transactions?userReference=" + userId + "&merchantId=VPS475074793423&channelId=WEB&channelName=Vodacom";


        Header origin = new Header("Origin","http://localhost:8085");
        List<Header> headerList = new ArrayList<Header>();

        headerList.add(origin);
        Headers headers = new Headers(headerList);

        return  restInteractionPoint.get(headers,endpoint);


    }


}
