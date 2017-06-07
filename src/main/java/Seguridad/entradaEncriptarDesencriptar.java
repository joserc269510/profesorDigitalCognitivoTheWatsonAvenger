package Seguridad;

public class entradaEncriptarDesencriptar {
	String Pin;
	int Clave;
	public entradaEncriptarDesencriptar(String pin, int clave){
		setPin(pin);
		setClave(clave);
	}
	public entradaEncriptarDesencriptar(String pin){
		setPin(pin);
	}
	public String getPin() {
		return Pin;
	}
	public void setPin(String pin) {
		Pin = pin;
	}
	public int getClave() {
		return Clave;
	}
	public void setClave(int clave) {
		Clave = clave;
	}

}
