package api.endpoints;

/*
swagger URI- https://petstore.swagger.io

Create user(post) : https://petstore.swagger.io/v2/user

get user(get) : https://petstore.swagger.io/v2/user/{Username}

update user (put) : https://petstore.swagger.io/v2/user/{Username}

delete user(delete) ; https://petstore.swagger.io/v2/user/{Username}

*/
public class Routs {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//user module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{Username}";
	public static String update_url=base_url+"/user/{Username}";
	public static String delete_url=base_url+"/user/{Username}";
	
	
	//store module 
	//here you all create store module url's
	
	//pet module 
	//here you all create pet module url's
	

}
