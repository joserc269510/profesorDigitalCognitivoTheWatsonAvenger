package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class EspacioBlanco extends Pregunta 
{
	protected String tipoPregunta;
	protected String descripcionTipoPreg;
	private int codigoTipoPregunta;
	
	public EspacioBlanco(int codigoPregunta,int codigoTipoPregunta, String descripcionPregunta, String descripcionAyduda, String tipoPregunta, String descripcionTipoPreg){
		super( codigoPregunta,  descripcionPregunta,  descripcionAyduda);
		setTipoPregunta(tipoPregunta);
		setDescripcion(descripcionTipoPreg);
		setCodigoTipoPregunta(codigoTipoPregunta);
	}

	public void RegistrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		BaseDeDatos conexion= new BaseDeDatos();
		conexion.insertDelete("insert into tipopregunta values (" + "'"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	
	public String getDescripcionTipoPreg() {
		return descripcionTipoPreg;
	}

	public void setDescripcionTipoPreg(String descripcionTipoPreg) {
		this.descripcionTipoPreg = descripcionTipoPreg;
	}


	public int getCodigoTipoPregunta() {
		return codigoTipoPregunta;
	}


	public void setCodigoTipoPregunta(int codigoTipoPregunta) {
		this.codigoTipoPregunta = codigoTipoPregunta;
	}


	public String getTipoPregunta() {
		return tipoPregunta;
	}

	public void setTipoPregunta(String tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}

	public String getDescripcion() 
	{
		return descripcionTipoPreg;
	}

	public void setDescripcion(String pDescripcion) 
	{
		descripcionTipoPreg = pDescripcion;
	}
	
}
