package johanhaleby;


import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class OnePathParameterWithjsonresponse
{
public static void main(String[] args)
{
		//Create HTTP request
	RestAssured.baseURI="http://jsonplaceholder.typicode.com/posts";
	RequestSpecification req=RestAssured.given();
	//send request with required http method and path parameter value
	Response res=req.request(Method.GET,"/1");
	//Analyse HTTP Response
	String rsl=res.getStatusLine();
	System.out.println("status line is "+rsl);
	System.out.println("Headers are:");
	List<Header>hs=res.getHeaders().asList();
	for(Header h:hs)
	{
		System.out.println(h.getName()+":"+h.getName());
	} 
	ResponseBody rbobj=res.getBody();
	String rb=rbobj.asString();
	System.out.println("Response Body is :\n"+rb);
	}

}
