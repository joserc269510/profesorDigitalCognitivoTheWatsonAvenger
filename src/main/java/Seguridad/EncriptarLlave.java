/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Seguridad;

/**
 *
 * @author Esteban
 */
public class EncriptarLlave extends Encriptar {

	public EncriptarLlave(){
		super();
	}
	@Override
	public void encriptarCadena(entradaEncriptarDesencriptar objetoEntrada) {
		String Abc="abcdefghijklmnopqrstuvwxyz ";
        String Abc2="abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
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
                    NuePIN=NuePIN+Abc2.charAt(Let+Num1);
                    Turno=1;
                    len++;
                    Let=0;
                }
                else{
                    NuePIN=NuePIN+Abc2.charAt(Let+Num2);
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
 