package Bitacora;

import Integracion.BaseDeDatos;
import Seguridad.Encriptar;
import Seguridad.EncriptarLlave;
import Seguridad.entradaEncriptarDesencriptar;
import Seguridad.Desencriptar;
import Seguridad.DesencriptarLlave;

import java.util.ArrayList;
import java.util.Date;

public abstract class Bitacora {
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
		entradaEncriptarDesencriptar objeto = new entradaEncriptarDesencriptar(pDescripcion,23);
		Encriptar PIN = new EncriptarLlave();
		PIN.encriptarCadena(objeto);
		baseDeDatos.insertDelete("insert into bitacora (fecha, descripcion, usuario) values (" +"'"+ sacarFecha() + "'"+","+ "'" +objeto.getPin() +"'" +"," +"'" + pUser + "'"+")");
	}
	
	//2017-03-10 13:29:49
	public ArrayList<Bitacora> consultarBitacora(String pUsuario, String pFechaInicio, String pFechaFinal){
		ArrayList<Bitacora> listaBitacora = baseDeDatos.selectBitacora(pFechaInicio, pFechaFinal, pUsuario);
		
		for (int i=0; i<listaBitacora.size();i++){
			entradaEncriptarDesencriptar objeto = new entradaEncriptarDesencriptar(listaBitacora.get(i).getDescripcion(),23);
			Desencriptar PIN= new DesencriptarLlave();
			PIN.desencriptarCadena(objeto);
			
			listaBitacora.get(i).setDescripcion(objeto.getPin());//PIN.getPIN()
		}
		return listaBitacora;
		
	}
	
	public abstract void generarDocumento(String pUsuario, String pFechaInicio, String pFechaFinal);
	
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
