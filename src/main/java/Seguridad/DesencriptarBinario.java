package Seguridad;

public class DesencriptarBinario  extends Desencriptar{

	public DesencriptarBinario (){
		super();
	}
	@Override
	public void desencriptarCadena(entradaEncriptarDesencriptar objetoEntrada) {
		objetoEntrada.setPin(objetoEntrada.getPin() + " ");
        int largo= objetoEntrada.getPin().length();
        int len=0;
        
        while(len!=largo){
        	String nLetra="";
        	while((objetoEntrada.getPin().charAt(len)!=' ')&&(objetoEntrada.getPin().charAt(len)!='*')){
        		nLetra=nLetra+objetoEntrada.getPin().charAt(len);
        		len++;
        	}
        	len++;
            
        	if(nLetra!=""){
            	Integer num=Integer.parseInt(nLetra, 2);
            	char[] caracter=Character.toChars(num);
                NuePIN=NuePIN+caracter[0];
            }
        	else{
        		NuePIN=NuePIN+" ";
        	}
        }
		
	}
	
}
