package PresentationLayer;


import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import BusinessLogicLayer.UserManager;
import TransferObjects.User;

public class UserBean {
	
	User user;
	UserManager userManager;
	
	@PostConstruct
	public void init() {
		if(userManager == null) {
			userManager = new UserManager();
		}
		if(user == null) {
			user = new User();
		}
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	/*
	 * ACTION-METHODEN DER BEAN
	 */
	
	
    
}
