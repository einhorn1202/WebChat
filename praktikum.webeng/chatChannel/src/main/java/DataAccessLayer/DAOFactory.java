package DataAccessLayer;

public class DAOFactory {

	public DAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static SQLiteChannelDAO getSQLiteChannelDAO() {
		return new SQLiteChannelDAO();
	}
	
	public static SQLiteUserDAO getSQLiteUserDAO() {
		return new SQLiteUserDAO();
	}

}
