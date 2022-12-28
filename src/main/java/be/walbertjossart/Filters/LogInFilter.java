package be.walbertjossart.Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.walbertjossart.JavaBeans.Users;

 public class LogInFilter implements Filter {
       
    
    public LogInFilter() {
        super();
     }
 
	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		
		boolean isLogged = (session != null && session.getAttribute("user") != null);
						
		boolean isHomePage = (httpRequest.getRequestURI().endsWith("/HomePageServlet")) || (httpRequest.getRequestURI().endsWith("/"));
		boolean isLoginPage = httpRequest.getRequestURI().endsWith("/LogInServlet");
		boolean isSignInPage = httpRequest.getRequestURI().endsWith("/SignInServlet");

		if(isHomePage|| isLoginPage || isSignInPage){
			if(isLogged){
				session.invalidate();
				RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePageServlet");
				dispatcher.forward(request, response);
 			}
			else{
				if(isHomePage){ 
					RequestDispatcher dispatcher = request.getRequestDispatcher("/HomePageServlet");
					dispatcher.forward(request, response);
 				}
				else if(isLoginPage){
					RequestDispatcher dispatcher = request.getRequestDispatcher("/LogInServlet");
					dispatcher.forward(request, response);
 				}
				else if(isSignInPage){
					RequestDispatcher dispatcher = request.getRequestDispatcher("/SignInServlet");
					dispatcher.forward(request, response);
 				}
			}		 
		}
		else{
		if(isLogged){
			chain.doFilter(request, response);
 		}
		else {
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
 			}
		}
 	}
	 
	public void init(FilterConfig fConfig) throws ServletException {
 	}

}
