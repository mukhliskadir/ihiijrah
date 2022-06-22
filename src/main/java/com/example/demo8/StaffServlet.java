package com.example.mosque;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/StaffServlet")
public class StaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public StaffServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
        response.setContentType("text/html");

        String action = request.getParameter("action");

        try {
            switch (action) {
                case "login":
                    login(request, response);
                    break;

            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        try {

            Class.forName("org.postgresql.Driver"); // ni stay
            String dbURL = "jdbc:postgresql://ec2-176-34-215-248.eu-west-1.compute.amazonaws.com/delu1t92658u0";
            String user = "zaiaryvqbpwwcb";
            String pass = "731fafeb016f84ea7f87300cbd19a24ba3e96adbaaf92504bc8d945d0302489b";
            Connection con = DriverManager.getConnection(dbURL, user, pass);

            String sql  = "SELECT * FROM staff";

            if (con != null){


                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while (res.next()){
                    if(username.equals(res.getString("staff_id")) && password.equals(res.getString("staff_password")))
                    {
                        response.sendRedirect("dashboardstaff.jsp");
                    }else{
                    }

                }                	out.print("Invalid Username/Password");

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}