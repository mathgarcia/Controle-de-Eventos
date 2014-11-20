<!DOCTYPE html>
<%@page import="pojo.Participante"%>
<html>

	<head>	
		<meta charset="UTF-8">
		<!-- Lae compiled and minified CSS -->
		<link rel="stylesheet" href="lib/bootstrap/3.2.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="lib/css/layout-default.css">
		<link rel="stylesheet" href="lib/css/events.css">
		<style type="text/css">
			
		</style>
		<script src="lib/jQuery/1.11.1/jquery-1.11.1.min.js"></script>
		<script src="lib/scripts/navbar-animation.js"></script>
		<script src="lib/scripts/layoutDefault.js"></script>
		<!-- Latest compiled and minified JavaScript -->
		<script src="lib/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<title>Pagina Inicial</title>
		<script type="text/javascript">
			$.ready = function(){
				$('body').prepend(getInicialMenu());
				startNavbarAnimation();
			}
		</script>
	</head>
	
	<body style="70px">
	
	<% 		
		int exibir = 0;
		try{
			Participante part = (Participante) session.getAttribute("usuarioInfo");
			exibir = part.getCodigo();
			System.out.println(part.getNome());
			session.getAttribute("usuarioInfo");
		}
		catch(NullPointerException e){
			//
		}%>		
	}
	
		<div id="corpo" style="height:3000px; margin-left: 50px; margin-top: 150px; display:block">		
		</div>
	
	</body>
</html>