package perparestatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

	public void add(UserBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(? , ? , ? , ? , ? , ? )");

		pstmt.setInt(1, bean.getId());

		pstmt.setString(2, bean.getFirstName());

		pstmt.setString(3, bean.getLastName());

		pstmt.setString(4, bean.getLogin());

		pstmt.setString(5, bean.getPassword());

		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();

		System.out.println(i + "row affected(records inserted...)");

		conn.close();

		pstmt.close();

	}

	public void Update(UserBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(" update st_user set FirstName = ? , LastName = ? , login = ? , password = ? , dob = ?  where id = ? ");

		pstmt.setString(1, bean.getFirstName());

		pstmt.setString(2, bean.getLastName());

		pstmt.setString(3, bean.getLogin());

		pstmt.setString(4, bean.getPassword());

		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));

		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + " Row Affected(Record Updated..)");

		conn.close();

		pstmt.close();

	}
	
	
	public void delete(UserBean bean) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
	
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");
		
		pstmt.setInt(1, bean.getId());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i + "Row Affected (Records Deleted....) ");
		
		conn.close();
		
		pstmt.close();
		
		
	}
	
	
	public List search() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays" , "root" , "root");
		
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user");
		
		ResultSet rs = pstmt.executeQuery();
		
		UserBean bean = null;
		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean); 
		}
		
		return list;
		
		
	}
	
	
	

}
