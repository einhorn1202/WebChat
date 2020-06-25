package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDAO {
	
	Connection connection = null;
	
	
	public SQLiteDAO() {
		try {
			if(connection == null)
				try {
					Class.forName("org.sqlite.JDBC");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				connection = DriverManager.getConnection("jdbc:sqlite:" + "src/main/resources/database.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	public void setConnection(Connection con) {
		this.connection = con;
	}
}