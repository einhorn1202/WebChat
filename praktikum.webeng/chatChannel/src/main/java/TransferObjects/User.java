package TransferObjects;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userID;
	private String username;
	private String password;
	private String profilePic;
	private String color;
	
	public User() {
	}
	
	public User(String username, String password, String profilePic, String color) {
		this.username = username;
		this.password = password;
		this.profilePic = profilePic;
		this.color = color;
	}
	
	public User(int userID, String username, String password, String profilePic, String color) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.profilePic = profilePic;
		this.color = color;
	}

	
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the profilePic
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 * @param profilePic the profilePic to set
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	

	

}
