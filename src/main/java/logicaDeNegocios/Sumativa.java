package logicaDeNegocios;

import java.util.Date;

import Integracion.BaseDeDatos;

public class Sumativa extends Evaluacion 
{
	private int codTipoEvaluacion;
	private String tipoEvaluacion;
	private String descripcionTipoEval;
	BaseDeDatos conexion;
	
	public Sumativa(int pCodEvaluacion, String pNombreEvaluacion,int pPuntajeTotal,int pPorcentajeNotaFinal,String pFechaEvaluacion,int pTiempoMinutos,boolean pStatus,int pCodTipoEvaluacion,String pTipoEvaluacion,String pDescripcionTipoEval){
		super( pCodEvaluacion,  pNombreEvaluacion, pPuntajeTotal, pPorcentajeNotaFinal, pFechaEvaluacion, pTiempoMinutos, pStatus);
		conexion = new BaseDeDatos();
		setCodTipoEvaluacion(pCodTipoEvaluacion);
		setTipoEvaluacion(pTipoEvaluacion);
		setDescripcionTipoEval(pDescripcionTipoEval);
	}
	public Sumativa(){
		super();
		conexion = new BaseDeDatos();
	}
	
	
	public Sumativa (String pTipoEvaluacion, String pDescripcion)
	{
		super();
		conexion = new BaseDeDatos();
		setDescripcionTipoEval(pDescripcion);
		setTipoEvaluacion(pTipoEvaluacion);
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
	public int getCodTipoEvaluacion() {
		return codTipoEvaluacion;
	}
	public void setCodTipoEvaluacion(int codTipoEvaluacion) {
		this.codTipoEvaluacion = codTipoEvaluacion;
	}
	public String getTipoEvaluacion() {
		return tipoEvaluacion;
	}
	public void setTipoEvaluacion(String tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}
	public String getDescripcionTipoEval() {
		return descripcionTipoEval;
	}
	public void setDescripcionTipoEval(String descripcionTipoEval) 
	{
		this.descripcionTipoEval = descripcionTipoEval;
	}
	
	
	public void registrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) 
	{
		setTipoEvaluacion(pTipoEvaluacion);
		getConexion().insertDelete("insert into tipoevaluacion(tipoevaluacion,descripciontipoeval) values (" + "'"+ pTipoEvaluacion + "'" + "," + "'" + pDescripcion +"'" + ")");	
	}
	
	public void registrarEvaluacion(String pCodigoEvaluacion, String pCodigoCurso, String pCodTipoEvaluacion,String pNombreEvaluacion, int pPuntajetotal, int pPorcentajenotafinal, String pFechaevaluacion, int pTiempominutos)
	{
		getConexion().insertDelete("insert into evaluacion (codevaluacion, codigocurso, codtipoevaluacion, nombreevaluacion, puntajetotal, porcentajenotafinal, fechaevaluacion, tiempominutos,status) values ("+pCodigoEvaluacion+","+"'"+ pCodigoCurso+ "'"+","+ pCodTipoEvaluacion+","+"'"+ pNombreEvaluacion+"'"+","+  pPuntajetotal+","+  pPorcentajenotafinal+","+  "'"+pFechaevaluacion+"'"+","+  pTiempominutos +","+ "B'0'"+ ")" );
	}
	
	public void registrarPregunta(int pCodPregunta, int pCodEvaluacion, int pPuntaje)
	{
		getConexion().insertDelete("insert into evaluacionpregunta (codigopregunta, codevaluacion, puntajeasignado) values ("+pCodPregunta+","+pCodEvaluacion+","+pPuntaje+")");
	}
}
