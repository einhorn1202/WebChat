package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDAO {
	
	Connection connection;
	
	
	public SQLiteDAO() {
		try {
			if(connection == null)
				connection = DriverManager.getConnection("jdbc:sqlite:" + "C:/Users/Julius Jérôme/git/WebChat/praktikum.webeng/chatChannel/src/main/resources/database.db");
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
