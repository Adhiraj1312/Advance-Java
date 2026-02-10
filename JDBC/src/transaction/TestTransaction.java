package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {

	public static void main(String[] args) throws SQLException {

		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into st_user values(13 , 'anirudh' , 'vyas' , 'anirudh@gmail.com' , 'anii23' , '2001-01-21')");

			i = stmt.executeUpdate(
					"insert into st_user values(14 , 'anirudh' , 'vyas' , anirudh@gmail.com' , 'ani23' , '2001-01-21')");

			conn.commit();
			System.out.println("Transaction coplited:(Record saved)");

			conn.close();

			stmt.close();

		} catch (Exception e) {
			conn.rollback();
			e.getStackTrace();
		

		}

	}

}
