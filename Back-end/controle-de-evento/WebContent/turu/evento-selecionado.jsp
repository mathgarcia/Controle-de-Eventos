<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="pojo.Atividade"%>
<%@page import="pojo.Evento"%>
<%@page import="pojo.Participante"%>
<%@page import="pojo.Palestrante"%>
<%@page import="dao.PalestranteBD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@page import="dao.ParticipanteBD" %>
<%@page import="java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" href="lib/css/events.css">
<link rel="stylesheet" href="lib/css/event-selected.css">

<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
<script type="text/javascript">
	/* stLight.options({
		publisher: "a5b0e44e-491c-456a-ae7a-cb2d4712f699",
		doNotHash: false,
		doNotCopy: false,
		hashAddressBar: false
	}); */
</script>	
	
		<div style="height: 450px; background-color: #F5F7FA;">
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<center><span style="font-size: 45px; font-weight: bold; color: #73879C;">Imagem</span></center>
		</div>
		<div class="row">
			<%
				Evento e =(Evento) session.getAttribute("evento");
				 
				Participante part = (Participante) session.getAttribute("usuarioInfo");
				Integer inscricao_evento = null;
				try{
					inscricao_evento = ParticipanteBD.consultarInscricaoEvento(part.getCodigo(),e.getCodigo());
				}catch (SQLException ex){
					//
				}catch (NullPointerException ex){
					//
				}
			%>
			<div class="col-md-8">
				<div class="event-description">
					<h1><%=e.getNome() %><div class="encerrado" style="display: none"> - Encerrado</div></h1> <!-- Alterar de display: none para display: inline para exibir o evento como encerrado-->
					<div class="event-destaque">
						<p>Local: <%=e.getLocal() %></p>
						<p>Data: <%=e.getDataInicioFormatada()%> até <%=e.getDataFinalFormatada() %></p>
					</div>
					<div>
						<div class="event-description">
							<%=e.getDescricao() %>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 text-center">
				<div class="event-buttons">
					<!-- <p>
						<button type="button" class="btn btn-default">Como Chegar</button>
					</p> -->
					<% if (part != null && inscricao_evento == null){%>
						<p>	<button type="button" class="btn btn-default">Inscreva-se</button></p><%-- <a href="#" class="btn btn-default bottom-button" role="button" id="inscrever<%=idEvento %>">Inscreva-se</a> --%>		
					<% }else if (inscricao_evento!=null){%>
					 	<p>	<button type="button" class="btn btn-default">Cancelar Inscrição</button></p><%-- <a href="#" class="btn btn-default bottom-button" role="button" id="cancelarInscricao<%=idEvento %>">Cancelar Inscrição</a> --%>
					<% }else{%>
						<p>	<button type="button" class="btn btn-default">Logue para inscrever-se</button></p><!-- <but href="#" class="btn btn-default bottom-button disabled" role="button" >Faça login para inscrever-se</a> -->
					<% }%>
					
					<span class='st_facebook_large share' displayText='Facebook'></span>
					<span class='st_twitter_large share' displayText='Tweet'></span>
					<span class='st_googleplus_large share' displayText='Google +'></span>
				</div>
			</div>
		</div>


		<div class="btn-group btn-atividade open">
			<button type="button" class="btn btn-default dropdown-toggle btn-atividade" data-toggle="dropdown" id="btn-atividade">
				Atividade <span class="caret"></span>
			</button>
			<ul class="dropdown-menu dropdown-atividade " role="menu" id="drop-atividade">
			<%
				ArrayList<Atividade> listaAtiviade = e.getAtividades();
				Iterator<Atividade> iterator = listaAtiviade.iterator();
				while (iterator.hasNext()) {
					Atividade atividade = (Atividade) iterator.next();
					int idAtividade = atividade.getCodigo();
					
					ArrayList<Palestrante> palestrante = PalestranteBD.consultarPorAtividade(idAtividade);
					Iterator<Palestrante> itPalestrante = palestrante.iterator();
			%>
					<div class="col-sm-12 col-sm-6 col-md-4">
						<div class="thumbnail">
							<div class="view view-third">
								<img src="img/cal.png">
								<div class="mask">
									<h2><%=atividade.getNome() %></h2>
									<p>
										Palestrante(s): 
										<%if (itPalestrante.hasNext()){ %>
											<%=itPalestrante.next().getDadosPalestrante().getNome() %>
											<% while (itPalestrante.hasNext()){ %>
												,<%=itPalestrante.next().getDadosPalestrante().getNome() %>
											<% } %>
										<% } else { %>
											Sem Palestrante(s)
										<% } %>
									</p>
									<p>Tipo: <%=atividade.getTipo().getDescricao() %></p>
									<p>Data: <%=atividade.getData() %></p>
									<p>Horário: <%=atividade.getHora() %></p>
									<p>Local: <%=atividade.getLocal() %></p>
									<a id="<%=atividade.getCodigo() %>" href="#" class="info">Leia Mais</a>
								</div>
							</div>
							<a href="#" class="btn btn-default bottom-button" role="button">Inscreva-se</a>	
						</div>
					</div>		
					<script>
						$("#<%=atividade.getCodigo() %>").on('click', function(){
							$.post("/controle-de-evento/AtividadeExibe", {cod_atividade: <%=atividade.getCodigo() %>}, function(response){
								$('#corpo').html(response);
							});
						});
					</script>
			<%
				} 
			%>
			</ul>	
		</div>