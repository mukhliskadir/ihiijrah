package com.example.demo8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {private static final long serialVersionUID = 1L;

    private LoginDAO ld;
    public void init() {
        ld = new LoginDAO();
    }
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String n =request.getParameter("username");  
        String p =request.getParameter("userpass");

        if(ld.validate(n, p)){
            RequestDispatcher rd=request.getRequestDispatcher("dashboardstaff.jsp");  
            rd.forward(request,response);  
        }  
        else{  
            out.print("Sorry username or password error");  
            RequestDispatcher rd=request.getRequestDispatcher("loginstaff.jsp");  
            rd.include(request,response);  
        }  
              
        out.close();  
        } 

}
