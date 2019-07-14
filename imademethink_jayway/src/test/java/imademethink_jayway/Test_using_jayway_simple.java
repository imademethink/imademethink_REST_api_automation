package imademethink_jayway;

//need to import jayway as static

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.with;

//import javax.ws.rs.core.Response;

public class Test_using_jayway_simple {

    public static void main(String[] args) throws Exception{

//        String url_getAccountDetails            = "https://demo8207651.mockable.io/getAccountDetails";
//        String url_getAccountDetailsv2          = "https://demo8207651.mockable.io/getAccountDetails/v2";
//        String url_getMinStatement              = "https://demo8207651.mockable.io/getMinStatement";
//        String url_updateBalanceMobileRecharge  = "https://demo8207651.mockable.io/updateBalanceMobileRecharge";
//        String url_createHomeloneEMI            = "https://demo8207651.mockable.io/createHomeloneEMI";
//        String url_delSubAccount                = "https://demo8207651.mockable.io/delSubAccount";

        example1_GET();

        example2_GET();

        example3_GET();

        example4_PUT();

        example5_POST();

        example6_DELETE();

        example7_GET_failure();

    }

    public static void example1_GET() throws Exception{
        System.out.println("----------------------------------------------------------------------------");

        String  url                             = "https://demo8207651.mockable.io/getAccountDetails";
        RequestSpecification requestspecs       = with();
        requestspecs.contentType(MediaType.APPLICATION_JSON);
        requestspecs.accept(MediaType.APPLICATION_JSON);

        Response responseJayWay =  requestspecs.get(url);

        String responseInString             = responseJayWay.asString();

        int responseCode                    = responseJayWay.getStatusCode();

        String strContentTypeOfResponse     = responseJayWay.getContentType();

        System.out.println("Response Code                        : HTTP " + responseCode);

        System.out.println("Content type of actual response is   : " + strContentTypeOfResponse);

        System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);

        System.out.println("\nFollowing success response received from web application.");
        JSONObject jsonobject                         = parse_StringResponse(responseInString);

        System.out.println("Full json response == " + jsonobject.toString());

        System.out.println("custid : " + jsonobject.get("custid").toString());

        System.out.println("----------------------------------------------------------------------------");
    }

    public static void example2_GET() throws Exception{
        System.out.println("----------------------------------------------------------------------------");

        String  url                             = "https://demo8207651.mockable.io/getAccountDetails/v2";
        RequestSpecification requestspecs       = with();
        requestspecs.contentType(MediaType.APPLICATION_JSON);
        requestspecs.accept(MediaType.APPLICATION_JSON);

        Response responseJayWay =  requestspecs.get(url);

        String responseInString             = responseJayWay.asString();

        int responseCode                    = responseJayWay.getStatusCode();

        String strContentTypeOfResponse     = responseJayWay.getContentType();

        System.out.println("Response Code                        : HTTP " + responseCode);

        System.out.println("Content type of actual response is   : " + strContentTypeOfResponse);

        System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);

        System.out.println("\nFollowing success response received from web application.");
        JSONObject jsonobject                         = parse_StringResponse(responseInString);

        System.out.println("Full json response == " + jsonobject.toString());

        System.out.println("custid : " + jsonobject.get("custid").toString());
        System.out.println("email : " + jsonobject.get("email").toString());
        System.out.println("currentBalance : " + jsonobject.get("currentBalance").toString());

        System.out.println("----------------------------------------------------------------------------");
    }

    public static void example3_GET() throws Exception{
        System.out.println("----------------------------------------------------------------------------");

        String  url                             = "https://demo8207651.mockable.io/getMinStatement";
        RequestSpecification requestspecs       = with();
        requestspecs.contentType(MediaType.APPLICATION_JSON);
        requestspecs.accept(MediaType.APPLICATION_JSON);

        Response responseJayWay =  requestspecs.get(url);

        String responseInString             = responseJayWay.asString();

        int responseCode                    = responseJayWay.getStatusCode();

        String strContentTypeOfResponse     = responseJayWay.getContentType();

        System.out.println("Response Code                        : HTTP " + responseCode);

        System.out.println("Content type of actual response is   : " + strContentTypeOfResponse);

        System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);

        System.out.println("\nFollowing success response received from web application.");
        JSONObject jsonobject                         = parse_StringResponse(responseInString);

        System.out.println("Full json response == " + jsonobject.toString());

        System.out.println("custid : " + jsonobject.get("custid").toString());
        System.out.println("month : " + jsonobject.get("month").toString());
        System.out.println("year : " + jsonobject.get("year").toString());
        System.out.println("ministatement : " + jsonobject.get("ministatement").toString());
        JSONObject jsonobject2                         = parse_StringResponse(jsonobject.get("ministatement").toString());
        System.out.println("deduct jan 01 : " + jsonobject2.get("deduct jan 01").toString());
        System.out.println("deduct jan 04 : " + jsonobject2.get("deduct jan 04").toString());
        System.out.println("deduct jan 21 : " + jsonobject2.get("deduct jan 21").toString());
        System.out.println("add jan 31 : " + jsonobject2.get("add jan 31").toString());

        System.out.println("----------------------------------------------------------------------------");
    }

    public static void example4_PUT() throws Exception{
        System.out.println("----------------------------------------------------------------------------");

        String  url                             = "https://demo8207651.mockable.io/updateBalanceMobileRecharge";
        RequestSpecification requestspecs       = with();
        requestspecs.contentType(MediaType.APPLICATION_JSON);
        requestspecs.accept(MediaType.APPLICATION_JSON);

        Response responseJayWay =  requestspecs.put(url);

        String responseInString             = responseJayWay.asString();

        int responseCode                    = responseJayWay.getStatusCode();

        String strContentTypeOfResponse     = responseJayWay.getContentType();

        System.out.println("Response Code                        : HTTP " + responseCode);

        System.out.println("Content type of actual response is   : " + strContentTypeOfResponse);

        System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);

        System.out.println("\nFollowing success response received from web application.");
        JSONObject jsonobject                         = parse_StringResponse(responseInString);

        System.out.println("Full json response == " + jsonobject.toString());

        System.out.println("balance update : " + jsonobject.get("balance update").toString());
        System.out.println("update balance type : " + jsonobject.get("update balance type").toString());

        System.out.println("----------------------------------------------------------------------------");
    }

    public static void example5_POST() throws Exception{
        System.out.println("----------------------------------------------------------------------------");

        String  url                             = "https://demo8207651.mockable.io/createHomeloneEMI";
        RequestSpecification requestspecs       = with();
        requestspecs.contentType(MediaType.APPLICATION_JSON);
        requestspecs.accept(MediaType.APPLICATION_JSON);

        Response responseJayWay =  requestspecs.post(url);
        //requestspecs.with().formParameters("");

        String responseInString             = responseJayWay.asString();

        int responseCode                    = responseJayWay.getStatusCode();

        String strContentTypeOfResponse     = responseJayWay.getContentType();

        System.out.println("Response Code                        : HTTP " + responseCode);

        System.out.println("Content type of actual response is   : " + strContentTypeOfResponse);

        System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);

        System.out.println("\nFollowing success response received from web application.");
        JSONObject jsonobject                         = parse_StringResponse(responseInString);

        System.out.println("Full json response == " + jsonobject.toString());

        System.out.println("biller emi amount : " + jsonobject.get("biller emi amount").toString());
        System.out.println("biller name : " + jsonobject.get("biller name").toString());

        System.out.println("----------------------------------------------------------------------------");
    }

    public static void example6_DELETE() throws Exception{
        System.out.println("---------------------Work in progress----------------------------------------");

        String  url                             = "https://demo8207651.mockable.io/delSubAccount";
        RequestSpecification requestspecs       = with();
        requestspecs.contentType(MediaType.APPLICATION_JSON);
        requestspecs.accept(MediaType.APPLICATION_JSON);

//        Response responseJayWay =  requestspecs.post(url);
//        //requestspecs.with().formParameters("");
//
//        String responseInString             = responseJayWay.asString();
//
//        int responseCode                    = responseJayWay.getStatusCode();
//
//        String strContentTypeOfResponse     = responseJayWay.getContentType();
//
//        System.out.println("Response Code                        : HTTP " + responseCode);
//
//        System.out.println("Content type of actual response is   : " + strContentTypeOfResponse);
//
//        System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
//
//        System.out.println("\nFollowing success response received from web application.");
//        JSONObject jsonobject                         = parse_StringResponse(responseInString);
//
//        System.out.println("Full json response == " + jsonobject.toString());
//
//        System.out.println("biller emi amount : " + jsonobject.get("biller emi amount").toString());
//        System.out.println("biller name : " + jsonobject.get("biller name").toString());

        System.out.println("----------------------------------------------------------------------------");
    }

    public static void example7_GET_failure() throws Exception{
        System.out.println("----------------------------------------------------------------------------");

        String  url                             = "https://demo8207651.mockable.io/getAccountDetails123456";
        RequestSpecification requestspecs       = with();
        requestspecs.contentType(MediaType.APPLICATION_JSON);
        requestspecs.accept(MediaType.APPLICATION_JSON);

        Response responseJayWay =  requestspecs.get(url);

        String responseInString             = responseJayWay.asString();

        int responseCode                    = responseJayWay.getStatusCode();

        String strContentTypeOfResponse     = responseJayWay.getContentType();

        System.out.println("Response Code                        : HTTP " + responseCode);

        System.out.println("Content type of actual response is   : " + strContentTypeOfResponse);

        System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);

        System.out.println("\nFollowing success response received from web application.");
        JSONObject jsonobject                         = parse_StringResponse(responseInString);

        System.out.println("Full json response == " + jsonobject.toString());

        System.out.println("custid : " + jsonobject.get("custid").toString());

        System.out.println("----------------------------------------------------------------------------");
    }



    private static JSONObject parse_StringResponse(String responseInString) throws Exception{
        // parsing the response and json conversion
        JSONParser parser                 = new JSONParser();
        Object object                     = parser.parse(responseInString);

        JSONObject jsonobject             = (JSONObject) object;
        
        return jsonobject;
    }

	
}
