package perparestatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestUserModel {

	private static final String Iterator = null;


	public static void main(String[] args) throws Exception {

//		testAdd();
		
//		testUpdate();
		
//		testDelete();
		
		testSearch();
		
//		testfindByLogin();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

//		bean.setId(8);

		bean.setFirstName("Eathun");

		bean.setLastName("Hunt");

		bean.setLogin("Hunt@gmail.com");

		bean.setPassword("Eathun@Hunt");

		bean.setDob(sdf.parse("2003-05-25"));

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

	
	public static void testfindByLogin() throws ClassNotFoundException, SQLException {
		
		
		UserModel model = new UserModel();
		
		UserBean bean  = new UserBean();
		
		
		bean = model.findByLogin("ram123@gmail.com");

		if (bean == null) {
		
			System.out.println("user not found");
		
		} else {
			System.out.println(bean.getId());
			
			System.out.println(bean.getFirstName());
			
			System.out.println(bean.getLastName());
			
			System.out.println(bean.getLogin());
			
			System.out.println(bean.getPassword());
			
			System.out.println(bean.getDob());
		}
		
		
	}
	

	public static void testSearch() throws ClassNotFoundException, SQLException {
		
		
		UserModel model = new UserModel();
		
		UserBean bean  = new UserBean();
		
		bean.setFirstName("s");
		
		List list = model.search(bean);
		
		
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
