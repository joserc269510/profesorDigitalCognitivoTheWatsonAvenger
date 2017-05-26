package Integracion;

public class Desencriptar2 {
String NuePIN="";
    
    public Desencriptar2(String Pin){
    	Pin=Pin+" ";
        int largo= Pin.length();
        int len=0;
        
        while(len!=largo){
        	String nLetra="";
        	while((Pin.charAt(len)!=' ')&&(Pin.charAt(len)!='*')){
        		nLetra=nLetra+Pin.charAt(len);
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
    
    public String getPIN(){
        return NuePIN;
    }
    
    public static void main(String args[]){
        Desencriptar2 PIN=new Desencriptar2("1100101 1110011 1110100 1100101 1100010 1100001 1101110 * 1101101 1101111 1110010 1100001 1101100 1100101 1110011");
        System.out.print("1100101 1110011 1110100 1100101 1100010 1100001 1101110 * 1101101 1101111 1110010 1100001 1101100 1100101 1110011 : ");
        System.out.println(PIN.getPIN());
    }
}
