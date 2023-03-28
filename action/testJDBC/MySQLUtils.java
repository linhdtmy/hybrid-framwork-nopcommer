package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLUtils {
	public static Connection getMySQLConnection() {
		String hostName = "localhost";
		String dbName = "automationfc";
		String userName = "root";
		String password = "";
		return getMySQLConnection(hostName, dbName, userName, password);

	}

	private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
		Connection connect = null;
		try {
			String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
			connect = DriverManager.getConnection(connectionURL, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connect;
	}

}
