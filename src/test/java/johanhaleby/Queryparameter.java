package johanhaleby;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Queryparameter {

	public static void main(String[] args) {
	RestAssured.baseURI="http://lipsum.com";
	Response res=RestAssured.given().get("/hindi");
	String rsl=res.getStatusLine();
	System.out.println("Status line is :"+rsl);
	List<Header> hs=res.getHeaders().asList();
	for(Header h:hs)
	{
		System.out.println(h.getName()+":"+h.getName());
	} 
	ResponseBody rbobj=res.getBody();
	String rb=rbobj.asString();
	System.out.println("Response Body is :\n"+rb);
	}

}
