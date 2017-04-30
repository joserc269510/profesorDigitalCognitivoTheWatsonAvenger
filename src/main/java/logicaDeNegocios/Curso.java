package logicaDeNegocios;

import java.util.ArrayList;

import Integracion.BaseDeDatos;

public class Curso 
{
	String codigo; 
	String descripcionCurso;
	ArrayList temas;
	ArrayList evaluaciones;


	Estudiante estudiante;
	
	public Curso(String codigo, String descripcionCurso){
		 temas = new ArrayList<Tema>();
		 evaluaciones = new ArrayList<Evaluacion>();
		 setCodigo(codigo);
		 setDescripcionCurso(descripcionCurso);
	}
	public Curso(){
		
	}
	
	public void MatricularEstudiante(String pCodigoC, String pEstudiante)
	{
		BaseDeDatos conexion= new BaseDeDatos();
		conexion.insertDelete("insert into estudiantecurso values ("+ "'"+ pCodigoC + "'" + "," + "'" + pEstudiante +"'" + ")");
	}
	
	public void RegistrarCurso(String pCodigo, String pDescripcion)
	{
		setCodigo(pCodigo);
		setDescripcionCurso(pDescripcion);
		BaseDeDatos conexion= new BaseDeDatos();
		conexion.insertDelete("insert into curso values (" + "'"+ pCodigo + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	public void setEstudiante(Estudiante pEstudiante) 
	{
		estudiante = pEstudiante;
	}
	
	public void anadirEvaluacion(Evaluacion evaluacion)
	{
		evaluaciones.add(evaluacion);
	}
	
	
	public void registrarTema(Tema tema){
		temas.add(tema);
	}
	
	public ArrayList getTemas() {
		return temas;
	}

	public void setTemas(ArrayList temas) {
		this.temas = temas;
	}


	
	public String getCodigo() 
	{
		return codigo;
	}
	
	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}
	
	public String getDescripcionCurso() 
	{
		return descripcionCurso;
	}
	
	public void setDescripcionCurso(String descripcionCurso) 
	{
		this.descripcionCurso = descripcionCurso;
	} 
	
	
}
