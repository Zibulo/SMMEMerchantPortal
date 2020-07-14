package za.co.vodacom.api.apiFeatures;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.json.JSONObject;
import vfs.automation.core.api.RestInteractionPoint;
import vfs.automation.core.messageTypes.JSONBuilder;
import vfs.automation.core.utilities.SystemUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        return restInteractionPoint.get(headers, endpoint);

    }
}

    //public String SearchMerchantProfile(String userId) throws Exception {

     //   JSONBuilder jsonBuilder = new JSONBuilder();
      //  JSONObject jsonObject = new JSONObject();
      //  jsonBuilder.putString(jsonObject, "userId", userId);
     //   System.out.println("Profile UserId  " + userId);

     //   System.out.println(jsonObject.toString());
      //  return jsonObject.toString();


   // }


