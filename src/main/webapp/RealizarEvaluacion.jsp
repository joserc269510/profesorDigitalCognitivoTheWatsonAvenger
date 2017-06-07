<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

		<head>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Realizar Evaluacion</title>
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
<body class="home" onload="ram()">
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
			  <form name="RealizarEvaluacion" method="post">
			    <div>
			      <h2>Realizar Evaluacion</h2>
			      <div>
			        <table>
			         <tr>
			        <td><h3>Tiempo restante:</h3></td>
			        <td><input type="text" id="kulu"/></td>
			        </tr>
			        <%@ page import="java.util.ArrayList, logicaDeNegocios.*, Integracion.*, Seguridad.*" %>
			        <%
			            		ArrayList<pregunta> Preguntas= (ArrayList<pregunta>) request.getAttribute("ListPreguntas");
			                    
			        			String codEvaluacion = (String) request.getAttribute("CodEvaluacion"); 
			        			String carnet = (String) request.getAttribute("carnet"); 
			        			ArrayList<Integer> ListPreguntas=new ArrayList<Integer>();
			        %>
			        <%for(int i=0;i<Preguntas.size();){
			        	BaseDeDatos bd=new BaseDeDatos();
			        	String isAleatorio=bd.ObtenerAleatorioEvaluacion(codEvaluacion);
			        	int aleatorio=0;
			        	if(isAleatorio.equals("1")){
			        		aleatorio= (int) Math.floor(Math.random()*Preguntas.size());
			        	}
			        	pregunta Tpregunta=Preguntas.get(aleatorio);
			        	ListPreguntas.add(Tpregunta.getCodigoPregunta());
			        	String tipoPreg=bd.ObtenerTipoPreguntas(Tpregunta.getCodigoPregunta());
			        	System.out.println("TipoPregunta="+tipoPreg);
			        	String descrip=Tpregunta.getDescripcionPregunta();
			        	
			        	Desencriptar nDescripcion=new Desencriptar(descrip.toLowerCase(),26); 
			        	String descripcion=nDescripcion.getPIN();
			        	
			        	System.out.println("Descripcion="+descripcion);
			        	if(tipoPreg.equals("1")){
			        		System.out.println("Marque con X");
			        		ArrayList<Respuesta> respuestas=bd.ObtenerOpciones(Tpregunta.getCodigoPregunta());
			        		
			        			
			        %>			
			        
			        
			       
			       	<tr>
			       		
				        <td>
					            <h3><%=descripcion %></h3></td>
					     </tr>
				           
				   <%
				  		 for(Respuesta r:respuestas){
				     		Desencriptar nDescripcion2=new Desencriptar(r.getDescripcionRespuesta(),26); 
			        		
			        %>
					        <tr><td>
					            <input type="radio" id="<%=Tpregunta.getCodigoPregunta() %>" name="<%=Tpregunta.getCodigoPregunta() %>" value=<%=r.getCodRespuesta() %>> <%=nDescripcion2.getPIN() %>
					        </td></tr>
					        
					        
					    
					   <%			
			        		
			        	}
			        
			        		
			        	}
			        	if(tipoPreg.equals("2")){
			        		System.out.println("Corta");
					 %>
					       			<tr>
							            <td ><h3 ><%=descripcion %></h3></td>
						            </tr>
						            <% ArrayList<Respuesta> respuestas=bd.ObtenerOpciones(Tpregunta.getCodigoPregunta());%>
						            <tr>
							            <td ><input type="text" id="<%=Tpregunta.getCodigoPregunta() %>" name="<%=Tpregunta.getCodigoPregunta() %>" placeholder="Respuesta" /></td>
						            </tr>
					 <%
					        		
					    }
			        	if(tipoPreg.equals("3")){
			        		System.out.println("Desarrollo");
					 %>
					       			 <tr>
							            <td ><h3 ><%=descripcion %></h3></td>
						            </tr>
						             <tr>
				                      	<%
							            		String texto= (String) request.getAttribute("texto");
										%>
							            <td ><textarea id="<%=Tpregunta.getCodigoPregunta() %>" name="<%=Tpregunta.getCodigoPregunta() %>" style="width:700px;height:200px">
							            <%= texto %>
							            </textarea></td>
				                        <td  ><button class="submit" formaction="generarSpeech?x=<%=codEvaluacion%>" type="submit">Grabar</button></td>
						              </tr>
					 <%
					        		
					     }
			     
			             Preguntas.remove(aleatorio);   
				  }
			        %>
			       
			          <tr>
			            
			            <td  ><button class="submit" type="submit" >Terminar Evaluacion</button></td>
		              </tr>
		            </table>
		          </div>
		        </div>
		      </form>
		  </div>
		<div id="footer">
		
		</div>
</body>
<%
		HttpSession s=request.getSession(false);
		
		if(s==null) { %>
		
		    <jsp:forward page="/Expired" />
		<% } %>
		<% String duration=(String)s.getAttribute("duration"); %>
		<% BaseDeDatos bd =new BaseDeDatos(); %>
		<% int a=Integer.parseInt(bd.ObtenerTiempoEvaluacion(codEvaluacion)); %>
		
<script type="text/javascript">
		var cmin=<%= a %>;
		var total=cmin*60;
		cmin=cmin-1;
		var ctr=0;
		var dom=document.getElementById("kulu");
		function ram(){
		var dom=document.getElementById("kulu");
		dom.value=(cmin)+"minutes"+(total%60)+"seconds";
		<% String t=(String)s.getAttribute("over"); %>
		var tt=<%= t %>
		if(tt=="false"){ram1();}
		total=total-1;ctr++;
		if(ctr==60){ctr=0;cmin=cmin-1;}
		if(total==0){
		ram1();}
		setTimeout("ram()", 1000);
		              }
		function ram1(){
		
		window.location.replace("/hcl/TTimeUp.jsp");
		
		                }
		</script>
</html>