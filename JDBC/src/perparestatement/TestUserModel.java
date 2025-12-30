package perparestatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestUserModel {

	private static final String Iterator = null;


	public static void main(String[] args) throws ClassNotFoundException, ParseException, SQLException {

		//testAdd();
		
		//testUpdate();
		
		//testDelete();
		
		testSearch();
	}

	public static void testAdd() throws ParseException, ClassNotFoundException, SQLException {

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(8);

		bean.setFirstName("Sakshi");

		bean.setLastName("Sharma");

		bean.setLogin("sakshi@gmail.com");

		bean.setPassword("Sakshi@435");

		bean.setDob(sdf.parse("2001-09-25"));

		model.add(bean);
		
	}
	
	
	public static void testUpdate() throws ParseException, ClassNotFoundException, SQLException {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		UserModel model = new UserModel();
		
		UserBean bean = new UserBean();
		
		
		bean.setId(8);
		
		bean.setFirstName("Begum");
		
		bean.setLastName("Mumtaz");
		
		bean.setLogin("begummmumtaz@gmail.com");
		
		bean.setPassword("saket420");
		
		bean.setDob(sdf.parse("2005-04-12"));
		
		
		model.Update(bean);
		
	}
	
	
	public static void testDelete() throws ClassNotFoundException, SQLException {
		
		
		UserModel model = new UserModel();
		
		UserBean bean = new UserBean();
		
		bean.setId(5);
		
		model.delete(bean);
	}
	

	public static void testSearch() throws ClassNotFoundException, SQLException {
		
		
		UserModel model = new UserModel();
		
		UserBean bean  = new UserBean();
		
		List list = model.search();
		
		
		java.util.Iterator<UserBean> it = list.iterator();
		
		while(it.hasNext()) {
			
			bean = it.next();
			
			System.out.println(bean.getId());
			
			System.out.println(bean.getFirstName());
			
			System.out.println(bean.getLastName());
			
			System.out.println(bean.getLogin());
			
			System.out.println(bean.getPassword());
			
			System.out.println(bean.getDob());
			
			System.out.println("----------------------------");
			
		}
		
		
		
	}
	
}
