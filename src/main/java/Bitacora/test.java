package Bitacora;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {		
		Bitacora bitacora = new XML();
		bitacora.generarDocumento("Jose", "2017-03-11 13:29:49","2017-07-07");
		//bitacora.insertarEnBitacora("Jose", "inserto en evaluaciones aaaaaaaaaaaaaaaaaa");
		//bitacora.consultarBitacora("Jose", "2017-03-11 13:29:49","2017-07-07");
		//bitacora.generarXML("Jose", "2017-03-11 13:29:49","2017-07-07");
		//bitacora.generarCSV("Jose", "2017-03-11 13:29:49","2017-07-07");
		
		//ArrayList <Bitacora> hola =bitacora.consultarBitacora("Jose", "2017-03-11 13:29:49","2017-07-07");
		//for (int i=0; i<hola.size();i++){
		//	System.out.println(hola.get(i).getDescripcion());
		//}
	//	bitacora.generarArchivoPlano("Jose", "2017-03-11 13:29:49","2017-07-07");
		
	}

}
