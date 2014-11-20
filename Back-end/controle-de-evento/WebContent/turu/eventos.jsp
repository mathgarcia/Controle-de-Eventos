<link rel="stylesheet" href="lib/css/events.css">
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="pojo.Evento"%>
<%@page import="pojo.Participante"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

		<div class="row">
			<%
				ArrayList<Evento> listaEvento = (ArrayList<Evento>) session.getAttribute("evento");
  				Iterator<Evento> iterator = listaEvento.iterator();
  				while (iterator.hasNext()) {
					Evento umEvento = (Evento) iterator.next();
					int idEvento = umEvento.getCodigo();
  			%>
					<div class="col-sm-12 col-sm-6 col-md-4">
						<div class="thumbnail">
							<a class="<%=idEvento %>" href="#">
								<img src="img/turu.jpg" alt="Turuboy" style="max-width: 300px">
							</a>
							<div class="info-event" style="border-bottom-width: 0px">
								<%=umEvento.getData_inicio() %> | <%=umEvento.getData_fim() %>
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
							<a href="#" class="btn btn-default bottom-button" role="button" id="inscrever">Inscreva-se</a>	
						</div>
					</div>
					<script>
					<% Participante part = (Participante) session.getAttribute("usuarioInfo"); %>
						$(".<%=idEvento %>").on('click', function(){
							$.post("/controle-de-evento/EventoSelecionado", {idEvento:<%=idEvento%>}, function(response){
								$('#corpo').html(response);
							});
						});
						$("#inscrever").on('click', function(){							
							$.post("/controle-de-evento/InscreverEvento", {codigo_evento:<%=idEvento%>, codigo_participante:<%=part.getCodigo()%>} , function(response){
								$('#corpo').html(response);
							});
						});
					</script>
			<%
  				}
  				//session.invalidate();
			%>
		</div>