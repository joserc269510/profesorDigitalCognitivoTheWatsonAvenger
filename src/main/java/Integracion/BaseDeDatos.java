package Integracion;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            db.close();
            }
        catch (java.sql.SQLException e) {
        }
        return index;
  }
  
  public ArrayList<Curso> selectCurso (){
	  ArrayList curso = new ArrayList<Curso>();
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
              ResultSet rs = st.executeQuery("Select * from curso order by codigocurso asc");
              
              while (rs.next()) {
            	System.out.println("va por aqui");
                Curso objetoCurso = new Curso(rs.getString(1),rs.getString(2));
                System.out.println(rs.getString(1));
                curso.add(objetoCurso);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return curso;
    }
  
  public ArrayList<Estudiante> selectEstudiante (){
    ArrayList estudiante = new ArrayList<Estudiante>();
	 // Estudiante estudiante [] = new Estudiante[getNumeroRegistros("estudiante", "cedula")];
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
            ResultSet rs = st.executeQuery("Select * from estudiante order by cedula asc");
           
            while (rs.next()) {
              Estudiante objetoEstudiante = new Estudiante();
              objetoEstudiante.setNumeroIdentificacion(rs.getString(1));
              objetoEstudiante.setNombre(rs.getString(2));
              objetoEstudiante.setApellido1(rs.getString(3));
              objetoEstudiante.setApellido2(rs.getString(4));
              objetoEstudiante.setNumeroCarnet(rs.getString(5));
              objetoEstudiante.setFechaNacimiento(rs.getDate(6));//ojo
              objetoEstudiante.setEmail(rs.getString(7));
              estudiante.add(objetoEstudiante);
            }
            rs.close();
            st.close();
            db.close();
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
              ResultSet rs = st.executeQuery("Select * from profesor order by codprofesor asc");
              
              int index = 0;
              while (rs.next()) {
                Profesor objetoProfesor = new Profesor();
                objetoProfesor.setCodProfesor(rs.getString(1));
                objetoProfesor.setContrasena(rs.getString(3));
                objetoProfesor.setCorreo(rs.getString(2));
                profesor[index] = objetoProfesor;
                index++;        
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return profesor;
    }
  public ArrayList<Evaluacion> selectEvaluacion(){//revisar object
	  ArrayList evaluacion = new ArrayList<Evaluacion>();
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
	            ResultSet rs = st.executeQuery("select codevaluacion, evaluacion.codigocurso, evaluacion.codtipoevaluacion, nombreevaluacion, puntajetotal, porcentajenotafinal,fechaevaluacion,tiempominutos,status, tipoevaluacion.tipoevaluacion, tipoevaluacion.descripciontipoeval, descripcioncurso from evaluacion join tipoevaluacion on evaluacion.codtipoevaluacion = tipoevaluacion.codtipoevaluacion join curso on curso.codigocurso = evaluacion.codigocurso order by codevaluacion asc");

	            while (rs.next()) {
	            	System.out.println(rs.getString(10));
	            	if(rs.getString(10).equals("Sumativa")){
	            		System.out.println(rs.getString(10));
	            	    Evaluacion objetoEvaluacion = new Sumativa(Integer.parseInt(rs.getString(1)),rs.getString(4),Integer.parseInt(rs.getString(5)),Integer.parseInt(rs.getString(6)),rs.getString(7),Integer.parseInt(rs.getString(8)),rs.getBoolean(9),Integer.parseInt(rs.getString(3)),rs.getString(10),rs.getString(11) );           	
	            		Curso curso = new Curso(rs.getString(2),rs.getString(12));
	            		objetoEvaluacion.asociarCurso(curso);
	            		evaluacion.add(objetoEvaluacion);
	            	}
	            	else{
	            		System.out.println(rs.getString(10));
	            		Evaluacion objetoEvaluacion = new Formativa(Integer.parseInt(rs.getString(1)),rs.getString(4),Integer.parseInt(rs.getString(5)),Integer.parseInt(rs.getString(6)),rs.getString(7),Integer.parseInt(rs.getString(8)),rs.getBoolean(9),Integer.parseInt(rs.getString(3)),rs.getString(10),rs.getString(11) );           	
		           		Curso curso = new Curso(rs.getString(2),rs.getString(12));
		            	objetoEvaluacion.asociarCurso(curso);
			            evaluacion.add(objetoEvaluacion);
	            	}
	            }
	            rs.close();
	            st.close();
	            db.close();
	        }catch (java.sql.SQLException e) {
	            System.out.println(e.getMessage() + "adioskk");
	        }
	        return evaluacion;
	}
  
  
  public Evaluacion selectEvaluacion(String codEvaluacion){//revisar object
	  Evaluacion objetoEvaluacion=null;  
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
	            ResultSet rs = st.executeQuery("select codevaluacion, evaluacion.codigocurso, evaluacion.codtipoevaluacion, nombreevaluacion, puntajetotal, porcentajenotafinal,fechaevaluacion,tiempominutos,status, tipoevaluacion.tipoevaluacion, tipoevaluacion.descripciontipoeval, descripcioncurso from evaluacion join tipoevaluacion on evaluacion.codtipoevaluacion = tipoevaluacion.codtipoevaluacion join curso on curso.codigocurso = evaluacion.codigocurso where codevaluacion = '"+codEvaluacion+"' order by codevaluacion asc");
	            
	            while (rs.next()) {
	            	if(rs.getString(10).compareTo("Sumativa") == 0){
	            		System.out.println("SUMATIVAAAAA ");
	            	    objetoEvaluacion = new Sumativa(Integer.parseInt(rs.getString(1)),rs.getString(4),Integer.parseInt(rs.getString(5)),Integer.parseInt(rs.getString(6)),rs.getString(7),Integer.parseInt(rs.getString(8)),rs.getBoolean(9),Integer.parseInt(rs.getString(3)),rs.getString(10),rs.getString(11) );           	
	            		Curso curso = new Curso(rs.getString(2),rs.getString(12));
	            		objetoEvaluacion.asociarCurso(curso);
	            		
	            	}
	            	else{
	            		System.out.println("FORMATIVA ");
		            	objetoEvaluacion = new Formativa(Integer.parseInt(rs.getString(1)),rs.getString(4),Integer.parseInt(rs.getString(5)),Integer.parseInt(rs.getString(6)),rs.getString(7),Integer.parseInt(rs.getString(8)),rs.getBoolean(9),Integer.parseInt(rs.getString(3)),rs.getString(10),rs.getString(11) );           	
		           		Curso curso = new Curso(rs.getString(2),rs.getString(12));
		            	objetoEvaluacion.asociarCurso(curso);
			           
	            	}
	            	
	            }
	            rs.close();
	            st.close();
	            db.close();
	        }catch (java.sql.SQLException e) {
	            System.out.println(e.getMessage() + "adioskk");
	        }
	        return objetoEvaluacion;
	}
  
  
  public ArrayList<String> selectTipoEvaluacion(){
	  ArrayList tipoevaluacion = new ArrayList<String>();
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
              ResultSet rs = st.executeQuery("Select * from tipoevaluacion order by codtipoevaluacion asc");
              
              while (rs.next()) {
                String objetoTipoEvaluacion = new String (rs.getString(2));
                tipoevaluacion.add(objetoTipoEvaluacion);
                System.out.println(objetoTipoEvaluacion);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return tipoevaluacion;
	  
  }
  
  public ArrayList<String> selectTipoPregunta(){
	  ArrayList tipopregunta = new ArrayList<String>();
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
              ResultSet rs = st.executeQuery("Select * from tipopregunta order by codtipopregunta asc");
              
              while (rs.next()) {
                String objetoTipoPregunta = new String (rs.getString(2));
                tipopregunta.add(objetoTipoPregunta);
                System.out.println(objetoTipoPregunta);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return tipopregunta;
	  
  }
  
  public ArrayList<Object> selectPregunta (){
      ArrayList preguntas = new ArrayList<Object>();
	  
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
              ResultSet rs = st.executeQuery("SELECT codigopregunta, pregunta.codsubtema, pregunta.codtipopregunta, descripcionpregunta, descripcionayuda, subtema.descripcion, tema.descripciontema, tipopregunta.nombretipopreg, tipopregunta.decripcion, tema.codtema  from pregunta join subtema on pregunta.codsubtema = subtema.codsubtema join tema on tema.codtema = subtema.codtema join tipopregunta on tipopregunta.codtipopregunta = pregunta.codtipopregunta order by codigopregunta asc");
              while (rs.next()) {
            	  System.out.println(rs.getString(7));
	            	
	            	if(rs.getString(8).compareTo("marqueconx") == 0){//rs.getString(1)
	            	  MarqueX objetoPregunta = new MarqueX(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(8), rs.getString(9));
	            	  
	            	  objetoPregunta.anadirSubTema(Integer.parseInt(rs.getString(2)), rs.getString(6));
	            	  objetoPregunta.getSubtema().anadirTema(Integer.parseInt(rs.getString(10)), rs.getString(7));
	            	  preguntas.add(objetoPregunta);
	            	}
	            	else if(rs.getString(8).compareTo("desarrollo") == 0){
	            		MarqueX objetoPregunta = new MarqueX(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(8), rs.getString(9));
		            	
	            		objetoPregunta.anadirSubTema(Integer.parseInt(rs.getString(2)), rs.getString(6));
		                objetoPregunta.getSubtema().anadirTema(Integer.parseInt(rs.getString(10)), rs.getString(7));
		                preguntas.add(objetoPregunta);
	            	}
	            	else if(rs.getString(8).compareTo("respuesta corta") == 0){
	            		MarqueX objetoPregunta = new MarqueX(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5), rs.getString(8), rs.getString(9));
		                objetoPregunta.anadirSubTema(Integer.parseInt(rs.getString(2)), rs.getString(6));
		                objetoPregunta.getSubtema().anadirTema(Integer.parseInt(rs.getString(10)), rs.getString(7));
		                preguntas.add(objetoPregunta);
	            	}
	            	else{
	            		//tirar error aqui
	            	}
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return preguntas;
  	  }
  
	  public ArrayList<Tema>selectTema(){
		  ArrayList tema = new ArrayList<Tema>();
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
	              ResultSet rs = st.executeQuery("Select * from tema order by codtema asc");
	              
	              while (rs.next()) {
	                Tema objetoTema = new Tema(Integer.parseInt(rs.getString(1)),rs.getString(3));
	                System.out.println(rs.getString(1));
	                tema.add(objetoTema);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return tema;
		  
	  }
	  
	  public ArrayList<Tema>selectTema(String pCurso ){
		  ArrayList tema = new ArrayList<Tema>();
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
	              ResultSet rs = st.executeQuery("Select * from tema where codigoCurso="+"'" + pCurso + "' order by codtema asc");
	              
	              while (rs.next()) {
	                Tema objetoTema = new Tema(Integer.parseInt(rs.getString(1)),rs.getString(3));
	                System.out.println(rs.getString(1));
	                tema.add(objetoTema);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return tema;
		  
	  }

	  public ArrayList<Subtema>selectSubTema(){
		  ArrayList subtema = new ArrayList<Subtema>();
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
	              ResultSet rs = st.executeQuery("Select * from subtema order by codsubtema asc");
	              
	              while (rs.next()) {
	            	
	                Subtema objetoSubtema = new Subtema(Integer.parseInt(rs.getString(1)),rs.getString(3));
	                System.out.println(rs.getString(1));
	                subtema.add(objetoSubtema);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return subtema;
		  
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
            db.close();
        }
        catch(java.sql.SQLException e){
          System.out.println(e.getMessage() + "adios");
        }
  }
  

  public ArrayList<String>SelectTipoPreguntaEspecifica(String tipoPregunta){
	  ArrayList pregunta = new ArrayList<String>();
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
              ResultSet rs = st.executeQuery("Select descripcionpregunta from pregunta join tipopregunta on pregunta.codtipopregunta = tipopregunta.codtipopregunta where tipopregunta.nombretipopreg = '"+tipoPregunta+"'");
              
              while (rs.next()) {	
                pregunta.add(rs.getString(1));
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return pregunta;
  }

public ArrayList<String>SelectTipoPreguntaPorSubtema(String tipoPregunta, String subtema){
	  ArrayList pregunta = new ArrayList<String>();
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
              ResultSet rs = st.executeQuery("Select descripcionpregunta from pregunta join tipopregunta on pregunta.codtipopregunta = tipopregunta.codtipopregunta join subtema on subtema.codsubtema = pregunta.codsubtema where tipopregunta.nombretipopreg = '"+tipoPregunta+"' and subtema.descripcion = '" +subtema+"'");
              
              while (rs.next()) {	
                pregunta.add(rs.getString(1));
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return pregunta;
  	}
	
	

	public ArrayList<String>SelectTipoPreguntaPorTema(String tipoPregunta, String tema){
	  ArrayList pregunta = new ArrayList<String>();
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
              ResultSet rs = st.executeQuery("Select descripcionpregunta from pregunta join tipopregunta on pregunta.codtipopregunta = tipopregunta.codtipopregunta join subtema on subtema.codsubtema = pregunta.codsubtema join tema on tema.codtema = subtema.codtema where tipopregunta.nombretipopreg = '"+tipoPregunta+"' and tema.descripciontema = '" +tema+"'");
              
              while (rs.next()) {	
                pregunta.add(rs.getString(1));
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return pregunta;
  }
	
	public String SelectPorCodigo(String codigo, String nombreColumna, String nombreTabla){
		//descripcioncurso   para curso
		//descripcion para subtema
		//descripciontema para tema
		//tipoevaluacion para tipo evaluacion
		//nombretipopreg para tipo pregunta
		String curso = "";
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
	              ResultSet rs = st.executeQuery("select "+nombreColumna+" from "+nombreTabla+" where codigocurso = '"+codigo+"'");
	              
	              while (rs.next()) {	
	            	  curso=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return curso;
	  }
	
	public String SelectPorCodigoSubtema(String codigo){
		//descripciontema para tema
		//tipoevaluacion para tipo evaluacion
		//nombretipopreg para tipo pregunta
		String curso = "";
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
	              ResultSet rs = st.executeQuery("select descripcion from subtema where codsubtema = '"+codigo+"'");
	              
	              while (rs.next()) {	
	            	  curso=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return curso;
	  }
	
	
	public String SelectSubtema(String codigo){
		//descripciontema para tema
		//tipoevaluacion para tipo evaluacion
		//nombretipopreg para tipo pregunta
		String curso = "";
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
	              ResultSet rs = st.executeQuery("select descripciontema from subtema join tema on tema.codtema=subtema.codtema where codsubtema = '"+codigo+"'");
	              
	              while (rs.next()) {	
	            	  curso=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return curso;
	  }
	
	public String SelectPorCodigoTPreg(String codigo){
		//descripciontema para tema
		//tipoevaluacion para tipo evaluacion
		//nombretipopreg para tipo pregunta
		String curso = "";
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
	              ResultSet rs = st.executeQuery("select nombretipopreg from tipopregunta where codtipopregunta = '"+codigo+"'");
	              
	              while (rs.next()) {	
	            	  curso=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return curso;
	  }
	
	public String SelectPorCodigoTEval(String codigo){
		//descripciontema para tema
		//tipoevaluacion para tipo evaluacion
		//nombretipopreg para tipo pregunta
		String curso = "";
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
	              ResultSet rs = st.executeQuery("select tipoevaluacion from tipoevaluacion where codtipoevaluacion = '"+codigo+"'");
	              
	              while (rs.next()) {	
	            	  curso=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return curso;
	  }
	
	public String SelectPorCodigoTema(String codigo){
		//descripciontema para tema
		//tipoevaluacion para tipo evaluacion
		//nombretipopreg para tipo pregunta
		String curso = "";
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
	              ResultSet rs = st.executeQuery("select descripciontema from tema where codtema = '"+codigo+"'");
	              
	              while (rs.next()) {	
	            	  curso=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return curso;
	  }
	
	public Curso SelectPorTema(String pCodigo){
		//descripciontema para tema
		//tipoevaluacion para tipo evaluacion
		//nombretipopreg para tipo pregunta
		Curso curso = new Curso();
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
	              ResultSet rs = st.executeQuery("select curso.codigocurso, descripcioncurso from tema join curso on tema.codigocurso=curso.codigocurso where codtema = '"+pCodigo+"'");
	              
	              while (rs.next()) {
	            	  curso.setCodigo(rs.getString(1));
	            	  curso.setDescripcionCurso(rs.getString(2));
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return curso;
	  }
  
  
	public ArrayList<Profesor> selectProfe (){
	    ArrayList<Profesor> profesor = new ArrayList<Profesor>();
		 // Estudiante estudiante [] = new Estudiante[getNumeroRegistros("estudiante", "cedula")];
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
	           
	            while (rs.next()) {
	              Profesor objetoProfesor = new Profesor();
	              objetoProfesor.setCodProfesor(rs.getString(1));
	              objetoProfesor.setCorreo(rs.getString(3));
	              
	              profesor.add(objetoProfesor);
	            }
	            rs.close();
	            st.close();
	            db.close();
	        }catch (java.sql.SQLException e) {
	            System.out.println(e.getMessage() + "adios");
	        }
	        return profesor;
	}
	
  
  
  public void update(String query){
    
  }
  
  public ArrayList<Subtema>selectSubTema(int pCodTema){
	  ArrayList subtema = new ArrayList<Subtema>();
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
              ResultSet rs = st.executeQuery("Select * from subtema where codtema="+ pCodTema );
              
              while (rs.next()) {
            	
                Subtema objetoSubtema = new Subtema(Integer.parseInt(rs.getString(1)),rs.getString(3));
                System.out.println(rs.getString(1));
                subtema.add(objetoSubtema);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return subtema;
	  
  }
  
  public void actualizarTipEval(String pCodigo, String pDescripcion)
	{
		//BaseDeDatos conexion= new BaseDeDatos();
		insertDelete("UPDATE tipoevaluacion SET tipoevaluacion = '"+pDescripcion+"' WHERE codtipoevaluacion = '"+pCodigo+"'");
		System.out.println("UPDATE curso SET descripcioncurso = '"+pDescripcion+"' WHERE codigocurso = '"+pCodigo+"'");
	}
  
  public void actualizarTipPregunta(String pCodigo, String pDescripcion)
	{
		//BaseDeDatos conexion= new BaseDeDatos();
		insertDelete("UPDATE tipopregunta SET nombretipopreg = '"+pDescripcion+"' WHERE codtipopregunta = '"+pCodigo+"'");
		System.out.println("UPDATE curso SET descripcioncurso = '"+pDescripcion+"' WHERE codigocurso = '"+pCodigo+"'");
	}
  
  public void actualizarTema(String pCodigo, String pCodCurso, String pDescripcion)
	{
		//BaseDeDatos conexion= new BaseDeDatos();
		insertDelete("UPDATE tema SET descripciontema = '"+pDescripcion+"' , codigocurso = '"+pCodCurso+"' WHERE codtema = '"+pCodigo+"'");
		System.out.println("UPDATE curso SET descripcioncurso = '"+pDescripcion+"' , codigocurso = '"+pCodCurso+"' WHERE codigocurso = '"+pCodigo+"'");
	}
  
  public void actualizarSubtema(String pCodigo, String pCodTema, String pDescripcion)
	{
		//BaseDeDatos conexion= new BaseDeDatos();
		insertDelete("UPDATE subtema SET descripcion = '"+pDescripcion+"' , codtema = '"+pCodTema+"' WHERE codsubtema = '"+pCodigo+"'");
		System.out.println("UPDATE curso SET descripcioncurso = '"+pDescripcion+"' WHERE codigocurso = '"+pCodigo+"'");
	}
  
  public void habilitarEvaluacion(String pCodigo)
	{
		insertDelete("UPDATE evaluacion SET status = "+"B'1'"+" WHERE codevaluacion = '"+pCodigo+"'");
		System.out.println("UPDATE evaluacion SET status = "+"B'1'"+" WHERE codevaluacion = '"+pCodigo+"'");
	}
  
  

  public static void main(String[] args) {
     BaseDeDatos b= new BaseDeDatos();
     ArrayList hola = b.SelectTipoPreguntaPorSubtema("marqueconx", "repeticion de codigo" );
     
     for (int i=0; i<hola.size(); i++){
    	 System.out.println(hola.get(i));
     }
     //System.out.println(b.SelectCursoEspecifico("TI5501","descripcioncurso","curso"));

      /*
      ArrayList curso = b.selectCurso();
     
      /*Estudiante[] curso = b.selectEstudiante();
      
      for (int i=0; i<curso.length;i++){
        System.out.println(curso[i].getNombre());
        System.out.println(curso[i].getApellido1());
      }
      */
     //b.selectTema();
     // nuevo.registrarP("thawatsonavengers@gmail.com", "proyecto1");
      

         // System.out.println(profes[i].getContrasena());
        }
     
     //System.out.println(nuevo.validarUsuario("thewatsonavengers@gmail.com", "proyecto1"));
     /*
      for (int i=0; i<curso.size();i++){
        System.out.println(((Curso) curso.get(i)).getDescripcionCurso());
        System.out.println(((Curso) curso.get(i)).getCodigo());
      }
  */
      /*ArrayList evaluacion = b.selectEvaluacion();
      for (int i=0; i<evaluacion.size();i++){
    	  System.out.println(((Formativa)evaluacion.get(i)).getCodEvaluacion());
    	  System.out.println(((Formativa)evaluacion.get(i)).getCurso().getCodigo());
    	  System.out.println(((Formativa)evaluacion.get(i)).getCodTipoEvaluacion());
          System.out.println(((Formativa)evaluacion.get(i)).getNombreEvaluacion());
          System.out.println(((Formativa)evaluacion.get(i)).getPuntajeTotal());
          System.out.println(((Formativa)evaluacion.get(i)).getPorcentajeNotaFinal());
          System.out.println(((Formativa)evaluacion.get(i)).getFechaEvaluacion());
          System.out.println(((Formativa)evaluacion.get(i)).getTiempoMinutos());
          System.out.println(((Formativa)evaluacion.get(i)).isStatus());
          System.out.println(((Formativa)evaluacion.get(i)).getTipoEvaluacion());
          System.out.println(((Formativa)evaluacion.get(i)).getDescripcionTipoEval());
          System.out.println("\n\n");
        }
        
/*
      
      
      ArrayList pregunta = b.selectPregunta();
      for (int i=0; i<pregunta.size();i++){
    	  System.out.println(((pregunta) pregunta.get(i)).getCodigoPregunta());
    	  System.out.println(((pregunta) pregunta.get(i)).getSubtema().getCodSubTema());
    	  System.out.println(((MarqueX) pregunta.get(i)).getCodTipoPregunta() );
    	  System.out.println(((MarqueX) pregunta.get(i)).getDescripcionTipoPreg());
    	  System.out.println(((pregunta) pregunta.get(i)).getDescripcionAyuda());
    	  System.out.println(((pregunta)pregunta.get(i)).getSubtema().getDescripcion());
    	  System.out.println(((pregunta)pregunta.get(i)).getSubtema().getTema().getDescripcionTema());
    	  System.out.println(((MarqueX)pregunta.get(i)).getTipoPregunta());
    	  System.out.println(((MarqueX)pregunta.get(i)).getDescripcionTipoPreg());
    	  System.out.println(((pregunta)pregunta.get(i)).getSubtema().getTema().getCodTema());
      }
    */
    }
    

  