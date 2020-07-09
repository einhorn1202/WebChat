package DataAccessLayer;

public class DAOFactory {

	public DAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static ChannelDAO getChannelDAO() {
		return new SQLiteChannelDAO();
	}
	
	public static UserDAO getUserDAO() {
		return new SQLiteUserDAO();
	}

}
