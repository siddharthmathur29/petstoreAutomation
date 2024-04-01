package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform CURD operation requests to the user API.

public class UserEndPoints {

	public static Response createUser(User payload) 
	//This line defines a method named createUser which is declared as public, static, and returns an object of type Response. 
	//It takes one parameter named payload, which is expected to be of type User. 
	//This means that when calling this method, you need to pass an object of type User as an argument.
	 {
		 Response response = given() //3. storing the response in a variable 
		          .contentType(ContentType.JSON)
		          .accept(ContentType.JSON)
		          .body(payload)
		 
		 .when()
		 .post(Routes.post_url); //2. sending the request
		 
		 return response; //4.
		 
    //The parameter type User in the method signature (public static Response createUser(User payload)), 
	//This method is specifically designed to create a user on some system or service. 
	//Therefore, it takes a User object as a parameter to provide the necessary data needed to create a user. 
	//The User object likely contains attributes such as username, email, password, etc., which are essential for creating a user in the system being tested or interacted with. 
	//Passing the parameter type as User ensures that the method receives the correct type of data it needs to perform its task effectively.		 
		 
	 }
	
	public static Response readUser(String userName) 
	 {
		 Response response = given()
		          .pathParam("username", userName)
		  
		 .when()
		 .get(Routes.get_url); 
		 
		 return response; 
		 
	 }
	
	public static Response updateUser(String userName, User payload) 
	 {
		 Response response = given()
				 .contentType(ContentType.JSON)
				 .accept(ContentType.JSON)
		         .pathParam("username", userName)
		         .body(payload)
		  
		 .when()
		 .put(Routes.update_url); 
		 
		 return response; 
		 
	 }
	public static Response deleteUser(String userName) 
	 {
		 Response response = given()
		          .pathParam("username", userName)
		  
		 .when()
		 .delete(Routes.delete_url); 
		 
		 return response; 
		 
	 }
	
}
