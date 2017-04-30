package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class  MarqueX extends pregunta
{
	private int codTipoPregunta;
	protected String tipoPregunta;
	protected String  descripcionTipoPreg;

	public MarqueX(int codigoPregunta, int codigoTipoPregunta, String descripcionPregunta, String descripcionAyduda, String tipoPregunta, String descripcionTipoPreg){
		super( codigoPregunta,  descripcionPregunta,  descripcionAyduda);
		setTipoPregunta(tipoPregunta);
		setDescripcionTipoPreg(descripcionTipoPreg);
		setCodTipoPregunta(codigoTipoPregunta);
	}
	
	
	public void RegistrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		setDescripcionTipoPreg(pDescripcion);
		BaseDeDatos conexion= new BaseDeDatos();
		conexion.insertDelete("insert into tipopregunta values (" + 1 + "," + "'"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	
	public int getCodTipoPregunta() {
		return codTipoPregunta;
	}

	public void setCodTipoPregunta(int codTipoPregunta) {
		this.codTipoPregunta = codTipoPregunta;
	}
	
	public String getTipoPregunta()
	{
		return tipoPregunta;
	}

	public void setTipoPregunta(String pTipoPregunta) 
	{
		tipoPregunta = pTipoPregunta;
	}

	public String getDescripcionTipoPreg() 
	{
		return descripcionTipoPreg;
	}

	public void setDescripcionTipoPreg(String pDescripcionTipoPreg) 
	{
		descripcionTipoPreg = pDescripcionTipoPreg;
	}
	
	
	
	
}
