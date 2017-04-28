package logicaDeNegocios;

public class Evaluacion {
	int codEvaluacion;
	String codigoCurso;
	String nombreEvaluacion;
	int puntajeTotal;
	int porcentajeNotaFinal;
	String fechaEvaluacion;
	int tiempoMinutos;
	boolean status;
	String tipoEvaluacion;
	String descripcionTipoEval;
	
	public int getCodEvaluacion() {
		return codEvaluacion;
	}
	public void setCodEvaluacion(int codEvaluacion) {
		this.codEvaluacion = codEvaluacion;
	}
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public String getNombreEvaluacion() {
		return nombreEvaluacion;
	}
	public void setNombreEvaluacion(String nombreEvaluacion) {
		this.nombreEvaluacion = nombreEvaluacion;
	}
	public int getPuntajeTotal() {
		return puntajeTotal;
	}
	public void setPuntajeTotal(int puntajeTotal) {
		this.puntajeTotal = puntajeTotal;
	}
	public int getPorcentajeNotaFinal() {
		return porcentajeNotaFinal;
	}
	public void setPorcentajeNotaFinal(int porcentajeNotaFinal) {
		this.porcentajeNotaFinal = porcentajeNotaFinal;
	}
	public String getFechaEvaluacion() {
		return fechaEvaluacion;
	}
	public void setFechaEvaluacion(String fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}
	public int getTiempoMinutos() {
		return tiempoMinutos;
	}
	public void setTiempoMinutos(int tiempoMinutos) {
		this.tiempoMinutos = tiempoMinutos;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
