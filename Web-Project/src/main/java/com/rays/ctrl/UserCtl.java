package com.rays.ctrl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserCtl")
public class UserCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.sendRedirect("UserRegistrationView.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in do post method");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		
		UserBean bean = new UserBean();
		
		
		String fname = request.getParameter("FirstName");
		String lname = request.getParameter("LastName");
		String login = request.getParameter("Login");
		String pass = request.getParameter("password");
		String dob = request.getParameter("dob");
		
		try {
			
			bean.setFirstName(fname);
			bean.setLastName(lname);
			bean.setLogin(login);
			bean.setPassword(pass);
			bean.setDob(sdf.parse(dob));
			
			model.add(bean);
			System.out.println("User added Successfully");
			request.setAttribute("successMsg", "User added Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
