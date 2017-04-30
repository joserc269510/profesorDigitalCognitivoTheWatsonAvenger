package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Sumativa extends Evaluacion 
{
	protected int codTipoEvaluacion;
	protected String tipoEvaluacion;
	protected String descripcionTipoEval;
	

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
	public void setDescripcionTipoEval(String descripcionTipoEval) {
		this.descripcionTipoEval = descripcionTipoEval;
	}
	@Override
	public void RegistrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) {
		setTipoEvaluacion(pTipoEvaluacion);
		BaseDeDatos conexion=  new BaseDeDatos();
		conexion.insertDelete("insert into tipoevaluacion values (" + "'"+ pTipoEvaluacion + "'" + "," + "'" + pDescripcion +"'" + ")");	
	}

}
