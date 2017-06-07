package Seguridad;

public class EncriptarBinario extends Encriptar {
	
	public EncriptarBinario(){
		super();
	}
    
	@Override
	public void encriptarCadena(entradaEncriptarDesencriptar objetoEntrada) {
		String Abc="abcdefghijklmnopqrstuvwxyz ";
        int largo= objetoEntrada.getPin().length();
        int len=0;
        int Let=0;
        
        
        while(len!=largo){
            char letra=objetoEntrada.getPin().charAt(len);
            if (letra==Abc.charAt(Let)){
            	 if(letra==' '){
                 	 NuePIN=NuePIN+"*"+" ";
                     len++;
                     Let=0;
            	 }
                else{
                	String letraBinaria = Integer.toBinaryString(Abc.charAt(Let));
                    NuePIN=NuePIN+letraBinaria+" ";
                    len++;
                    Let=0;
                }
            }
            else{
                Let++;
            }
        }
		
	}
}
