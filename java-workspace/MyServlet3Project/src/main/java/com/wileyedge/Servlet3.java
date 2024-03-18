package com.wileyedge;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//no web.xml
//all the info is captured in the form of annotations
//this anno is given by JEE from 3.0
//below is just like <servlet> tag
//anno is like combining source file and meta data
//no need to mention <servlet-class> cuz this is the class itself
//init param is also mentioned using anno
//no need to worry about changing the web.xml for changes made anywhere

@WebServlet(
		urlPatterns = { "/servlet3" }, 
		initParams = { 
				@WebInitParam(name = "db", value = "mysql")
		}
)
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet3() {
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("<html>"
				+ "<body>"
				+ "<h2>Hello in Servlet 3 using annotations</h2>"
				+ "</body>"
				+ "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
	}

}
