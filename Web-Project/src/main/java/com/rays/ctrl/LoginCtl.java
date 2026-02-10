package com.rays.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.modeler.modules.ModelerSource;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;



@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String op = request.getParameter("opreation");
		
		System.out.println("op == " + op);
		
		if (op != null ) {
			
			HttpSession session = request.getSession();
			
			session.invalidate();         // (invalidate method is used to destroy the session)
		}
		
		response.sendRedirect("LoginView.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		System.out.println("in do post method ");
		
		UserModel modle = new UserModel();
		
		UserBean bean = new UserBean();
	
		String login = request.getParameter("login");
		
		String password = request.getParameter("password");
		
		
		bean.setLogin(login);
		
		bean.setPassword(password);
		
		HttpSession session = request.getSession();
		
		try {
			bean = modle.authenticate(bean.getLogin(), bean.getPassword());
			if (bean != null) {
				
				System.out.println("User login successfull");
				
				session.setAttribute("User", bean);
				
				response.sendRedirect("WelcomeCtl");
			}
			else {
				
				System.out.println("invalid login or password");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}

}
