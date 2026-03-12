package com.kdh.calc;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Reg")
public class Reg extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // 1. 값 받기
		      String n = request.getParameter("name");
		      String i = request.getParameter("id");
		      String p = request.getParameter("pw");
		      String g = request.getParameter("gender");
		      String a = request.getParameter("Addr");
		      String[] in = request.getParameterValues("interest");
		      String intr = request.getParameter("introduce");
		      
		      
		  // 콘솔에 다 출력    
		      System.out.println(n);
		      System.out.println(i);
		      System.out.println(p);
		      System.out.println(g);
		      System.out.println(a);
		      
		    
		       for (String ss : in) {
				System.out.println(ss);
			}
		      System.out.println(intr);
		      
		      
		        int xx = Integer.parseInt(request.getParameter("x"));
	              int yy = Integer.parseInt(request.getParameter("y"));
			      String[] op = request.getParameterValues("oper");
			      System.out.println(xx);
	              System.out.println(yy);
	              
		          
		          
		          
	              // 브라우저에 무언가 쓰고 싶음 (html)
	              response.setCharacterEncoding("utf-8"); 
	              PrintWriter out = response.getWriter();
	              out.print("<html>");
	              
	              out.print("<head>");
	              out.print("<meta charset=\"UTF-8\">");
	              out.print("</head>");
	              
	              out.print("<body>");
	              
	              
	              
	              out.print("");
	              
	              
	              
	              
	              
	              
	       
	              
	             
	              
	              
	              out.print("</body>");
	              
	              
	              out.print("</html>");
		      
		      
		      
	
	}

}
