package BusinessLogicLayer;

import DataAccessLayer.DAOFactory;
import DataAccessLayer.SQLiteUserDAO;
import DataAccessLayer.UserDAO;
import TransferObjects.User;

public class UserManager{
	
	private UserDAO dao;
	public UserManager() {
		dao = DAOFactory.getUserDAO();
	}

	public User getUserByID(int id) {
		return dao.getUserById(id);
	}

	public String updateUser(User user) {
		
		boolean success = true;
		
		for(User newUser : dao.getAllUsers()) {
			if(newUser.getUsername() == user.getUsername() && newUser.getUserID() != user.getUserID())
				success = false;
		}
		if(success) {
			dao.updateUser(user);
			return "updateSuccess";
		}
		else 
			return "updateFailure";
	}

	public void addUser(User user) {
		dao.addUser(user);
	}

	public void deleteUser(User user) {
		dao.deleteUser(user);
		//test
		
	}
	
	public Boolean isUsernameValid(String newUsername) {
		for(User oldUser : dao.getAllUsers()) {
			if(oldUser.getUsername().compareTo(newUsername) == 0) {
				return false;
				
			}
		}
		return true;
	}
	
	public User loginUser(String loginUsername, String loginPassword) {
		User user = dao.getUserByUsername(loginUsername);
		if(user == null)
		return null;
		else {
			if(user.getPassword().compareTo(loginPassword) == 0)
				return user;
			else return null;
		}
	}
	
	public User getUserByUsername(String username) {
		return dao.getUserByUsername(username);
	}
	
	public String getColorOfUser(String username) {
		User user = dao.getUserByUsername(username);
		if(user != null)
		    return user.getColor();
		else 
			return "black";
	}
}
