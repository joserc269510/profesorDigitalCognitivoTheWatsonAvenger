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
public class Encriptar {
    String NuePIN="";
    
    public Encriptar(String Pin, int Clave){
        String Abc="abcdefghijklmnopqrstuvwxyz ";
        String Abc2="abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
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
    
    public String getPIN(){
        return NuePIN;
    }
    
    public static void main(String args[]){
        Encriptar PIN=new Encriptar("tarea programada criptografia de datos zygalski henryk",23);
        System.out.print("tarea programada criptografia de datos zygalski henryk : ");
        System.out.println(PIN.getPIN());
    }
}
    
/*   
    def encriptar(palabra,numero):
    abecedario="abcdefghijklmnñopqrstuvwxyzabcdefghijklmnñopqrstuvwxyz"
    
    numero=int(numero)
    num1=numero//10
    num2=numero%10
    cont=0
    cont2=0
    nueva_palabra=""
    var=0
    while len(palabra)!=cont:
        letra=palabra[cont]
        if letra==abecedario[cont2]:
            if var==0:
                nueva_palabra=nueva_palabra+abecedario[cont2+num1]
                var=1
                cont=cont+1
                cont2=0
            else:
                nueva_palabra=nueva_palabra+abecedario[cont2+num2]
                var=0
                cont=cont+1
                cont2=0
        else:
            cont2=cont2+1
    return(nueva_palabra)
#-----------------------------------------------------------------------------------------------------------------------------------------------------#
def desencriptar(palabra,numero):
    abecedario="abcdefghijklmnñopqrstuvwxyzabcdefghijklmnñopqrstuvwxyz"
    numero=int(numero)
    num1=numero//10
    num2=numero%10
    cont=0
    cont2=0
    nueva_palabra=""
    var=0
    while len(palabra)!=cont:
        letra=palabra[cont]
        if letra==abecedario[cont2]:
            if var==0:
                nueva_palabra=nueva_palabra+abecedario[cont2-num1]
                var=1
                cont=cont+1
                cont2=0
            else:
                nueva_palabra=nueva_palabra+abecedario[cont2-num2]
                var=0
                cont=cont+1
                cont2=0
        else:
            cont2=cont2+1
    return(nueva_palabra)
}
*/