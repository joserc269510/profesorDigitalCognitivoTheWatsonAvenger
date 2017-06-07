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
				<a href="ModuloAdministrativo.html"><img id="logo" src="img/ModuloAdministrativo.png" alt="Nova" /></a>
				<!-- Social -->
				<div id="social-holder">
					
				</div>
				<!-- ENDS Social -->
				
				<!-- Navigation -->
				<ul id="nav" class="sf-menu">
				
				     <h1 >Bienvenido al Modulo Administrador </h1>
				</ul>
				<!-- Navigation -->	
				
				
				<div id="slider-block">
				</div>
		
			</div>
			<div id="main">
	              <%@ page import="java.util.ArrayList, logicaDeNegocios.*, Integracion.*" %>
		          <% String evaluacion = (String) request.getParameter("x"); %>
		
			  <form name="autentificarEstudiante"  action="autentificando?x=<%=evaluacion%>" method="post" enctype="multipart/form-data">
			    <div>
			    	
			    
			      <h1> Autentificacion del Estudiante <font size="3"> </h1>
			      <div>
			      <table>
			   		  
			   	
		          <% System.out.println(evaluacion); %>
			     
                      <tr>
						<td><input type="file" name="inputFile2" id="inputFile2" value="" Style="font-size: 14px" /> 	</td>							
                     </tr>
                     			
                     			    <tr>   
			            <td  ><button class="submit" type="submit"  >Subir archivos positivos</button></td>
		              </tr>
					  
            	 </table>
            	 
			      </div>
		        </div>
		      </form>      
		 
		  </div>
		<div id="footer">
		
		</div>
      </div>
</body>
	
</html>
