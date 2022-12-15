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

/**
 * Servlet implementation class TestServlet
 */
 public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAO dao = new UsersDAO();
		PrintWriter out = response.getWriter();
 
		ArrayList<Users> liste = dao.getAll();
		if(liste.size() == 0) {
			out.println("Empty List");
		}
		else {
			for (Users u: liste) {
				out.println(u.toString());
			}	
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
