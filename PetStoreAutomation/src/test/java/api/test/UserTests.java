package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayload;
	
	public Logger logger; //for logs
	
	@BeforeClass
	public void steup()
	{
	   faker = new Faker();
	   userPayload = new User();
	   
	   userPayload.setId(faker.idNumber().hashCode());
	   userPayload.setUsername(faker.name().username());
	   userPayload.setFirstName(faker.name().firstName());
	   userPayload.setLastName(faker.name().lastName());
	   userPayload.setEmail(faker.internet().safeEmailAddress());
	   userPayload.setPassword(faker.internet().password(5 ,10));
	   userPayload.setPhone(faker.phoneNumber().cellPhone());
	   
	   //logs
	   logger=LogManager.getLogger(this.getClass()); //initiate the variable 
	   
	   logger.debug("debugging......");
	   
	}
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("********** Creating user ************");
		Response response=UserEndPoints2.createUser(userPayload);
		response.then().log().body();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200); 
		logger.info("********** User is created ************");
	}

	//how to get the data from the user
	@Test(priority=2)
	public void testGetUserByName()
	{
		logger.info("********** Reading user Info ************");
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().body();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** User info is displayed ************");
	}
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		logger.info("********** Updating User ************");
		
		//update data using the Payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		   
		Response response=UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** User is Updated ************");
		
		//Checking data after update 
		Response responseAfterUpdate =UserEndPoints2.readUser(this.userPayload.getUsername());
		AssertJUnit.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	public void testGetUserByUpdatedName()
	{
		logger.info("********** Checking user after Update ************");
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().body();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** User updated successfully ************");
		
	}
	@Test(priority=5)
	public void testDeleteUserByName()
	{
		logger.info("********** Deleting user ************");
		Response response=UserEndPoints2.deleteUser(this.userPayload.getUsername());
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		
		logger.info("********** user Deleted ************");
		
	}
}
