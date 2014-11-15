<link rel="stylesheet" href="lib/css/cadastro.css">
<script src="lib/jQuery/inputMasks/jquery.inputmask.js"></script>
<script src="lib/scripts/masks.js"></script>
<script src="lib/scripts/navbar-animation.js"></script>

<div class="row">
	<form class="form-group" type="get" role="search" style="margin-bottom: 0px;">
		<div class="col-md-4 bloco-formulario" >
			<h1>Dados pessoais</h1>
			<input type="text" class="form-control" name="nomeSocial" placeholder="Nome Social" autofocus required>
				<input type="text" class="form-control" name="nomeCompleto" placeholder="Nome Completo" required>
				<input type="text" class="form-control" name="cpf" placeholder="CPF" required>
				
	
				<div class="div-cadastro">
				Sexo: 
				<input type="radio" name="sexo" value="masculino" style="margin-left: 10px; margin-right: 5px;">Masculino
				<input type="radio" name="sexo" value="feminino" style="margin-left: 10px; margin-right: 5px;">Feminino </div>
					<input type="text" class="form-control" name="instituicao" placeholder="Intituição" required>
					
				<p>	
				<div class="div-cadastro">Grau de Intrução: 
					<select name="grauInstrucao">
						 <option value="fundInc">Fundamental Incompleto</option>
						 <option value="fundComp">Fundamental Completo</option>
						 <option value="medInc">Médio Incompleto</option>
						 <option value="medComp" selected>Médio Completo</option>
						 <option value="supInc" selected>Superior Incompleto</option>
						 <option value="supComp" selected>Superior Completo</option>
						 <option value="metr" selected>Mestrado</option>
						 <option value="dout" selected>Doutorado</option>
						 <option value="outro" selected>Outro</option>
					</select>
				</div>
				</p>
				
				<div class="data-holder">Data de Nascimento:</div>
				<input type="date" class="form-control data" name="dataNascimento" placeholder="Data de Nascimento" required>
				<input type="password" class="form-control" name="senha" placeholder="Senha" required>
				<input type="password" class="form-control" id="senhaConfirm" placeholder="Confirme sua Senha" required>
		</div>
		
		<div class="col-md-4 bloco-formulario">
			<h1>Endereço</h1>
				<input type="text" class="form-control logradouro" name="logradouro" placeholder="Logradouro" required>
				<input type="text" class="form-control numero" name="numero" placeholder="Número" required>
				<input type="text" class="form-control" name="complemento" placeholder="Complemento" required>
				<input type="text" class="form-control" name="bairro" placeholder="Bairro" required>
				<input type="text" class="form-control" name="cep" placeholder="CEP" required>
				<p><div class="div-cadastro">Selecione um Estado:					
					<select>
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
				<input type="email" class="form-control" name="email" placeholder="E-mail" required>
				<input type="text" class="form-control" name="telefone" placeholder="Telefone" required>
				<input type="text" class="form-control" name="celular" placeholder="Celular" required>				
			</div>
			<div class="col-md-4" style="margin-top: 10px;">
				<button class="btn btn-default logar" type="submit">Cadastrar</button>
				<button class="btn btn-default logar" type="reset">Reiniciar</button>
			</div>
		</form>
</div>