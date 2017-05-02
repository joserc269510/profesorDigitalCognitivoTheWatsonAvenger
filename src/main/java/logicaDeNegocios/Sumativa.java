package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Sumativa extends Evaluacion 
{
	protected int codTipoEvaluacion;
	protected String tipoEvaluacion;
	protected String descripcionTipoEval;
	BaseDeDatos conexion;
	
	public Sumativa(int codEvaluacion, String nombreEvaluacion,int puntajeTotal,int porcentajeNotaFinal,String fechaEvaluacion,int tiempoMinutos,boolean status,int codTipoEvaluacion,String tipoEvaluacion,String descripcionTipoEval){
		super( codEvaluacion,  nombreEvaluacion, puntajeTotal, porcentajeNotaFinal, fechaEvaluacion, tiempoMinutos, status);
		conexion = new BaseDeDatos();
		setCodTipoEvaluacion(codTipoEvaluacion);
		setTipoEvaluacion(tipoEvaluacion);
		setDescripcionTipoEval(descripcionTipoEval);
	}
	public Sumativa(){
		super();
		conexion = new BaseDeDatos();
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
	public void setDescripcionTipoEval(String descripcionTipoEval) {
		this.descripcionTipoEval = descripcionTipoEval;
	}
	@Override
	public void RegistrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) {
		setTipoEvaluacion(pTipoEvaluacion);
		getConexion().insertDelete("insert into tipoevaluacion values (" + "'"+ pTipoEvaluacion + "'" + "," + "'" + pDescripcion +"'" + ")");	
	}

}
