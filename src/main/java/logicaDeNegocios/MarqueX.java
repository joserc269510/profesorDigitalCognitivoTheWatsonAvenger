package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class  MarqueX extends pregunta
{
	private int codTipoPregunta;
	private String tipoPregunta;
	private String  descripcionTipoPreg;
	BaseDeDatos conexion;
	

	public MarqueX(int pCodigoPregunta, int pCodigoTipoPregunta, String pDescripcionPregunta, String pDescripcionAyuda, String pTipoPregunta, String pDescripcionTipoPreg){
		super( pCodigoPregunta,  pDescripcionPregunta,  pDescripcionAyuda);
		setTipoPregunta(tipoPregunta);
		setDescripcionTipoPreg(descripcionTipoPreg);
		setCodTipoPregunta(pCodigoTipoPregunta);
		conexion = new BaseDeDatos();
	}
	public  MarqueX ( String pTipoPregunta, String pDescripcion) 
	{
		super();
		setTipoPregunta(pTipoPregunta);
		setDescripcionTipoPreg(pDescripcion);
		conexion = new BaseDeDatos();
	}
	public  MarqueX(){
		super();
		conexion = new BaseDeDatos();
		
	}
	
	public void registrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		setDescripcionTipoPreg(pDescripcion);
		getConexion().insertDelete("insert into tipopregunta(nombretipopreg, decripcion) values ("+ 6+",'"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	public void registrarPregunta(String CodP,String sub, String descp, String descpAy)
	{
     
		int codP= Integer.parseInt(CodP);
		int Subt=Integer.parseInt(sub);
		setCodigoPregunta(codP);
		
		
		//setStatus(stt);
		
		BaseDeDatos conexion = new BaseDeDatos();
		conexion.insertDelete("insert into pregunta(codigopregunta,codsubtema,codtipopregunta,descripcionpregunta,descripcionayuda)"
				+ " values (" + codP  + ","+ Subt  + "," + 1  + "," +  "'" + descp + "'" + "," + "'"+ descpAy+ "'"  + ")" ) ;
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
