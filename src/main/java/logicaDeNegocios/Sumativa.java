package logicaDeNegocios;

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
	public void registrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion) {
		setTipoEvaluacion(pTipoEvaluacion);
		getConexion().insertDelete("insert into tipoevaluacion values (" + "'"+ pTipoEvaluacion + "'" + "," + "'" + pDescripcion +"'" + ")");	
	}

}
