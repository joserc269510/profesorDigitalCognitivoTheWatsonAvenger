package logicaDeNegocios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Integracion.BaseDeDatos;
/*
 * Revisar si dejar o no anadirCurso (si hacerla bidireccional o no ) y el atributo cursos
 */
public class Estudiante {
	private String numeroIdentificacion;
	private String numeroCarnet; 
	private Date fechaNacimiento;
	private String apellido1;
	private String apellido2;
	private String nombre;
	private String email;	
	private ArrayList evaluaciones;
	//ArrayList cursos;
	BaseDeDatos conexion;
	
	public Estudiante(){
		evaluaciones = new ArrayList<Evaluacion>();
		//cursos = new ArrayList<Curso>();
		conexion = new BaseDeDatos();
	}
	
	public Estudiante(String pNumIdentificacion, String pCarne,Date pFechaNac,String pApellido1,String pApellido2, String pNombre, String pCorreo){
		setNumeroIdentificacion(pNumIdentificacion);
		setNumeroCarnet(pCarne);
		setFechaNacimiento(pFechaNac);
		setApellido1(pApellido1);
		setApellido2(pApellido2);
		setNombre(pNombre);
		setEmail(pCorreo);
		evaluaciones = new ArrayList<Evaluacion>();
		//cursos = new ArrayList<Curso>();
		conexion = new BaseDeDatos();
	}
	/*
	public void anadirCurso(Curso pCurso){
		cursos.add(pCurso);
	}
	 */
	public void anadirEvaluacion(Evaluacion pEvaluacion){
		evaluaciones.add(pEvaluacion);
	}
	
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
		
		
        getConexion().insertDelete("insert into estudiante values (" + pNumeroIdentificacion  + "," +  "'" + pNombre + "'" + "," + "'"+ pApellido1 + "'" + "," + "'" + pApellido2 + "'"+ "," +  "'" +pNumeroCarnet + "'" + "," + "'"+ fechaNacimiento +  "'"+ "," + "'" + pEmail +"'" + ")" ) ;
	}
	
	public ArrayList<Estudiante> cargarEstudiante(){
		ArrayList<Estudiante> estudiantes=new ArrayList<Estudiante>();
		ArrayList<Estudiante> estudiante = getConexion().selectEstudiante();
		  
		  Estudiante nombreEstudiante;
	      
	      for (int i=0; i<estudiante.size();i++)
	      {
	    	  nombreEstudiante= (estudiante.get(i));
	    	  estudiantes.add(nombreEstudiante);  
	      }
	
		
		return estudiantes;
		
	}
	 private static Date ConvertirFecha(String pFecha)
	 {
	        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	        Date fechaDate = null;
	        try {
	            fechaDate = formato.parse(pFecha);
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
	
	public ArrayList getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(ArrayList evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
/*
	public ArrayList getCursos() {
		return cursos;
	}

	public void setCursos(ArrayList cursos) {
		this.cursos = cursos;
	}
*/
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

	public BaseDeDatos getConexion() {
		if (conexion == null){
			conexion = new BaseDeDatos();
		}
		return conexion;
	}

	public void setConexion(BaseDeDatos conexion) {
		this.conexion = conexion;
	}
	
}
