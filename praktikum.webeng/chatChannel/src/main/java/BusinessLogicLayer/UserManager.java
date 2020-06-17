package BusinessLogicLayer;

import DataAccessLayer.DAOFactory;
import DataAccessLayer.SQLiteUserDAO;
import DataAccessLayer.UserDAO;
import TransferObjects.User;

public class UserManager implements UserDAO{
	
	SQLiteUserDAO dao;
	public UserManager() {
		dao = DAOFactory.getSQLiteUserDAO();
	}

	@Override
	public User getUser(int id) {
		return dao.getUser(id);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public void addUser(User user) {
		dao.addUser(user);
	}

	@Override
	public void deleteUser(User user) {
		dao.deleteUser(user);
		//test
		
	}
}
