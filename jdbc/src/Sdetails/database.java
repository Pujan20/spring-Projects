package Sdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class database {

	private database() {
		
	}
	
	private static String url="jdbc:mysql://localhost:3306/student";
			private static  String user="root";
			private static  String pswd="Root@123";
			
			public static Connection getConnection() throws SQLException{
				Connection con=null;
			con=DriverManager.getConnection(url,user,pswd);
			PreparedStatement p=con.prepareStatement("update Sdetails set result=Pass where id=3");
			
			return con;
			}
			
			
}
