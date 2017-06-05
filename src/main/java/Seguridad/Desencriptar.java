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
public class Desencriptar {
    String NuePIN="";
    
    public Desencriptar(String Pin, int Clave){
        String Abc="abcdefghijklmnopqrstuvwxyz ";
        int largo= Pin.length();
        int Num1=Clave/10;
        int Num2=Clave%10;
        int len=0;
        int Let=0;
        int Turno=0;
        
        while(len!=largo){
            char letra=Pin.charAt(len);
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
    
    public String getPIN(){
        return NuePIN;
    }
    
    public static void main(String args[]){
        Desencriptar PIN=new Desencriptar("vdthc ruqjtdodfd euksvriucikd fh fdvru bbidnvml jhpuan",23);
        System.out.print("vdthc ruqjtdodfd euksvriucikd fh fdvru bbidnvml jhpuan : ");
        System.out.println(PIN.getPIN());
    }
}
