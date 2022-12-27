package be.walbertjossart.Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.walbertjossart.JavaBeans.Users;


 public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignInServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/SignIn.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get username from request
		String pseudoParam = request.getParameter("pseudo");
		//Get password from request
		String passwordParam = request.getParameter("password");

		String emailParam = request.getParameter("email");

		//Check if we are in the submission case
		if(request.getParameter("submit") != null) {
			if(pseudoParam==null || passwordParam==null || pseudoParam.equals("") || passwordParam.equals("") || emailParam==null || emailParam.equals("")){
				request.setAttribute("error", "Username, password or email empty ! Go back to <a href=\"/Project_PresentList_Client/SignInServlet\">Sign In Page</a>");
			 	getServletContext().getRequestDispatcher("/WEB-INF/ErrorsJSP/Error.jsp").forward(request, response);
			 			
			}
			else {

				Users users = new Users();
				users.setPseudo(pseudoParam);
				users.setPassword(passwordParam);
				users.setEmail(emailParam);

				request.setAttribute("users", users);
				try {
					if(users.insertUsers()) {
						this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/HomePage.jsp").forward(request, response);

					}
					else {
						request.setAttribute("error", "An error during the register ! Go back to <a href=\"/Project_PresentList_Client/SignInServlet\">Sign In Page</a>");
					 	getServletContext().getRequestDispatcher("/WEB-INF/ErrorsJSP/Error.jsp").forward(request, response);

					}
				} catch (SQLException e) {
 					e.printStackTrace();
				}

			}
		}	
	}

}
