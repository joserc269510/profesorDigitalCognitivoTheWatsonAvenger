package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class Desarrollo extends pregunta 
{
	private String tipoPregunta;
	private String descripcionTipoPreg;
	private int codigoTipoPregunta;
	BaseDeDatos conexion;
	
	public Desarrollo(int pCodigoPregunta, int pCodigoTipoPregunta, String pDescripcionPregunta, String pDescripcionAyduda, String pTipoPregunta, String pDescripcionTipoPreg){
		super(pCodigoPregunta,pDescripcionPregunta,pDescripcionAyduda);
		setTipoPregunta(pTipoPregunta);
		setDescripcion(pDescripcionTipoPreg);
		setCodigoTipoPregunta(pCodigoTipoPregunta);
		conexion = new BaseDeDatos();
	}
	public Desarrollo( String pTipoPregunta, String pDescripcion) {
		super();
		setTipoPregunta(pTipoPregunta);
		setDescripcion(pDescripcion);
		conexion = new BaseDeDatos();
		
	}

	public void registrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		getConexion().insertDelete("insert into tipopregunta values (" + "'"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	
	public void registrarPregunta(String CodP,String sub, String descp, String descpAy){//no esta en dise;o
     
		int codP= Integer.parseInt(CodP);
		int Subt=Integer.parseInt(sub);
		setCodigoPregunta(codP);
		
		
		//setStatus(stt);
		
		BaseDeDatos conexion = new BaseDeDatos();
		conexion.insertDelete("insert into pregunta(codigopregunta,codsubtema,codtipopregunta,descripcionpregunta,descripcionayuda)"
				+ " values (" + codP  + ","+ Subt  + "," + 4  + "," +  "'" + descp + "'" + "," + "'"+ descpAy+ "'"  + ")" ) ;
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
	public void registrarPregunta(String CodP,String sub, String descp, String descpAy)
	{
     
		int codP= Integer.parseInt(CodP);
		int Subt=Integer.parseInt(sub);
		setCodigoPregunta(codP);
		
		
		//setStatus(stt);
		
		BaseDeDatos conexion = new BaseDeDatos();
		conexion.insertDelete("insert into pregunta(codigopregunta,codsubtema,codtipopregunta,descripcionpregunta,descripcionayuda)"
				+ " values (" + codP  + ","+ Subt  + "," + 4  + "," +  "'" + descp + "'" + "," + "'"+ descpAy+ "'"  + ")" ) ;
	}

}
