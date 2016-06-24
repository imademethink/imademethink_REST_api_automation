package com.imademethink_test.jerseyclient;

import java.io.StringReader;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Form;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

public class Test_using_jerseyclient {

	String strEmailId  						= "hk48@hk.com";
	String strPassword 						= "aaaaaaA0";	
	HashMap<String,Object> objHM_UserDetails 	= fill_UserDetail(strEmailId, strPassword);

	public Test_using_jerseyclient(){};
	
	public static void main(String[] args) {
		
		Test_using_jerseyclient objTestUsingJerseyClient = new Test_using_jerseyclient();

//		DELETE 	sign out
//				http://localhost:8080/imademethink/restfulapi/signout

		System.out.println("\n\nINFO:     Startign scenarion 1");

		objTestUsingJerseyClient.test123();
		
//		if(! objTestUsingJerseyClient.GET_signup_related_param()){								System.out.println("Following step failed: " + "GET_signup_related_param");}
//		if(! objTestUsingJerseyClient.POST_signup_with_correct_form_parameter()){				System.out.println("Following step failed: " + "POST_signup_with_correct_form_parameter");}
//		if(! objTestUsingJerseyClient.GET_activate_user()){										System.out.println("Following step failed: " + "GET_activate_with_user");}
//		if(! objTestUsingJerseyClient.POST_signin_registered_user()){							System.out.println("Following step failed: " + "POST_signin_registered_user");}

		
		
		
	}
	
	public boolean test123(){
		String signupurl = "http://localhost:8080/imademethink/restfulapi/account_basic/signup";
		
		System.out.println("DEBUG:    1");
		Client client = ClientBuilder.newBuilder().build();
		
		System.out.println("DEBUG:    2");
		WebTarget target = client.target(signupurl);
		
		System.out.println("DEBUG:    3");
		@SuppressWarnings("unused")
		Response response = target.request().get();
		
//		System.out.println("DEBUG:    4");
//		String users = response.readEntity(String.class);
		
		System.out.println("DEBUG:    5");
		return true;
	}
	
	public boolean GET_signup_related_param(){	
		
		System.out.println("\n\n=======================================================================");
		System.out.println("INFO:     Step - Raising GET request to get signup parameters.");
		
		System.out.println("DEBUG:    Init Jersey client.");
		Client client 				= ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );

		System.out.println("DEBUG:    Assign web target.");

		WebTarget webTarget 		= client.target("http://localhost:8080/imademethink/restfulapi/account_basic/signup");
		Invocation.Builder invocationBuilder 
									= webTarget.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		System.out.println("DEBUG:    Hit http get request and receive response from web application.");
		Response response           = invocationBuilder.get();

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		// response validation - media type
		MediaType objMediaType 		= response.getMediaType();
		System.out.println("DEBUG:    Response media type is: " + objMediaType.toString());
		if(! objMediaType.toString().contains(MediaType.APPLICATION_JSON)){
			System.out.println("ERROR:    This is unsupported media type.");
			return false;
		}

		// response validation - http response code
		int nHttpResponseCode 		= response.getStatus();
		System.out.println("DEBUG:    Response code for this request is: " + nHttpResponseCode);
		System.out.println("DEBUG:    Response code for this request in words is: " + response.getStatusInfo());
		
		if (nHttpResponseCode>= 400 && nHttpResponseCode <= 499){
			// handle client side error
			System.out.println("ERROR:    Client side error observed.");
			// handle_ClientSideError(nHttpResponseCode);
			// handle_ErrorResponse(nHttpResponseCode,response.readEntity(String.class).toString());
			return false;
		}
		
		if (nHttpResponseCode>= 500 && nHttpResponseCode <= 599){
			// handle server side error
			System.out.println("ERROR:    Server side error observed.");
			// handle_ServerSideError(nHttpResponseCode);
			return false;
		}
		
		if (nHttpResponseCode!= 200){
			// handle undesired error code
			System.out.println("DEBUG:    This is undesired http response code. Need to analyse more.");
			// handle_ServerSideError(nHttpResponseCode);
			// handle_ErrorResponse(nHttpResponseCode,response.readEntity(String.class).toString());
			return false;
		}

		String strStringResponseinJson
									= response.readEntity(String.class).toString();
		StringReader strStringReaderFromJson
									= new StringReader(strStringResponseinJson);
	    JsonReader objJsonReader 	= Json.createReader(strStringReaderFromJson);
 		JsonObject obj_json 		= objJsonReader.readObject();
 		
		System.out.println("\nDEBUG:    Following json response received.");
 		System.out.println("Activity status: "       +  obj_json.get("Activity status"));
 		System.out.println("Additional message: "    +  obj_json.get("Additional message"));
 		
 		System.out.println("Payload: ");
 		JsonObject obj_json_Payload = obj_json.getJsonObject("Payload");

 		System.out.println("     signup_emailid:"    +  obj_json_Payload.get("signup_emailid"));
 		System.out.println("     signup_password:"   +  obj_json_Payload.get("signup_password"));
 		System.out.println("     signup_firstname:"  +  obj_json_Payload.get("signup_firstname"));
 		System.out.println("     signup_lastname:"   +  obj_json_Payload.get("signup_lastname"));
 		System.out.println("     signup_gender:"   +  obj_json_Payload.get("signup_gender"));
 		System.out.println("     signup_secret_question_1:"   +  obj_json_Payload.get("signup_secret_question_1"));
 		System.out.println("     signup_secret_question_2:"   +  obj_json_Payload.get("signup_secret_question_2"));
 		System.out.println("     signup_secret_question_1_answer:"   +  obj_json_Payload.get("signup_secret_question_1_answer"));
 		System.out.println("     signup_secret_question_2_answer:"   +  obj_json_Payload.get("signup_secret_question_2_answer"));

 		System.out.println("Links: ");
 		JsonObject obj_json_Links = obj_json.getJsonObject("Links");
 		System.out.println("     Link documentation:"    +  obj_json_Links.get("Link documentation"));
 		System.out.println("     Actual signup:"         +  obj_json_Links.get("Actual signup"));
 		
 		// close jersey client
 		client.close();
		System.out.println("=======================================================================");
 		return true;
	}

	public boolean POST_signup_with_correct_form_parameter(){
		System.out.println("\n\n=======================================================================");
		System.out.println("INFO:     Step - Raising POST request to signup actually.");

		System.out.println("DEBUG:    Init Jersey client.");
		Client client 				= ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );

		System.out.println("DEBUG:    Assign web target.");
		WebTarget webTarget 		= client.target("http://localhost:8080/imademethink/restfulapi/account_basic/signup");

		Form form = new Form();
		form.param("signup_emailid", 					objHM_UserDetails.get("signup_emailid").toString());
		form.param("signup_password", 					objHM_UserDetails.get("signup_password").toString());
		form.param("signup_firstname", 					objHM_UserDetails.get("signup_firstname").toString());
		form.param("signup_lastname", 					objHM_UserDetails.get("signup_lastname").toString());
		form.param("signup_gender", 					objHM_UserDetails.get("signup_gender").toString());
		form.param("signup_secret_question_1", 			objHM_UserDetails.get("signup_secret_question_1").toString());
		form.param("signup_secret_question_2", 			objHM_UserDetails.get("signup_secret_question_2").toString());
		form.param("signup_secret_question_1_answer", 	objHM_UserDetails.get("signup_secret_question_1_answer").toString());
		form.param("signup_secret_question_2_answer", 	objHM_UserDetails.get("signup_secret_question_2_answer").toString());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON);

		System.out.println("DEBUG:    Hit http post request and receive response from web application.");
		Response response                    = invocationBuilder.post(Entity.form(form));

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		// response validation - media type
		MediaType objMediaType 		= response.getMediaType();
		System.out.println("DEBUG:    Response media type is: " + objMediaType.toString());
		if(! objMediaType.toString().contains(MediaType.APPLICATION_JSON)){
			System.out.println("ERROR:    This is unsupported media type.");
			return false;
		}

		// response validation - http response code
		int nHttpResponseCode 		= response.getStatus();
		System.out.println("DEBUG:    Response code for this request is: " + nHttpResponseCode);
		System.out.println("DEBUG:    Response code for this request in words is: " + response.getStatusInfo());
		
		if (nHttpResponseCode>= 400 && nHttpResponseCode <= 499){
			// handle client side error
			System.out.println("ERROR:    Client side error observed.");
			// handle_ClientSideError(nHttpResponseCode);
			//handle_ErrorResponse(nHttpResponseCode,response.readEntity(String.class).toString());
			return false;
		}
		
		if (nHttpResponseCode>= 500 && nHttpResponseCode <= 599){
			// handle server side error
			System.out.println("ERROR:    Server side error observed.");
			// handle_ServerSideError(nHttpResponseCode);
			// handle_ErrorResponse(nHttpResponseCode,response.readEntity(String.class).toString());
			return false;
		}
		
		if (nHttpResponseCode!= 201){
			// handle undesired error code
			System.out.println("DEBUG:    This is undesired http response code. Need to analyse more.");
			// handle_ServerSideError(nHttpResponseCode);
			return false;
		}

		String strStringResponseinJson
									= response.readEntity(String.class).toString();
		StringReader strStringReaderFromJson
									= new StringReader(strStringResponseinJson);
	    JsonReader objJsonReader 	= Json.createReader(strStringReaderFromJson);
 		JsonObject obj_json 		= objJsonReader.readObject();

		System.out.println("\nDEBUG:    Following json response received.");
 		System.out.println("Activity status: "       +  obj_json.get("Activity status").toString());
 		System.out.println("Additional message: "    +  obj_json.get("Additional message").toString());
 		System.out.println("Payload: "               +  obj_json.get("Payload").toString());
 		
 		System.out.println("Links: ");
 		JsonObject obj_json_Links = obj_json.getJsonObject("Links");
 		System.out.println("     Account activation link:"    +  obj_json_Links.get("Account activation link"));
 		System.out.println("     Link documentation:"         +  obj_json_Links.get("Link documentation"));

 		// save activation key
 		objHM_UserDetails.put("activation_key",obj_json.get("Payload").toString().replaceAll("\"", ""));

 		// close jersey client
 		client.close();
		System.out.println("=======================================================================");
 		return true;
	}

	public boolean GET_activate_user(){
		System.out.println("\n\n=======================================================================");
		System.out.println("INFO:     Step - Raising GET request to activate basic user account.");
		
		System.out.println("DEBUG:    Init Jersey client.");
		Client client 				= ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );

		System.out.println("DEBUG:    Cook query param in url and assign web target.");
		StringBuilder strbldrRequestUrl	 = new StringBuilder();
		strbldrRequestUrl.append("http://localhost:8080/imademethink/restfulapi/account_basic/activate");
		strbldrRequestUrl.append("?");
		strbldrRequestUrl.append("signup_emailid").append("=").append(objHM_UserDetails.get("signup_emailid").toString());
		strbldrRequestUrl.append("&");
		strbldrRequestUrl.append("account_basic_activatation_key").append("=").append(objHM_UserDetails.get("activation_key").toString());

		WebTarget webTarget 		= client.target(strbldrRequestUrl.toString());
		Invocation.Builder invocationBuilder
									= webTarget.request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		System.out.println("DEBUG:    Hit http get request and receive response from web application.");
		Response response           = invocationBuilder.get();

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		// response validation - media type
		MediaType objMediaType 		= response.getMediaType();
		System.out.println("DEBUG:    Response media type is: " + objMediaType.toString());
		if(! objMediaType.toString().contains(MediaType.APPLICATION_JSON)){
			System.out.println("ERROR:    This is unsupported media type.");
			return false;
		}

		// response validation - http response code
		int nHttpResponseCode 		= response.getStatus();
		System.out.println("DEBUG:    Response code for this request is: " + nHttpResponseCode);
		System.out.println("DEBUG:    Response code for this request in words is: " + response.getStatusInfo());
		
		if (nHttpResponseCode>= 400 && nHttpResponseCode <= 499){
			// handle client side error
			System.out.println("ERROR:    Client side error observed.");
			// handle_ClientSideError(nHttpResponseCode);
			// handle_ErrorResponse(nHttpResponseCode,response.readEntity(String.class).toString());
			return false;
		}
		
		if (nHttpResponseCode>= 500 && nHttpResponseCode <= 599){
			// handle server side error
			System.out.println("ERROR:    Server side error observed.");
			// handle_ServerSideError(nHttpResponseCode);
			//handle_ErrorResponse(nHttpResponseCode,response.readEntity(String.class).toString());
			return false;
		}
		
		if (nHttpResponseCode!= 200){
			// handle undesired error code
			System.out.println("DEBUG:    This is undesired http response code. Need to analyse more.");
			// handle_ServerSideError(nHttpResponseCode);
			return false;
		}

		String strStringResponseinJson
									= response.readEntity(String.class).toString();
		StringReader strStringReaderFromJson
									= new StringReader(strStringResponseinJson);
	    JsonReader objJsonReader 	= Json.createReader(strStringReaderFromJson);
 		JsonObject obj_json 		= objJsonReader.readObject();
 		
		System.out.println("\nDEBUG:    Following json response received.");
 		System.out.println("Activity status: "       +  obj_json.get("Activity status"));
 		System.out.println("Additional message: "    +  obj_json.get("Additional message"));
 		System.out.println("Payload: "               +  obj_json.get("Payload"));

 		System.out.println("Links: ");
 		JsonObject obj_json_Links = obj_json.getJsonObject("Links");
 		System.out.println("     Signin link:"                +  obj_json_Links.get("Signin link"));
 		System.out.println("     Link documentation:"         +  obj_json_Links.get("Link documentation"));

 		// close jersey client
 		client.close();
		System.out.println("=======================================================================");
 		return true;
	}
	
	public boolean POST_signin_registered_user(){
		System.out.println("\n\n=======================================================================");
		System.out.println("INFO:     Step - Raising POST request to signin registered user.");

		System.out.println("DEBUG:    Init Jersey client.");
		Client client 				= ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );

		System.out.println("DEBUG:    Assign web target.");
		WebTarget webTarget 		= client.target("http://localhost:8080/imademethink/restfulapi/account_basic/signin");

		Form form = new Form();
		form.param("signup_emailid", 					objHM_UserDetails.get("signup_emailid").toString());
		form.param("signup_password", 					objHM_UserDetails.get("signup_password").toString());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON);

		System.out.println("DEBUG:    Hit http post request and receive response from web application.");
		Response response                    = invocationBuilder.post(Entity.form(form));

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		// response validation - media type
		MediaType objMediaType 		= response.getMediaType();
		System.out.println("DEBUG:    Response media type is: " + objMediaType.toString());
		if(! objMediaType.toString().contains(MediaType.APPLICATION_JSON)){
			System.out.println("ERROR:    This is unsupported media type.");
			return false;
		}

		// response validation - http response code
		int nHttpResponseCode 		= response.getStatus();
		System.out.println("DEBUG:    Response code for this request is: " + nHttpResponseCode);
		System.out.println("DEBUG:    Response code for this request in words is: " + response.getStatusInfo());
		
		if (nHttpResponseCode>= 400 && nHttpResponseCode <= 499){
			// handle client side error
			System.out.println("ERROR:    Client side error observed.");
			//handle_ClientSideError(nHttpResponseCode);
			//handle_ErrorResponse(nHttpResponseCode,response.readEntity(String.class).toString());
			return false;
		}
		
		if (nHttpResponseCode>= 500 && nHttpResponseCode <= 599){
			// handle server side error
			System.out.println("ERROR:    Server side error observed.");
			// handle_ServerSideError(nHttpResponseCode);
			//handle_ErrorResponse(nHttpResponseCode,response.readEntity(String.class).toString());
			return false;
		}
		
		if (nHttpResponseCode!= 200){
			// handle undesired error code
			System.out.println("DEBUG:    This is undesired http response code. Need to analyse more.");
			// handle_ServerSideError(nHttpResponseCode);
			//handle_ErrorResponse(nHttpResponseCode,response.readEntity(String.class).toString());
			return false;
		}

		String strStringResponseinJson
									= response.readEntity(String.class).toString();
		StringReader strStringReaderFromJson
									= new StringReader(strStringResponseinJson);
	    JsonReader objJsonReader 	= Json.createReader(strStringReaderFromJson);
 		JsonObject obj_json 		= objJsonReader.readObject();

		System.out.println("\nDEBUG:    Following json response received.");
 		System.out.println("Activity status: "       +  obj_json.get("Activity status").toString());
 		System.out.println("Additional message: "    +  obj_json.get("Additional message").toString());
 		System.out.println("Payload: "               +  obj_json.get("Payload").toString());

		System.out.println("Links: ");
 		JsonObject obj_json_Links = obj_json.getJsonObject("Links");
 		System.out.println("     Signout link:"               +  obj_json_Links.get("Signout link"));
 		System.out.println("     Link documentation:"         +  obj_json_Links.get("Link documentation"));

 		// save session id
 		objHM_UserDetails.put("session_id",obj_json.get("Payload").toString().replaceAll("\"", ""));

 		// close jersey client
 		client.close();
		System.out.println("=======================================================================");
 		return true;
	}
	
	
	
	
	
	
	
	
	// helper methods
	public HashMap<String,Object> fill_UserDetail(String strEmailId, String strPassword){
		HashMap<String,Object> hMapLocal = new HashMap<String,Object>();
		hMapLocal.put("signup_emailid", 	strEmailId);
		hMapLocal.put("signup_password", 	strPassword);
		hMapLocal.put("signup_firstname", 	"Jignesh");
		hMapLocal.put("signup_lastname", 	"Sharma");		
		hMapLocal.put("signup_gender", 		"m");
		hMapLocal.put("signup_secret_question_1",			"What is the brand of your toothpaste");
		hMapLocal.put("signup_secret_question_2",			"What is your favorite mobile app");
		hMapLocal.put("signup_secret_question_1_answer", 	"toothpaste");
		hMapLocal.put("signup_secret_question_2_answer", 	"mobileapp");
		hMapLocal.put("activation_key", 	"");
		hMapLocal.put("session_id", 		"");

		return hMapLocal;
	}
	
	
	
	
	
	
	

}
