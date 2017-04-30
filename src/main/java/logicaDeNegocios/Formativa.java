package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Formativa extends Evaluacion {
	int codTipoEvaluacion;
	String tipoEvaluacion;
	String descripcionTipoEval;
	
	public void RegistrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) {
		setTipoEvaluacion(pTipoEvaluacion);
		BaseDeDatos conexion=  new BaseDeDatos();
		conexion.insertDelete("insert into tipoevaluacion values (" + "'"+ pTipoEvaluacion + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	
	public int getCodTipoEvaluacion() {
		return codTipoEvaluacion;
	}
	public void setCodTipoEvaluacion(int pCodTipoEvaluacion) 
	{
	  codTipoEvaluacion = pCodTipoEvaluacion;
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
	public void setDescripcionTipoEval(String descripcionTipoEval) {
		this.descripcionTipoEval = descripcionTipoEval;
	}
	
	
	
}
