package PresentationLayer;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

import BusinessLogicLayer.UserManager;
import TransferObjects.User;

@Named
@SessionScoped
public class UserBean implements Serializable {
	/**
	 * 
	 */
	private User user;
	private UserManager userManager;
	private String loginUsername;
	private String loginPassword;
	
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
		if(userManager.isUsernameValid(user)){
			userManager.addUser(user);
			return "registerSuccess";
		}
		else
			return "registerFailure";
	}
	
	public String loginUser() {
		user = userManager.loginUser(user.getUsername(), user.getPassword());
		if(user != null){
			return "loginSuccess";
		}
		else
			return "loginFailure";
	}

}