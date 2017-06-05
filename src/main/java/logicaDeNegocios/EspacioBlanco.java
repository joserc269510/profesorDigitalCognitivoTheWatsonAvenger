package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class EspacioBlanco extends pregunta 
{
	private String tipoPregunta;
	private String descripcionTipoPreg;
	private int codigoTipoPregunta;
	BaseDeDatos conexion;
	

	public EspacioBlanco(int pCodigoPregunta,int pCodigoTipoPregunta, String pDescripcionPregunta, String pDescripcionAyduda, String pTipoPregunta, String pDescripcionTipoPreg){
		super( pCodigoPregunta,  pDescripcionPregunta,  pDescripcionAyduda);
		setTipoPregunta(pTipoPregunta);
		setDescripcion(pDescripcionTipoPreg);
		setCodigoTipoPregunta(pCodigoTipoPregunta);
		conexion = new BaseDeDatos();
	}

	public EspacioBlanco( String pTipoPregunta, String pDescripcion) 
	{
		super();
		setTipoPregunta(pTipoPregunta);
		setDescripcion(pDescripcion);
		conexion = new BaseDeDatos();
		
	}
	
	public EspacioBlanco(){
		super();
		conexion = new BaseDeDatos();
	}

	public void registrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		setDescripcionTipoPreg(pDescripcion);
		//conexion.insertDelete("insert into tipopregunta(nombretipopreg,decripcion) values (" + "'"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		getConexion().insertDelete("insert into tipopregunta(nombretipopreg, decripcion) values (" + "'"+pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
	}
	
	public void registrarPregunta(String CodP,String sub, String descp, String descpAy)
	{
     
		int codP= Integer.parseInt(CodP);
		int Subt=Integer.parseInt(sub);
		setCodigoPregunta(codP);
		
		
		//setStatus(stt);
		
		
		//getConexion().insertDelete("insert into pregunta(codigopregunta,codsubtema,codtipopregunta,descripcionpregunta,descripcionayuda)"
		//		+ " values (" + codP  + ","+ Subt  + "," + 2  + "," +  "'" + descp + "'" + "," + "'"+ descpAy+ "'"  + ")" ) ;
		conexion.insertDelete("insert into pregunta(codigopregunta,codsubtema,codtipopregunta,descripcionpregunta,descripcionayuda)"
				+ " values (" + codP  + ","+ Subt  + "," + 2  + "," +  "'" + descp + "'" + "," + "'"+ descpAy+ "'"  + ")" ) ;
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
