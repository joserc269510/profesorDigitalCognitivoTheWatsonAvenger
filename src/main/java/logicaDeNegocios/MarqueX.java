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
	public  MarqueX ( String pTipoPregunta, String pDescripcion) 
	{
		super();
		setTipoPregunta(pTipoPregunta);
		setDescripcionTipoPreg(pDescripcion);
		
	}
	public MarqueX(){}
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
	
	
	
}
