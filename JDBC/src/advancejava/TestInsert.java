package advancejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("connection stablished successfull");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into employee values(24,'tulsidaskhan','HCL', 46527, 'Indore',4)");

		System.out.println(i + "Row Affected.. (Record inserted");

		conn.close();

	}

}
