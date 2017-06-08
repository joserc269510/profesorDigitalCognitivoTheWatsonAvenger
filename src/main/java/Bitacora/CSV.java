package Bitacora;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class CSV extends Bitacora {
	
	public CSV(Date pFecha, String pDescripcion, String pUser){
		super( pFecha,  pDescripcion,  pUser);	
	}
	public CSV(){
		super();
	}
	
	public void generarCSV(ArrayList<Bitacora>lista){
		final String NEXT_LINE = "\n";
		final String delim = ";";
		try {
			FileWriter archivo = new FileWriter("C:/Users/Esteban Morales/Desktop/bitacora.csv");
			
			for (int i=0; i<lista.size(); i++){
				archivo.append(lista.get(i).getUser()).append(delim);
				archivo.append(lista.get(i).getFecha().toString()).append(delim);
				archivo.append(lista.get(i).getDescripcion()).append(NEXT_LINE);
			}
			archivo.flush();
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void generarDocumento(String pUsuario, String pFechaInicio, String pFechaFinal) {
		generarCSV(consultarBitacora(pUsuario,pFechaInicio, pFechaFinal));
		
	}

}
