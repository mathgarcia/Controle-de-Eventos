<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="lib/css/cadastro.css">
<!-- <script src="lib/jQuery/inputMasks/jquery.inputmask.js"></script>
<script src="lib/scripts/masks.js"></script>
<script src="lib/scripts/navbar-animation.js"></script> -->
<%
	String mensagem = (String)session.getAttribute("mensagem");
	if (mensagem != null) {
%>
		<script>alert("Erro: " + <%=mensagem%>);</script>
<%
	}
%>
<div class="row">
	<form class="form-group" role="search" action="#" style="margin-bottom: 0px;">
		<div class="col-md-4 bloco-formulario" >
			<h1>Dados pessoais</h1>
			<input type="text" class="form-control" id="nomeSocial" placeholder="Nome Social" autofocus required>
				<input type="text" class="form-control" id="nomeCompleto" placeholder="Nome Completo" required>
				<input type="text" class="form-control" id="cpf" placeholder="CPF" required>
				
	
				<div class="div-cadastro">
				Sexo: 
				<input type="radio" name="sexo" value="masculino" style="margin-left: 10px; margin-right: 5px;">Masculino
				<input type="radio" name="sexo" value="feminino" style="margin-left: 10px; margin-right: 5px;">Feminino </div>
					<input type="text" class="form-control" id="instituicao" placeholder="Intituição" required>
					
				<p>	
				<div class="div-cadastro">Grau de Intrução: 
					<select id="grauInstrucao">
						 <option value="0">Fundamental Incompleto</option>
						 <option value="1">Fundamental Completo</option>
						 <option value="2">Médio Incompleto</option>
						 <option value="3" selected>Médio Completo</option>
						 <option value="4" selected>Superior Incompleto</option>
						 <option value="5" selected>Superior Completo</option>
						 <option value="6" selected>Mestrado</option>
						 <option value="7" selected>Doutorado</option>
						 <option value="8" selected>Outro</option>
					</select>
				</div>
				</p>
				
				<div class="data-holder">Data de Nascimento:</div>
				<input type="date" class="form-control data" id="dataNascimento" placeholder="Data de Nascimento" required>
				<input type="password" class="form-control" id="senha" placeholder="Senha" required>
				<input type="password" class="form-control" id="senhaConfirm" placeholder="Confirme sua Senha" required>
		</div>
		
		<div class="col-md-4 bloco-formulario">
			<h1>Endereço</h1>
				<input type="text" class="form-control logradouro" id="logradouro" placeholder="Logradouro" required>
				<input type="text" class="form-control numero" id="numero" placeholder="Número" required>
				<input type="text" class="form-control" id="complemento" placeholder="Complemento" required>
				<input type="text" class="form-control" id="cidade" placeholder="Cidade" required>
				<input type="text" class="form-control" id="bairro" placeholder="Bairro" required>
				<input type="text" class="form-control" id="cep" placeholder="CEP" required>
				<p><div class="div-cadastro">Selecione um Estado:					
					<select id="estado">
						<option value="AC">Acre</option>
						<option value="AL">Alagoas</option>
						<option value="AP">Amapá</option>
						<option value="AM">Amazonas</option>
						<option value="BA">Bahia</option>
						<option value="CE">Ceará</option>
						<option value="DF">Distrito Federal</option>
						<option value="ES">Espirito Santo</option>
						<option value="GO">Goiás</option>
						<option value="MA">Maranhão</option>
						<option value="MT">Mato Grosso</option>
						<option value="MS">Mato Grosso do Sul</option>
						<option value="MG">Minas Gerais</option>
						<option value="PA">Pará</option>
						<option value="PB">Paraiba</option>
						<option value="PR">Paraná</option>
						<option value="PE">Pernambuco</option>
						<option value="PI">Piauí</option>
						<option value="RJ">Rio de Janeiro</option>
						<option value="RN">Rio Grande do Norte</option>
						<option value="RS">Rio Grande do Sul</option>
						<option value="RO">Rondônia</option>
						<option value="RR">Roraima</option>
						<option value="SC">Santa Catarina</option>
						<option value="SP">São Paulo</option>
						<option value="SE">Sergipe</option>
						<option value="TO">Tocantis</option>
						</select>
				</div></p>
			</div>
			
			<div class="col-md-4 bloco-formulario">
				<h1>Contato</h1>
				<input type="email" class="form-control" id="email" placeholder="E-mail" required>
				<input type="text" class="form-control" id="telefone" placeholder="Telefone" required>
				<input type="text" class="form-control" id="celular" placeholder="Celular" required>				
			</div>
			<div class="col-md-4" style="margin-top: 10px;">
				<button class="btn btn-default logar" id="botaoCadastrar" type="button">Cadastrar</button>
				<button class="btn btn-default logar" type="reset">Reiniciar</button>
			</div>
		</form>
</div>
<script type="text/javascript">
	/* $("#botaoCadastrar").on("click", function(){
		alert("x");
	}); */
	$("#botaoCadastrar").on('click', function(){
		alert("Opa!");
		var dados = {
			nomeSocial: $("#nomeSocial").val(),
			nomeCompleto: $("#nomeCompleto").val(),
			cpf: $("#cpf").val(),
			sexo: $("input[name=sexo]").val(),
			instituicao: $("#instituicao").val(),
			grauInstrucao: $("#grauInstrucao").val(),
			dataNascimento: $("#dataNascimento").val(),
			senha: $("#senha").val(),
			logradouro: $("#logradouro").val(),
			numero: $("#numero").val(),
			complemento: $("#complemento").val(),
			bairro: $("#bairro").val(),
			cep: $("#cep").val(),
			estado: $("#estado").val(),
			email:$("#email").val(),
			telefone: $("#telefone").val(),
			celular: $("#celular").val()
		}
		$.post("/controle-de-evento/InscricaoParticipante", dados , function(){
			<% mensagem = (String)session.getAttribute("mensagem");%>
			alert(<%=mensagem%>);
		});
	});
</script>