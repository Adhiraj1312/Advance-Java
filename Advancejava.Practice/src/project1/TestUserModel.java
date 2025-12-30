package project1;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception, Exception {
		testAdd();

	}

	public static void testAdd() throws ParseException, Exception, Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

	

		bean.setFirstName("Sakshi");

		bean.setLastName("Jain");
		
		bean.setLogin("Sakshi@gmail.com");
		
		bean.setPassword("Sakshi142");
		
		bean.setDob(sdf.parse("2001-12-23"));
		bean.setId(9);
		
		model.add(bean);
		
		
	}

	
	
}
