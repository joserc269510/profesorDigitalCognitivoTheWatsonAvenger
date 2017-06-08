<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>Modulo Administrativo</title>
		
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
			
					<li class="current-menu-item"><a>Bitacora</a>
						<ul>
							<li class="current-menu-item"><a href="<%=request.getContextPath()%>/ConsultarBitacora.jsp"><span>Consultar Bitacora</span></a></li>
						</ul>
					</li>
		
				</ul>
				<!-- Navigation -->	
				
		
				<div id="slider-block">
				</div>
			
				
			</div>
	
				<div id="main">
			  <form name="ConsultarBitacora" method="post">
			    <div>
			      <h2>Consulta Bitacora</h2>
			      <div>
			        <table>
			          <tr>
                        
			            
                        <tr>
			            <td ><h3 >Fecha Inicio</h3></td>
			            <td ><input type="text" id="txtFechaI" name="txtFechaI" placeholder="X-XXXX-XXXX"  required/></td>
		            </tr>
				
				<tr>
			            <td ><h3 >Fecha Final</h3></td>
			            <td ><input type="text" id="txtFechaF" name="txtFechaF" placeholder="X-XXXX-XXXX"  required/></td>
		            </tr>
                        <%@ page import="java.util.ArrayList, Bitacora.Bitacora" %>
			            <%
			            	ArrayList<Bitacora> bitacora= (ArrayList<Bitacora>) request.getAttribute("Listbitacoras"); 
			           		 String fechaI = (String) request.getAttribute("FechaI");  		
	             			String fechaF= (String) request.getAttribute("FechaF");	
						%>
                       
		
                      
		           
		             <% if(fechaI!=null&&fechaF!=null){ 
		             System.out.println("True if");
		             System.out.println(bitacora.size());
		             %>
		             <tr><td ><h3>Usuario:</h3></td>
		              <td ><h3>Fecha de registro:</h3></td>
		              <td ><h3>Descripcion:</h3></td>
		              </tr>
						 <% for(Bitacora t: bitacora)
						 
						 { System.out.println(bitacora.size());
		                  System.out.println("True for"); %>
		                  
		              
		               <tr>
		               <td  ><h3><%= t.user %></h3></td>
			            <td  ><h3><%= t.fecha %></h3></td>
			            <td  ><h3><%= t.descripcion %></h3></td>
			            </tr>
			         
				 
				  <% } %>
				  
		              <% } %>
		              <tr>
			            <td  ><button class="submit" formaction="consultandoBit" type="submit" >Consultar Bitacora</button></td>
		              </tr>
		            
		            
		              <tr>
		               <td ><h3 >Seleccione el formato en que desea descargar la bitacora</h3></td>
			            <td  ><button class="submit" formaction="descargandoCSV?x=<%= fechaI %>&y=<%=fechaF%>&z=<%="CSV"%>"type="submit" >Formato CSV</button></td>
			            <td  ><button class="submit" formaction="descargandoCSV?x=<%= fechaI %>&y=<%=fechaF%>&z=<%="XML"%>"type="submit" >Formato XML</button></td>
			             <td  ><button class="submit" formaction="descargandoCSV?x=<%= fechaI %>&y=<%=fechaF%>&z=<%="TXT"%>"type="submit" >Formato TXT</button></td>
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