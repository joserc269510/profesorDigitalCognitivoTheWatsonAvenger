package Seguridad;

public abstract class Desencriptar {
	String NuePIN;
	public Desencriptar(){
		NuePIN = "";
	}
	
	public abstract void desencriptarCadena(entradaEncriptarDesencriptar objetoEntrada);

    public String getPIN(){
        return NuePIN;
    }

	public void setNuePIN(String nuePIN) {
		NuePIN = nuePIN;
	}

}
