/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Seguridad;

/**
 * @author Esteban
 */
public class DesencriptarLlave extends Desencriptar {

    public DesencriptarLlave(){
        super();
    }

	@Override
	public void desencriptarCadena(entradaEncriptarDesencriptar objetoEntrada) {
		String Abc="abcdefghijklmnopqrstuvwxyz ";
        int largo= objetoEntrada.getPin().length();
        int Num1=objetoEntrada.getClave()/10;
        int Num2=objetoEntrada.getClave()%10;
        int len=0;
        int Let=0;
        int Turno=0;
        
        while(len!=largo){
            char letra=objetoEntrada.getPin().charAt(len);
            if (letra==Abc.charAt(Let)){
            	if(letra==' '){
                 	 NuePIN=NuePIN+Abc.charAt(Let);
                     len++;
                     Turno=0;
                     Let=0;
            	 }
            	else if (Turno==0){
                    int cmb=Let-Num1;
                    if (cmb<0){
                        cmb=26+cmb;
                    }
                    NuePIN=NuePIN+Abc.charAt(cmb);
                    Turno=1;
                    len++;
                    Let=0;
                }
                else{
                    int cmb=Let-Num2;
                    if (cmb<0){
                        cmb=26+cmb;
                    }
                    NuePIN=NuePIN+Abc.charAt(cmb);
                    Turno=0;
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
