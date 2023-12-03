package api.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests 
{
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testpostuser(String userID,String UserName,String fname,String lname,String usermail,String pwd,String ph)
	{
		user userpayload=new user();
		
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(UserName);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(usermail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		
		Response response=UserEndpoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String UserName)
	{
		Response response=UserEndpoints.deleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
}
