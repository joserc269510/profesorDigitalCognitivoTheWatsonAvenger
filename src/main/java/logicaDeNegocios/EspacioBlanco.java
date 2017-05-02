package logicaDeNegocios;

import Integracion.BaseDeDatos;

public class EspacioBlanco extends pregunta 
{
	private String tipoPregunta;
	private String descripcionTipoPreg;
	private int codigoTipoPregunta;
	

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
		
	}
	
	public EspacioBlanco(){
		super();
		conexion = new BaseDeDatos();
	}

	public void registrarTipoPregunta(String pTipoPregunta, String pDescripcion) 
	{
		setTipoPregunta(pTipoPregunta);
		BaseDeDatos conexion= new BaseDeDatos();
		conexion.insertDelete("insert into tipopregunta values (" + "'"+ pTipoPregunta + "'" + "," + "'" + pDescripcion +"'" + ")");
		
	}
	
	public void registrarPregunta(String CodP,String sub, String descp, String descpAy)
	{
     
		int codP= Integer.parseInt(CodP);
		int Subt=Integer.parseInt(sub);
		setCodigoPregunta(codP);
		
		
		//setStatus(stt);
		
		BaseDeDatos conexion = new BaseDeDatos();
		conexion.insertDelete("insert into pregunta(codigopregunta,codsubtema,codtipopregunta,descripcionpregunta,descripcionayuda)"
				+ " values (" + codP  + ","+ Subt  + "," + 3  + "," +  "'" + descp + "'" + "," + "'"+ descpAy+ "'"  + ")" ) ;
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
