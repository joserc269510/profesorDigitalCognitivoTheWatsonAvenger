<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<head>
		<meta charset="utf-8">
		<title>Profesor Cognitivo</title>
		
		<!-- CSS -->
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
		
		
		<!-- JS -->
		<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
		<script type="text/javascript" src="js/custom.js"></script>
		
		
		
		<!-- Nivo slider -->
		<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />
		<script src="js/nivo-slider/jquery.nivo.slider.js" type="text/javascript"></script>
		<!-- ENDS Nivo slider -->
		
		<!-- tabs -->
		<link rel="stylesheet" href="css/tabs.css" type="text/css" media="screen" />
		<script type="text/javascript" src="js/tabs.js"></script>
  		<!-- ENDS tabs -->
  		
  		
		
		<!-- superfish -->
		<link rel="stylesheet" media="screen" href="css/superfish.css" /> 
		<link rel="stylesheet" media="screen" href="css/superfish-left.css" /> 
		<script type="text/javascript" src="js/superfish-1.4.8/js/hoverIntent.js"></script>
		<script type="text/javascript" src="js/superfish-1.4.8/js/superfish.js"></script>
		<script type="text/javascript" src="js/superfish-1.4.8/js/supersubs.js"></script>
		<!-- ENDS superfish -->
		
		<!-- poshytip -->
		<link rel="stylesheet" href="js/poshytip-1.0/src/tip-twitter/tip-twitter.css" type="text/css" />
		<link rel="stylesheet" href="js/poshytip-1.0/src/tip-yellowsimple/tip-yellowsimple.css" type="text/css" />
		<script type="text/javascript" src="js/poshytip-1.0/src/jquery.poshytip.min.js"></script>
		<!-- ENDS poshytip -->	
		
	</head>
	
	<body class="home">
	
	
		<!-- WRAPPER -->
		<div id="wrapper">
			
			<!-- HEADER -->
			<div id="header">
				<a href="<%=request.getContextPath()%>/AutentificarEstudiante.jsp"><img id="logo" src="img/ModuloEstudiante.png" alt="Nova" /></a>
				<!-- Social -->
				<div id="social-holder">
					
				</div>
				<!-- ENDS Social -->
				
				<!-- Navigation -->
				<ul id="nav" class="sf-menu">
				
				     <h1 >Bienvenido al Modulo Estudiante </h1>
				</ul>
				<!-- Navigation -->	
				
				
				<div id="slider-block">
				</div>
		
			</div>
			<div id="main">
				<%@ page import="java.util.ArrayList,logicaDeNegocios.*" %>
			            <%
			            		Estudiante es=  (Estudiante)request.getAttribute("estudiante");
			            		String ruta =(String)request.getAttribute("ruta");
			            		String  carnet = (String)request.getAttribute("carnet");
			            		String evaluacion = (String)request.getAttribute("CodEvaluacion");
			            		System.out.println(ruta);
			            		System.out.println(carnet);
			            		System.out.println(evaluacion);
			            		ArrayList<Estudiante> dato= (ArrayList<Estudiante>) request.getAttribute("dato"); 
			              
			          %>
		
			  <form name="" action="empezarEvaluacion?x=<%=evaluacion%>&y=<%=carnet%>" method="post">
			  <table>
			
			       
			      <h1> Informacion del Estudiante <font size="3"> </h1>

			             <%  for(Estudiante t:dato){ 
			             	System.out.println(t.getNumeroIdentificacion()+" "+t.getNombre()+" "+t.getApellido1()+" "+t.getApellido2());%>
			            <tr><td ><h3>Informacion del estudiante:</h3></td></tr>
			            <tr><td ><h3>Numero de identificacion:</h3></td>
			            <td><h3><%= t.getNumeroIdentificacion() %></h3></td></tr>
			            
			            <tr><td ><h3>Numero de Carnet:</h3></td>
			            <td  ><h3><%= t.getNumeroCarnet() %></h3></td></tr>
			            <tr><td><h3>Nombre del estudiante:</h3></td>
			            <td><h3><%= t.getNombre() %></h3></td></tr>
			            <tr><td><h3>Primer apellido del estudiante:</h3></td>
			            <td><h3><%= t.getApellido1() %></h3></td></tr>
			            <tr><td><h3>Segundo apellido del estudiante:</h3></td>
			            <td><h3><%= t.getApellido2() %></h3></td></tr>	
			            <tr><td><h3>Fecha Nacimiento:</h3></td>
			            <td><h3><%= t.getFechaNacimiento() %></h3></td></tr>	
			            <tr><td><h3>Email:</h3></td>
			            <td><h3><%= t.getEmail() %></h3></td></tr>
			            <tr>
			            <td ></td>
			            <td  ><button class="submit" type="submit" >Empezar Evaluacion</button></td>
		              </tr>
					    <% } %>
			      
			      </table>
		      </form>      
		 
		  </div>
		<div id="footer">
		
		</div>
      </div>
</body>
	
</html>