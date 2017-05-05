<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>E  html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Registrar Pregunta Complete</title>
		
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
                    <li><a>Evaluacion</a>
						<ul>
			
							<li><a><span>Evaluacion</span></a>
                            	<ul>
                            		<li><a href="<%=request.getContextPath()%>/ToConfEvaluacion"><span>Configurar Evaluación</span></a></li>
                                    <li><a href="<%=request.getContextPath()%>/ToEvaluacion?x=HabilitarEvaluacion"><span>Habilitar Evaluación</span></a></li>
                            		<li><a href="<%=request.getContextPath()%>/ToEvaluacion?x=EstadoEvaluacion"><span>Ver Estado Evaluación</span></a></li>
                            		<li><a href="<%=request.getContextPath()%>/ToEvaluacion?x=DetalleEvaluacion"><span>Ver Detalle Evaluación</span></a></li>
                                </ul>
                            </li>
                            <li><a><span>Tipo de Evaluacion</span></a>
                            	<ul>
                            		<li><a href="<%=request.getContextPath()%>/RegistrarTipoEvaluacion.jsp"><span>Registrar Tipo de Evaluación</span></a></li>
                            		<li><a href="<%=request.getContextPath()%>/ToTipoEvaluacion?x=ConsultarTipoEvaluacion"><span>Consultar Tipo Evaluación</span></a></li>
									<li><a href="<%=request.getContextPath()%>/ToTipoEvaluacion?x=ActualizarTipoEvaluacion"><span>Actualizar Tipo Evaluación</span></a></li>
									<li><a href="<%=request.getContextPath()%>/ToTipoEvaluacion?x=EliminarTipoEvaluacion"><span>Eliminar Tipo Evaluación</span></a></li>
                                </ul>
                            </li>
							
						</ul>
					</li>
					
					<li class="current-menu-item"><a>Pregunta</a>
						<ul>
							<li class="current-menu-item"><a><span>Registrar Pregunta</span></a>
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
				</ul>
				<!-- Navigation -->	
				
				
				
				
				
				
				<div id="slider-block">
				</div>
			
				
			</div>
			<div id="main">
			    <div>
			      <h2>Registrar Pregunta de Complete</h2>
			      <div>
			        <table>
                    <form action="selectCursoC" method="post">
                      <tr>
			            <td ><h3>Codigo del Curso</h3></td>
			            
			           <td >
                        <%@ page import="java.util.ArrayList, logicaDeNegocios.Curso, logicaDeNegocios.Tema, logicaDeNegocios.Subtema " %>
			            <%
			            		ArrayList<Curso> cursos= (ArrayList<Curso>) request.getAttribute("ListCursos"); 
			            		
						%>
                        <select id="selCodigo" name="selCodigo" >
						<%  for(Curso c:cursos){ %>
			                <option value="<%=c.getCodigo() %>"><%=c.getCodigo() %> - <%= c.getDescripcionCurso()%></option>
				        <% } %>
                        </select></td>
                         <td><button class="submit" type="submit" >Cargar Curso</button></td>
                       
                     
		              </tr>
                      </form>
                      <% try{
                      		String curso= (String) request.getAttribute("Curso");
                      		%>
                      <form action="selectTema_C?x=<%=curso%>" method="post">
                      <tr>
                      <%}catch(Exception e){%>
                      <form action="selectTema_C" method="post">
                      <tr>
                      <%}%>
			            <td ><h3>Codigo del Tema</h3></td>
			            <td ><!--input type="text" id="txtCodigo2" name="txtCodigo" placeholder="Codigo Tema"  required/-->
			            <%
			            		ArrayList<Tema> temas= (ArrayList<Tema>) request.getAttribute("ListTemas");      		
						%>
			            <select id="selCodigoTema" name="selCodigoTema">
		              	<%if(temas!=null){ %>
		              	<%  for(Tema t:temas){ %>
		              	<% System.out.println("ESTE ES EL TEMA"+t.getDescripcionTema());%>
			              <option value="<%=t.getCodTema()%>"><%=t.getDescripcionTema()%></option>
				        <% } %>
                        <% } %>
                        </select></td>
                        <td><button class="submit" type="submit" >Cargar Tema</button></td>
		              </tr>
		              </form>
		             
		             
		             <% try{
                      		String curso= (String) request.getAttribute("Curso");
                      		String tema= (String)request.getAttribute("Tema");
                      %>
                      <form action="postRegistrarPC?x=<%=curso%>&y=<%=tema%>" method="post">
                      <tr>
                      <%}catch(Exception e){%>
                      <form action="postRegistrarPC" method="post">
                      <tr>
                      <%}%>
			            <td ><h3>Codigo del Subtema</h3></td>
			            <td ><!--input type="text" id="txtCodigo3" name="txtCodigo" placeholder="Codigo Subtema"  required/-->
			            
			             <%
			            		ArrayList<Subtema> subtemas= (ArrayList<Subtema>) request.getAttribute("ListSubTemas");      		
						%>
			            <select id="selCodigoSubtema" name="selCodigoSubtema">
		              	<%if(subtemas!=null){ %>
		              	<%  for(Subtema t:subtemas){ %>
		              	<% System.out.println("ESTE ES EL TEMA"+t.getDescripcion());%>
			              <option value="<%=t.getCodSubTema()%>"><%=t.getDescripcion()%></option>
				        <% } %>
                        <% } %>
                        </select></td>
                       
		              </tr>
		           		<tr>
			            <td ><h3>Codigo de la Pregunta</h3></td>
			            <td ><input type="text" id="txtCodigo" name="txtCodigo" placeholder="Codigo Pregunta"  required/></td>
		              	
		              </tr>
			          <tr>
			            <td ><h3>Descripcion de la Pregunta</h3></td>
			            <td ><input type="text" id="txtDescripcion" name="txtDescripcion" placeholder="Descrpcion Pregunta"  required/></td>
		              </tr>
		            
                      <tr>
			            <td ><h3>Descripcion de la Respuesta </h3></td>
			            <td ><input type="text" id="txtRespuesta1" name="txtRespuesta1" placeholder="Descripcion de la respuesta"  required/></td>
		              </tr>
		               <tr>
			            <td ><h3>Descripcion de Ayuda </h3></td>
			            <td ><input type="text" id="txtDescripcionAyuda" name="txtDescripcionAyuda" placeholder="Descripcion de ayuda"  required/></td>
		              </tr>
			       
			          <tr>
			            <td ></td>
			            <td  ><button class="submit" type="submit" >Registrar Pregunta Complete</button></td>
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