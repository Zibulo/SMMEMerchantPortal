package za.co.vodacom.api.apiFeatures;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import vfs.automation.core.api.RestInteractionPoint;
import vfs.automation.core.utilities.SystemUtilities;

import java.util.ArrayList;
import java.util.List;

public class MerchantDatedTransactions extends SystemUtilities {

    public  Response iCanViewMerchantDatedTransactions(String userId,String fromDate,String toDate) throws Exception {

        RestInteractionPoint restInteractionPoint = new RestInteractionPoint();
        String endpoint = getPropertyValue("Environment", "smmeAWSAPIEndpoint").replace("8080","8085") + "/dashboard/dated_transactions?userReference=" + userId + "&fromDate=2020-03-01&toDate=2020-06-30";
        //String endpoint = getPropertyValue("Environment", "smmeAWSAPIEndpoint").replace("8080","8085") + ("/dashboard/dated_transactions?userReference=" + userId + "&fromDate=" + fromDate + "&toDate=" + toDate);
        Header origin = new Header("Origin","http://localhost:8085");
        List<Header> headerList = new ArrayList<Header>();
        headerList.add(origin);
        Headers headers = new Headers(headerList);

        return  restInteractionPoint.get(headers,endpoint);

    }
}
