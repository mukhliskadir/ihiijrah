package com.example.demo8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO { 
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
public static boolean validate(String name,String pass){  
boolean status=false;  
try{  
	

con = ConnectionManager.getConnection();     
PreparedStatement ps=con.prepareStatement( "select * from staff where staff_id=? and staff_password=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}