package PresentationLayer;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import BusinessLogicLayer.UserManager;
import TransferObjects.User;

@Named
@SessionScoped
public class UserBean implements Serializable {
	/*
	 * Instanzvariablen
	 */
	private User user;
	private UserManager userManager;
	private String loginUsername;
	private String loginPassword;
	
	/*
	 * Getter und Setter
	 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	

	@PostConstruct
	public void init() {
		if(userManager == null) {
			userManager = new UserManager();
		}
		if(user == null) {
			user = new User();
		}
	}
	
	/*
	 * ACTION-METHODEN DER BEAN
	 */
	
	
	
	public String registerUser() {
		if(userManager.isUsernameValid(user.getUsername())){
			userManager.addUser(user);
			user = userManager.getUserByUsername(user.getUsername());
			return "registerSuccess";
		}
		else
			return "registerFailure";
	}
	
	public String loginUser() {
		User newUser = userManager.loginUser(user.getUsername(), user.getPassword());
		
		if(newUser != null){
			this.user = userManager.getUserByUsername(newUser.getUsername());
			return "loginSuccess";
		}
		else
			return "loginFailure";	
	}
	
	public String logoutUser() {
		user = new User();
		return "logoutSuccess";
	}
	
	public String getColorOfUser(String username) {
		return userManager.getColorOfUser(username);
	}
	
	public String deleteUser() {
		userManager.deleteUser(user);
		user = new User();
		return "deleteSuccess";
	}
	
	public String updateUser() {
		return userManager.updateUser(user);
	}
	
	
	/*
	 * Validators
	 */
	
	
	public void usernameValidate(FacesContext ctx, UIComponent ui, Object value) throws ValidatorException{
		String val = (String) value;
		if(val.compareTo("") != 0) {
			if(!userManager.isUsernameValid(val)) {
				throw new ValidatorException(new FacesMessage("Nutzername bereits vergeben!"));
			}
		}
		else throw new ValidatorException(new FacesMessage("Nutzername ist ein Pflichtfeld!"));
	}
}