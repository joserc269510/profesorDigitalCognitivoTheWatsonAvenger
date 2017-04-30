<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>PROYECTO XE</title>
		
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
					
                    <li><a href="">Estudiante</a>
						<ul>
							<li><a href="RegistrarEstudiante.html"><span>Registrar Estudiante</span></a></li>
							<li><a href="MatricularEstudiante.html"><span>Matricular Estudiante</span></a></li>
						</ul>
					</li>
					<li><a href="">Curso</a>
						<ul>
							<li><a href="RegistrarCurso.html"><span>Registrar Curso</span></a></li>
							<li><a href="ConsultarCurso.html"><span>Consultar Curso</span></a></li>
							<li><a href="ActualizarCurso.html"><span>Actualizar Curso</span></a></li>
							<li><a href="EliminarCurso.html"><span>Eliminar Curso</span></a></li>
						</ul>
					</li>
                    <li><a href="">Evaluaci�n</a>
						<ul>
									
							<li><a href="RegistrarTipoEvaluacion.html"><span>Registrar Tipo de Evaluaci�n</span></a></li>
                            <li><a href="HabilitarEvaluacion.html"><span>Habilitar Evaluaci�n</span></a></li>
                            <li><a href="EstadoEvaluacion.html"><span>Ver Estado Evaluaci�n</span></a></li>
                            <li><a href="DetalleEvaluacion.html"><span>Ver Detalle Evaluaci�n</span></a></li>
							<li><a href="ConsultarEvaluacion.html"><span>Consultar Evaluaci�n</span></a></li>
							<li><a href="ActualizarEvaluacion.html"><span>Actualizar Evaluaci�n</span></a></li>
							<li><a href="EliminarEvaluacion.html"><span>Eliminar Evaluaci�n</span></a></li>
						</ul>
					</li>
                    <li><a href="">Pregunta</a>
						<ul>
						<li><a href="RegistrarTipoPregunta.html"><span>Registrar Tipo Pregunta</span></a></li>
							<li><a href=""><span>Registrar Pregunta</span></a>
                            	<ul>
                                    <li><a href="RegistrarPreguntaMarqueX.html"><span>Marcar con X</span></a></li>
                                    <li><a href="RegistrarPreguntaComplete.html"><span>Completar Espacio en Blanco</span></a></li>
                                    <li><a href="RegistrarPreguntaDesarrollo.html"><span>Desarrollo</span></a></li>
                                </ul>
                            </li>
							<li><a href="ConsultarPregunta.html"><span>Consultar Pregunta</span></a></li>
							<li><a href="ActualizarPregunta.html"><span>Actualizar Pregunta</span></a></li>
							<li><a href="EliminarPregunta.html"><span>Eliminar Pregunta</span></a></li>
						</ul>
					</li>
                    <li><a href="">Tema</a>
						<ul>
							<li><a href="RegistrarTema.html"><span>Registrar Tema</span></a></li>
							<li><a href="ConsultarTema.html"><span>Consultar Tema</span></a></li>
							<li><a href="ActualizarTema.html"><span>Actualizar Tema</span></a></li>
							<li><a href="EliminarTema.html"><span>Eliminar Tema</span></a></li>
						</ul>
					</li>
                    <li><a href="">Subtema</a>
						<ul>
							<li><a href="RegistrarSubtema.html"><span>Registrar Subtema</span></a></li>
							<li><a href="ConsultarSubtema.html"><span>Consultar Subtema</span></a></li>
							<li><a href="ActualizarSubtema.html"><span>Actualizar Subtema</span></a></li>
							<li><a href="EliminarSubtema.html"><span>Eliminar Subtema</span></a></li>
						</ul>
					</li>
					<li><a href="<%=request.getContextPath()%>/crearPDF">Generar PDF</a></li>
					<li><a href="">CERRAR SESION</a></li>
				</ul>
				<!-- Navigation -->	
				
				
				
				
				<div id="slider-block">
				</div>
			
				
			</div>
			<div id="main">
			  <form name="PruebaSpeech" action="generarSpeech" method="post">
			    <div>
			      <h2>Prueba SPEECH</h2>
			      <div>
			        <table>
			          <tr>
			            <td ><h3>Pulse el boton para empezar a grabar</h3></td>
                      </tr>
                      <tr>
			            <td ><textarea id="txtNombre" name="txtNombre" style="width:700px;height:200px">${texto}</textarea></td>
                        <td  ><button class="submit" type="submit">Grabar</button></td>
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