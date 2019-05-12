package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }

    public static void processRegister(String username, String password, String passwordCheck, String type){
		
		User u_check = User.loadUser(username);
		if (u_check == null)
		{
			User u = new User(username, HashUtils.getMd5(password), type, -1);
			u.save();
			registerComplete();
		}
		else	
		{
				registerFailure();
		}
    }
	
	public static void registerFailure(){
        render();
    }

    public static void registerComplete(){
        render();
    }
}
