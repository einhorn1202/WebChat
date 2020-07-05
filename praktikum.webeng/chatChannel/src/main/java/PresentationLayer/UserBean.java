package PresentationLayer;

import java.io.Serializable;
import javax.annotation.PostConstruct;
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
		if(userManager.isUsernameValid(user.getUsername())){
			userManager.addUser(user);
			user = userManager.getUserByUsername(user.getUsername());
			return "registerSuccess";
		}
		else
			return "registerFailure";
	}
	
	public String loginUser() {
		user = userManager.loginUser(user.getUsername(), user.getPassword());
		if(user.getUsername().compareTo("") != 0){
			this.user = userManager.getUserByUsername(user.getUsername());
			return "loginSuccess";
		}
		else
			return "loginFailure";
	}
	
	//Validators
	
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