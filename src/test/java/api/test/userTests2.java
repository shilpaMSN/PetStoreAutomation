package api.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints2;
import api.payload.user;
import io.restassured.response.Response;

public class userTests2 {
	Faker faker=new Faker();
	user userpayload=new user();
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority=1)
	public void testpostuser()
	{
		logger.info("**************************Creating User***********************************");
		Response response=UserEndpoints2.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("************************** User created***********************************");
	}
	
	@Test(priority=2)
	
	public void getuser()
	{
		logger.info("**************************reading User info***********************************");
		Response response=UserEndpoints2.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("************************** User info is displayed***********************************");
		
	}
	
	@Test(priority=3)
	public void updateuser()
	{	
		logger.info("**************************updating User***********************************");
		//	update data using payload 
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		Response Afterupdateresponse=UserEndpoints2.updateUser(this.userpayload.getUsername(),userpayload);
		Afterupdateresponse.then().log().all();
		Assert.assertEquals(Afterupdateresponse.getStatusCode(),200);
	
		logger.info("************************** User is updated***********************************");
		Response response=UserEndpoints2.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	
	
	}
	
@Test(priority=4)
	
	public void deleteuser()
	{
	logger.info("**************************deleting User***********************************");
		Response response=UserEndpoints2.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("************************** User deleted***********************************");
		
	}
	
}
