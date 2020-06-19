package PresentationLayer;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

import BusinessLogicLayer.UserManager;
import TransferObjects.User;

@Named
@SessionScoped
public class UserBean implements Serializable {
	
	/**
	 * 
	 */
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
	
	
	public String registerUser() {
		System.out.println("hallo");
		userManager.addUser(user);
		return "";
	}
	
	public String loginUser() {
		return "channelOverView";
	}
	
	public String deleteUser() {
		userManager.deleteUser(user);
		return "SuccessDelete";
	}
}
