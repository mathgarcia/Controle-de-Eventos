<link rel="stylesheet" href="lib/css/events.css">
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="pojo.Evento"%>
<%@page import="pojo.Participante"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="dao.ParticipanteBD" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

		<div class="row">
			<%				
				DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				
				Participante part = (Participante) session.getAttribute("usuarioInfo");
			
				ArrayList<Evento> listaEvento = (ArrayList<Evento>) session.getAttribute("evento");
  				Iterator<Evento> iterator = listaEvento.iterator();
  				
  				while (iterator.hasNext()) {
					Evento umEvento = (Evento) iterator.next();
					int idEvento = umEvento.getCodigo();
					Integer inscricao_evento = ParticipanteBD.consultarInscricaoEvento(part.getCodigo(),idEvento);
  			%>
					<div class="col-sm-12 col-sm-6 col-md-4">
						<div class="thumbnail">
							<a class="<%=idEvento %>" href="#">
								<img src="img/turu.jpg" alt="Turuboy" style="max-width: 300px">
							</a>
							<div class="info-event" style="border-bottom-width: 0px">
								<%=formato.format(umEvento.getData_inicio()) %> | <%=formato.format(umEvento.getData_fim()) %>
							</div>
							<div class="info-event">
								Local: <%=umEvento.getLocal() %>
							</div>
							<div class="caption">
								<center>
									<a class="<%=idEvento %>" href="#">
										<h3><%=umEvento.getNome() %></h3>
									</a>
									<p><%=umEvento.getDescricao() %></p>
								</center>
							</div>							
							<a href="#" class="btn btn-default bottom-button" role="button" id="inscrever<%=idEvento %>">
								<% if(inscricao_evento == null){%>
									Inscreva-se
									<% }else {%>
									Inscri��o Realizada
									<%} %>
							</a>	
						</div>
					</div>
					<script>
						$(".<%=idEvento %>").on('click', function(){
							$.post("/controle-de-evento/EventoSelecionado", {idEvento:<%=idEvento%>}, function(response){
								$('#corpo').html(response);
							});
						});
						 $("#inscrever<%=idEvento %>").on('click', function(){							
					<% if (part != null && inscricao_evento == null){%>
							$.post("/controle-de-evento/InscreverEvento", {codigo_evento:<%=idEvento%>} , function(response){
								$('#corpo').html(response);
							});		
						 <% }else if (inscricao_evento!=null){%>
						 	alert("Inscri��o j� realizada. Clique no evento e participe das atividades.");
						 <% }else{%>
						 	alert("Fa�a login ou inscreva-se para continuar.");
						 <% }%>
						}); 
					</script>
			<%
  				}
  				//session.invalidate();
			%>
		</div>