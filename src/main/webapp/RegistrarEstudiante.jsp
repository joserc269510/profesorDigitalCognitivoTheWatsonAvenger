<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
		<meta charset="utf-8">
		<title>Registro de Estudiante</title>
		
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
					
                    <li class="current-menu-item"><a href="">Estudiante</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/RegistrarEstudiante.jsp"><span>Registrar Estudiante</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToMatricular"><span>Matricular Estudiante</span></a></li>
						</ul>
					</li>
					<li><a href="">Curso</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/RegistrarCurso.jsp"><span>Registrar Curso</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToCurso?x=ConsultarCurso"><span>Consultar Curso</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToCurso?x=ActualizarCurso"><span>Actualizar Curso</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToCurso?x=EliminarCurso"><span>Eliminar Curso</span></a></li>
						</ul>
					</li>
                    <li><a href="">Evaluacion</a>
						<ul>
			
							<li><a href=""><span>Evaluacion</span></a>
                            	<ul>
                            		<li><a href="<%=request.getContextPath()%>/ToConfEvaluacion"><span>Configurar Evaluación</span></a></li>
                                    <li><a href="HabilitarEvaluacion.html"><span>Habilitar Evaluación</span></a></li>
                            		<li><a href="EstadoEvaluacion.html"><span>Ver Estado Evaluación</span></a></li>
                            		<li><a href="DetalleEvaluacion.html"><span>Ver Detalle Evaluación</span></a></li>
                                </ul>
                            </li>
                            <li><a href=""><span>Tipo de Evaluacion</span></a>
                            	<ul>
                            		<li><a href="<%=request.getContextPath()%>/RegistrarTipoEvaluacion.jsp"><span>Registrar Tipo de Evaluación</span></a></li>
                            		<li><a href="<%=request.getContextPath()%>/ToTipoEvaluacion?x=ConsultarTipoEvaluacion"><span>Consultar Tipo Evaluación</span></a></li>
									<li><a href="<%=request.getContextPath()%>/ToTipoEvaluacion?x=ActualizarTipoEvaluacion"><span>Actualizar Tipo Evaluación</span></a></li>
									<li><a href="<%=request.getContextPath()%>/ToTipoEvaluacion?x=EliminarTipoEvaluacion"><span>Eliminar Tipo Evaluación</span></a></li>
                                </ul>
                            </li>
							
						</ul>
					</li>
					
					<li><a href="">Pregunta</a>
						<ul>
							<li><a href=""><span>Registrar Pregunta</span></a>
                            	<ul>
                                    <li><a href="<%=request.getContextPath()%>/RegistrarPreguntaMarqueX.jsp"><span>Marcar con X</span></a></li>
                                    <li><a href="<%=request.getContextPath()%>/RegistrarPreguntaComplete.jsp"><span>Completar Espacio en Blanco</span></a></li>
                                    <li><a href="<%=request.getContextPath()%>/RegistrarPreguntaDesarrollo.jsp"><span>Desarrollo</span></a></li>
                                </ul>
                            </li>
                            <li><a href=""><span>Tipo de Pregunta</span></a>
                            	<ul>
                            		<li><a href="<%=request.getContextPath()%>/RegistrarTipoPregunta.jsp"><span>Registrar Tipo Pregunta</span></a></li>
                                    <li><a href="<%=request.getContextPath()%>/ToTipoPregunta?x=ConsultarTipoPregunta"><span>Consultar Tipo Pregunta</span></a></li>
									<li><a href="<%=request.getContextPath()%>/ToTipoPregunta?x=ActualizarTipoPregunta"><span>Actualizar Tipo  Pregunta</span></a></li>
									<li><<a href="<%=request.getContextPath()%>/ToTipoPregunta?x=EliminarTipoPregunta"><span>Eliminar Tipo Pregunta</span></a></li>
                                </ul>
                            </li>
						</ul>
					</li>
					
					
					
					
                    <li><a href="">Tema</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/ToCurso?x=RegistrarTema"><span>Registrar Tema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToTema?x=ConsultarTema"><span>Consultar Tema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToTema?x=ActualizarTema"><span>Actualizar Tema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToTema?x=EliminarTema"><span>Eliminar Tema</span></a></li>
						</ul>
					</li>
                    <li><a href="">Subtema</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/ToTema?x=RegistrarSubTema"><span>Registrar Subtema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToSubtema?x=ConsultarSubtema"><span>Consultar Subtema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToSubtema?x=ActualizarSubtema"><span>Actualizar Subtema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToSubtema?x=EliminarSubtema"><span>Eliminar Subtema</span></a></li>
						</ul>
					</li>
					<li><a href="EntrenarProfesor.html">Entrenar Profesor</a></li>
					<li><a href="">CERRAR SESION</a></li>
				</ul>
				<!-- Navigation -->	
				
				<div id="slider-block">
				</div>
			
				
			</div>
			<div id="main">
			  <form name="registroestudiante" action="registrarEstudiante" method="post">
			    <div>
			      <h2>Registrar Estudiante</h2>
			      <div>
			        <table>
			        <tr>
			            <td ><h3 >Numero de Identificacion</h3></td>
			            <td ><input type="text" id="txtIdentificacion" name="txtIdentificacion" placeholder="X-XXXX-XXXX"  required/></td>
		            </tr>
		           	<tr>
			            <td ><h3>Nombre </h3></td>
			            <td ><input type="text" id="txtNombre" name="txtNombre" placeholder="Nombre"  required/></td>
		              </tr>
		              <tr>
			            <td ><h3>Primer Apellido </h3></td>
			            <td ><input type="text" id="txApellido1" name="txtApellido1" placeholder="Apellido1"  required/></td>
		              </tr>
		              <tr>
			            <td ><h3>Segundo Apellido </h3></td>
			            <td ><input type="text" id="txtApellido2" name="txtApellido2" placeholder="Apellido2"  required/></td>
		              </tr>
			          
		                 <tr>
			            <td ><h3 >Numero de Carnet</h3></td>
			            <td ><input type="text" id="txtCarnet" name="txtCarnet" placeholder="Carnet Estudiantil"  required/></td>
		              </tr>
			          <tr>
			            <td ><h3 >Fecha Nacimiento</h3></td>
			            <td><input type="text" id="txtNacimiento" name="txtNacimiento"  placeholder="Dia/Mes/AÃ±o"  required/></td>
		              </tr>
			          <tr>
			            <td ><h3 >Correo Electronico</h3></td>
			            <td ><input type="email" id="txtEmail" name="txtEmail"  placeholder="@"  required/></td>
		              </tr>
			       
			          <tr>
			            
			            <td  ><button class="submit" type="submit" >Registrar Estudiante</button></td>
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
</html>