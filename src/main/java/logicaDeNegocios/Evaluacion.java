package logicaDeNegocios;

import Integracion.BaseDeDatos;

public abstract class Evaluacion 
{
	private int codEvaluacion;
	private String codigoCurso;
	private String nombreEvaluacion;
	private int puntajeTotal;
	private int porcentajeNotaFinal;
	private String fechaEvaluacion;
	private int tiempoMinutos;
	private boolean status;


	private String descripcionTipoEval;
	
	public abstract void RegistrarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion);
	
	public void VerificarTipoEvaluacion(String pTipoEvaluacion, String pDescripcion)
	{
		String tipoEvaluacion;
		
		tipoEvaluacion= pTipoEvaluacion.toLowerCase(); 
		
		if (tipoEvaluacion.equals("sumativa"))
		{
			Evaluacion tipoEvaluacionS= new Sumativa(); 
			tipoEvaluacionS.RegistrarTipoEvaluacion(pTipoEvaluacion, pDescripcion);
		}
		if (tipoEvaluacion.equals("formativa"))
		{
			Evaluacion tipoEvaluacionF= new Formativa();
			tipoEvaluacionF.RegistrarTipoEvaluacion(pTipoEvaluacion, pDescripcion);
		}
	}
	
	public int getCodEvaluacion() 
	{
		return codEvaluacion;
	}
	public void setCodEvaluacion(int pCodEvaluacion) 
	{
		codEvaluacion = pCodEvaluacion;
	}
	public String getCodigoCurso() 
	{
		return codigoCurso;
	}
	public void setCodigoCurso(String pCodigoCurso) 
	{
		codigoCurso = pCodigoCurso;
	}
	public String getNombreEvaluacion() 
	{
		return nombreEvaluacion;
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
	public void setStatus(boolean pStatus) 
	{
		status = pStatus;
	}

	
}
