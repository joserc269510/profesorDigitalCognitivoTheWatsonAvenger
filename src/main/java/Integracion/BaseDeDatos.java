package Integracion;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logicaDeNegocios.Curso;
public class BaseDeDatos {

	public static final String url ="jdbc:postgresql://echo.db.elephantsql.com:5432/syvmjttg";
	public static final String username = "syvmjttg";
	public static final String password = "MFVYQ1dzq8OSpqf7P3t6IFk-9rYyBi8q";
	
	public int getNumeroRegistros(String tabla, String columna){
		int index=0;
		try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage() + "hola");
        }
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery( "select count(" + columna + ") from " + tabla);
            while (rs.next()) {
            	index = rs.getInt(1);            
            }
            rs.close();
            st.close();
            }
        catch (java.sql.SQLException e) {
        }
        return index;
	}
	
	public Curso[] selectCurso (){
			Curso curso [] = new Curso[getNumeroRegistros("curso", "codigocurso")];
			
			try {
	            Class.forName("org.postgresql.Driver");
	        }
	        catch (java.lang.ClassNotFoundException e) {
	            System.out.println(e.getMessage() + "hola");
	        }
	        try {
	        	System.out.println("daskdjkasjdsakl");
	            Connection db = DriverManager.getConnection(url, username, password);
	            Statement st = db.createStatement();
	            ResultSet rs = st.executeQuery("Select * from curso");
	            
	            int index = 0;
	            while (rs.next()) {
	            	Curso objetoCurso = new Curso();
	            	objetoCurso.setCodigo(rs.getString(1));
	            	objetoCurso.setDescripcionCurso(rs.getString(2));
	            	curso[index] = objetoCurso;
	            	index++;	      
	            }
	            rs.close();
	            st.close();
	        }catch (java.sql.SQLException e) {
	            System.out.println(e.getMessage() + "adios");
	        }
	        
	        return curso;
	    }
	
	
	public void insertDelete(String query){
       	try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage() + "hola");
        }
       	
       	try{
       		System.out.println("daskdjkasjdsakl");
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            st.executeUpdate(query);  
            st.close();
       	}
       	catch(java.sql.SQLException e){
       		System.out.println(e.getMessage() + "adios");
       	}
	}
	
	public void update(String query){
		
	}
  
  	public static void main(String[] args) 
  	{
  		BaseDeDatos b= new BaseDeDatos();
  		//select count (nombreestudiante) from estudiante
  		//insert into estudiante values ('3485081','Jose', 'Ramirez', 'Calderon', '2014077444','2/5/1994','jose12.13@hotmail.com');
  		//b.insertDelete("insert into estudiante values( "1-1235-345","Coraima",'Fonseca', 'Alvarado','201210915','2/5/1994','cora2994@gmail.com')");
  		//b.select("Select * from estudiante");
  		//b.select("Select * from estudiante",1);
  		//b.getNumeroRegistros("estudiante", "nombreestudiante");
  		
  		Curso[] curso = b.selectCurso();
  		
  		for (int i=0; i<curso.length;i++){
  			System.out.println(curso[i].getDescripcionCurso());
  			System.out.println(curso[i].getCodigo());
  		}
  	}

	}
