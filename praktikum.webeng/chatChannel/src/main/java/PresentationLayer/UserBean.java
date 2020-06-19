package PresentationLayer;


import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import BusinessLogicLayer.UserManager;
import TransferObjects.User;

@Named
@SessionScoped
public class UserBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		userManager.addUser(user);
		return "channelOverView";
	}
	
	public String deleteUser() {
		userManager.deleteUser(user);
		return "SuccessDelete";
	}
}
