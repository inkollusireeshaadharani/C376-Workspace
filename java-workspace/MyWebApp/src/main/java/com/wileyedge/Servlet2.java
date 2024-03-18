package com.wileyedge;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private ServletConfig config;
    
    public Servlet2() {
        super();
    }

	
//	public void init(ServletConfig config) throws ServletException {
//		this.config = config;
//	}

    @Override
	public void init() throws ServletException {
		System.out.println("Inside init() of servlet2"+this.getServletConfig().toString());

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		
		ServletContext context = getServletConfig().getServletContext();
		String lname = context.getInitParameter("lastName");
		System.out.println("Inside servlet2 "+lname);
		
		//cant print middle name here cuz it was available only for servlet1
		String mname = getServletConfig().getInitParameter("middleName");
		System.out.println("Inside servlet2 "+mname);
				
		PrintWriter out = response.getWriter();
		String nickname = (String) request.getAttribute("nickname");
		out.println("<h2>Welcome "+fname+" "+nickname+"</h2>");
		
	}

	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
