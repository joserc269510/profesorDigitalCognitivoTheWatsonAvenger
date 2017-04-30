package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Formativa extends Evaluacion 
{
	protected int codTipoEvaluacion;
	protected String tipoEvaluacion;
	protected String descripcionTipoEval;
	
	public Formativa(int codEvaluacion, String nombreEvaluacion,int puntajeTotal,int porcentajeNotaFinal,String fechaEvaluacion,int tiempoMinutos,boolean status,int codTipoEvaluacion,String tipoEvaluacion,String descripcionTipoEval){
		super( codEvaluacion,  nombreEvaluacion, puntajeTotal, porcentajeNotaFinal, fechaEvaluacion, tiempoMinutos, status);
		setCodTipoEvaluacion(codTipoEvaluacion);
		setTipoEvaluacion(tipoEvaluacion);
		setDescripcionTipoEval(descripcionTipoEval);
	}
	public Formativa(){
		super();
	}
	
	
	public void RegistrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) 
	{
		setTipoEvaluacion(pTipoEvaluacion);
		setDescripcionTipoEval(pDescripcion);
		BaseDeDatos conexion=  new BaseDeDatos();
		conexion.insertDelete("insert into tipoevaluacion values (" + "'"+ pTipoEvaluacion + "'" + "," + "'" + pDescripcion +"'" + ")");
		
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
