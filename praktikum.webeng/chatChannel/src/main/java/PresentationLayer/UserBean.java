package PresentationLayer;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

import BusinessLogicLayer.UserManager;
import TransferObjects.User;

@Named
@SessionScoped
<<<<<<< HEAD
public class UserBean implements Serializable{
=======
public class UserBean implements Serializable {
>>>>>>> branch 'master' of https://github.com/einhorn1202/WebChat.git
	
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
		if(userManager.isUsernameValid(user)) {
			userManager.addUser(user);
			return "registerSuccess";
		}
		else 
			return "registerFailure";
			
		
	}
	
	public String loginUser() {
		return "channelOverView";
	}
	
	public String deleteUser() {
		userManager.deleteUser(user);
		return "SuccessDelete";
	}
}
