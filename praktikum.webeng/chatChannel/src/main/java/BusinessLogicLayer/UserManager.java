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

	public User getUser(int id) {
		return dao.getUser(id);
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
}
