package logicaDeNegocios;

import java.util.Date;

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
	public void registrarEvaluacion(String pCodigoEvaluacion, String pCodigoCurso, String pCodTipoEvaluacion,String pNombreEvaluacion, int pPuntajetotal, int pPorcentajenotafinal, String pFechaevaluacion, int pTiempominutos){
		getConexion().insertDelete("insert into evaluacion (codevaluacion, codigocurso, codtipoevaluacion, nombreevaluacion, puntajetotal, porcentajenotafinal, fechaevaluacion, tiempominutos,status) values ("+pCodigoEvaluacion+","+pCodigoCurso+","+ pCodTipoEvaluacion+","+ pNombreEvaluacion+","+  pPuntajetotal+","+  pPorcentajenotafinal+","+  pFechaevaluacion+","+  pTiempominutos +","+ "B'0'"+ ")" );
	}
	
	public void registrarPregunta(String pCodPregunta, String pCodEvaluacion, String pPuntaje){
		getConexion().insertDelete("insert into evaluacionpregunta (codigopregunta, codevaluacion, puntajeasignado) values ("+pCodPregunta+","+pCodEvaluacion+","+Integer.parseInt(pPuntaje)+")");
	}
}
