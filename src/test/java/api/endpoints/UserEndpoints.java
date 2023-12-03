package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoints.java
//created for perform create,read,update,delete requests to the user api

public class UserEndpoints {
	
	public static Response createUser(user payload)
	{
		Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		  
		.when()
		.post(Routs.post_url);
		
		return response;	
	}
	
	
	public static Response readUser(String Username)
	{
		Response response=given()
		  .contentType(ContentType.JSON)
		  .pathParam("Username",Username)
		 
		.when()
		.get(Routs.get_url);
		
		return response;
		
	}
	
	public static Response updateUser(String Username, user payload)
	{
		Response response=given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		  .pathParam("Username", Username)
		  
		.when()
		.put(Routs.update_url);
		
		return response;	
	}
	
	public static Response deleteUser(String Username)
	{
		Response response=given()
		  .contentType(ContentType.JSON)
		  .pathParam("Username",Username)
		 
		.when()
		.delete(Routs.delete_url);
		
		return response;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
