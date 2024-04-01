package api.endpoints;



/*
Swagger URI ---> https://petstore.swagger.io (Base URL)
Create User(post): https://petstore.swagger.io/v2/user
Get User(Get): https://petstore.swagger.io/v2/user/{username}
Update User(Put): https://petstore.swagger.io/v2/user/{username}
Delete User(Delete): https://petstore.swagger.io/v2/user/{username}
*/

public class Routes {
	
	//We will maintain only the URL's
    //Public to access anywhere in project and static so that we can access directly thru class name without creating any object
	
	public static String base_url = "https://petstore.swagger.io/v2"; 
	
	//User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//Store module
	
	    //To create Store module URL's
	
	//Pet Module
	  
	    //To create Pet module URL's
	
	

}
