<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Consultar Tipo Evaluacion</title>
		
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
				<a href="<%=request.getContextPath()%>/index.jsp"><img id="logo" src="img/ModuloAdministrativo.png" alt="Nova" /></a>
				<!-- Social -->
				<div id="social-holder">
					
				</div>
				<!-- ENDS Social -->
				
				<!-- Navigation -->
				<ul id="nav" class="sf-menu">
					
                    <li><a>Estudiante</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/RegistrarEstudiante.jsp"><span>Registrar Estudiante</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToMatricular"><span>Matricular Estudiante</span></a></li>
						</ul>
					</li>
					<li><a>Curso</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/RegistrarCurso.jsp"><span>Registrar Curso</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToCurso?x=ConsultarCurso"><span>Consultar Curso</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToCurso?x=ActualizarCurso"><span>Actualizar Curso</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToCurso?x=EliminarCurso"><span>Eliminar Curso</span></a></li>
						</ul>
					</li>
                    <li class="current-menu-item"><a>Evaluacion</a>
						<ul>
			
							<li><a><span>Evaluacion</span></a>
                            	<ul>
                            		<li><a href="<%=request.getContextPath()%>/ToConfEvaluacion"><span>Configurar Evaluación</span></a></li>
                                    <li><a href="<%=request.getContextPath()%>/ToEvaluacion?x=HabilitarEvaluacion"><span>Habilitar Evaluación</span></a></li>
                            		<li><a href="<%=request.getContextPath()%>/ToEvaluacion?x=EstadoEvaluacion"><span>Ver Estado Evaluación</span></a></li>
                            		<li><a href="<%=request.getContextPath()%>/ToEvaluacion?x=DetalleEvaluacion"><span>Ver Detalle Evaluación</span></a></li>
                                </ul>
                            </li>
                            <li class="current-menu-item"><a><span>Tipo de Evaluacion</span></a>
                            	<ul>
                            		<li><a href="<%=request.getContextPath()%>/RegistrarTipoEvaluacion.jsp"><span>Registrar Tipo de Evaluación</span></a></li>
                            		<li><a href="<%=request.getContextPath()%>/ToTipoEvaluacion?x=ConsultarTipoEvaluacion"><span>Consultar Tipo Evaluación</span></a></li>
									<li><a href="<%=request.getContextPath()%>/ToTipoEvaluacion?x=ActualizarTipoEvaluacion"><span>Actualizar Tipo Evaluación</span></a></li>
									<li><a href="<%=request.getContextPath()%>/ToTipoEvaluacion?x=EliminarTipoEvaluacion"><span>Eliminar Tipo Evaluación</span></a></li>
                                </ul>
                            </li>
							
						</ul>
					</li>
					
					<li><a>Pregunta</a>
						<ul>
							<li><a><span>Registrar Pregunta</span></a>
                            	<ul>
                                    <li><a href="<%=request.getContextPath()%>/postRegistrar"><span>Marcar con X</span></a></li>
                                    <li><a href="<%=request.getContextPath()%>/postRegistrarPC"><span>Completar Espacio en Blanco</span></a></li>
                                    <li><a href="<%=request.getContextPath()%>/postRegistrarD"><span>Desarrollo</span></a></li>
                                </ul>
                            </li>
                            <li><a><span>Tipo de Pregunta</span></a>
                            	<ul>
                            		<li><a href="<%=request.getContextPath()%>/RegistrarTipoPregunta.jsp"><span>Registrar Tipo Pregunta</span></a></li>
                                    <li><a href="<%=request.getContextPath()%>/ToTipoPregunta?x=ConsultarTipoPregunta"><span>Consultar Tipo Pregunta</span></a></li>
									<li><a href="<%=request.getContextPath()%>/ToTipoPregunta?x=ActualizarTipoPregunta"><span>Actualizar Tipo  Pregunta</span></a></li>
									<li><<a href="<%=request.getContextPath()%>/ToTipoPregunta?x=EliminarTipoPregunta"><span>Eliminar Tipo Pregunta</span></a></li>
                                </ul>
                            </li>
						</ul>
					</li>
					
					
					
					
                    <li><a>Tema</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/ToCurso?x=RegistrarTema"><span>Registrar Tema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToTema?x=ConsultarTema"><span>Consultar Tema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToTema?x=ActualizarTema"><span>Actualizar Tema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToTema?x=EliminarTema"><span>Eliminar Tema</span></a></li>
						</ul>
					</li>
                    <li><a>Subtema</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/ToCurso?x=RegistrarSubtema"><span>Registrar Subtema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToSubtema?x=ConsultarSubtema"><span>Consultar Subtema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToSubtema?x=ActualizarSubtema"><span>Actualizar Subtema</span></a></li>
							<li><a href="<%=request.getContextPath()%>/ToSubtema?x=EliminarSubtema"><span>Eliminar Subtema</span></a></li>
						</ul>
					</li>
					<li><a>Entrenamiento</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/SubirArchivos.jsp"><span>Subir Archivos Positivos</span></a></li>
						</ul>
					</li>
					<li><a href="<%=request.getContextPath()%>/AsignandoProfesor" > Asignar Profesor Curso</a></li>
					
					<li><a>Bitacora</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/ConsultarBitacora.jsp"><span>Consultar Bitacora</span></a></li>
						</ul>
					</li>
				</ul>
				<!-- Navigation -->	
				
				
				
				
				
				
				
				<div id="slider-block">
				</div>
			
				
			</div>
		
			<div id="main">
			  <form name="consultarEvaluacion" method="post">
			    <div>
			      <h2>Consultar Tipo Evaluacion</h2>
			      <div>
			        <table>
			          <tr>
                      
			            <td ><h3>Codigo Tipo de la Evaluacion</h3></td>
			            <td ><!--input type="text" id="txtCodigo" name="txtNombre" placeholder="Codigo Evaluacion"  required/-->
			            <%@ page import="java.util.ArrayList" %>
			            <%
			            		ArrayList<String> tipoEval= (ArrayList<String>) request.getAttribute("ListTipoEval"); 
			            		
						%>
			            <select id="selCodigo" name="selCodigo">
			            <%Integer i=1; %>
			            <%for(String t:tipoEval){ %> 
			                <option value="<%=i.toString()%>"><%= t %></option>
			            <%i++; %>
				        <% } %>
			            </select></td>
                        
		              </tr>
		              
		              
			       
			          <tr>
			            <td ></td>
			            <td  ><button class="submit" formaction="consultarTipEval" type="submit" >Consultar Tipo Evaluacion</button></td>
		              </tr>
		              
		              <%
		              		String tipEval = (String) request.getAttribute("TipEval");  		
		             		 String texto= (String) request.getAttribute("texto");
						%>
		              <% if(tipEval!=null&&texto!=null){ %>
		              <tr>
			            <td ><h3>Codigo Tipo de la Evaluacion:</h3></td>
			            <td  ><h3><%= tipEval %></h3></td>
		              </tr>
		              <tr>
			            <td ><h3>Tipo de la Evaluacion:</h3></td>
			            <td  ><h3><%= texto %></h3></td>
		              </tr>
		              <tr>
			            <td ></td>
			            <td  ><button class="submit" formaction="ToTipoEvaluacion?x=ConsultarTipoEvaluacion" type="submit" >Salir</button></td>
		              </tr>
		              <% } %>
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