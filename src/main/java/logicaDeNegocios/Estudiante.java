package logicaDeNegocios;

import java.text.SimpleDateFormat;
import java.util.Date;

import Integracion.BaseDeDatos;

public class Estudiante {
	private String numeroIdentificacion;
	private String numeroCarnet; 
	private Date fechaNacimiento;
	private String apellido1;
	private String apellido2;
	private String nombre;
	private String email;	
	

	public void registrarEstudiante(String pNumeroIdentificacion, String pNombre, String pApellido1,
			String pApellido2, String pNumeroCarnet,String pFechaNacimiento, String pEmail)
	{
     
		Date fechaNacimiento; 
		fechaNacimiento= ConvertirFecha(pFechaNacimiento);
		setNumeroIdentificacion(pNumeroIdentificacion);
		setNumeroCarnet(pNumeroCarnet);
		setNombre(pNombre);
		setApellido1(pApellido1);
		setApellido2(pApellido2);
		setFechaNacimiento(fechaNacimiento);
		setEmail(pEmail);
		
		BaseDeDatos conexion = new BaseDeDatos();
        conexion.insertDelete("insert into estudiante values (" + pNumeroIdentificacion  + "," +  "'" + pNombre + "'" + "," + "'"+ pApellido1 + "'" + "," + "'" + pApellido2 + "'"+ "," +  "'" +pNumeroCarnet + "'" + "," + "'"+ fechaNacimiento +  "'"+ "," + "'" + pEmail +"'" + ")" ) ;
	}
	
	
	 private static Date ConvertirFecha(String fecha)
	 {
	        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	        Date fechaDate = null;
	        try {
	            fechaDate = formato.parse(fecha);
	        } 
	        catch (Exception ex) 
	        {
	            System.out.println(ex);
	        }
	        return fechaDate;
	   }
	
	// Métodos get y set
	public String getNumeroIdentificacion() 
	{
		
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(String pNumeroIdentificacion) 
	{
		numeroIdentificacion = pNumeroIdentificacion;
	}
	public String getNumeroCarnet() 
	{
		return numeroCarnet;
	}
	public void setNumeroCarnet(String pNumeroCarnet) 
	{
		numeroCarnet = pNumeroCarnet;
	}
	
	public Date getFechaNacimiento() 
	{
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date pFechaNacimiento) 
	{
		fechaNacimiento = pFechaNacimiento;
	}
	public String getApellido1() 
	{
		return apellido1;
	}
	public void setApellido1(String pApellido1) 
	{
		apellido1 = pApellido1;
	}
	public String getApellido2() 
	{
		return apellido2;
	}
	
	public void setApellido2(String pApellido2) 
	{
		this.apellido2 = pApellido2;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String pNombre) 
	{
		this.nombre = pNombre;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String pEmail) 
	{
		this.email = pEmail;
	}
}
