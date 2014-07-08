package com.jberry.services.user;

public class UserServiceFactory {
	public static UserService getUserService() {
		Class c = null;
		try {
		    c = Class.forName("com.jberry.services.user.UserServiceImpl");
		} 
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		UserService userServiceInstance = null;
		try {
		    userServiceInstance = (UserService)c.newInstance();
		    
		} 
		catch (InstantiationException e) {
		    e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
		    e.printStackTrace();
		}
		
		return userServiceInstance;
		
	}
}
