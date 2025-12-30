package perparestatement;

import java.sql.SQLException;

public class TestMarksheetModel {

	public static void  main(String [] args) throws ClassNotFoundException, SQLException {
		
		
	//	testAdd();
		
		//testUpdate();
		
		testDelete();
	}
	
	
	public static void testAdd() throws ClassNotFoundException, SQLException {
		
		
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(2);
		
		bean.setRollno(101);
		
		bean.setName("Shruti");
		
		bean.setPhy(32);
		
		bean.setChem(45);
		
		bean.setMaths(50);
	
		model.add(bean);
		
		
	}
	
	
	public static void testUpdate() throws ClassNotFoundException, SQLException {
		
		
		MarksheetModel model = new MarksheetModel();	
		
		MarksheetBean bean = new MarksheetBean();
		
		
		bean.setId(2);
		
		bean.setRollno(101);
		
		bean.setName("Adhiraj");
		
		bean.setPhy(68);
		
		bean.setChem(90);
		
		bean.setMaths(98);
		
		model.update(bean);
	}
	
	
	public static void testDelete() throws ClassNotFoundException, SQLException {
		
		
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(3);
		
		model.delete(bean);
		
	}
	
	
		
	
}
