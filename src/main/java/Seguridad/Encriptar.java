package Seguridad;

public abstract class Encriptar {

	String NuePIN;
	public Encriptar(){
		NuePIN = "";
	}
	
	public abstract void encriptarCadena(entradaEncriptarDesencriptar objetoEntrada);

    public String getPIN(){
        return NuePIN;
    }
    
}
