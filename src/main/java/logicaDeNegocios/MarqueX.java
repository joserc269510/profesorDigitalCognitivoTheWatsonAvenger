package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class  MarqueX extends pregunta
{
	private int codTipoPregunta;
	protected String tipoPregunta;
	protected String  descripcionTipoPreg;
	BaseDeDatos conexion;
	

	public MarqueX(int codigoPregunta, int codigoTipoPregunta, String descripcionPregunta, String descripcionAyduda, String tipoPregunta, String descripcionTipoPreg){
		super( codigoPregunta,  descripcionPregunta,  descripcionAyduda);
		setTipoPregunta(tipoPregunta);
		setDescripcionTipoPreg(descripcionTipoPreg);
		setCodTipoPregunta(codigoTipoPregunta);
		conexion = new BaseDeDatos();
	}
	public  MarqueX ( String pTipoPregunta, String pDescripcion) 
	{
		super();
		setTipoPregunta(pTipoPregunta);
		setDescripcionTipoPreg(pDescripcion);
		conexion = new BaseDeDatos();
	}
	
	public void RegistrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		setDescripcionTipoPreg(pDescripcion);
		getConexion().insertDelete("insert into tipopregunta(nombretipopreg, decripcion) values ( '"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		
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
