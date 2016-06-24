package imademethink_apachehttpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Test_using_apachehttpclient{

	public static void main(String[] args) throws Exception{

       	int nCount                    = 0;
        String     strTempEmail       = "";
        String     strTempPassword    = "k9aPass";
        Test_using_apachehttpclient apachehttpclient                     = new Test_using_apachehttpclient();
        HashMap<String,Object> objHashMapBasicUserDetails                = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapErrorResp                       = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapSignupGET                       = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapSignupPOST                      = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapActivateGET                     = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapSigninPOST                      = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapSignoutDELETE                   = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapGetAccountProfileDetailGET      = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapModifyAccountProfileDetailPUT   = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapForgetPasswordGetSecretQuestionGET     = new HashMap<String,Object>();
        HashMap<String,Object> objHashMapResetPasswordPUT                = new HashMap<String,Object>();
		
        
        
        
        // scenario -1 
        nCount                                                	= 1;
        strTempEmail                                        	= "Happy0"+ Integer.toString(nCount) +"@aaa.com";
        objHashMapBasicUserDetails                            	= fill_BasicUserDetails(strTempEmail,strTempPassword);        
        objHashMapErrorResp                                 	= fill_ErrorResponse();
        objHashMapSignupGET                                 	= fill_SignupGET();
        objHashMapSignupPOST                                	= fill_SignupPOST();
        objHashMapActivateGET                                	= fill_ActivateGET();
        objHashMapSigninPOST                                	= fill_SigninPOST();
        objHashMapSignoutDELETE                                	= fill_SignoutDELETE();
        
        System.out.println("\nScenario1.1 - Http-GET signup parameters");
        apachehttpclient.GET_signup_details(objHashMapSignupGET, objHashMapErrorResp);
        
        System.out.println("\nScenario1.2 - Http-POST signup actual");
        apachehttpclient.POST_signup_actual(objHashMapBasicUserDetails, objHashMapSignupPOST, objHashMapErrorResp);

        System.out.println("\nScenario1.3 - Http-GET activate basic account");
        apachehttpclient.GET_activate_basic_account(objHashMapBasicUserDetails,objHashMapActivateGET, objHashMapErrorResp);

        System.out.println("\nScenario1.4 - Http-POST signin actual");
        apachehttpclient.POST_signin_actual(objHashMapBasicUserDetails, objHashMapSigninPOST, objHashMapErrorResp);
        
        System.out.println("\nScenario1.5 - Http-DELETE signout basic account");
        apachehttpclient.DELETE_signout_basic_account(objHashMapBasicUserDetails,objHashMapSignoutDELETE, objHashMapErrorResp);

        // scenraio - 2
        nCount                                                	= 2;
        strTempEmail                                        	= "Happy0"+ Integer.toString(nCount) +"@aaa.com";
        objHashMapBasicUserDetails                             	= null;
        objHashMapBasicUserDetails                            	= fill_BasicUserDetails(strTempEmail, strTempPassword);        
        objHashMapErrorResp                                 	= null;
        objHashMapErrorResp                                 	= fill_ErrorResponse();
        objHashMapSignupGET                                 	= null;
        objHashMapSignupGET                                 	= fill_SignupGET();
        objHashMapSignupPOST                                	= null;
        objHashMapSignupPOST                                	= fill_SignupPOST();
        objHashMapActivateGET                                	= null;
        objHashMapActivateGET                                	= fill_ActivateGET();
        objHashMapSigninPOST                                	= null;
        objHashMapSigninPOST                                	= fill_SigninPOST();
        objHashMapSignoutDELETE                                	= null;
        objHashMapSignoutDELETE                                	= fill_SignoutDELETE();
        objHashMapGetAccountProfileDetailGET                	= null;
        objHashMapGetAccountProfileDetailGET                	= fill_GetAccountProfileDetailGET();
        objHashMapModifyAccountProfileDetailPUT                	= null;
        objHashMapModifyAccountProfileDetailPUT                	= fill_ModifyAccountProfileDetailPUT();
        
        System.out.println("\n\nScenario2.1 - Http-GET signup parameters");
        apachehttpclient.GET_signup_details(objHashMapSignupGET, objHashMapErrorResp);

        System.out.println("\nScenario2.2 - Http-POST signup actual");
        apachehttpclient.POST_signup_actual(objHashMapBasicUserDetails, objHashMapSignupPOST, objHashMapErrorResp);

        System.out.println("\nScenario2.3 - Http-GET activate basic account");
        apachehttpclient.GET_activate_basic_account(objHashMapBasicUserDetails,objHashMapActivateGET, objHashMapErrorResp);

        System.out.println("\nScenario2.4 - Http-POST signin actual");
        apachehttpclient.POST_signin_actual(objHashMapBasicUserDetails, objHashMapSigninPOST, objHashMapErrorResp);

        System.out.println("\nScenario2.5 - Http-GET get basic account profile detail");
        apachehttpclient.GET_basic_account_profile_detail(objHashMapBasicUserDetails,objHashMapGetAccountProfileDetailGET, objHashMapErrorResp);

        // actually modify details e.g. first name and last name
        objHashMapBasicUserDetails.put("str_modifyaccountprofiledetail_PUT_response_payload_value_firstname",    "Jack");
        objHashMapBasicUserDetails.put("str_modifyaccountprofiledetail_PUT_response_payload_value_lastname",     "Black");        
        System.out.println("\nScenario2.6 - Http-PUT modify basic account profile detail");
        apachehttpclient.PUT_modify_basic_account_profile_detail(objHashMapBasicUserDetails,objHashMapModifyAccountProfileDetailPUT, objHashMapErrorResp);

        System.out.println("\nScenario2.7 - Http-GET get basic account profile detail again");
        apachehttpclient.GET_basic_account_profile_detail(objHashMapBasicUserDetails,objHashMapGetAccountProfileDetailGET, objHashMapErrorResp);

        System.out.println("\nScenario2.8 - Http-DELETE signout basic account");
	        apachehttpclient.DELETE_signout_basic_account(objHashMapBasicUserDetails,objHashMapSignoutDELETE, objHashMapErrorResp);
 
	        // scenraio - 3
        nCount                                                	= 3;
        strTempEmail                                        	= "Happy0"+ Integer.toString(nCount) +"@aaa.com";
        objHashMapBasicUserDetails                             	= null;
        objHashMapBasicUserDetails                            	= fill_BasicUserDetails(strTempEmail, strTempPassword);        
        objHashMapErrorResp                                 	= null;
        objHashMapErrorResp                                 	= fill_ErrorResponse();
        objHashMapSignupGET                                 	= null;
        objHashMapSignupGET                                 	= fill_SignupGET();
        objHashMapSignupPOST                                	= null;
        objHashMapSignupPOST                                	= fill_SignupPOST();
        objHashMapActivateGET                                	= null;
        objHashMapActivateGET                                	= fill_ActivateGET();
        objHashMapSigninPOST                                	= null;
        objHashMapSigninPOST                                	= fill_SigninPOST();
        objHashMapSignoutDELETE                                	= null;
        objHashMapSignoutDELETE                                	= fill_SignoutDELETE();
        objHashMapGetAccountProfileDetailGET                	= null;
        objHashMapGetAccountProfileDetailGET                	= fill_GetAccountProfileDetailGET();
        objHashMapModifyAccountProfileDetailPUT                	= null;
        objHashMapModifyAccountProfileDetailPUT                	= fill_ModifyAccountProfileDetailPUT();
        objHashMapForgetPasswordGetSecretQuestionGET        	= null;
        objHashMapForgetPasswordGetSecretQuestionGET        	= fill_ForgetPasswordGetSecretQuestionGET();
        objHashMapResetPasswordPUT                            	= null;
        objHashMapResetPasswordPUT                            	= fill_ResetPasswordPUT();
        
        System.out.println("\n\nScenario3.1 - Http-GET signup parameters");
        apachehttpclient.GET_signup_details(objHashMapSignupGET, objHashMapErrorResp);

        System.out.println("\nScenario3.2 - Http-POST signup actual");
        apachehttpclient.POST_signup_actual(objHashMapBasicUserDetails, objHashMapSignupPOST, objHashMapErrorResp);

        System.out.println("\nScenario3.3 - Http-GET activate basic account");
        apachehttpclient.GET_activate_basic_account(objHashMapBasicUserDetails,objHashMapActivateGET, objHashMapErrorResp);

        System.out.println("\nScenario3.4 - Http-POST signin actual");
        apachehttpclient.POST_signin_actual(objHashMapBasicUserDetails, objHashMapSigninPOST, objHashMapErrorResp);

        System.out.println("\nScenario3.5 - Http-GET forget password get secret question");
        apachehttpclient.GET_forget_password_get_secret_question(objHashMapBasicUserDetails,objHashMapForgetPasswordGetSecretQuestionGET, objHashMapErrorResp);

        System.out.println("\nScenario3.6 - Http-PUT reset password");
        apachehttpclient.PUT_reset_password(objHashMapBasicUserDetails,objHashMapResetPasswordPUT, objHashMapErrorResp);
        
        System.out.println("\nScenario3.7 - Http-DELETE signout basic account");
        apachehttpclient.DELETE_signout_basic_account(objHashMapBasicUserDetails,objHashMapSignoutDELETE, objHashMapErrorResp);

        System.out.println("\nScenario3.8 - Http-POST signin actual");
        apachehttpclient.POST_signin_actual(objHashMapBasicUserDetails, objHashMapSigninPOST, objHashMapErrorResp);

        
        // scenraio - 4
        nCount                                                	= 4;
        strTempEmail                                        	= "Happy0"+ Integer.toString(nCount) +"@aaa.com";
        objHashMapBasicUserDetails                             	= null;
        objHashMapBasicUserDetails                            	= fill_BasicUserDetails(strTempEmail, strTempPassword);        
        objHashMapErrorResp                                 	= null;
        objHashMapErrorResp                                 	= fill_ErrorResponse();
        objHashMapSignupGET                                 	= null;
        objHashMapSignupGET                                 	= fill_SignupGET();
        objHashMapSignupPOST                                	= null;
        objHashMapSignupPOST                                	= fill_SignupPOST();
        objHashMapActivateGET                                	= null;
        objHashMapActivateGET                                	= fill_ActivateGET();
        objHashMapSigninPOST                                	= null;
        objHashMapSigninPOST                                	= fill_SigninPOST();
        objHashMapSignoutDELETE                                	= null;
        objHashMapSignoutDELETE                                	= fill_SignoutDELETE();
        objHashMapGetAccountProfileDetailGET                	= null;
        objHashMapGetAccountProfileDetailGET                	= fill_GetAccountProfileDetailGET();
        objHashMapModifyAccountProfileDetailPUT                	= null;
        objHashMapModifyAccountProfileDetailPUT                	= fill_ModifyAccountProfileDetailPUT();
        objHashMapForgetPasswordGetSecretQuestionGET        	= null;
        objHashMapForgetPasswordGetSecretQuestionGET        	= fill_ForgetPasswordGetSecretQuestionGET();
        objHashMapResetPasswordPUT                            	= null;
        objHashMapResetPasswordPUT                            	= fill_ResetPasswordPUT();

        System.out.println("\n\nScenario4.1 - Http-GET signup parameters");
        apachehttpclient.GET_signup_details(objHashMapSignupGET, objHashMapErrorResp);

        System.out.println("\nScenario4.2 - Http-POST signup actual");
        apachehttpclient.POST_signup_actual(objHashMapBasicUserDetails, objHashMapSignupPOST, objHashMapErrorResp);

        System.out.println("\nScenario4.3 - Http-POST signin actual");
        apachehttpclient.POST_signin_actual(objHashMapBasicUserDetails, objHashMapSigninPOST, objHashMapErrorResp);

        // use dummy / fake session id
        objHashMapBasicUserDetails.put("str_basic_account_session_value",             "12345678901234567890123456789012");
        objHashMapBasicUserDetails.put("str_basic_account_latest_session_value",     "12345678901234567890123456789012");
        System.out.println("\nScenario4.4 - Http-DELETE signout basic account");
        apachehttpclient.DELETE_signout_basic_account(objHashMapBasicUserDetails,objHashMapSignoutDELETE, objHashMapErrorResp);
        
        // scenraio - 5
        nCount                                              	= 5;
        strTempEmail                                        	= "Happy0"+ Integer.toString(nCount) +"@aaa.com";
        objHashMapBasicUserDetails                             	= null;
        objHashMapBasicUserDetails                            	= fill_BasicUserDetails(strTempEmail, strTempPassword);        
        objHashMapErrorResp                                 	= null;
        objHashMapErrorResp                                 	= fill_ErrorResponse();
        objHashMapSignupGET                                 	= null;
        objHashMapSignupGET                                 	= fill_SignupGET();
        objHashMapSignupPOST                                	= null;
        objHashMapSignupPOST                                	= fill_SignupPOST();
        objHashMapActivateGET                                	= null;
        objHashMapActivateGET                                	= fill_ActivateGET();
        objHashMapSigninPOST                                	= null;
        objHashMapSigninPOST                                	= fill_SigninPOST();
        objHashMapSignoutDELETE                                	= null;
        objHashMapSignoutDELETE                                	= fill_SignoutDELETE();
        objHashMapGetAccountProfileDetailGET                	= null;
        objHashMapGetAccountProfileDetailGET                	= fill_GetAccountProfileDetailGET();
        objHashMapModifyAccountProfileDetailPUT                	= null;
        objHashMapModifyAccountProfileDetailPUT                	= fill_ModifyAccountProfileDetailPUT();
        objHashMapForgetPasswordGetSecretQuestionGET        	= null;
        objHashMapForgetPasswordGetSecretQuestionGET        	= fill_ForgetPasswordGetSecretQuestionGET();
        objHashMapResetPasswordPUT                            	= null;
        objHashMapResetPasswordPUT                            	= fill_ResetPasswordPUT();

        System.out.println("\n\nScenario5.1 - Http-GET signup parameters");
        apachehttpclient.GET_signup_details(objHashMapSignupGET, objHashMapErrorResp);

        System.out.println("\nScenario5.2 - Http-POST signup actual");
        apachehttpclient.POST_signup_actual(objHashMapBasicUserDetails, objHashMapSignupPOST, objHashMapErrorResp);

        System.out.println("\nScenario5.3 - Http-GET activate basic account");
        apachehttpclient.GET_activate_basic_account(objHashMapBasicUserDetails,objHashMapActivateGET, objHashMapErrorResp);

        System.out.println("\nScenario5.4 - Http-POST signin actual");
        apachehttpclient.POST_signin_actual(objHashMapBasicUserDetails, objHashMapSigninPOST, objHashMapErrorResp);

        System.out.println("\nScenario5.5 - Http-GET get basic account profile detail with Content type as XML");
        apachehttpclient.GET_basic_account_profile_detail_special(objHashMapBasicUserDetails,objHashMapGetAccountProfileDetailGET, objHashMapErrorResp);

        System.out.println("\nScenario5.6 - Http-DELETE signout basic account with acceptable content type set to XML");
        apachehttpclient.DELETE_signout_basic_account_special(objHashMapBasicUserDetails,objHashMapSignoutDELETE, objHashMapErrorResp);
        
        // scenraio - 6
        nCount                                                	= 6;
        strTempEmail                                        	= "Happy0"+ Integer.toString(nCount) +"@aaa.com";
        objHashMapBasicUserDetails                             	= null;
        objHashMapBasicUserDetails                            	= fill_BasicUserDetails(strTempEmail, strTempPassword);        
        objHashMapErrorResp                                 	= null;
        objHashMapErrorResp                                 	= fill_ErrorResponse();
        objHashMapSignupGET                                 	= null;
        objHashMapSignupGET                                 	= fill_SignupGET();
        objHashMapSignupPOST                                	= null;
        objHashMapSignupPOST                                	= fill_SignupPOST();
        objHashMapActivateGET                                	= null;
        objHashMapActivateGET                                	= fill_ActivateGET();
        objHashMapSigninPOST                                	= null;
        objHashMapSigninPOST                                	= fill_SigninPOST();
        objHashMapSignoutDELETE                                	= null;
        objHashMapSignoutDELETE                                	= fill_SignoutDELETE();
        objHashMapGetAccountProfileDetailGET                	= null;
        objHashMapGetAccountProfileDetailGET                	= fill_GetAccountProfileDetailGET();
        objHashMapModifyAccountProfileDetailPUT                	= null;
        objHashMapModifyAccountProfileDetailPUT                	= fill_ModifyAccountProfileDetailPUT();
        objHashMapForgetPasswordGetSecretQuestionGET        	= null;
        objHashMapForgetPasswordGetSecretQuestionGET        	= fill_ForgetPasswordGetSecretQuestionGET();
        objHashMapResetPasswordPUT                            	= null;
        objHashMapResetPasswordPUT                            	= fill_ResetPasswordPUT();

        System.out.println("\nScenario6.1 - Http-POST signup actual");
        apachehttpclient.POST_signup_actual(objHashMapBasicUserDetails, objHashMapSignupPOST, objHashMapErrorResp);

        // use dummy / fake session id
        objHashMapBasicUserDetails.put("str_basic_account_session_value",             "12345678901234567890123456789012");
        objHashMapBasicUserDetails.put("str_basic_account_latest_session_value",     "12345678901234567890123456789012");
        System.out.println("\nScenario6.2 - Http-DELETE signout basic account");
        apachehttpclient.DELETE_signout_basic_account(objHashMapBasicUserDetails,objHashMapSignoutDELETE, objHashMapErrorResp);

        System.out.println("\nScenario6.3 - Http-GET forget password get secret question");
        apachehttpclient.GET_forget_password_get_secret_question(objHashMapBasicUserDetails,objHashMapForgetPasswordGetSecretQuestionGET, objHashMapErrorResp);

        System.out.println("\nScenario6.4 - Http-GET get basic account profile detail");
        apachehttpclient.GET_basic_account_profile_detail(objHashMapBasicUserDetails,objHashMapGetAccountProfileDetailGET, objHashMapErrorResp);
	        
	}
	


    private void GET_signup_details(HashMap<String,Object> objHashMapSignupGETTemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");
        String url                 = objHashMapSignupGETTemp.get("str_signup_GET_url").toString();

        HttpGet httpGet                            = new HttpGet(url);
        HttpUriRequest corerequest                 = setup_Connection_General(url, httpGet);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}

        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();

        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject     = null;

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                         = parse_StringResponse(responseInString);
            
            JSONObject jsonobject_internal     = null;

            System.out.println(objHashMapSignupGETTemp.get("str_signup_GET_response_key1").toString()+":"+jsonobject.get(objHashMapSignupGETTemp.get("str_signup_GET_response_key1").toString()));
            System.out.println(objHashMapSignupGETTemp.get("str_signup_GET_response_key2").toString()+":"+jsonobject.get(objHashMapSignupGETTemp.get("str_signup_GET_response_key2").toString())); 
            System.out.println(objHashMapSignupGETTemp.get("str_signup_GET_response_key3").toString()+":");
            jsonobject_internal             = (JSONObject) jsonobject.get(objHashMapSignupGETTemp.get("str_signup_GET_response_key3").toString());

            System.out.println("     "+ objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_emailid").toString()   +":"+jsonobject_internal.get(objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_emailid")));
            System.out.println("     "+ objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_firstname").toString() +":"+jsonobject_internal.get(objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_firstname"))); 
            System.out.println("     "+ objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_lastname").toString()  +":"+jsonobject_internal.get(objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_lastname"))); 
            System.out.println("     "+ objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_gender").toString()    +":"+jsonobject_internal.get(objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_gender"))); 
            System.out.println("     "+ objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_password").toString()  +":"+jsonobject_internal.get(objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_password"))); 
            System.out.println("     "+ objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_secret_question_1").toString()         +":"+jsonobject_internal.get(objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_secret_question_1"))); 
            System.out.println("     "+ objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_secret_question_2").toString()         +":"+jsonobject_internal.get(objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_secret_question_2"))); 
            System.out.println("     "+ objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_secret_question_answer_1").toString()  +":"+jsonobject_internal.get(objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_secret_question_answer_1"))); 
            System.out.println("     "+ objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_secret_question_answer_2").toString()  +":"+jsonobject_internal.get(objHashMapSignupGETTemp.get("str_signup_GET_response_payload_key_secret_question_answer_2"))); 

     		System.out.println("Links: ");
     		JSONObject obj_json_Links = (JSONObject) jsonobject.get("Links");
     		System.out.println("     Link documentation:"    +  obj_json_Links.get("Link documentation"));
     		System.out.println("     Actual signup:"            +  obj_json_Links.get("Actual signup"));
            
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }

    private void POST_signup_actual(HashMap<String,Object> objHashMapBasicUserDetailsTemp, HashMap<String,Object> objHashMapSignupPOSTTemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");
        String url                 = objHashMapSignupPOSTTemp.get("str_signup_POST_url").toString();

        HttpPost httpPost                          = new HttpPost(url);
        List<NameValuePair> urlParameters          = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_emailid").toString(),
        											objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_emailid").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_firstname").toString(),
        											objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_firstname").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_lastname").toString(),
													objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_lastname").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_gender").toString(),
													objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_gender").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_password").toString(),
													objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_password").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_secret_question_1").toString(),
													objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_secret_question_1").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_secret_question_2").toString(),
													objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_secret_question_2").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_secret_question_answer_1").toString(),
													objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_secret_question_answer_1").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_secret_question_answer_2").toString(),
													objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_secret_question_answer_2").toString()));        
        
        HttpEntity postParams                      = new UrlEncodedFormEntity(urlParameters);
        httpPost.setEntity(postParams);
        
        HttpUriRequest corerequest                 = setup_Connection_POST(url, httpPost);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}

        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
		System.out.println("Response Code               : HTTP " + responseCode);
		System.out.println("Content type of response is : " + strContentTypeOfResponse);
		JSONObject jsonobject     = null;
		
        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 201){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                 = parse_StringResponse(responseInString);
            System.out.println(objHashMapSignupPOSTTemp.get("str_signup_POST_response_key1").toString()+":"+jsonobject.get(objHashMapSignupPOSTTemp.get("str_signup_POST_response_key1").toString()));
            System.out.println(objHashMapSignupPOSTTemp.get("str_signup_POST_response_key2").toString()+":"+jsonobject.get(objHashMapSignupPOSTTemp.get("str_signup_POST_response_key2").toString())); 
            System.out.println(objHashMapSignupPOSTTemp.get("str_signup_POST_response_key3").toString()+":"+jsonobject.get(objHashMapSignupPOSTTemp.get("str_signup_POST_response_key3").toString()) );
            // insert activation key in basic user hashmap variable
            objHashMapBasicUserDetailsTemp.put("str_basic_account_activation_value",jsonobject.get(objHashMapSignupPOSTTemp.get("str_signup_POST_response_key3").toString()));
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }

    private void GET_activate_basic_account(HashMap<String,Object> objHashMapBasicUserDetailsTemp,HashMap<String,Object> objHashMapActivateGET, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {
        
        System.out.println("----------------------------------------------------------------------------");
        if(objHashMapBasicUserDetailsTemp.get("str_basic_account_activation_value").toString().isEmpty()){
            System.out.println("This test can not be performed as activation code is empty.");
            return;
        }
        // build the query param string using string builder first
        StringBuilder requestUrl = new StringBuilder(objHashMapActivateGET.get("str_activate_GET_url").toString()).append("?");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_key_emailid") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_signup_POST_response_payload_value_emailid"));
        requestUrl.append("&");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_activation_key") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_activation_value"));
        String url                 = requestUrl.toString();

        HttpGet httpGet                            = new HttpGet(url);
        HttpUriRequest corerequest                 = setup_Connection_General(url, httpGet);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}

        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject     = null;

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                         = parse_StringResponse(responseInString);
            System.out.println(objHashMapActivateGET.get("str_activate_GET_response_key1").toString()+":"+jsonobject.get(objHashMapActivateGET.get("str_activate_GET_response_key1").toString()));
            System.out.println(objHashMapActivateGET.get("str_activate_GET_response_key2").toString()+":"+jsonobject.get(objHashMapActivateGET.get("str_activate_GET_response_key2").toString())); 
            System.out.println(objHashMapActivateGET.get("str_activate_GET_response_key3").toString()+":"+jsonobject.get(objHashMapActivateGET.get("str_activate_GET_response_key3").toString()) );
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }
    
    private void POST_signin_actual(HashMap<String,Object> objHashMapBasicUserDetailsTemp, HashMap<String,Object> objHashMapSigninPOSTTemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");
        String url                 = objHashMapSigninPOSTTemp.get("str_signin_POST_url").toString();

        HttpPost httpPost                          = new HttpPost(url);
        List<NameValuePair> urlParameters          = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signin_POST_response_payload_key_emailid").toString(),
        											objHashMapBasicUserDetailsTemp.get("str_signin_POST_response_payload_value_emailid").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_signin_POST_response_payload_key_password").toString(),
													objHashMapBasicUserDetailsTemp.get("str_signin_POST_response_payload_value_password").toString()));
        
        HttpEntity postParams                      = new UrlEncodedFormEntity(urlParameters);
        httpPost.setEntity(postParams);
        
        HttpUriRequest corerequest                 = setup_Connection_POST(url, httpPost);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}

        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject               = null;

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                 = parse_StringResponse(responseInString);
            System.out.println(objHashMapSigninPOSTTemp.get("str_signin_POST_response_key1").toString()+":"+jsonobject.get(objHashMapSigninPOSTTemp.get("str_signin_POST_response_key1").toString()));
            System.out.println(objHashMapSigninPOSTTemp.get("str_signin_POST_response_key2").toString()+":"+jsonobject.get(objHashMapSigninPOSTTemp.get("str_signin_POST_response_key2").toString())); 
            System.out.println(objHashMapSigninPOSTTemp.get("str_signin_POST_response_key3").toString()+":"+jsonobject.get(objHashMapSigninPOSTTemp.get("str_signin_POST_response_key3").toString()) );
            // insert activation key in basic user hashmap variable
            objHashMapBasicUserDetailsTemp.put("str_basic_account_session_value",jsonobject.get(objHashMapSigninPOSTTemp.get("str_signin_POST_response_key3").toString()));
            objHashMapBasicUserDetailsTemp.put("str_basic_account_latest_session_value",jsonobject.get(objHashMapSigninPOSTTemp.get("str_signin_POST_response_key3").toString()));
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }

    private void DELETE_signout_basic_account(HashMap<String,Object> objHashMapBasicUserDetailsTemp, HashMap<String,Object> objHashMapSignoutDELETETemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");
        if(objHashMapBasicUserDetailsTemp.get("str_basic_account_session_value").toString().isEmpty()){
            System.out.println("This test can not be performed as session value is empty.");
            return;
        }
        
        // build the query param string using string builder first
        StringBuilder requestUrl = new StringBuilder(objHashMapSignoutDELETETemp.get("str_signout_DELETE_url").toString()).append("?");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_signout_DELETE_response_payload_key_emailid") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_signout_DELETE_response_payload_value_emailid"));
        requestUrl.append("&");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_session_key") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_session_value"));
        String url                 = requestUrl.toString();

        HttpDelete httpDelete                      = new HttpDelete(url);
        HttpUriRequest corerequest                 = setup_Connection_General(url, httpDelete);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}

        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject     = null;

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                         = parse_StringResponse(responseInString);
            System.out.println(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key1").toString()+":"+jsonobject.get(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key1").toString()));
            System.out.println(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key2").toString()+":"+jsonobject.get(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key2").toString())); 
            System.out.println(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key3").toString()+":"+jsonobject.get(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key3").toString()) );
            
            // during successful sign out set the session id / value to empty
            objHashMapBasicUserDetailsTemp.put("str_basic_account_session_value","");
            objHashMapBasicUserDetailsTemp.put("str_basic_account_latest_session_value","");
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }

    private void DELETE_signout_basic_account_special(HashMap<String,Object> objHashMapBasicUserDetailsTemp, HashMap<String,Object> objHashMapSignoutDELETETemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");
        if(objHashMapBasicUserDetailsTemp.get("str_basic_account_session_value").toString().isEmpty()){
            System.out.println("This test can not be performed as session value is empty.");
            return;
        }
        
        // build the query param string using string builder first
        StringBuilder requestUrl = new StringBuilder(objHashMapSignoutDELETETemp.get("str_signout_DELETE_url").toString()).append("?");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_signout_DELETE_response_payload_key_emailid") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_signout_DELETE_response_payload_value_emailid"));
        requestUrl.append("&");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_session_key") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_session_value"));
        String url                 = requestUrl.toString();

        HttpDelete httpDelete                      = new HttpDelete(url);
        HttpUriRequest corerequest                 = setup_Connection_General_special(url, httpDelete, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        
//        
//        
//        
//        
//        
//        
//        
//        // build the query param string using string builder first
//        StringBuilder requestUrl = new StringBuilder(objHashMapSignoutDELETETemp.get("str_signout_DELETE_url").toString()).append("?");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_signout_DELETE_response_payload_key_emailid") + "=");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_signout_DELETE_response_payload_value_emailid"));
//        requestUrl.append("&");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_session_key") + "=");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_session_value"));
//        String url                 = requestUrl.toString();
//
//        // setup connection
//        // set wrong expected media type e.g. sml
//        ResteasyWebTarget target   = setup_Connection_General_special(url,MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML);
//        // call method
//		Response response          = null;
//        try {response = target.request().delete();}
//        catch (ProcessingException e){System.out.println("Web application is not running.");return;}
//        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject     = null;

        if (null == strContentTypeOfResponse){
            System.out.println("Raw response is : " + strContentTypeOfResponse);
            return;
        }

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                         = parse_StringResponse(responseInString);
            System.out.println(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key1").toString()+":"+jsonobject.get(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key1").toString()));
            System.out.println(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key2").toString()+":"+jsonobject.get(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key2").toString())); 
            System.out.println(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key3").toString()+":"+jsonobject.get(objHashMapSignoutDELETETemp.get("str_signout_DELETE_response_key3").toString()) );
            
            // during successful sign out set the session id / value to empty
            objHashMapBasicUserDetailsTemp.put("str_basic_account_session_value","");
            objHashMapBasicUserDetailsTemp.put("str_basic_account_latest_session_value","");
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }

    private void GET_basic_account_profile_detail(HashMap<String,Object> objHashMapBasicUserDetailsTemp,HashMap<String,Object> objHashMapGetAccountProfileDetailGETTemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");
        if(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_value").toString().isEmpty()){
            System.out.println("This test can not be performed as latest session value is empty.");
            return;
        }

        // build the query param string using string builder first
        StringBuilder requestUrl = new StringBuilder(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_url").toString()).append("?");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_emailid") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_emailid"));
        requestUrl.append("&");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_password") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_password"));
        requestUrl.append("&");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_key") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_value"));
        String url                 = requestUrl.toString();

        HttpGet httpGet                            = new HttpGet(url);
        HttpUriRequest corerequest                 = setup_Connection_General(url, httpGet);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        
        
        
        
        
        
//        // build the query param string using string builder first
//        StringBuilder requestUrl = new StringBuilder(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_url").toString()).append("?");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_emailid") + "=");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_emailid"));
//        requestUrl.append("&");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_password") + "=");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_password"));
//        requestUrl.append("&");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_key") + "=");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_value"));
//        String url                 = requestUrl.toString();
//
//        // setup connection
//        ResteasyWebTarget target   = setup_Connection_General(url);
//        // call method
//		Response response          = null;
//        try {response = target.request().get();}
//        catch (ProcessingException e){System.out.println("Web application is not running.");return;}
//        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject     = null;

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                         = parse_StringResponse(responseInString);
            JSONObject jsonobject_internal     = null;

            System.out.println(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key1").toString()+":"+jsonobject.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key1").toString()));
            System.out.println(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key2").toString()+":"+jsonobject.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key2").toString())); 
            System.out.println(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key3").toString()+":");
            jsonobject_internal     = (JSONObject) jsonobject.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key3").toString());

            System.out.println("     "+ objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_emailid").toString()       +":"+jsonobject_internal.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_emailid")));
            System.out.println("     "+ objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_firstname").toString()       +":"+jsonobject_internal.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_firstname")));
            System.out.println("     "+ objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_lastname").toString()       +":"+jsonobject_internal.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_lastname")));
            System.out.println("     "+ objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_gender").toString()       +":"+jsonobject_internal.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_gender")));
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }

    private void GET_basic_account_profile_detail_special(HashMap<String,Object> objHashMapBasicUserDetailsTemp,HashMap<String,Object> objHashMapGetAccountProfileDetailGETTemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");
        if(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_value").toString().isEmpty()){
            System.out.println("This test can not be performed as latest session value is empty.");
            return;
        }

        // build the query param string using string builder first
        StringBuilder requestUrl = new StringBuilder(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_url").toString()).append("?");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_emailid") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_emailid"));
        requestUrl.append("&");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_password") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_password"));
        requestUrl.append("&");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_key") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_value"));
        String url                 = requestUrl.toString();

        HttpGet httpGet                            = new HttpGet(url);
        HttpUriRequest corerequest                 = setup_Connection_General_special(url, httpGet, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        
        
        
        
        
//        // build the query param string using string builder first
//        StringBuilder requestUrl = new StringBuilder(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_url").toString()).append("?");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_emailid") + "=");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_emailid"));
//        requestUrl.append("&");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_password") + "=");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_password"));
//        requestUrl.append("&");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_key") + "=");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_value"));
//        String url                 = requestUrl.toString();
//        
//        // setup connection
//        // set wrong content type e.g. xml
//        ResteasyWebTarget target   = setup_Connection_General_special(url,MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON);
//        // call method
//		Response response          = null;
//        try {response = target.request().get();}
//        catch (ProcessingException e){System.out.println("Web application is not running.");return;}
//        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject     = null;

        if (null == strContentTypeOfResponse){
            System.out.println("Raw response is : " + responseInString);
            return;
        }

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                         = parse_StringResponse(responseInString);
            JSONObject jsonobject_internal     = null;

            System.out.println(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key1").toString()+":"+jsonobject.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key1").toString()));
            System.out.println(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key2").toString()+":"+jsonobject.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key2").toString())); 
            System.out.println(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key3").toString()+":");
            jsonobject_internal     = (JSONObject) jsonobject.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_response_key3").toString());

            System.out.println("     "+ objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_emailid").toString()       +":"+jsonobject_internal.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_emailid")));
            System.out.println("     "+ objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_firstname").toString()       +":"+jsonobject_internal.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_firstname")));
            System.out.println("     "+ objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_lastname").toString()       +":"+jsonobject_internal.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_lastname")));
            System.out.println("     "+ objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_gender").toString()       +":"+jsonobject_internal.get(objHashMapGetAccountProfileDetailGETTemp.get("str_getaccountprofiledetail_GET_key_gender")));
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }
    
    private void PUT_modify_basic_account_profile_detail(HashMap<String,Object> objHashMapBasicUserDetailsTemp, HashMap<String,Object> objHashMapModifyAccountProfileDetailPUTTemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");
        String url                 = objHashMapModifyAccountProfileDetailPUTTemp.get("str_modifyaccountprofiledetail_PUT_url").toString();

        HttpPut httpPut                            = new HttpPut(url);
        List<NameValuePair> urlParameters          = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_key_emailid").toString(),
        											objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_value_emailid").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_key_firstname").toString(),
													objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_value_firstname").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_key_lastname").toString(),
													objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_value_lastname").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_key_gender").toString(),
													objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_value_gender").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_key_password").toString(),
													objHashMapBasicUserDetailsTemp.get("str_modifyaccountprofiledetail_PUT_response_payload_value_password").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_key").toString(),
													objHashMapBasicUserDetailsTemp.get("str_basic_account_latest_session_value").toString()));
        
        HttpEntity postParams                      = new UrlEncodedFormEntity(urlParameters);
        httpPut.setEntity(postParams);
        
        HttpUriRequest corerequest                 = setup_Connection_POST(url, httpPut);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        
        
        
        
//        Map<String,Object> params = new LinkedHashMap<>();
//        params.put(objHashMapBasicUserDetailsTemp.get("").toString(),
//                   objHashMapBasicUserDetailsTemp.get("").toString());
//        params.put(objHashMapBasicUserDetailsTemp.get("").toString(),
//                   objHashMapBasicUserDetailsTemp.get("").toString());
//        params.put(objHashMapBasicUserDetailsTemp.get("").toString(),
//                   objHashMapBasicUserDetailsTemp.get("").toString());
//        params.put(objHashMapBasicUserDetailsTemp.get("").toString(),
//                   objHashMapBasicUserDetailsTemp.get("").toString());
//        params.put(objHashMapBasicUserDetailsTemp.get("").toString(),
//                   objHashMapBasicUserDetailsTemp.get("").toString());
//        params.put(objHashMapBasicUserDetailsTemp.get("").toString(),
//                       objHashMapBasicUserDetailsTemp.get("").toString());
//
//        StringBuilder postData     = new StringBuilder();
//        for (Map.Entry<String,Object> one_param : params.entrySet()) {
//            if (postData.length() != 0) 
//                postData.append('&');
//            postData.append(URLEncoder.encode(one_param.getKey(), "UTF-8"));
//            postData.append('=');
//            postData.append(URLEncoder.encode(String.valueOf(one_param.getValue()), "UTF-8"));
//        }
//
//        byte[] postDataBytes     = postData.toString().getBytes("UTF-8");
//        // setup connection
//        ResteasyWebTarget target   = setup_Connection_POST(url);
//        // call method
//		Response response          = null;
//        try {response = target.request().put(Entity.entity(postDataBytes,MediaType.APPLICATION_FORM_URLENCODED));}
//        catch (ProcessingException e){System.out.println("Web application is not running.");return;}
//        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject               = null;

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                 = parse_StringResponse(responseInString);
            System.out.println(objHashMapModifyAccountProfileDetailPUTTemp.get("str_modifyaccountprofiledetail_PUT_response_key1").toString()+":"+jsonobject.get(objHashMapModifyAccountProfileDetailPUTTemp.get("str_modifyaccountprofiledetail_PUT_response_key1").toString()));
            System.out.println(objHashMapModifyAccountProfileDetailPUTTemp.get("str_modifyaccountprofiledetail_PUT_response_key2").toString()+":"+jsonobject.get(objHashMapModifyAccountProfileDetailPUTTemp.get("str_modifyaccountprofiledetail_PUT_response_key2").toString())); 
            System.out.println(objHashMapModifyAccountProfileDetailPUTTemp.get("str_modifyaccountprofiledetail_PUT_response_key3").toString()+":"+jsonobject.get(objHashMapModifyAccountProfileDetailPUTTemp.get("str_modifyaccountprofiledetail_PUT_response_key3").toString()) );
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }

    private void GET_forget_password_get_secret_question(HashMap<String,Object> objHashMapBasicUserDetailsTemp,HashMap<String,Object> objHashMapForgetPasswordGetSecretQuestionGETTemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");

        // build the query param string using string builder first
        StringBuilder requestUrl = new StringBuilder(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_url").toString()).append("?");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_emailid") + "=");
        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_emailid"));
        String url                 = requestUrl.toString();

        HttpGet httpGet                            = new HttpGet(url);
        HttpUriRequest corerequest                 = setup_Connection_General(url, httpGet);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        
        
//        // build the query param string using string builder first
//        StringBuilder requestUrl = new StringBuilder(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_url").toString()).append("?");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_key_emailid") + "=");
//        requestUrl.append(objHashMapBasicUserDetailsTemp.get("str_getaccountprofiledetail_GET_response_payload_value_emailid"));
//        String url                 = requestUrl.toString();
//
//        // setup connection
//        ResteasyWebTarget target   = setup_Connection_General(url);
//        // call method
//		Response response          = null;
//        try {response = target.request().get();}
//        catch (ProcessingException e){System.out.println("Web application is not running.");return;}
//        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject     = null;

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                         = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                         = parse_StringResponse(responseInString);
            JSONObject jsonobject_internal     = null;

            System.out.println(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_response_key1").toString()+":"+jsonobject.get(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_response_key1").toString()));
            System.out.println(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_response_key2").toString()+":"+jsonobject.get(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_response_key2").toString())); 
            System.out.println(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_response_key3").toString()+":");
            jsonobject_internal     = (JSONObject) jsonobject.get(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_response_key3").toString());

            System.out.println("     "+ objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_key_question1").toString()       +":"+jsonobject_internal.get(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_key_question1")));
            System.out.println("     "+ objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_key_question2").toString()       +":"+jsonobject_internal.get(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_key_question2")));
            
            // insert secret question in basic user hashmap variable
            objHashMapBasicUserDetailsTemp.put("str_signup_POST_response_payload_value_secret_question_1",jsonobject.get(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_key_question1").toString()));
            objHashMapBasicUserDetailsTemp.put("str_signup_POST_response_payload_value_secret_question_2",jsonobject.get(objHashMapForgetPasswordGetSecretQuestionGETTemp.get("str_forgetpasswordgetsecretquestion_GET_key_question2").toString()));
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }
    
    private void PUT_reset_password(HashMap<String,Object> objHashMapBasicUserDetailsTemp, HashMap<String,Object> objHashMapResetPasswordPUTTemp, HashMap<String,Object> objHashMapErrorRespTemp) throws Exception {

        System.out.println("----------------------------------------------------------------------------");
        String url                 = objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_url").toString();

        HttpPut httpPut                            = new HttpPut(url);
        List<NameValuePair> urlParameters          = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_resetpassword_PUT_response_payload_key_emailid").toString(),
        											objHashMapBasicUserDetailsTemp.get("str_resetpassword_PUT_response_payload_value_emailid").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_forgetpassword_PUT_response_payload_key_secret_question_answer_1").toString(),
													objHashMapBasicUserDetailsTemp.get("str_forgetpassword_PUT_response_payload_value_secret_question_answer_1").toString()));
        urlParameters.add(new BasicNameValuePair (	objHashMapBasicUserDetailsTemp.get("str_forgetpassword_PUT_response_payload_key_secret_question_answer_2").toString(),
													objHashMapBasicUserDetailsTemp.get("str_forgetpassword_PUT_response_payload_value_secret_question_answer_2").toString()));
        
        HttpEntity postParams                      = new UrlEncodedFormEntity(urlParameters);
        httpPut.setEntity(postParams);
        
        HttpUriRequest corerequest                 = setup_Connection_POST(url, httpPut);
        CloseableHttpClient closablehttpClient     = HttpClients.createDefault();
        CloseableHttpResponse closablehttpResponse = null;
        
        // set up connection and call method
        try {closablehttpResponse = closablehttpClient.execute(corerequest);}
        catch (HttpHostConnectException e){System.out.println("Web application is not running.");return;}
        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        
//        Map<String,Object> params = new LinkedHashMap<>();
//        params.put(objHashMapBasicUserDetailsTemp.get("str_resetpassword_PUT_response_payload_key_emailid").toString(),
//                   objHashMapBasicUserDetailsTemp.get("str_resetpassword_PUT_response_payload_value_emailid").toString());
//        params.put(objHashMapBasicUserDetailsTemp.get("str_forgetpassword_PUT_response_payload_key_secret_question_answer_1").toString(),
//                   objHashMapBasicUserDetailsTemp.get("str_forgetpassword_PUT_response_payload_value_secret_question_answer_1").toString());
//        params.put(objHashMapBasicUserDetailsTemp.get("str_forgetpassword_PUT_response_payload_key_secret_question_answer_2").toString(),
//                   objHashMapBasicUserDetailsTemp.get("str_forgetpassword_PUT_response_payload_value_secret_question_answer_2").toString());
//
//        StringBuilder postData     = new StringBuilder();
//        for (Map.Entry<String,Object> one_param : params.entrySet()) {
//            if (postData.length() != 0) 
//                postData.append('&');
//            postData.append(URLEncoder.encode(one_param.getKey(), "UTF-8"));
//            postData.append('=');
//            postData.append(URLEncoder.encode(String.valueOf(one_param.getValue()), "UTF-8"));
//        }
//
//        byte[] postDataBytes     = postData.toString().getBytes("UTF-8");
//        // setup connection
//        ResteasyWebTarget target   = setup_Connection_POST(url);
//        // call method
//		Response response          = null;
//        try {response = target.request().put(Entity.entity(postDataBytes,MediaType.APPLICATION_FORM_URLENCODED));}
//        catch (ProcessingException e){System.out.println("Web application is not running.");return;}
//        catch (Exception e1){System.out.println("Unknown exception while invoking this request."); e1.printStackTrace(); return;}
        
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
        // response handling
        BufferedReader reader = new BufferedReader(new InputStreamReader(closablehttpResponse.getEntity().getContent()));
        String inputLine      = "";
        StringBuffer response = new StringBuffer();
        while ((inputLine = reader.readLine()) != null) {response.append(inputLine);}
        reader.close();
        closablehttpClient.close();

		String responseInString             = response.toString();
		int responseCode                    = closablehttpResponse.getStatusLine().getStatusCode();
		String strContentTypeOfResponse     = closablehttpResponse.getEntity().getContentType().toString();
        System.out.println("Response Code               : HTTP " + responseCode);
        System.out.println("Content type of response is : " + strContentTypeOfResponse);
        JSONObject jsonobject               = null;

        if(! strContentTypeOfResponse.contains(MediaType.APPLICATION_JSON)){
            System.out.println("Content type of response expected is : " + MediaType.APPLICATION_JSON);
            System.out.println("Please check what is the issue from server side.");
            return;
        }

        if (responseCode >= 400 && responseCode < 500 ){
            // Client side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ClientSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode >= 500 && responseCode < 600 ){
            // Server side error handler
            // parsing the response and json conversion
            jsonobject                 = parse_StringResponse(responseInString);
            handle_ServerSideError(responseCode);
            handle_ErrorResponse(jsonobject,objHashMapErrorRespTemp);
            return;
        }

        if (responseCode == 200){
            System.out.println("\nFollowing success response received from web application.");
            jsonobject                 = parse_StringResponse(responseInString);
            System.out.println(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key1").toString()+":"+jsonobject.get(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key1").toString()));
            System.out.println(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key2").toString()+":"+jsonobject.get(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key2").toString())); 
            System.out.println(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key3").toString()+":"+jsonobject.get(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key3").toString()) );

            // insert new password in basic user hashmap variable
            objHashMapBasicUserDetailsTemp.put("str_signup_POST_response_payload_value_password",jsonobject.get(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key3").toString()));
            objHashMapBasicUserDetailsTemp.put("str_signin_POST_response_payload_value_password",jsonobject.get(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key3").toString()));
            objHashMapBasicUserDetailsTemp.put("str_getaccountprofiledetail_GET_response_payload_value_password",jsonobject.get(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key3").toString()));
            objHashMapBasicUserDetailsTemp.put("str_modifyaccountprofiledetail_PUT_response_payload_value_password",jsonobject.get(objHashMapResetPasswordPUTTemp.get("str_resetpassword_PUT_response_key3").toString()));
        }
        else{System.out.println("Following invalid HTTP code received : " + responseCode);}

        System.out.println("----------------------------------------------------------------------------");
    }


    
    
    
    // helper methods

    private static HashMap<String,Object> fill_SignupGET(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_signup_GET_url",                 "http://localhost:8080/imademethink/restfulapi/account_basic/signup");
        hMapLocal.put("str_signup_GET_method",                 "GET");
        hMapLocal.put("str_signup_GET_response_key1",         "Activity status");
        hMapLocal.put("str_signup_GET_response_key2",         "Additional message");
        hMapLocal.put("str_signup_GET_response_key3",         "Payload");

        hMapLocal.put("str_signup_GET_response_payload_key_emailid",         "signup_emailid");
        hMapLocal.put("str_signup_GET_response_payload_key_firstname",         "signup_firstname");
        hMapLocal.put("str_signup_GET_response_payload_key_lastname",         "signup_lastname");
        hMapLocal.put("str_signup_GET_response_payload_key_gender",         "signup_gender");
        hMapLocal.put("str_signup_GET_response_payload_key_password",         "signup_password");
        hMapLocal.put("str_signup_GET_response_payload_key_secret_question_1",             "signup_secret_question_1");
        hMapLocal.put("str_signup_GET_response_payload_key_secret_question_2",             "signup_secret_question_2");
        hMapLocal.put("str_signup_GET_response_payload_key_secret_question_answer_1",     "signup_secret_question_1_answer");
        hMapLocal.put("str_signup_GET_response_payload_key_secret_question_answer_2",     "signup_secret_question_2_answer");

        return hMapLocal;
    }

    private static HashMap<String,Object> fill_SignupPOST(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_signup_POST_url",                 "http://localhost:8080/imademethink/restfulapi/account_basic/signup");
        hMapLocal.put("str_signup_POST_method",             "POST");
        hMapLocal.put("str_signup_POST_response_key1",         "Activity status");
        hMapLocal.put("str_signup_POST_response_key2",         "Additional message");
        hMapLocal.put("str_signup_POST_response_key3",         "Payload");

        return hMapLocal;
    }
    
    private static HashMap<String,Object> fill_ActivateGET(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_activate_GET_url",                 "http://localhost:8080/imademethink/restfulapi/account_basic/activate");
        hMapLocal.put("str_activate_GET_method",             "GET");
        hMapLocal.put("str_activate_GET_response_key1",     "Activity status");
        hMapLocal.put("str_activate_GET_response_key2",     "Additional message");
        hMapLocal.put("str_activate_GET_response_key3",     "Payload");

        return hMapLocal;
    }    
    
    private static HashMap<String,Object> fill_SigninPOST(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_signin_POST_url",                 "http://localhost:8080/imademethink/restfulapi/account_basic/signin");
        hMapLocal.put("str_signin_POST_method",             "POST");
        hMapLocal.put("str_signin_POST_response_key1",         "Activity status");
        hMapLocal.put("str_signin_POST_response_key2",         "Additional message");
        hMapLocal.put("str_signin_POST_response_key3",         "Payload");

        return hMapLocal;
    }
    
    private static HashMap<String,Object> fill_SignoutDELETE(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_signout_DELETE_url",             "http://localhost:8080/imademethink/restfulapi/account_basic/signout");
        hMapLocal.put("str_signout_DELETE_method",             "DELETE");
        hMapLocal.put("str_signout_DELETE_response_key1",     "Activity status");
        hMapLocal.put("str_signout_DELETE_response_key2",     "Additional message");
        hMapLocal.put("str_signout_DELETE_response_key3",     "Payload");

        return hMapLocal;
    }
    
    private static HashMap<String,Object> fill_GetAccountProfileDetailGET(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_getaccountprofiledetail_GET_url",             "http://localhost:8080/imademethink/restfulapi/account_basic/get_account_profile_details");
        hMapLocal.put("str_getaccountprofiledetail_GET_method",         "GET");
        hMapLocal.put("str_getaccountprofiledetail_GET_response_key1",     "Activity status");
        hMapLocal.put("str_getaccountprofiledetail_GET_response_key2",     "Additional message");
        hMapLocal.put("str_getaccountprofiledetail_GET_response_key3",     "Payload");

        hMapLocal.put("str_getaccountprofiledetail_GET_key_emailid",         "Basic account: email id");
        hMapLocal.put("str_getaccountprofiledetail_GET_key_firstname",         "Basic account: first name");
        hMapLocal.put("str_getaccountprofiledetail_GET_key_lastname",         "Basic account: last name");
        hMapLocal.put("str_getaccountprofiledetail_GET_key_gender",         "Basic account: gender");

        return hMapLocal;
    }    
    
    private static HashMap<String,Object> fill_ModifyAccountProfileDetailPUT(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_url",             "http://localhost:8080/imademethink/restfulapi/account_basic/modify_account_profile_details");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_method",             "PUT");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_key1",     "Activity status");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_key2",     "Additional message");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_key3",     "Payload");

        return hMapLocal;
    }

    private static HashMap<String,Object> fill_ForgetPasswordGetSecretQuestionGET(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_forgetpasswordgetsecretquestion_GET_url",             "http://localhost:8080/imademethink/restfulapi/account_basic/forget_password_get_secret_question");
        hMapLocal.put("str_forgetpasswordgetsecretquestion_GET_method",         "GET");
        hMapLocal.put("str_forgetpasswordgetsecretquestion_GET_response_key1",     "Activity status");
        hMapLocal.put("str_forgetpasswordgetsecretquestion_GET_response_key2",     "Additional message");
        hMapLocal.put("str_forgetpasswordgetsecretquestion_GET_response_key3",     "Payload");

        hMapLocal.put("str_forgetpasswordgetsecretquestion_GET_key_question1",     "Basic account: secret question 1");
        hMapLocal.put("str_forgetpasswordgetsecretquestion_GET_key_question2",     "Basic account: secret question 2");

        return hMapLocal;
    }

    private static HashMap<String,Object> fill_ResetPasswordPUT(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_resetpassword_PUT_url",                 "http://localhost:8080/imademethink/restfulapi/account_basic/reset_password");
        hMapLocal.put("str_resetpassword_PUT_method",             "PUT");
        hMapLocal.put("str_resetpassword_PUT_response_key1",     "Activity status");
        hMapLocal.put("str_resetpassword_PUT_response_key2",     "Additional message");
        hMapLocal.put("str_resetpassword_PUT_response_key3",     "Payload");

        return hMapLocal;
    }
    
    private static HashMap<String,Object> fill_BasicUserDetails(String strTempEmailId, String strTempPassword){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_signup_POST_response_payload_key_emailid",                                 "signup_emailid");
        hMapLocal.put("str_signup_POST_response_payload_value_emailid",                             strTempEmailId);
        hMapLocal.put("str_signin_POST_response_payload_key_emailid",                                 "signin_emailid");
        hMapLocal.put("str_signin_POST_response_payload_value_emailid",                             strTempEmailId);
        hMapLocal.put("str_signout_DELETE_response_payload_key_emailid",                            "signout_emailid");
        hMapLocal.put("str_signout_DELETE_response_payload_value_emailid",                             strTempEmailId);
        hMapLocal.put("str_getaccountprofiledetail_GET_response_payload_key_emailid",                 "signin_emailid");
        hMapLocal.put("str_getaccountprofiledetail_GET_response_payload_value_emailid",             strTempEmailId);
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_key_emailid",             "signin_emailid");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_value_emailid",             strTempEmailId);
        hMapLocal.put("str_resetpassword_PUT_response_payload_key_emailid",                         "signup_emailid");
        hMapLocal.put("str_resetpassword_PUT_response_payload_value_emailid",                         strTempEmailId);

        hMapLocal.put("str_signup_POST_response_payload_key_password",                                 "signup_password");
        hMapLocal.put("str_signup_POST_response_payload_value_password",                             strTempPassword);
        hMapLocal.put("str_signin_POST_response_payload_key_password",                                 "signin_password");
        hMapLocal.put("str_signin_POST_response_payload_value_password",                             strTempPassword);
        hMapLocal.put("str_getaccountprofiledetail_GET_response_payload_key_password",                 "signin_password");
        hMapLocal.put("str_getaccountprofiledetail_GET_response_payload_value_password",             strTempPassword);
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_key_password",             "signin_password");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_value_password",         strTempPassword);

        hMapLocal.put("str_signup_POST_response_payload_key_firstname",                             "signup_firstname");
        hMapLocal.put("str_signup_POST_response_payload_value_firstname",                             "Sheldon");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_key_firstname",             "signin_firstname");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_value_firstname",         "Sheldon");

        hMapLocal.put("str_signup_POST_response_payload_key_lastname",                                 "signup_lastname");
        hMapLocal.put("str_signup_POST_response_payload_value_lastname",                             "Cooper");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_key_lastname",             "signin_lastname");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_value_lastname",         "Cooper");

        hMapLocal.put("str_signup_POST_response_payload_key_gender",                                 "signup_gender");
        hMapLocal.put("str_signup_POST_response_payload_value_gender",                                 "m");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_key_gender",             "signin_gender");
        hMapLocal.put("str_modifyaccountprofiledetail_PUT_response_payload_value_gender",             "m");

        hMapLocal.put("str_signup_POST_response_payload_key_secret_question_1",                     "signup_secret_question_1");
        hMapLocal.put("str_signup_POST_response_payload_value_secret_question_1",                     "What is the brand of your toothpaste");
        hMapLocal.put("str_signup_POST_response_payload_key_secret_question_2",                     "signup_secret_question_2");
        hMapLocal.put("str_signup_POST_response_payload_value_secret_question_2",                     "What was the name of your babysitter");

        hMapLocal.put("str_signup_POST_response_payload_key_secret_question_answer_1",                 "signup_secret_question_1_answer");
        hMapLocal.put("str_signup_POST_response_payload_value_secret_question_answer_1",            "Pune");
        hMapLocal.put("str_forgetpassword_PUT_response_payload_key_secret_question_answer_1",         "signup_secret_question_1_answer");
        hMapLocal.put("str_forgetpassword_PUT_response_payload_value_secret_question_answer_1",        "Pune");
        hMapLocal.put("str_signup_POST_response_payload_key_secret_question_answer_2",                 "signup_secret_question_2_answer");
        hMapLocal.put("str_signup_POST_response_payload_value_secret_question_answer_2",            "Toystory");
        hMapLocal.put("str_forgetpassword_PUT_response_payload_key_secret_question_answer_2",         "signup_secret_question_2_answer");
        hMapLocal.put("str_forgetpassword_PUT_response_payload_value_secret_question_answer_2",        "Toystory");

        // other user details
        hMapLocal.put("str_basic_account_activation_key",                     "account_basic_activatation_key");
        hMapLocal.put("str_basic_account_activation_value",                 "");
        
        hMapLocal.put("str_basic_account_session_key",                         "session_id");
        hMapLocal.put("str_basic_account_session_value",                     "");
        
        hMapLocal.put("str_basic_account_latest_session_key",                 "latest_session_key");
        hMapLocal.put("str_basic_account_latest_session_value",             "");

        return hMapLocal;
    }

    private static HashMap<String,Object> fill_ErrorResponse(){
        HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
        hMapLocal.put("str_key_ErrorMessage",         "Error message");
        hMapLocal.put("str_key_ExceptionType",         "Exception type");
        hMapLocal.put("str_key_InternalErrorCode",     "Internal error code");

        return hMapLocal;
    }    
    
    // helper methods general

    private HttpUriRequest setup_Connection_General(String urlTemp, HttpUriRequest corerequest){
      HttpUriRequest corerequestlocal = corerequest;
      corerequest.setHeader("User-Agent", "Mozilla/5.0");
      corerequest.setHeader("Content-Type", MediaType.APPLICATION_JSON);
      corerequest.setHeader("Accept", MediaType.APPLICATION_JSON);
      corerequest.setHeader("Connection", "keep-alive");

      return corerequestlocal;
    }
    
    private HttpUriRequest setup_Connection_General_special(String urlTemp, HttpUriRequest corerequest,String mediatypeContent, String mediatypeResponse){
        HttpUriRequest corerequestlocal = corerequest;
        corerequest.setHeader("User-Agent", "Mozilla/5.0");
        corerequest.setHeader("Content-Type", mediatypeContent);
        corerequest.setHeader("Accept", mediatypeResponse);
        corerequest.setHeader("Connection", "keep-alive");

        return corerequestlocal;
    }
 
    private HttpUriRequest setup_Connection_POST(String urlTemp, HttpUriRequest corerequest){
	    HttpUriRequest corerequestlocal = corerequest;
	    corerequest.setHeader("User-Agent", "Mozilla/5.0");
	    corerequest.setHeader("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);
	    corerequest.setHeader("Accept", MediaType.APPLICATION_JSON);
	    corerequest.setHeader("Connection", "keep-alive");
	
	    return corerequestlocal;
    }

    
    private void handle_ClientSideError(int nResponseCodeTemp){
        if (400 ==  nResponseCodeTemp)        System.out.println("ERROR     : This is a bad request.");
        if (404 ==  nResponseCodeTemp)        System.out.println("ERROR     : This page / resource is not found.");
        if (401 ==  nResponseCodeTemp)        System.out.println("ERROR     : This request is not authorized.");
        if (403 ==  nResponseCodeTemp)        System.out.println("ERROR     : This request is not forbidded.");
    }
    
    private void handle_ServerSideError(int nResponseCodeTemp){
        if (500 ==  nResponseCodeTemp)        System.out.println("ERROR     : Internal server error.");
        if (503 ==  nResponseCodeTemp)        System.out.println("ERROR     : Service unavailable or some maintenance is going on.");
    }
    
    private void handle_ErrorResponse(JSONObject jsonobjectTemp,HashMap<String,Object> objHashMapErrorRespTemp){
        System.out.println("\nFollowing error response received: ");
        System.out.println(objHashMapErrorRespTemp.get("str_key_ErrorMessage").toString()      +":"+jsonobjectTemp.get(objHashMapErrorRespTemp.get("str_key_ErrorMessage").toString()));
        System.out.println(objHashMapErrorRespTemp.get("str_key_ExceptionType").toString()     +":"+jsonobjectTemp.get(objHashMapErrorRespTemp.get("str_key_ExceptionType").toString()));
        System.out.println(objHashMapErrorRespTemp.get("str_key_InternalErrorCode").toString() +":"+jsonobjectTemp.get(objHashMapErrorRespTemp.get("str_key_InternalErrorCode").toString()));
    }
    
    private JSONObject parse_StringResponse(String responseInString) throws Exception{
        // parsing the response and json conversion
        JSONParser parser                 = new JSONParser();
        Object object                     = parser.parse(responseInString);

        JSONObject jsonobject             = (JSONObject) object;
        
        return jsonobject;
    }

	
	
}
