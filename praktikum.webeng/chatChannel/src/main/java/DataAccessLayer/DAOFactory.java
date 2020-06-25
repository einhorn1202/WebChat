package DataAccessLayer;

public class DAOFactory {

	public DAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ChannelDAO getSQLiteChannelDAO() {
		return new SQLiteChannelDAO();
	}
	
	public static UserDAO getSQLiteUserDAO() {
		return new SQLiteUserDAO();
	}

}
