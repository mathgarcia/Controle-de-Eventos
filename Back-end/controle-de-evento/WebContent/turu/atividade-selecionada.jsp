<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="pojo.Atividade"%>
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
    			Atividade atividade = (Atividade)session.getAttribute("atividade");
    		%>
			<div class="atividade-tittle destacado col-md-12 left-15"><%=atividade.getNome()%></div>
            <div class="col-md-8">
                <div class="atividade-destaque col-md-4 left-15">
                    <p>Palestrante(s): Palestrante?1 </p> <!-- preciso do palestrante... -->
                    <p>Data: <%=atividade.getData() %></p>
                    <p>Horário: <%=atividade.getHora() %> horas</p>
                    <p>Duração: <%=atividade.getDuracao() %></p>
                    <p>Local(Sala): <%=atividade.getLocal() %></p>
                    <p>Tipo: <%=atividade.getCod_tipo() %> preciso do nome!!</p> <!-- preciso do nome... -->
                    
                    </div>
            
                <div class="atividade-descricao col-md-8 left-15">
					<%=atividade.getResumo() %>
				</div>
                <div class="col-md-12">
                    <div class="atividade-tittle left-15">Descricao?</div>
	                    <div class="atividade-descricao destacado left-15">
	                    	Preciso disso no banco! Preciso disso no banco! Preciso disso no banco! Preciso disso no banco! Preciso disso no banco! Preciso disso no banco! Preciso disso no banco! Preciso disso no banco! 
	                    </div>
                    </div>
                </div>
			
			<div class="col-md-4">
                
				<div class="atividade-buttons text-center">
                    <center><div style="width: 350px; height: 200px; background-color: transparent; border: 1px solid; border-color: #E6E9ED; margin-bottom: 10px;">
                       <span style="font-size: 25px; font-weight: bold; color: #73879C;"><br><br>Imagem</span></div></center>
				<p><button type="button" class="btn btn-default">Inscreva-se</button></p>
				<p><button type="button" class="btn btn-default">Material</button></p>
				<span class='st_facebook_large share' displayText='Facebook'></span>
				<span class='st_twitter_large share' displayText='Tweet'></span>
				<span class='st_googleplus_large share' displayText='Google +'></span>
			</div>
		</div>     
	</div>
