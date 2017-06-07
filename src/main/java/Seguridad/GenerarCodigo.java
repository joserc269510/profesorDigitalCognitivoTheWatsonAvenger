package Seguridad;

import java.io.IOException;
import java.net.MalformedURLException;

import Integracion.BaseDeDatos;

public class GenerarCodigo {	
	int numero=0;
	BaseDeDatos baseDeDatos;
	
	public GenerarCodigo(int numero){
		baseDeDatos = new BaseDeDatos();
		setNumero(numero);
	}
	public GenerarCodigo(){
		baseDeDatos = new BaseDeDatos();
	}
	
	public int generarCodigo(){
		int aleatorio= (int) Math.floor(Math.random()*1000);
		setNumero(aleatorio);
		return aleatorio;
	}
	

	public void enviarSMS(String numeroTelefono, String carnet){
		try {
			
			String codigoEnviado = String.valueOf(generarCodigo());
			EnviarSMS sms = new EnviarSMS(numeroTelefono, codigoEnviado);
			baseDeDatos.insertDelete("Update estudiante SET codigoespecial='" + codigoEnviado + "' where numerocarne='" +carnet+"'");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean validarCodigo(String codigo, String carnet){
		String codigoBueno = baseDeDatos.selectCodigoSMS(carnet);
		System.out.println(codigo);
		System.out.println(carnet);
		System.out.println(codigoBueno);
		boolean esIgual = false;
		if (codigoBueno.compareTo(codigo) == 0){
			esIgual = true;
		}
		return esIgual;
	}
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
