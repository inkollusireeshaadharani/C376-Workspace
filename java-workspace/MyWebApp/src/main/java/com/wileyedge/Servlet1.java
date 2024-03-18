package com.wileyedge;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private ServletConfig config;
    
    public Servlet1() {
        super();
    }

//	public void init(ServletConfig config) throws ServletException {
//		this.config = config;
//	}
    
    @Override
	public void init() throws ServletException {
		System.out.println("Inside init() of servlet1 "+this.getServletConfig().toString());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("firstname");
		request.setAttribute("nickname", "dhanu");

		ServletContext context = getServletConfig().getServletContext();
		String lname = context.getInitParameter("lastName");
		System.out.println("Inside servlet1 "+lname);
		
		String mname = getServletConfig().getInitParameter("middleName");
		System.out.println("Inside servlet1 "+mname);
		
		RequestDispatcher rd = request.getRequestDispatcher("/servlet2");
		rd.forward(request,response);
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
