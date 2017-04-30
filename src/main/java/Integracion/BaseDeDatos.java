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
              ResultSet rs = st.executeQuery("Select * from curso");
              
              while (rs.next()) {
            	  System.out.println("va por aqui");
                Curso objetoCurso = new Curso(rs.getString(1),rs.getString(2));
                System.out.println(rs.getString(1));
                curso.add(objetoCurso);
              }
              rs.close();
              st.close();
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
            ResultSet rs = st.executeQuery("Select * from estudiante");
           
            while (rs.next()) {
              Estudiante objetoEstudiante = new Estudiante();
              objetoEstudiante.setNumeroIdentificacion(rs.getString(1));
              objetoEstudiante.setNombre(rs.getString(2));
              objetoEstudiante.setApellido1(rs.getString(3));
              objetoEstudiante.setApellido2(rs.getString(4));
              objetoEstudiante.setNumeroCarnet(rs.getString(5));
             // objetoCurso.setFechaNacimiento(rs.getString(6));
              objetoEstudiante.setEmail(rs.getString(7));
              estudiante.add(objetoEstudiante);
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
  public ArrayList<Object> selectEvaluacion(){//revisar object
	  ArrayList evaluacion = new ArrayList<Object>();
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
	            ResultSet rs = st.executeQuery("select codevaluacion, codigocurso, evaluacion.codtipoevaluacion, nombreevaluacion, puntajetotal, porcentajenotafinal,fechaevaluacion,tiempominutos,status, tipoevaluacion.tipoevaluacion, tipoevaluacion.descripciontipoeval from evaluacion join tipoevaluacion on evaluacion.codtipoevaluacion = tipoevaluacion.codtipoevaluacion");

	            while (rs.next()) {
	            	System.out.println(rs.getString(11));
	            	
	            	if(rs.getString(10).compareTo("Sumativa") == 0){
	            	  Sumativa objetoEvaluacion = new Sumativa();
	            		objetoEvaluacion.setCodEvaluacion(Integer.parseInt(rs.getString(1)));
	            		objetoEvaluacion.setCodigoCurso(rs.getString(2));
	            		objetoEvaluacion.setCodTipoEvaluacion(Integer.parseInt(rs.getString(3)));
	            		objetoEvaluacion.setNombreEvaluacion(rs.getString(4));	  
	            		objetoEvaluacion.setPuntajeTotal(Integer.parseInt(rs.getString(5)));
	            		objetoEvaluacion.setPorcentajeNotaFinal(Integer.parseInt(rs.getString(6)));
	            		objetoEvaluacion.setFechaEvaluacion(rs.getString(7));//revisar es string
	            		objetoEvaluacion.setTiempoMinutos(Integer.parseInt(rs.getString(8)));
	            		objetoEvaluacion.setStatus(rs.getBoolean(9));
	            		objetoEvaluacion.setTipoEvaluacion(rs.getString(10));
	            		objetoEvaluacion.setDescripcionTipoEval(rs.getString(11));
	            		evaluacion.add(objetoEvaluacion);
	            	}
	            	else if (rs.getString(10).compareTo("Formativa") == 0){
	            		Formativa objetoEvaluacion = new Formativa();	            		
	            		objetoEvaluacion.setCodEvaluacion(Integer.parseInt(rs.getString(1)));
	            		objetoEvaluacion.setCodigoCurso(rs.getString(2));
	            		objetoEvaluacion.setCodTipoEvaluacion(Integer.parseInt(rs.getString(3)));
	            		objetoEvaluacion.setNombreEvaluacion(rs.getString(4));	  
	            		objetoEvaluacion.setPuntajeTotal(Integer.parseInt(rs.getString(5)));
	            		objetoEvaluacion.setPorcentajeNotaFinal(Integer.parseInt(rs.getString(6)));
	            		objetoEvaluacion.setFechaEvaluacion(rs.getString(7));//revisar es string
	            		objetoEvaluacion.setTiempoMinutos(Integer.parseInt(rs.getString(8)));
	            		objetoEvaluacion.setStatus(rs.getBoolean(9));
	            		objetoEvaluacion.setTipoEvaluacion(rs.getString(10));
	            		objetoEvaluacion.setDescripcionTipoEval(rs.getString(11));
			            evaluacion.add(objetoEvaluacion);
	            	}
	            }
	            rs.close();
	            st.close();
	        }catch (java.sql.SQLException e) {
	            System.out.println(e.getMessage() + "adioskk");
	        }
	        return evaluacion;
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
              ResultSet rs = st.executeQuery("SELECT codigopregunta, pregunta.codsubtema, pregunta.codtipopregunta, descripcionpregunta, descripcionayuda, subtema.descripcion, tema.descripciontema, tipopregunta.nombretipopreg, tipopregunta.decripcion, tema.codtema  from pregunta join subtema on pregunta.codsubtema = subtema.codsubtema join tema on tema.codtema = subtema.codtema join tipopregunta on tipopregunta.codtipopregunta = pregunta.codtipopregunta");
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
          }catch (java.sql.SQLException e) {
              System.out.println(e.getMessage() + "adios");
          }
          return preguntas;
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


      /*
      ArrayList curso = b.selectCurso();
     
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
     /*
      for (int i=0; i<curso.size();i++){
        System.out.println(((Curso) curso.get(i)).getDescripcionCurso());
        System.out.println(((Curso) curso.get(i)).getCodigo());
      }
  
      ArrayList evaluacion = b.selectEvaluacion();
      for (int i=0; i<evaluacion.size();i++){
    	  System.out.println(((Formativa)evaluacion.get(i)).getCodEvaluacion());
    	  System.out.println(((Formativa)evaluacion.get(i)).getCodigoCurso());
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
        
            */
      
      
      ArrayList pregunta = b.selectPregunta();
      for (int i=0; i<pregunta.size();i++){
    	  System.out.println(((Pregunta) pregunta.get(i)).getCodigoPregunta());
    	  System.out.println(((Pregunta) pregunta.get(i)).getSubtema().getCodSubTema());
    	  System.out.println(((MarqueX) pregunta.get(i)).getCodTipoPregunta() );
    	  System.out.println(((MarqueX) pregunta.get(i)).getDescripcionTipoPreg());
    	  System.out.println(((Pregunta) pregunta.get(i)).getDescripcionAyuda());
    	  System.out.println(((Pregunta)pregunta.get(i)).getSubtema().getDescripcion());
    	  System.out.println(((Pregunta)pregunta.get(i)).getSubtema().getTema().getDescripcionTema());
    	  System.out.println(((MarqueX)pregunta.get(i)).getTipoPregunta());
    	  System.out.println(((MarqueX)pregunta.get(i)).getDescripcionTipoPreg());
    	  System.out.println(((Pregunta)pregunta.get(i)).getSubtema().getTema().getCodTema());
      }
    }

  }