package be.walbertjossart.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 import be.walbertjossart.DAO.UsersDAO;
import be.walbertjossart.JavaBeans.Users;

 
 public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public HomePageServlet() {
        super();
     }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		this.getServletContext().getRequestDispatcher("/WEB-INF/HomePage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doGet(request, response);
	}

}
