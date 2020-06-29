package DataAccessLayer;

import TransferObjects.User;
import java.util.ArrayList;

public interface UserDAO {
	public User getUserById(int id);
	public User getUserByUsername(String username);
	public void updateUser(User user);
	public void addUser(User user);
	public void deleteUser(User user);
	public ArrayList<User> getAllUsers();
}
