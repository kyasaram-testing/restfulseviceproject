package johanhaleby;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameters {

	public static void main(String[] args) throws Exception
	{
	// HHTP request 
		RestAssured.baseURI="https://www.amazon.com/s";
		RequestSpecification req=RestAssured.given();
		//https://www.amazon.in/s?k=boat+headset&crid=FOP64VRDC64M&sprefix=boat%2Caps%2C304&ref=nb_sb_ss_i_5_4
		Response res =req.queryParam("k","addidas").get("");
		//Analyze HTTP response
		String rsl=res.getStatusLine();
		System.out.println(rsl);
		List<Header> hs=res.getHeaders().asList();
		for(Header h:hs)
		{
		System.out.println(h.getName()+":"+h.getValue());
		}
		String rb=res.getBody().asString();
        File f;
        String hv=res.getHeader("Content-Type");
        if(hv.contains("json"))
        {
        	f=new File("amazonresponse.json");
        }
        else if(hv.contains("xml"))
        {
        	f=new File("amazonresponse.xml");
        }
        else if(hv.contains("html"))
        {
        	f=new File("amazonsearchresponse.html");
        }
        else if(hv.contains("csv"))
        {
        	f=new File("amazonresponse.csv");
        }
        else
        {
        	f=new File("amazonresponse.txt");
        }
        FileWriter fw=new FileWriter(f);
        fw.write(rb);
        fw.close();
	}

}
