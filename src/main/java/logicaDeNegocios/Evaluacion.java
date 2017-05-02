package logicaDeNegocios;

import java.util.ArrayList;
import java.util.Date;

import Integracion.BaseDeDatos;

public abstract class Evaluacion 
{
	protected int codEvaluacion;
	protected String nombreEvaluacion;
	protected int puntajeTotal;
	protected int porcentajeNotaFinal;
	protected String fechaEvaluacion;
	protected int tiempoMinutos;
	protected boolean status;
	Curso curso;
	ArrayList estudiantes;
	ArrayList preguntas;
	BaseDeDatos conexion;

	
	public Evaluacion(int codEvaluacion, String nombreEvaluacion,int puntajeTotal,int porcentajeNotaFinal,String fechaEvaluacion,int tiempoMinutos,boolean status){
		estudiantes = new ArrayList<Estudiante>();
		preguntas = new ArrayList<pregunta>();
		curso = new Curso();
		conexion = new BaseDeDatos();
		setCodEvaluacion(codEvaluacion);
		setNombreEvaluacion(nombreEvaluacion);
		setPuntajeTotal(puntajeTotal);
		setPorcentajeNotaFinal(porcentajeNotaFinal);
		setFechaEvaluacion(fechaEvaluacion);
		setTiempoMinutos(tiempoMinutos);
		setStatus(status);
		
	}
	public Evaluacion(){
		estudiantes = new ArrayList<Estudiante>();
		preguntas = new ArrayList<pregunta>();
		curso = new Curso();
		conexion = new BaseDeDatos();
	}
	public void asociarEstudiante(Estudiante estudiante){
		estudiantes.add(estudiante);
	}
	public void asociarPregunta(Estudiante pregunta){
		preguntas.add(pregunta);
	}
	public void asociarCurso(Curso curso){
		this.curso = curso;
	}
	
	public abstract void registrarEvaluacion(String pCodigoEvaluacion, String pCodigoCurso, String pCodTipoEvaluacion,String pNombreEvaluacion, int pPuntajetotal, int pPorcentajenotafinal, String pFechaevaluacion, int pTiempominutos);
	public abstract void RegistrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion);
	public abstract void registrarPregunta(String pCodPregunta, String pCodEvaluacion, String pPuntaje);
	
	public void VerificarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion){
		String tipoEvaluacion;
		
		tipoEvaluacion= pTipoEvaluacion.toLowerCase(); 
		
		if (tipoEvaluacion.equals("sumativa"))
		{
			Evaluacion tipoEvaluacionS= new Sumativa(); 
			tipoEvaluacionS.RegistrarTipoEvaluacion(tipoEvaluacion, pDescripcion);
		}
		if (tipoEvaluacion.equals("formativa"))
		{
			Evaluacion tipoEvaluacionF= new Formativa();
			tipoEvaluacionF.RegistrarTipoEvaluacion(tipoEvaluacion, pDescripcion);
		}
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
	public int getCodEvaluacion() 
	{
		return codEvaluacion;
	}
	public void setCodEvaluacion(int pCodEvaluacion) 
	{
		codEvaluacion = pCodEvaluacion;
	}
	
	
	public String getNombreEvaluacion() 
	{
		return nombreEvaluacion;
	}
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public ArrayList getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList estudiantes) {
		this.estudiantes = estudiantes;
	}

	public ArrayList getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(ArrayList preguntas) {
		this.preguntas = preguntas;
	}

	public void setNombreEvaluacion(String pNombreEvaluacion) 
	{
		nombreEvaluacion = pNombreEvaluacion;
	}
	public int getPuntajeTotal() 
	{
		return puntajeTotal;
	}
	public void setPuntajeTotal(int PpuntajeTotal) 
	{
		puntajeTotal = PpuntajeTotal;
	}
	public int getPorcentajeNotaFinal() 
	{
		return porcentajeNotaFinal;
	}
	public void setPorcentajeNotaFinal(int porcentajeNotaFinal) 
	{
		this.porcentajeNotaFinal = porcentajeNotaFinal;
	}
	public String getFechaEvaluacion() 
	{
		return fechaEvaluacion;
	}
	
	public void setFechaEvaluacion(String pFechaEvaluacion) 
	{
		fechaEvaluacion = pFechaEvaluacion;
	}
	public int getTiempoMinutos() {
		return tiempoMinutos;
	}
	public void setTiempoMinutos(int pTiempoMinutos) 
	{
		tiempoMinutos = pTiempoMinutos;
	}
	public boolean isStatus() 
	{
		return status;
	}
	public void setStatus(boolean pStatus) {
		status = pStatus;
	}

	
}
