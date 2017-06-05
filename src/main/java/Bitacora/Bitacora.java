package Bitacora;

import Integracion.BaseDeDatos;
import Seguridad.Encriptar;
import Seguridad.Desencriptar;
import java.util.ArrayList;
import java.util.Date;

public class Bitacora {
	public Date fecha;
	public String user;
	public String descripcion;
	BaseDeDatos baseDeDatos;
	public Bitacora(Date pFecha, String pDescripcion, String pUser){
		setFecha(pFecha);
		setUser(pUser);
		setDescripcion(pDescripcion);
		baseDeDatos = new BaseDeDatos();
	}
	public Bitacora(){
		baseDeDatos = new BaseDeDatos();
	}
	
	public void insertarEnBitacora(String pUser, String pDescripcion){
		Encriptar PIN = new Encriptar(pDescripcion,23);
		baseDeDatos.insertDelete("insert into bitacora (fecha, descripcion, usuario) values (" +"'"+ sacarFecha() + "'"+","+ "'" +PIN.getPIN() +"'" +"," +"'" + pUser + "'"+")");
	}
	
	//2017-03-10 13:29:49
	public ArrayList<Bitacora> consultarBitacora(String pUsuario, String pFechaInicio, String pFechaFinal){
		ArrayList<Bitacora> listaBitacora = baseDeDatos.selectBitacora(pFechaInicio, pFechaFinal, pUsuario);
		
		for (int i=0; i<listaBitacora.size();i++){
			Desencriptar PIN=new Desencriptar(listaBitacora.get(i).getDescripcion(),23);
			listaBitacora.get(i).setDescripcion(PIN.getPIN());
		}
		return listaBitacora;
		
	}
	
	public void generarXML(String pUsuario, String pFechaInicio, String pFechaFinal){
		XML xml = new XML();
		xml.generarXML(consultarBitacora(pUsuario,pFechaInicio, pFechaFinal));
	}
	public void generarCSV(String pUsuario, String pFechaInicio, String pFechaFinal){
		CSV csv = new CSV();
		csv.generarCSV(consultarBitacora(pUsuario,pFechaInicio, pFechaFinal));
	}
	public void generarArchivoPlano(String pUsuario, String pFechaInicio, String pFechaFinal){
		TXT txt = new TXT();
		txt.generarTXT(consultarBitacora(pUsuario,pFechaInicio, pFechaFinal));
	}
	
	
	public Date sacarFecha(){
		Date fecha = new Date();
		return fecha;
		
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}

/*
create table Bitacora (
  idBitacora SERIAL UNIQUE, 
  fecha timestamp,
  descripcion varchar(500),
  usuario varchar(50) 
);
*/
