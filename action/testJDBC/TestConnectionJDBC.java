package testJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionJDBC {
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return MySQLUtils.getMySQLConnection();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Get connection..");

		Connection connect = TestConnectionJDBC.getMyConnection();
		System.out.println("Open connection : " + connect);

		Statement statement = connect.createStatement();
		String sql = "select EMP_ID,FIRST_NAME,LAST_NAME,DEPT_ID from employee";

		// thực thi câu lệnh trả về đối tượng resultSet
		ResultSet rs = statement.executeQuery(sql);
		// duyệt kết quả trả về
		while (rs.next()) {
			// di chuyển con trỏ xuống bản ghi tiếp theo
			int emId = rs.getInt(1);
			String emFirstName = rs.getString(2);
			String emLastName = rs.getString(3);
			System.out.println("emId : "+emId);
			System.out.println("emFirstName : "+emFirstName);
			System.out.println("emLastName : "+emLastName);
		}
	}

}
