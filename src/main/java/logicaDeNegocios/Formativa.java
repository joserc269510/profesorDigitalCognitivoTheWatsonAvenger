package logicaDeNegocios;

import java.util.Date;

import Integracion.BaseDeDatos;

public class Formativa extends Evaluacion 
{
	private int codTipoEvaluacion;
	private String tipoEvaluacion;
	private String descripcionTipoEval;
	private BaseDeDatos conexion;
	
	public Formativa(int pCodEvaluacion, String pNombreEvaluacion,int pPuntajeTotal,int pPorcentajeNotaFinal,String pFechaEvaluacion,int pTiempoMinutos,boolean pStatus,int pCodTipoEvaluacion,String pTipoEvaluacion,String pDescripcionTipoEval)
	{
		super( pCodEvaluacion,  pNombreEvaluacion, pPuntajeTotal, pPorcentajeNotaFinal, pFechaEvaluacion, pTiempoMinutos, pStatus);
		setCodTipoEvaluacion(pCodTipoEvaluacion);
		setTipoEvaluacion(pTipoEvaluacion);
		setDescripcionTipoEval(pDescripcionTipoEval);
		conexion = new BaseDeDatos();
	}
	
	public Formativa()
	{
		super();
		conexion = new BaseDeDatos();
	}
	
	public Formativa (String pTipoEvaluacion, String pDescripcion)
	{
		super();
		conexion = new BaseDeDatos();
		setDescripcionTipoEval(pDescripcion);
		setTipoEvaluacion(pTipoEvaluacion);
	}
	
	public void registrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) 
	{
		setTipoEvaluacion(pTipoEvaluacion);
		setDescripcionTipoEval(pDescripcion);
		System.out.println("insert into tipoevaluacion (tipoevaluacion,descripciontipoeval) values (" + "'"+ pTipoEvaluacion + "'" + "," + "'" + pDescripcion +"'" + ")");
		getConexion().insertDelete("insert into tipoevaluacion (tipoevaluacion,descripciontipoeval) values (" + "'"+ pTipoEvaluacion + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	public void registrarEvaluacion(String pCodigoEvaluacion, String pCodigoCurso, String pCodTipoEvaluacion,String pNombreEvaluacion, int pPuntajetotal, int pPorcentajenotafinal, String pFechaevaluacion, int pTiempominutos, String pAleatorio)
	{
		getConexion().insertDelete("insert into evaluacion (codevaluacion, codigocurso, codtipoevaluacion, nombreevaluacion, puntajetotal, porcentajenotafinal, fechaevaluacion, tiempominutos,status,aleatorio) values ("+pCodigoEvaluacion+","+"'"+ pCodigoCurso+ "'"+","+ pCodTipoEvaluacion+","+"'"+ pNombreEvaluacion+"'"+","+  pPuntajetotal+","+  pPorcentajenotafinal+","+  "'"+pFechaevaluacion+"'"+","+  pTiempominutos +","+ "B'0'"+","+pAleatorio+ ")" );
	}
	
	public void registrarPregunta(int pCodPregunta, int pCodEvaluacion, int pPuntaje){
		getConexion().insertDelete("insert into evaluacionpregunta (codigopregunta, codevaluacion, puntajeasignado) values ("+pCodPregunta+","+pCodEvaluacion+","+pPuntaje+")");
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
	
	public int getCodTipoEvaluacion() 
	{
		return codTipoEvaluacion;
	}
	
	public void setCodTipoEvaluacion(int pCodTipoEvaluacion) 
	{
	  codTipoEvaluacion = pCodTipoEvaluacion;
	}
	
	public String getTipoEvaluacion() 
	{
		return tipoEvaluacion;
	}
	public void setTipoEvaluacion(String tipoEvaluacion) 
	{
		this.tipoEvaluacion = tipoEvaluacion;
	}
	public String getDescripcionTipoEval() 
	{
		return descripcionTipoEval;
	}
	public void setDescripcionTipoEval(String descripcionTipoEval) 
	{
		this.descripcionTipoEval = descripcionTipoEval;
	}
	
	
	
}
