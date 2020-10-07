package johanhaleby;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class StatusLineparsing {

	public static void main(String[] args) {
	RestAssured.baseURI="http://lipsum.com";
	Response res=RestAssured.given().get("/hindi");
	String rsl=res.getStatusLine();
	System.out.println("Status line is :"+rsl);
	// get details of Statusline parsing
	//Get value of protocol version
	String pv=rsl.substring(0,8);
	System.out.println("Protocol version is :"+pv);
	//Get value of status code
	String sc=rsl.substring(9,12);
	System.out.println("Status code is"+sc);
	//get status message
	
	List<Header> hs=res.getHeaders().asList();
	for(Header h:hs)
	{
		System.out.println(h.getName()+":"+h.getValue());
	} 
	ResponseBody rbobj=res.getBody();
	String rb=rbobj.asString();
	System.out.println("Response Body is :\n"+rb);
	}

}
