package advancejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("connection stablished successfully");

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from employee ");

		while (rs.next()) {

			System.out.println("id " + rs.getInt(1));
			System.out.println("name " + rs.getString(2));
			System.out.println("company" + rs.getString(3));
			System.out.println("salary" + rs.getInt(4));
			System.out.println("Address" + rs.getString(5));

			System.out.println();
			System.out.println();

			System.out.println();

		}
		conn.close();
	}

}
