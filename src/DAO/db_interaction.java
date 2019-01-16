package DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_interaction {
	private static db_interaction instance = new db_interaction();
	public static final String URL = "jdbc:mysql://localhost:3306/poll";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	private db_interaction() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to Connect to Database.");
		}
		return connection;
	}

	public static Connection _get_connection() {
		return instance.createConnection();
	}
	
	 public static void main(String[] args) {
	        Connection _connection = db_interaction._get_connection();
	        System.out.println("OKAY IT WORKS ,HAPPY NOW --> "+_connection.toString());
	    }
}
