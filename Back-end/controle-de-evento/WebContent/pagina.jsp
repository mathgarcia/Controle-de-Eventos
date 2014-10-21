<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="pojo.Evento"%>
<%@page import="pojo.Atividade"%>
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
}

div {	
	float: left;
}

</style>
</head>
<body>
<%ArrayList<Evento> evento = (ArrayList<Evento>) session.getAttribute("evento");
  Iterator<Evento> iterator = evento.iterator();%>
	<input type="submit" name="Sair" id="Sair" value="Voltar" onClick="voltar();" />
<%for (int i=0;iterator.hasNext();i++) {
	Evento umEvento = (Evento) iterator.next();%>		
	<table width="100%" id="tabela" border="1px" rules="none" frame=box>	
		<tr>
			<td align="left"><%=umEvento.getNome()%></td>
			<%-- 					<td><%=evento[i].getDescricao() %></td> --%>
			<td align="left"><%=umEvento.getData_inicio()%> | <%=umEvento.getData_fim()%></td>
			<td align="left">Local: <%=umEvento.getLocal() %></td>
			<td align="right" width="35%"></td>
		</tr>
	</table>
	<br>
	
<%}%>
<%session.invalidate();%>
</body>
</html>