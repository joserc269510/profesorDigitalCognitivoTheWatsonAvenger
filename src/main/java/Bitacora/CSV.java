package Bitacora;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {
	
	public void generarCSV(ArrayList<Bitacora>lista){
		final String NEXT_LINE = "\n";
		final String delim = ";";
		try {
			FileWriter archivo = new FileWriter("/Users/joseramirezcalderon/Desktop/bitacora.csv");
			
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

}
