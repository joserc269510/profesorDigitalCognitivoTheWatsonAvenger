package logicaDeNegocios;

import java.util.Date;

import Integracion.BaseDeDatos;


public class Respuesta {
	private int codRespuesta;
	private int codigoPregunta;
	private String descripcionRespuesta;
	private boolean status;
	private BaseDeDatos conexion;
	


	
	public BaseDeDatos getConexion() {
		if (conexion == null){
			conexion = new BaseDeDatos();
		}
		return conexion;
	}

	public void setConexion(BaseDeDatos conexion) {
		this.conexion = conexion;
	}

	public int getCodRespuesta() {
		return codRespuesta;
	}
	public void setCodRespuesta(int codRespuesta) {
		this.codRespuesta = codRespuesta;
	}
	public int getCodigoPregunta() {
		return codigoPregunta;
	}
	public void setCodigoPregunta(int codigoPregunta) {
		this.codigoPregunta = codigoPregunta;
	}
	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}
	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void registrarRespuesta(String CodP, String descp, String stt)
	{
     
		int codP= Integer.parseInt(CodP);
		setCodigoPregunta(codP);
		setDescripcionRespuesta(descp);
		//setStatus(stt);
		
		BaseDeDatos conexion = new BaseDeDatos();
		conexion.insertDelete("insert into respuesta(codigopregunta,descripcionrespuesta,status) values (" + codP  + "," +  "'" + descp + "'" + "," + "'"+  "B" + stt + "'"  + ")" ) ;
	}
	private static int calculoLevenshtein(String str1,String str2) {
		int distancia=0;
		int[][] matriz;
	      matriz = new int[str1.length() + 1][str2.length() + 1];
	      for (int i = 0; i <= str1.length(); i++) {
	         matriz[i][0] = i;
	      }
	      for (int j = 0; j <= str2.length(); j++) {
	         matriz[0][j] = j;
	      }
	      for (int i = 1; i < matriz.length; i++) {
	         for (int j = 1; j < matriz[i].length; j++) {
	            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
	               matriz[i][j] = matriz[i - 1][j - 1];
	            } else {
	               int min = Integer.MAX_VALUE;
	               if ((matriz[i - 1][j]) + 1 < min) {
	                  min = (matriz[i - 1][j]) + 1;
	               }
	               if ((matriz[i][j - 1]) + 1 < min) {
	                  min = (matriz[i][j - 1]) + 1;
	               }
	               if ((matriz[i - 1][j - 1]) + 1 < min) {
	                  min = (matriz[i - 1][j - 1]) + 1;
	               }
	               matriz[i][j] = min;
	            }
	         }
	      }
	      distancia = matriz[str1.length()][str2.length()];
	      return distancia;
	   }
	
	public static void setWords(String str1, String str2) {
	     
	      calculoLevenshtein(str1,str2);
	   }

	

	 public static float getAfinidad(String str1,String str2) {
		 int ff=calculoLevenshtein(str1,str2);
	      float longitud = str1.length() > str2.length() ? str1.length() : str2.length();
	      return 1 - (ff / longitud);
	   }
	 
	 public static boolean revisar(String respEst,String respPro){
	    	setWords(respEst,respPro);
	       // System.out.println(ld.getAfinidad());
	        if(getAfinidad(respEst, respPro)>0.45){
	        	return true;
	        }
	        return false;
	    	
	    }
	
	
}
