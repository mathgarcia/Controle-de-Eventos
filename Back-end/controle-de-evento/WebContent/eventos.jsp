<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="model.Evento"%>
<%@page import="model.Atividade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function voltar() {
		history.go(-1);
	}
</script>
<style type="text/css">

table {
	border-bottom-width: 2px;	
	color: darkblue;
	width: 20%;
	height: 400px;
	table-layout: fixed;	
	float:left;	
	margin: 20px;	
}

div {	
	padding-left: 25px;
}
td,th{
	vertical-align:top;
	height: 100px;
	border: 1px;
	background-color: 
}
.tdtitulo{
/* 	background-color: darkblue; */	
	color: black;	
	text-align: left;	
	background-image:url("conteudo/logo.png");
	background-size: 300px auto;
}
.tdbotao{
	height: 1px;
	text-align: center;
	border-top-style: solid;
}
.descricao{
	text-align: center;
}
</style>
</head>
<body>
<fieldset>
<%ArrayList<Evento> listaEvento = (ArrayList<Evento>) session.getAttribute("evento");
  Iterator<Evento> iterator = listaEvento.iterator();%>
	<input type="submit" name="Sair" id="Sair" value="Voltar" onClick="voltar();" />
	
<% while (iterator.hasNext()) {
   		Evento umEvento = (Evento) iterator.next();%>	
	<a href="eventosDetalhes.jsp?cod_evento=<%=umEvento.getCodigo() %>">
	<table frame="box">			
		
		<tr>
			<th class="tdtitulo" ><%=umEvento.getNome()%></th>
		</tr>		
		<tr>										
			<td align="right"><p>Inicio:<%=umEvento.getData_inicio()%> | Fim:<%=umEvento.getData_fim()%></p></td>						
		</tr>
		<tr>
			<td class="descricao"><%=umEvento.getDescricao() %></td>
		</tr>	
		
		<tr>
			<td class="tdbotao">Inscreva-se</td>
		</tr>
	</table>
</a>		
<!-- 	<br> -->
<%-- 	<%for (int j = 0; evento[i].getAtividades()[j] != null; j++) { --%>
<%-- 		Atividade ativ = evento[i].getAtividades()[j];%> --%>
<!-- 	<div style="padding-left: 25px;"> -->
<!-- 	<table rules="none" frame=box> -->
<%-- 		<tr align="center"><td><%=ativ.getData().getMonth()%></td></tr> --%>
<%-- 		<tr align="center"><td><%=ativ.getData().getDay()%></td></tr> --%>
<!-- 		<tr align="center"><td><br></td></tr> -->
<!-- 		<tr align="center"><td>SEG</td></tr> -->
<!-- 	</table> -->
<!-- 	</div> -->
<!-- 	<div> -->
<!-- 		<table border="1px" rules="none" frame=box> -->
			
<%-- 			<tr><td><%=ativ.getNome()%></td></tr>		 --%>
<!-- 			<tr><td>Palestrante(s): </td></tr> -->
<%-- 			<tr><td>Horario: <%=ativ.getHora()%></td></tr> --%>
<%-- 			<tr><td>Local: <%=ativ.getLocal()%></td></tr>						 --%>
<!-- 		</table> -->
<!-- 	</div>	 -->
<%-- 	<%}%>	 --%>
<!-- 	<br><br><br><br><br><br><br> -->
<%}%>
<%session.invalidate();%>
</fieldset>
</body>
</html>