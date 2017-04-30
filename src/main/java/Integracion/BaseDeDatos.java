package Integracion;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.log.SysoLogger;

import logicaDeNegocios.*;

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
            	  System.out.println("va por aqui");
                Curso objetoCurso = new Curso();
                objetoCurso.setCodigo(rs.getString(1));
                objetoCurso.setDescripcionCurso(rs.getString(2));
                System.out.println(rs.getString(1));
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
  
  public Estudiante[] selectEstudiante (){
    Estudiante estudiante [] = new Estudiante[getNumeroRegistros("estudiante", "cedula")];
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
            ResultSet rs = st.executeQuery("Select * from estudiante");
            
            int index = 0;
            
            while (rs.next()) {
            	
              Estudiante objetoCurso = new Estudiante();
              objetoCurso.setNumeroIdentificacion(rs.getString(1));
              objetoCurso.setNombre(rs.getString(2));
              objetoCurso.setApellido1(rs.getString(3));
              objetoCurso.setApellido2(rs.getString(4));
              objetoCurso.setNumeroCarnet(rs.getString(5));
             //objetoCurso.setFechaNacimiento(rs.getString(6));
              objetoCurso.setEmail(rs.getString(7));
              estudiante[index] = objetoCurso;
              index++;        
            }
            rs.close();
            st.close();
        }catch (java.sql.SQLException e) {
            System.out.println(e.getMessage() + "adios");
        }
        return estudiante;
}
  public Profesor[] selectProfesor (){
      Profesor profesor [] = new Profesor[getNumeroRegistros("profesor", "codprofesor")];
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
              ResultSet rs = st.executeQuery("Select * from profesor");
              
              int index = 0;
              while (rs.next()) {
                Profesor objetoProfesor = new Profesor();
                //objetoProfesor.setCodProfesor(rs.getString(0));
                objetoProfesor.setContrasena(rs.getString(1));
                objetoProfesor.setCorreo(rs.getString(2));
                profesor[index] = objetoProfesor;
                index++;        
              }
              rs.close();
              st.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return profesor;
    }
  public Object[] selectEvaluacion(){
	  Object [] evaluacion = new Object[getNumeroRegistros("tipoevaluacion", "codtipoevaluacion")];
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
	            ResultSet rs = st.executeQuery("select codevaluacion, codigocurso, evaluacion.codtipoevaluacion, nombreevaluacion, puntajetotal, porcentajenotafinal,fechaevaluacion,tiempominutos,status"
	            		+ ",tipoevaluacion.codtipoevaluacion, tipoevaluacion, descripciontipoeval from evaluacion join tipoevaluacion" +
	            		"on evaluacion.codtipoevaluacion = tipoevaluacion.codtipoevaluacion");
	            
	            int index = 0;
	            while (rs.next()) {
	            	
	            	if(rs.getString(11).compareTo("Sumativa") == 0){
		              Sumativa objetoCurso = new Sumativa();
		              objetoCurso.setCodEvaluacion(Integer.parseInt(rs.getString(1)));
		              objetoCurso.setCodigoCurso(rs.getString(2));
		              objetoCurso.setNombreEvaluacion(rs.getString(3));
		              objetoCurso.setPuntajeTotal(Integer.parseInt(rs.getString(4)));
		              objetoCurso.setPorcentajeNotaFinal(Integer.parseInt(rs.getString(5)));
		              objetoCurso.setFechaEvaluacion(rs.getString(6));//revisar es string
		              objetoCurso.setTiempoMinutos(Integer.parseInt(rs.getString(7)));
		              objetoCurso.setStatus(rs.getBoolean(8));
		              objetoCurso.setCodTipoEvaluacion(Integer.parseInt(rs.getString(9)));
		              objetoCurso.setTipoEvaluacion(rs.getString(10));
		              objetoCurso.setDescripcionTipoEval(rs.getString(11));
		              evaluacion[index] = objetoCurso;
		              index++;  
	            	}
	            	else if (rs.getString(11).compareTo("Formativa") == 0){
	            		Formativa objetoCurso = new Formativa();
			              objetoCurso.setCodEvaluacion(Integer.parseInt(rs.getString(1)));
			              objetoCurso.setCodigoCurso(rs.getString(2));
			              objetoCurso.setNombreEvaluacion(rs.getString(3));
			              objetoCurso.setPuntajeTotal(Integer.parseInt(rs.getString(4)));
			              objetoCurso.setPorcentajeNotaFinal(Integer.parseInt(rs.getString(5)));
			              objetoCurso.setFechaEvaluacion(rs.getString(6));//revisar es string
			              objetoCurso.setTiempoMinutos(Integer.parseInt(rs.getString(7)));
			              objetoCurso.setStatus(rs.getBoolean(8));
			              objetoCurso.setCodTipoEvaluacion(Integer.parseInt(rs.getString(9)));
			              objetoCurso.setTipoEvaluacion(rs.getString(10));
			              objetoCurso.setDescripcionTipoEval(rs.getString(11));
			              evaluacion[index] = objetoCurso;
			              index++;  
	            	}
	            }
	            rs.close();
	            st.close();
	        }catch (java.sql.SQLException e) {
	            System.out.println(e.getMessage() + "adios");
	        }
	        return evaluacion;
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
    // b.insertDelete("insert into estudiante values( "1-1235-345","Coraima",'Fonseca', 'Alvarado','201210915','2/5/1994','cora2994@gmail.com')");
      //b.select("Select * from estudiante");
      //b.select("Select * from estudiante",1);
      //b.getNumeroRegistros("estudiante", "nombreestudiante");
      
      /*Estudiante[] curso = b.selectEstudiante();
      
      for (int i=0; i<curso.length;i++){
        System.out.println(curso[i].getNombre());
        System.out.println(curso[i].getApellido1());
      }
      */
     // Profesor nuevo=new Profesor();
     // nuevo.registrarP("123", "proyecto1");
      
      //Profesor[] profes=b.selectProfesor();
     /* for (int i=0; i<profes.length;i++){
    	  //System.out.println(profes[i].getCodProfesor());
          System.out.println(profes[i].getCorreo());
          System.out.println(profes[i].getContrasena());
        }
      */
     // System.out.println(nuevo.validarUsuario("njnjc", "123"));
     
    }

  }