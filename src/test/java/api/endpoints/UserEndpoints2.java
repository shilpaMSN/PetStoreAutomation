package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoints.java
//created for perform create,read,update,delete requests to the user api

public class UserEndpoints2 {
	
	//loading properties file  by using special class called resourcebundle.
	
	static ResourceBundle getURL()   //additional method crested for getting  from properties file 
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");  //load properties file "routes" is a file name (complete path is not required here)
		return routes;
	}
	

	public static Response createUser(user payload)
	{
		String post_url=getURL().getString("post_url");
		Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		  
		.when()
		.post(post_url);
		
		return response;	
	}
	
	
	public static Response readUser(String Username)
	{
		String get_url=getURL().getString("get_url");
		Response response=given()
		  .contentType(ContentType.JSON)
		  .pathParam("Username",Username)
		 
		.when()
		.get(get_url);
		
		return response;
		
	}
	
	public static Response updateUser(String Username, user payload)
	{
		String update_url=getURL().getString("update_url");
		Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		  .pathParam("Username", Username)
		  
		.when()
		.put(update_url);
		
		return response;	
	}
	
	public static Response deleteUser(String Username)
	{
		String delete_url=getURL().getString("delete_url");
		Response response=given()
		  .contentType(ContentType.JSON)
		  .pathParam("Username",Username)
		 
		.when()
		.delete(delete_url);
		
		return response;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
