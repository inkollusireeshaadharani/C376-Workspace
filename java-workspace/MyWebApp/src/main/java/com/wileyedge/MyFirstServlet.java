package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyFirstServlet() {
    	System.out.println("Inside constrcutor of myservlet");
    }

//	public void init(ServletConfig config) throws ServletException {
//    	System.out.println("Inside init of myservlet");
//	}
    
    public void init() throws ServletException {
		System.out.println("Inside init() of servlet1 "+this.getServletConfig().toString());
	}

	public void destroy() {
    	System.out.println("Inside destroy of myservlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet() of myservlet");
    	PrintWriter out = response.getWriter();
    	
    	request.setAttribute("myname", "dharani");
		ServletContext context = getServletConfig().getServletContext();
		context.setAttribute("myname", "sara");
    	RequestDispatcher rd =  request.getRequestDispatcher("loginform.jsp");
    	System.out.println("forwarding the request to html");
    	rd.forward(request, response);
//    	out.println("hello from server");
//    	String value = request.getParameter("name");
//    	out.println("<html>");
//    	out.println("<body>");
//    	out.println("<h2>Login page</h2>");
//    	out.println("<form action='login' method='post' >");
//    	out.println("Enter Username : <input type='text' name='uname'/><br>");
//    	out.println("Enter Password : <input type='password' name='pwd'/><br>");
//    	out.println("<input type='submit' value='Sign In'/>" );			
//    	out.println("</form>");
//    	out.println("</body>");
//    	out.println("</html>");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPost() of myservlet");

		doGet(request, response);
	}

}
