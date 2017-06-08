package logicaDeNegocios;

import java.util.ArrayList;

import Integracion.BaseDeDatos;

public class Curso 
{
	private String codigo; 
	private String descripcionCurso;
	private ArrayList<Tema> temas;
	private ArrayList<Evaluacion> evaluaciones; //revisar
	private ArrayList<Estudiante> estudiantes;
	private Profesor profesor;
	private BaseDeDatos conexion;
	
	public Curso(String pCodigo, String pDescripcionCurso){
		 temas = new ArrayList<Tema>();
		 evaluaciones = new ArrayList<Evaluacion>();
		 setCodigo(pCodigo);
		 setDescripcionCurso(pDescripcionCurso);
		 conexion = new BaseDeDatos();
	}
	public Curso(){
		conexion = new BaseDeDatos();
		temas = new ArrayList<Tema>();
		evaluaciones = new ArrayList<Evaluacion>();
	}
	
	public void matricularEstudiante(String pCodigoC, String pEstudiante)
	{
		getConexion().insertDelete("insert into estudiantecurso values ("+ "'"+ pCodigoC + "'" + "," + "'" + pEstudiante +"'" + ")");
	}
	
	public void registrarCurso(String pCodigo, String pDescripcion)
	{
		setCodigo(pCodigo);
		setDescripcionCurso(pDescripcion);
		getConexion().insertDelete("insert into curso values (" + "'"+ pCodigo + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	public void eliminarCurso(String pCodigo){
		setCodigo(pCodigo); 
		//BaseDeDatos conexion= new BaseDeDatos();
		getConexion().insertDelete("delete from curso where codigocurso = '" + pCodigo+"'");
		
	}
	public void actualizarCurso(String pCodigo, String pDescripcion)
	{
		setCodigo(pCodigo);
		setDescripcionCurso(pDescripcion);
		//BaseDeDatos conexion= new BaseDeDatos();
		getConexion().insertDelete("UPDATE curso SET descripcioncurso = '"+pDescripcion+"' WHERE codigocurso = '"+pCodigo+"'");
		System.out.println("UPDATE curso SET descripcioncurso = '"+pDescripcion+"' WHERE codigocurso = '"+pCodigo+"'");
	}

	
	public ArrayList<Estudiante> getEstudiante() {
		return estudiantes;
	}
	
	public void setEstudiante(ArrayList<Estudiante> pEstudiante) 
	{
		estudiantes = pEstudiante;
	}
	
	public void anadirEvaluacion(Evaluacion pEvaluacion)
	{
		evaluaciones.add(pEvaluacion);
	}
	
	
	public void registrarTema(Tema pTema){
		temas.add(pTema);
	}
	
	public ArrayList getTemas() {
		return temas;
	}

	public void setTemas(ArrayList temas) {
		this.temas = temas;
	}

	public void AsinarProfesorCurso(String pCodCurso,String pCodProfe)//no ha sido agregada
	{
		getConexion().insertDelete("insert into profesorcurso(codigocurso,codprofesor )values("+ "'"+ pCodCurso+ "'"+ "," + "'" + pCodProfe + "'"  +")");
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

	public BaseDeDatos getConexion() {
		if (conexion == null){
			conexion = new BaseDeDatos();
		}
		return conexion;
	}

	public void setConexion(BaseDeDatos conexion) {
		this.conexion = conexion;
	}
	
}
