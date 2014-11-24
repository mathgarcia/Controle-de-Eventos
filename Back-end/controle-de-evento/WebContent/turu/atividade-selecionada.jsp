<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="pojo.Atividade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@page import="pojo.Evento"%>
<%@page import="pojo.Participante"%>
<%@page import="dao.ParticipanteBD"%>
<%@page import="pojo.Palestrante"%>
<%@page import="dao.PalestranteBD"%>
<%@page import="java.sql.SQLException" %>
	<link rel="stylesheet" href="lib/css/activity.css">
	<script type="text/javascript">
		stLight.options({
			publisher: "a5b0e44e-491c-456a-ae7a-cb2d4712f699",
			doNotHash: false,
			doNotCopy: false,
			hashAddressBar: false
		});
	</script>
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
    		<%
    			Atividade atividade = (Atividade)session.getAttribute("Atividade");
    			ArrayList<Palestrante> palestrante = PalestranteBD.consultarPorAtividade(atividade.getCodigo());
    			Iterator<Palestrante> iterator = palestrante.iterator();
    		%>
			<div class="atividade-tittle destacado col-md-12 left-15"><%=atividade.getNome()%></div>
            <div class="col-md-8">
                <div class="atividade-destaque col-md-4 left-15">
                    
						<%if (iterator.hasNext()){ %>
							<%=iterator.next().getDadosPalestrante().getNome() %>
						<% while (iterator.hasNext()){ %>
							<p>Palestrante(s): <%=iterator.next().getDadosPalestrante().getNome() %></p>
						<% } %>
						<% } else { %>
							<p>Palestrante(s): Sem Palestrante(s) </p>
						<% } %> 
                    <p>Data: <%=atividade.getData() %></p>
                    <p>Horário: <%=atividade.getHora() %> horas</p>
                    <p>Duração: <%=atividade.getDuracao() %></p>
                    <p>Local(Sala): <%=atividade.getLocal() %></p>
                    <p>Tipo: <%=atividade.getTipo().getDescricao() %></p>
                    
                    </div>
            
                <div class="atividade-descricao col-md-8 left-15">
					<%=atividade.getResumo() %>
				</div>
                <div class="col-md-12">
                    <div class="atividade-tittle left-15"><%=atividade.getNome() %></div>
	                    <div class="atividade-descricao destacado left-15">
	                    	<%=atividade.getResumo() %> 
	                    </div>
                    </div>
                </div>
			
			<div class="col-md-4">
                
				<div class="atividade-buttons text-center">
                    <center><div style="width: 350px; height: 200px; background-color: transparent; border: 1px solid; border-color: #E6E9ED; margin-bottom: 10px;">
                       <span style="font-size: 25px; font-weight: bold; color: #73879C;"><br><br>Imagem</span></div></center>
				<p>
					<% if (part != null && ParticipanteBD.consultarInscricaoAtividade(inscricao_evento, atividade.getCodigo()) == null){%>
							<button class="btn btn-default bottom-button" role="button" id="inscrever<%=atividade.getCodigo() %>">Inscreva-se</button>		
					<% }else if (inscricao_evento!=null){%>
					 	<button  class="btn btn-default bottom-button" role="button" id="cancelarInscricao<%=atividade.getCodigo() %>">Cancelar Inscrição</button>
					 <% }else{%>
					 	<button  class="btn btn-default bottom-button disabled" role="button" >Faça login para inscrever-se</button>
					 <% }%>
				</p>
				<p><button type="button" class="btn btn-default">Material</button></p>
				<span class='st_facebook_large share' displayText='Facebook'></span>
				<span class='st_twitter_large share' displayText='Tweet'></span>
				<span class='st_googleplus_large share' displayText='Google +'></span>
			</div>
		</div>     
	</div>
	<script>
		$("#inscrever<%=atividade.getCodigo() %>").on('click', function(){
			$.post("/controle-de-evento/InscreverAtividade", {codigo_evento: <%=e.getCodigo() %>, codigo_atividade: <%=atividade.getCodigo() %>} , function(response){
				$('#corpo').html(response);
			});
		}); 
		$("#cancelarInscricao<%=atividade.getCodigo() %>").on('click', function(){							
			$.post("/controle-de-evento/CancelaInscricaoAtividade", {cod:<%=ParticipanteBD.consultarInscricaoAtividade(inscricao_evento, atividade.getCodigo())%>}, function(response){
				$('#corpo').html(response);
			});
		}); 
	</script>
