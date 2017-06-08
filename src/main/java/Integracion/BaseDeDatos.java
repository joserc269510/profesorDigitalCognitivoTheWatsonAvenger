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
import Bitacora.Bitacora;
import Bitacora.XML;
import Seguridad.GenerarCodigo;

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
  public ArrayList<Profesor> selectProfesor (){
      ArrayList<Profesor> profesor= new ArrayList<Profesor>();
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
              
              while (rs.next()) {
                Profesor objetoProfesor = new Profesor();
                objetoProfesor.setCodProfesor(rs.getString(1));
                objetoProfesor.setContrasena(rs.getString(3));
                objetoProfesor.setCorreo(rs.getString(2));
                profesor.add(objetoProfesor);     
              }
              
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          System.out.println("TAMAÑO= "+profesor.size());
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
  
  
  public ArrayList<pregunta>ObtenerPreguntasEvaluacion(String pEvaluacion){
	  ArrayList<pregunta> preguntas = new ArrayList<pregunta>();
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
              ResultSet rs = st.executeQuery("Select pregunta.codigopregunta, descripcionpregunta from evaluacionpregunta join pregunta on pregunta.codigopregunta=evaluacionpregunta.codigopregunta where codevaluacion='"+pEvaluacion+"'");
              
              while (rs.next()) {	
            	  pregunta nPregunta=new pregunta() {
  					
  					@Override
  					public void registrarTipoPregunta(String pTipoEvaluacion, String pDescripcion) {
  						// TODO Auto-generated method stub
  						
  					}
  					
  					@Override
  					public void registrarPregunta(String CodP, String sub, String descp, String descpAy) {
  						// TODO Auto-generated method stub
  						
  					}
  				};
  				nPregunta.setCodigoPregunta(Integer.parseInt(rs.getString(1)));
  				nPregunta.setDescripcionPregunta(rs.getString(2));
                  preguntas.add(nPregunta);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return preguntas;
  }
  
  public ArrayList<Estudiante> ObtenerEstudiantesEvaluacion(String pEvaluacion){
	  ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
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
              ResultSet rs = st.executeQuery("Select estudiante.cedula, nombreestudiante, primerapellido, segundoapellido, numerocarne from estudianteevaluacion join estudiante on estudiante.cedula=estudianteevaluacion.cedula where codevaluacion='"+pEvaluacion+"'");
              
              while (rs.next()) {	
            	Estudiante nEstudiante=new Estudiante();
  				nEstudiante.setNumeroIdentificacion(rs.getString(1));
  				nEstudiante.setNombre(rs.getString(2));
  				nEstudiante.setApellido1(rs.getString(3));
  				nEstudiante.setApellido2(rs.getString(4));
  				nEstudiante.setNumeroCarnet(rs.getString(5));
                estudiantes.add(nEstudiante);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return estudiantes;
  }
  
  
  public ArrayList<Respuesta>ObtenerOpciones(int pregunta){
	  ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
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
              ResultSet rs = st.executeQuery("Select codrespuesta, descripcionrespuesta from respuesta where codigopregunta='"+pregunta+"'");
              
              while (rs.next()) {	
            	  Respuesta nRespuesta = new Respuesta();
            	  nRespuesta.setCodRespuesta(rs.getInt(1));
            	  nRespuesta.setDescripcionRespuesta(rs.getString(2));
                respuestas.add(nRespuesta);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return respuestas;
  }
  
  public String ObtenerTipoPreguntas(int pregunta){
	  String tipoPregunta="";
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
              ResultSet rs = st.executeQuery("Select tipopregunta.codtipopregunta from pregunta join tipopregunta on tipopregunta.codtipopregunta = pregunta.codtipopregunta where codigopregunta='"+pregunta+"'");
              
              while (rs.next()) {	
                tipoPregunta=rs.getString(1);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return tipoPregunta;
  }
  
  public String ObtenerDescripcionPregunta(String pregunta){
	  String descripcion="";
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
              ResultSet rs = st.executeQuery("Select descripcionpregunta from pregunta where codigopregunta='"+pregunta+"'");
              
              while (rs.next()) {	
                 descripcion=rs.getString(1);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return descripcion;
  }
  
  public String ObtenerNotaEstudiante(String pIdEstudiante, String pEvaluacion){
	  String nota="";
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
              ResultSet rs = st.executeQuery("Select nota from estudianteevaluacion where cedula='"+pIdEstudiante+"' and codevaluacion='"+pEvaluacion+"'");
              
              while (rs.next()) {	
                 nota=rs.getString(1);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return nota;
  }
  
  

  public ArrayList<pregunta> SelectTipoPreguntaEspecifica(String tipoPregunta){
	  ArrayList<pregunta> preguntas = new ArrayList<pregunta>();
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
              ResultSet rs = st.executeQuery("Select codigopregunta, descripcionpregunta from pregunta join tipopregunta on pregunta.codtipopregunta = tipopregunta.codtipopregunta where tipopregunta.nombretipopreg = '"+tipoPregunta+"'");
              
              while (rs.next()) {	
            	  pregunta nPregunta=new pregunta() {
  					
  					@Override
  					public void registrarTipoPregunta(String pTipoEvaluacion, String pDescripcion) {
  						// TODO Auto-generated method stub
  						
  					}
  					
  					@Override
  					public void registrarPregunta(String CodP, String sub, String descp, String descpAy) {
  						// TODO Auto-generated method stub
  						
  					}
  				};
  				nPregunta.setCodigoPregunta(Integer.parseInt(rs.getString(1)));
  				nPregunta.setDescripcionPregunta(rs.getString(2));
                  preguntas.add(nPregunta);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return preguntas;
  }

public ArrayList<pregunta>SelectTipoPreguntaPorSubtema(String tipoPregunta, String subtema){
	  ArrayList<pregunta> preguntas = new ArrayList<pregunta>();
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
              ResultSet rs = st.executeQuery("Select codigopregunta, descripcionpregunta from pregunta join tipopregunta on pregunta.codtipopregunta = tipopregunta.codtipopregunta join subtema on subtema.codsubtema = pregunta.codsubtema where tipopregunta.nombretipopreg = '"+tipoPregunta+"' and subtema.descripcion = '" +subtema+"'");
              
              while (rs.next()) {
            	  pregunta nPregunta=new pregunta() {
					
					@Override
					public void registrarTipoPregunta(String pTipoEvaluacion, String pDescripcion) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void registrarPregunta(String CodP, String sub, String descp, String descpAy) {
						// TODO Auto-generated method stub
						
					}
				};
				nPregunta.setCodigoPregunta(Integer.parseInt(rs.getString(1)));
				nPregunta.setDescripcionPregunta(rs.getString(2));
                preguntas.add(nPregunta);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return preguntas;
  	}
	
	

	public ArrayList<pregunta> SelectTipoPreguntaPorTema(String tipoPregunta, String tema){
	  ArrayList<pregunta> preguntas = new ArrayList<pregunta>();
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
              ResultSet rs = st.executeQuery("Select codigopregunta, descripcionpregunta from pregunta join tipopregunta on pregunta.codtipopregunta = tipopregunta.codtipopregunta join subtema on subtema.codsubtema = pregunta.codsubtema join tema on tema.codtema = subtema.codtema where tipopregunta.nombretipopreg = '"+tipoPregunta+"' and tema.descripciontema = '" +tema+"'");
              
              while (rs.next()) {	
            	  pregunta nPregunta=new pregunta() {
  					
  					@Override
  					public void registrarTipoPregunta(String pTipoEvaluacion, String pDescripcion) {
  						// TODO Auto-generated method stub
  						
  					}
  					
  					@Override
  					public void registrarPregunta(String CodP, String sub, String descp, String descpAy) {
  						// TODO Auto-generated method stub
  						
  					}
  				};
  				nPregunta.setCodigoPregunta(Integer.parseInt(rs.getString(1)));
  				nPregunta.setDescripcionPregunta(rs.getString(2));
                  preguntas.add(nPregunta);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return preguntas;
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
		String tema = "";
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
	            	  tema=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return tema;
	  }
	
	public String SelectSubtema2(String codigo){
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
	              ResultSet rs = st.executeQuery("select descripcioncurso from subtema join tema on tema.codtema=subtema.codtema join curso on curso.codigocurso=tema.codigocurso where codsubtema = '"+codigo+"'");
	              
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
	
	public ArrayList<String> SelectPorCodigoTPreg(String codigo){
		//descripciontema para tema
		//tipoevaluacion para tipo evaluacion
		//nombretipopreg para tipo pregunta
		ArrayList<String> curso = new ArrayList<String>();
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
	              ResultSet rs = st.executeQuery("select nombretipopreg, decripcion from tipopregunta where codtipopregunta = '"+codigo+"'");
	              
	              while (rs.next()) {	
	            	  String curso2=rs.getString(1);
	            	  String curso3=rs.getString(2);
	            	  curso.add(curso2);
	            	  curso.add(curso3);
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
	
	public String ObtenerCorreoEstudiante(String pIdentificacion){


		
		String correo = "";
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
	              ResultSet rs = st.executeQuery("Select correoelectronico from estudiante where cedula= '"+pIdentificacion+"'");
	              
	              while (rs.next()) {	
	            	  correo=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return correo;
	  }
	
public String ObtenerIdentificacion(String pCarnet){


		
		String correo = "";
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
	              ResultSet rs = st.executeQuery("Select cedula from estudiante where numerocarne = '"+pCarnet+"'");
	              
	              while (rs.next()) {	
	            	  correo=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return correo;
	  }

public String ObtenerCorreoProfesor(String pEvaluacion){


	
	String correo = "";
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
              ResultSet rs = st.executeQuery("Select profesor.correoelectronico from profesorcurso join profesor on profesorcurso.codprofesor=profesor.codprofesor join curso on profesorcurso.codigocurso=curso.codigocurso join evaluacion on evaluacion.codigocurso=curso.codigocurso where codevaluacion= '"+pEvaluacion+"'");
              
              while (rs.next()) {	
            	  correo=rs.getString(1);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return correo;
  }
	
public String ObtenerTiempoEvaluacion(String pEvaluacion){


		
		String tiempo = "";
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
	              ResultSet rs = st.executeQuery("Select tiempominutos from evaluacion where codevaluacion='"+pEvaluacion+"'");
	              
	              while (rs.next()) {	
	            	  tiempo=rs.getString(1);
	              }
	              rs.close();
	              st.close();
	              db.close();
	          }catch (java.sql.SQLException e) {
	              System.out.println(e.getMessage() + "adios");
	          }
	          return tiempo;
	  }

public String ObtenerAleatorioEvaluacion(String pEvaluacion){


	
	String aleatorio = "";
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
              ResultSet rs = st.executeQuery("Select aleatorio from evaluacion where codevaluacion='"+pEvaluacion+"'");
              
              while (rs.next()) {	
            	  aleatorio=rs.getString(1);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return aleatorio;
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
  
  public String selectCodigoSMS(String carnet){
	  String numero = "";
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
              ResultSet rs = st.executeQuery("Select codigoespecial from estudiante where numerocarne = '" + carnet  +"'" );
              
              while (rs.next()) {
            	numero = rs.getString(1);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return numero;
	  
  }

  public String selectNumeroTelefonoEstudiante(String carnet){
	  String numero = "";
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
              ResultSet rs = st.executeQuery("Select telefono from estudiante where numerocarne = '" + carnet  +"'" );
              
              while (rs.next()) {     	
            	numero = rs.getString(1);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return numero;
	  
  }
  
  public ArrayList<Bitacora> selectBitacora(String pFechaInicio, String pFechaFinal, String pUsuario){
	  ArrayList bitacora = new ArrayList<Bitacora>();
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
              ResultSet rs = st.executeQuery("Select * from Bitacora where fecha between '" + pFechaInicio + "' and '" + pFechaFinal + "' and usuario = '" + pUsuario + "'" );
              //select * from bitacora where fecha between '2017-03-10 13:29:49' and '2017-07-07' and usuario = 'Jose'
              while (rs.next()) {
            	
                Bitacora objetoBitacora = new XML(rs.getTimestamp(2), rs.getString(3), rs.getString(4));
                System.out.println(rs.getString(1));
                bitacora.add(objetoBitacora);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return bitacora;
	  
  }
 
  public String ObtenerDescripcionRespuesta(String pPregunta){
	  String descripcion="";
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
              ResultSet rs = st.executeQuery("Select descripcionrespuesta from respuesta where codigopregunta='"+pPregunta+"'");
              
              while (rs.next()) {	
                 descripcion=rs.getString(1);
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return descripcion;
  }
  
  public int ObtenerPuntajeEvaluacion(String pEvaluacion,String pPregunta){
	  int puntaje=0;
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
              ResultSet rs = st.executeQuery("Select puntajeasignado from evaluacionpregunta  where codevaluacion='"+pEvaluacion+"'"+" and codigopregunta='"+pPregunta+"'");
              
              while (rs.next()) {	
            	 
  				puntaje=Integer.parseInt(rs.getString(1));
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          
          return puntaje;
  }
  public int ObtenerStatusRespuesta (String pRespuesta){
	  int puntaje=0;
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
              ResultSet rs = st.executeQuery("Select status from respuesta  where codrespuesta='"+pRespuesta+"'");
              
              while (rs.next()) {	
            	 
  				puntaje=Integer.parseInt(rs.getString(1));
              }
              rs.close();
              st.close();
              db.close();
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          
          return puntaje;
  }
  
  public void InsertarCalificacion(String pCedula, String pEvaluacion, int pCalificacion){
	  insertDelete("Update estudianteevaluacion Set nota='"+pCalificacion+"' where codevaluacion='"+pEvaluacion+"' and cedula='"+pCedula+"'");
  }
  
  public static void main(String[] args) {
    
     
	  
	  /*BaseDeDatos b= new BaseDeDatos();
     ArrayList hola = b.SelectTipoPreguntaPorSubtema("marqueconx", "repeticion de codigo" );
     
     for (int i=0; i<hola.size(); i++){
    	 System.out.println(hola.get(i));
     }*/
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
    

  