package johanhaleby;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestHeaderParameter {

	public static void main(String[] args) {
		// Create HTTP Request
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/checkForAuthentication";
		//set Authentication details
		PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQA");
		auth.setPassword("Test password");
        RestAssured.authentication=auth;
        //define HTTP request
        RequestSpecification req=RestAssured.given();
        Response res=req.request(Method.GET,"");
        //Display response Statusline
        String rsl=res.getStatusLine();
        System.out.println(rsl);
        //Display response headers
        List<Header> hs=res.getHeaders().asList();
        for(Header h:hs)
        {
        	System.out.println(h.getName()+":"+h.getValue());
        }
        //Display response body
        String rb=res.getBody().asString();
        System.out.println("Response body is:\n"+rb);
	}

}
