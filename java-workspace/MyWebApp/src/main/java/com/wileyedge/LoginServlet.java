package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
        System.out.println("inside constructor of login servlet");
    }
    
    

    /*public void init(ServletConfig config) throws ServletException {
	// TODO Auto-generated method stub
}*/

    public void destroy() {
		// TODO Auto-generated method stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet()");
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doPost");
		String uname = request.getParameter("uname");
		String password = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
		
//		ServletConfig config = getServletConfig();
		ServletConfig config=getServletConfig();
		String myName = config.getInitParameter("myname");
		request.setAttribute("myname", myName);
		HttpSession session = request.getSession(true);
		if(uname.equals(password)) {
			
			session.setAttribute("uname", uname);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			System.out.println("Forwarding to success.html");
			rd.forward(request, response);
			//below is not printed on web page when i use forward
			//
//			out.println("Request is forwarded");
//			rd.include(request, response);
			out.println("Request is included");
//			out.println("<html>");
//			out.println("<body>");
//			out.println("<h2>Auth successful</h2>");
//			out.println("</body>");
//			out.println("</html>");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			System.out.println("Forwarding to error.html");
			rd.forward(request, response);
//			out.println("<html>");
//			out.println("<body>");
//			out.println("<h2>Please enter credentials again</h2>");
//			out.println("</body>");
//			out.println("</html>");
		}
	}

}
