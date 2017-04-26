package Integracion;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDeDatos {

  public static void main(String[] args) {
	        try {
	            Class.forName("org.postgresql.Driver");
	        }
	        catch (java.lang.ClassNotFoundException e) {
	            System.out.println(e.getMessage() + "hola");
	        }
	        String url ="jdbc:postgresql://echo.db.elephantsql.com:5432/syvmjttg";
	        String username = "syvmjttg";
	        String password = "MFVYQ1dzq8OSpqf7P3t6IFk-9rYyBi8q";

	        try {
	        	System.out.println("daskdjkasjdsakl");
	            Connection db = DriverManager.getConnection(url, username, password);
	            Statement st = db.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM public.profesor LIMIT 100");
	            while (rs.next()) {
	                System.out.print("Column 1 returned ");
	                System.out.println(rs.getString(2));
	                System.out.print("Column 2 returned ");
	                System.out.println(rs.getString(3));	              
	            }	           
	            rs.close();
	            st.close();
	            }
	        catch (java.sql.SQLException e) {
	            System.out.println(e.getMessage() + "adios");
	        }
	    }

	}
