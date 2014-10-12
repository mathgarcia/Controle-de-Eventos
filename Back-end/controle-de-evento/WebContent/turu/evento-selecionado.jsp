<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="pojo.Atividade"%>
<%@page import="pojo.Evento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" href="turu/lib/css/events.css">
<link rel="stylesheet" href="turu/lib/css/event-selected.css">

<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
<script type="text/javascript">
	stLight.options({
		publisher: "a5b0e44e-491c-456a-ae7a-cb2d4712f699",
		doNotHash: false,
		doNotCopy: false,
		hashAddressBar: false
	});
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
				ArrayList<Evento> listaEvento = (ArrayList<Evento>) session.getAttribute("evento");
				Iterator<Evento> it = listaEvento.iterator();
				Evento e = it.next();
			%>
			<div class="col-md-8">
				<div class="event-description">
					<h1><%=e.getNome() %></h1>
					<%=e.getDescricao() %>
				</div>
			</div>
			<div class="col-md-4 text-center">
				<div class="event-buttons">
					<p>
						<button type="button" class="btn btn-default">Como Chegar</button>
					</p>
					<p>
						<button type="button" class="btn btn-default">Inscreva-se</button>
					</p>
					<span class='st_facebook_large share' displayText='Facebook'></span>
					<span class='st_twitter_large share' displayText='Tweet'></span>
					<span class='st_googleplus_large share' displayText='Google +'></span>
				</div>
			</div>
		</div>


		<div class="btn-group btn-atividade">
			<button type="button" class="btn btn-default dropdown-toggle btn-atividade" data-toggle="dropdown" id="btn-atividade">
				Atividade <span class="caret"></span>
			</button>
			<ul class="dropdown-menu dropdown-atividade" role="menu" id="drop-atividade">
			<%
				ArrayList<Atividade> listaAtiviade = (ArrayList<Atividade>) session.getAttribute("atividades");
				Iterator<Atividade> iterator = listaAtiviade.iterator();
				while (iterator.hasNext()) {
					Atividade atividade = (Atividade) iterator.next();
					int idAtividade = atividade.getCodigo();
			%>
					<div class="col-sm-12 col-sm-6 col-md-4">
						<div class="thumbnail">
							<div class="view view-third">
								<img src="turu/img/cal.png">
								<div class="mask">
									<h2><%=atividade.getNome() %></h2>
									<p>Palestrnate: Palestrante!?!?</p>
									<p>Tipo: <%=atividade.getTipo() %></p>
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
							alert("click");
							
						});
					</script>
			<%
				} 
			%>
			</ul>	
		</div>
