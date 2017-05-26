package Integracion;

public class Encriptar2 {
String NuePIN="";
    
    public Encriptar2(String Pin){
        String Abc="abcdefghijklmnopqrstuvwxyz ";
        int largo= Pin.length();
        int len=0;
        int Let=0;
        
        
        while(len!=largo){
            char letra=Pin.charAt(len);
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
    
    public String getPIN(){
        return NuePIN;
    }
    
    public static void main(String args[]){
        Encriptar2 PIN=new Encriptar2("esteban morales");
        System.out.print("esteban morales : ");
        System.out.println(PIN.getPIN());
    }
}
