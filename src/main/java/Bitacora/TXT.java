package Bitacora;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class TXT extends Bitacora{
	
	public TXT(Date pFecha, String pDescripcion, String pUser){
		super( pFecha,  pDescripcion,  pUser);	
	}
	
	public void generarTXT(ArrayList<Bitacora>lista){
        File archivo = new File("/Users/joseramirezcalderon/Desktop/bitacora.txt");
        try {
        	for (int i=0; i<lista.size(); i++){
        		FileWriter escribirArchivo = new FileWriter(archivo, true);
	        	escribirArchivo.write("Bitacora: " + i + "\n");
	        	escribirArchivo.write("Usuario: " + lista.get(i).getUser() + "\n");
	        	escribirArchivo.write("Fecha: " + lista.get(i).getFecha().toString() + "\n");
	        	escribirArchivo.write("Usuario: " + lista.get(i).getDescripcion() + "\n\n");
	        	escribirArchivo.close();
        	}
		} catch (IOException e) {
			e.printStackTrace();
		}
     
	}

	@Override
	public void generarDocumento(String pUsuario, String pFechaInicio, String pFechaFinal) {
		generarTXT(consultarBitacora(pUsuario,pFechaInicio, pFechaFinal));
		
	}
}
