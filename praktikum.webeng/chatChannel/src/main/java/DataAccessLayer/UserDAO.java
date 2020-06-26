package DataAccessLayer;

import TransferObjects.User;
import java.util.ArrayList;

public interface UserDAO {
	public User getUser(int id);
	public void updateUser(User user);
	public void addUser(User user);
	public void deleteUser(User user);
	public ArrayList<User> getAllUsers();
}
