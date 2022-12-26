package be.walbertjossart.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.walbertjossart.JavaBeans.Users;

 
 public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public LogInServlet() {
        super(); 
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/LogIn.jsp").forward(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get username from request
		String pseudoParam = request.getParameter("pseudo");
		//Get password from request
		String passwordParam = request.getParameter("password");
		
		//Check if we are in the submission case
		if(request.getParameter("submit") != null) {
			if(pseudoParam==null || passwordParam==null || pseudoParam.equals("") || passwordParam.equals("")){
				request.setAttribute("error", "Username or password empty ! Go back to <a href=\"/Project_PresentList_Client/LogInServlet\">Log In Page</a>");
	 			getServletContext().getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
	 			
			}
			else {
				if(Users.GetUser(pseudoParam, passwordParam) != null) {
					Users users = Users.GetUser(pseudoParam, passwordParam);

					 //Get the current session
	                HttpSession session = request.getSession();
	                //If the session is not new, destroy the session and create a new one.
	                if(!session.isNew()) {
	                    session.invalidate();
	                    session = request.getSession();
	                }
	                
	                request.setAttribute("user", users);
	                session.setAttribute("user", users);  
	                //response.encodeURL("user_session");
	                
					//this.getServletContext().getRequestDispatcher("/MainPageServlet").forward(request, response);
	                response.sendRedirect("/Project_PresentList_Client/MainPageServlet");


				}else {
					request.setAttribute("error", "Username or password incorrect or not found ! Go back to <a href=\"/Project_PresentList_Client/LogInServlet\">Log In Page</a>");
		 			getServletContext().getRequestDispatcher("/WEB-INF/Error.jsp").forward(request, response);
		 			
				}

			}
		}	
	}
}
