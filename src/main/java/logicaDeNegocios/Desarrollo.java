package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Desarrollo extends pregunta 
{
	protected String tipoPregunta;
	protected String descripcionTipoPreg;
	int codigoTipoPregunta;
	BaseDeDatos conexion;
	
	public Desarrollo(int codigoPregunta, int codigoTipoPregunta, String descripcionPregunta, String descripcionAyduda, String tipoPregunta, String descripcionTipoPreg){
		super(codigoPregunta,descripcionPregunta,descripcionAyduda);
		setTipoPregunta(tipoPregunta);
		setDescripcion(descripcionTipoPreg);
		setCodigoTipoPregunta(codigoTipoPregunta);
		conexion = new BaseDeDatos();
	}
	public Desarrollo( String pTipoPregunta, String pDescripcion) {
		super();
		setTipoPregunta(pTipoPregunta);
		setDescripcion(pDescripcion);
		conexion = new BaseDeDatos();
		
	}

	public void RegistrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		getConexion().insertDelete("insert into tipopregunta values (" + "'"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		
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

	public void setDescripcion(String pDescripcion) {
		descripcionTipoPreg = pDescripcion;
	}
	

}
