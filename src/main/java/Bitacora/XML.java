package Bitacora;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML extends Bitacora {
	
	public XML(Date pFecha, String pDescripcion, String pUser){
		super( pFecha,  pDescripcion,  pUser);	
	}
	
	public void generarXML(ArrayList<Bitacora>lista) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			// elemento raiz
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("BitacoraAdministrador");
			doc.appendChild(rootElement);
			
			for (int i=0; i<lista.size(); i++){
				// creacion sub etiqueta bitacora
				Element bitacora = doc.createElement("Bitacora");
				rootElement.appendChild(bitacora);
				Attr attr = doc.createAttribute("ID");
				attr.setValue(i + "");
				bitacora.setAttributeNode(attr);
				
				// nombre usuario
				Element user = doc.createElement("user");
				user.appendChild(doc.createTextNode(lista.get(i).getUser()));
				bitacora.appendChild(user);
		 
				// fecha realizacion
				Element fecha = doc.createElement("fecha");
				fecha.appendChild(doc.createTextNode(lista.get(i).getFecha().toString()));//rev
				bitacora.appendChild(fecha);
		 
				// descripcion
				Element descripcion = doc.createElement("descripcion");
				descripcion.appendChild(doc.createTextNode(lista.get(i).getDescripcion()));
				bitacora.appendChild(descripcion);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("/Users/joseramirezcalderon/Desktop/bitacora.xml"));
			StreamResult hola = new StreamResult(System.out);
			transformer.transform(source, result);
		
		
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	@Override
	public void generarDocumento(String pUsuario, String pFechaInicio, String pFechaFinal) {
		generarXML(consultarBitacora(pUsuario,pFechaInicio, pFechaFinal));
		
	}

}
