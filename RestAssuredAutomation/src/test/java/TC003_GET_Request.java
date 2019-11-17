import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC003_GET_Request {

	
	
	@Test
	void googleMaptest() {
		//Specify base URL
		RestAssured.baseURI="https://www.trendyol.com/bilgisayar?st=bilgisayar&qt=Bilgisayar&pi=18";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response object
		Response response=httpRequest.request(Method.GET,"https://www.trendyol.com/hp/hp-250-g7-i5-8265u-16gb-1tb-256ssd-2gb-mx110-15-6-windows-10-home-6mq82eas4-p-7163186?boutiqueId=355600&merchantId=106664");
		
		//print response in console
		String responseBody=response.getBody().asString();
		System.out.println("Response body is:"+responseBody);
		
		//validating headers
		String contentType=response.header("Content-Type");//Capture details of headers from response
		System.out.println("Content type is:"+contentType);
		Assert.assertEquals(contentType , "text/html; charset=utf-8");
		
		
		//validating headers
				String contentEncoding=response.header("Content-Encoding");//Capture details of headers from response
				System.out.println("Content Encoding is:"+contentEncoding);
				Assert.assertEquals(contentEncoding , "gzip");
				
		
			}
}
