package logicaDeNegocios;

import java.util.ArrayList;
import java.util.Date;

import Integracion.BaseDeDatos;
/*
 * Hay relacion de estudiantes a evaluacion?
 * */

public abstract class Evaluacion implements IVerificarEvaluacion,IRegistableTipoEvaluacion
{
	protected int codEvaluacion;
	protected String nombreEvaluacion;
	protected int puntajeTotal;
	protected int porcentajeNotaFinal;
	protected String fechaEvaluacion;
	protected int tiempoMinutos;
	protected boolean status;
	protected boolean aleatorio;
	private Curso curso;
	private ArrayList estudiantes;
	private ArrayList preguntas;
	private BaseDeDatos conexion;

	
	public Evaluacion(int pCodEvaluacion, String pNombreEvaluacion,int pPuntajeTotal,int pPorcentajeNotaFinal,String pFechaEvaluacion,int pTiempoMinutos,boolean pStatus){
		estudiantes = new ArrayList<Estudiante>();
		preguntas = new ArrayList<pregunta>();
		curso = new Curso();
		conexion = new BaseDeDatos();
		setCodEvaluacion(pCodEvaluacion);
		setNombreEvaluacion(pNombreEvaluacion);
		setPuntajeTotal(pPuntajeTotal);
		setPorcentajeNotaFinal(pPorcentajeNotaFinal);
		setFechaEvaluacion(pFechaEvaluacion);
		setTiempoMinutos(pTiempoMinutos);
		setStatus(pStatus);
		
	}
	
	public Evaluacion(){
		estudiantes = new ArrayList<Estudiante>();
		preguntas = new ArrayList<pregunta>();
		curso = new Curso();
		conexion = new BaseDeDatos();
	}
	public void asociarEstudiante(Estudiante pEstudiante){
		estudiantes.add(pEstudiante);
	}
	public void asociarPregunta(pregunta pPregunta){
		preguntas.add(pPregunta);
	}
	public void asociarCurso(Curso pCurso){
		this.curso = pCurso;
	}
	

	public abstract void registrarEvaluacion(String pCodigoEvaluacion, String pCodigoCurso, String pCodTipoEvaluacion,String pNombreEvaluacion, int pPuntajetotal, int pPorcentajenotafinal, String pFechaevaluacion, int pTiempominutos, String pAleatorio);
	public abstract void registrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion);
	public abstract void registrarPregunta(int pCodPregunta, int pCodEvaluacion, int pPuntaje);
	
	public void registrarEstudiante(String pCedula, String pCodEvaluacion){
		System.out.println(pCedula);
		System.out.println(pCodEvaluacion);
		System.out.println("insert into estudianteevaluacion (codevaluacion, cedula) values ('"+pCodEvaluacion+"','"+pCedula+"')");
		getConexion().insertDelete("insert into estudianteevaluacion (codevaluacion, cedula) values ('"+pCodEvaluacion+"','"+pCedula+"')");
	}
	
	
	public void habilitarEvaluacion(String pCodigo)
	{
		getConexion().insertDelete("UPDATE evaluacion SET status = "+"B'1'"+" WHERE codevaluacion = '"+pCodigo+"'");
		System.out.println("UPDATE evaluacion SET status = "+"B'1'"+" WHERE codevaluacion = '"+pCodigo+"'");
	}

	
	public void verificarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion)
	{
		String tipoEvaluacion;
		
		tipoEvaluacion= pTipoEvaluacion.toLowerCase(); 

		MetodoFactoryEvaluacion factory = new FactoryTipoEvaluacion();
		Evaluacion evaluacion = factory.crearEvaluacion(tipoEvaluacion, pDescripcion);
		
		if (tipoEvaluacion.equals("sumativa"))
		{
			evaluacion.registrarTipoEvaluacion(pTipoEvaluacion, pDescripcion);
			System.out.println("Entro en SUMATIVA EVALUACION");
		}
		if (tipoEvaluacion.equals("formativa"))
		{
			evaluacion.registrarTipoEvaluacion(pTipoEvaluacion, pDescripcion);
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
