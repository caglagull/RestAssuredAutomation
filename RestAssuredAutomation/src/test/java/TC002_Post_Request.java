import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_Post_Request {
	@Test
	void LoginSuccessful() {
		RestAssured.baseURI="https://www.trendyol.com/butik/liste/kadin?e=login";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Request payload sending along with post request
		
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("email","eda_gul_94@hotmail.com");
		requestParams.put("passsword","XYZ123");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		//Response object
		Response response=httpRequest.request(Method.GET,"/Login");
		
		//print response in console
		String responseBody=response.getBody().asString();
		System.out.println("Response body is:"+responseBody);
		
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("status code is:"+statusCode);
		
		Assert.assertEquals(statusCode,200);
		
		//status line verification
		String statusLine=response.getStatusLine();
		System.out.println("Status line is"+statusLine);
		Assert.assertEquals(statusLine , "HTTP/1.1 200 OK");
		
		//successcode validation
		String successCode=response.jsonPath().get("SuccessCode");
		
		Assert.assertEquals(successCode,"OPERATION_SUCCESS");
		
		
		
	}
}
