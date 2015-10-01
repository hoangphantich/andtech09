package com.hoangphan.check03b_login;

public class AuthStubService implements IAuthService{
	
	public boolean authenticate(String name, String password){
		
		//check hardcode
		if(name.equals("admin") && password.equals("123456")){
			return true;
		}
		
		return false;
	}

}
