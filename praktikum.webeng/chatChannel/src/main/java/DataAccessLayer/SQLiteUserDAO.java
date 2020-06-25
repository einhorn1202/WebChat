package DataAccessLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import TransferObjects.User;

public class SQLiteUserDAO extends SQLiteDAO implements UserDAO{
	
	private static final String getUserStatement = "SELECT USERNAME, PASSWORD , PROFILE_PIC , COLOR FROM USER WHERE USER_ID = ?";
	private static final String updateUserStatement = "UPDATE USER SET USERNAME = ? , PASSWORD = ? , PROFILE_PIC = ? , COLOR =  ? WHERE USER_ID = ?";
	private static final String addUserStatement = "INSERT INTO USER (USERNAME,PASSWORD,PROFILE_PIC,COLOR) VALUES (?,?,?,?)";
	private static final String deleteUserStatement = "DELETE FROM USER WHERE USER_ID = ?";
	private static final String getAllUsersStatement = "SELECT * FROM USER";
	
	
	public SQLiteUserDAO() {
		super();
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		User user = null;
		try {
			stmt = getConnection().prepareStatement(getUserStatement);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				user = new User(id,rs.getString("USERNAME"),rs.getString("PASSWORD"), rs.getString("PROFILE_PIC"), rs.getString("COLOR"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	

	@Override
	public void updateUser(User user) {
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(updateUserStatement);
			stmt.setString(1,user.getUsername());
			stmt.setString(2,user.getPassword());
			stmt.setString(3,user.getProfilePic());
			stmt.setString(4,user.getColor());
			stmt.setInt(5,user.getUserID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(addUserStatement);
			stmt.setString(1,user.getUsername());
			stmt.setString(2,user.getPassword());
			stmt.setString(3,user.getProfilePic());
			stmt.setString(4,user.getColor());
			stmt.executeUpdate();
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                user.setUserID(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating User failed, no ID obtained.");
	            }
	        }
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		try {
			stmt = getConnection().prepareStatement(deleteUserStatement);
			stmt.setInt(1,user.getUserID());
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override public ArrayList<User> getAllUsers(){
		PreparedStatement stmt;
		ArrayList<User> userList = new ArrayList<User>();
		try {
			stmt = getConnection().prepareStatement(getAllUsersStatement);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				channelList.add(new User(rs.getInt("USER_ID"),rs.getString("USERNAME"),rs.getString("PASSWORD"), rs.getString("PROFILE_PIC"), rs.getString("COLOR")));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
	

}
