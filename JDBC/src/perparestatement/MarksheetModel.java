package perparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {

	public void add(MarksheetBean bean) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values(? , ? , ? , ? , ? , ? )");

		pstmt.setInt(1, bean.getId());

		pstmt.setInt(2, bean.getRollno());

		pstmt.setString(3, bean.getName());

		pstmt.setInt(4, bean.getPhy());

		pstmt.setInt(5, bean.getChem());

		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();

		System.out.println(i + "row Affected");

		conn.close();
		pstmt.close();

	}

	public void update(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				" update st_marksheet set rollno = ? , name = ? , phy = ? , chem = ? , maths = ?  where id = ?");

		pstmt.setInt(1, bean.getRollno());

		pstmt.setString(2, bean.getName());

		pstmt.setInt(3, bean.getPhy());

		pstmt.setInt(4, bean.getChem());

		pstmt.setInt(5, bean.getMaths());

		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + "Rows Affected(Record Updated) ");

		conn.close();
		pstmt.close();

	}

	public void delete(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_marksheet where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + "Rows Affected(Records deleted)");

		conn.close();

		pstmt.close();

	}

	public List  Listsearch(MarksheetBean bean) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_marksheet where 1=1 ");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {

				sql.append("and Name like '" + bean.getName() + "%'");
			}
			if (bean.getRollno() > 0) {
				sql.append("and RollNo = " + bean.getRollno());
			}
		}

		System.out.println("sql==> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			
			bean.setRollno(rs.getInt(2));
			
			bean.setName(rs.getString(3));
			
			bean.setPhy(rs.getInt(4));
			
			bean.setChem(rs.getInt(5));
			
			bean.setMaths(rs.getInt(6));
			
			list.add(bean);
			
		}
		

		return list;
	}

}
