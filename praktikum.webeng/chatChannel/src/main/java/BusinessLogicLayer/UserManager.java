package BusinessLogicLayer;

import DataAccessLayer.DAOFactory;
import DataAccessLayer.SQLiteUserDAO;
import DataAccessLayer.UserDAO;
import TransferObjects.User;

public class UserManager{
	
	UserDAO dao;
	public UserManager() {
		dao = DAOFactory.getSQLiteUserDAO();
	}

	public User getUserByID(int id) {
		return dao.getUserById(id);
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}

	public void addUser(User user) {
		dao.addUser(user);
	}

	public void deleteUser(User user) {
		dao.deleteUser(user);
		//test
		
	}
	
	public Boolean isUsernameValid(User newUser) {
		for(User oldUser : dao.getAllUsers()) {
			if(oldUser.getUsername().compareTo(newUser.getUsername()) == 0) {
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
}
