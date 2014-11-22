		/*Dependências
		*navbar-animation.js
		*jquery 11
		*/
		
		getInicialMenu = function(loginAction){
			var menu = $('<div class="navbar">');
			menu.append(getSuperiorNav(loginAction));
			menu.append(getInferiorNav());
			return menu;
		}
		
		getSuperiorNav = function(loginAction){
			var superiorNav = $('<nav class="navbar navbar-default" role="navigation">');
			var container = $('<div class="container-fluid">');
			var dateNextsEvents = $('<div id="events-avl>').append("Datas dos próximos testeEventos");
			container.append(dateNextsEvents);
			container.append(getCollapseSuperior(loginAction));
			superiorNav.append(container);			
			return superiorNav;
		}
		
		getCollapseSuperior = function (loginAction){ 
			var collapse = $('<div class="navbar-collapse collapse" id="navbar-login-collapse">');
			//primeiro passo para colocar o dropdown embaixo do botão "e inicado na direita"
			var ulNavRight = $('<ul class="nav navbar-nav navbar-right">');
			//uma lista dropdown para o ul, para inserir o botão
			var li = $('<li id="loginDrop" class="dropdown">');
			ulNavRight.append(li);
			var button = $('<button class="btn btn-default navbar-btn login dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">').append('Login');
			li.append(button);
			var dropdownContainer = $('<ul class="dropdown-menu" role="menu">');
			dropdownContainer.append(getFormDropDown(loginAction));
			li.append(dropdownContainer);
			collapse.append(ulNavRight);
			return collapse;
		}
		
		getFormDropDown = function(loginAction){
			var form = $('<form class="form-group" action="/controle-de-evento/loginParticipante" method="post" role="search" style="margin-bottom: 0px;">');
			
			var inputLogin = $('<input type="text" class="form-control" placeholder="Login" name="Login">');
			form.append(inputLogin);
			
			var inputGroup = $('<div class="input-group">');
			inputSenha = $('<input type="password" class="form-control" placeholder="Senha" name="Senha">');
			inputGroup.append(inputSenha);
			var btn = $('<span class="input-group-btn">').append(
				$('<button class="btn btn-default logar" type="button">')
				.append('Logar  ')
				.append('<span class="glyphicon glyphicon-log-in">')
			);
			btn.on('click', function(){
				$.post("/controle-de-evento/loginParticipante",{Login:inputLogin.val() ,Senha: inputSenha.val()}, loginAction);
			});
			inputGroup.append(btn);
			form.append(inputGroup);
			
			var groupRemember = $('<div class="lembrar">');
			groupRemember.append($('<input type="checkbox" name="stay" value="stay">'));
			groupRemember.append(' Lembrar-me  ');
			groupRemember.append($('<span class="glyphicon glyphicon-asterisk">'));
			groupRemember.append('  ');
			groupRemember.append($('<a href="#">').append('Esqueci minha senha'));
			form.append(groupRemember);

			var btnCreateAccount = $('<button class="btn btn-default bottom-button" type="button" id="createAccount">');
			btnCreateAccount.append('Criar uma conta'); 
			btnCreateAccount.on("click", function(){
				insertLoading();
				$('#loginDrop').removeClass('open');
				$.post("../turu/cadastro-usuario.jsp", function(response){
					$('#corpo').html(response);
				});
			});
			form.append(btnCreateAccount);
			
			return form;
		}
		
		//
		getInferiorNav = function (){
			var container = $('<div id="pos-inicial" class="pos-inicial" style="display:inline">');
			var inferiorNav = $('<nav id="header_nav" class="navbar navbar-inverse" role="navigation">');
			var content = $('<div class="container-fluid">');
			content.append(getInferiorNavHeader());
			content.append(getRightMenu());
			inferiorNav.append(content);
			container.append(inferiorNav);
			return container;
		}
		
		getInferiorNavHeader = function(){
			var header = $('<div class="navbar-header">');
			var button = $('<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-bottom-collapse">');
			button.append($('<span class="sr-only">').append('Toggle navigation'));
			button.append($('<span class="icon-bar">'));
			button.append($('<span class="icon-bar">'));
			button.append($('<span class="icon-bar">'));
			header.append(button);
			var img = $('<img id="turu" src="img/cal.png" width=95px height=65px>');
			header.append(img);
			var loginButton = $('<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-login-collapse">').append('Login');
			header.append(loginButton);
			return header;
		}
		
		getRightMenu = function() {
			var collapse = $('<div class="collapse navbar-collapse nav-middle" id="navbar-bottom-collapse">');
			var rightContent = $('<ul class="nav navbar-nav navbar-right">');
			rightContent.append($('<li>').append(getHomeButton()));
			rightContent.append($('<li>').append(getEventosButton()));
			rightContent.append($('<li>').append(getContatoButton()));
			rightContent.append(getSearchDropDown());
			collapse.append(rightContent);
			return collapse;
			
		}
		//link home buttons
		getHomeButton = function (){
			var button = $('<button type="button" class="btn btn-default btn-lg">');
			button.append('Home');
			button.on('click', function(){
				insertLoading();
				$('#corpo').html("Welcome to Home!");
			});
			return button;
		}
		getEventosButton = function(){
			var button = $('<button type="button" class="btn btn-default btn-lg">');
			button.append('Eventos');
			button.on('click', function(){
				insertLoading();
				$.post("/controle-de-evento/EventosExibe", function(response){
					$('#corpo').html(response);
				});
			});
			return button;
		}
		
		getContatoButton = function(){
			var button = $('<button type="button" class="btn btn-default btn-lg">');
			button.append('Contato');
			button.on('click', function(){
				insertLoading();
				$.post("/controle-de-evento/ExibeContatos", function(response){
					$('#corpo').html(response);
				});
			});
			return button;
		}
		
		insertLoading = function(){
			$('#corpo').html('<center><img align="center" src="../turu/img/loading.GIF"></center>');
		}
		
		getSearchDropDown = function(){
			var container = $('<li class="dropdown">');
			var button = $('<a href="#" class="dropdown-toggle dropdown-toggle-search" data-toggle="dropdown">').append('<span class="glyphicon glyphicon-search">');
			container.append(button);
			var dropdown = $('<ul class="dropdown-menu" role="menu">');
			var formContainer = $('<form class="form-group" role="search" style="margin-bottom: 0px;">');
			var formContent = $('<div class="input-group">');
			formContent.append($('<input type="text" class="form-control" placeholder="Procurar">'));
			formContent.append($('<span class="input-group-btn">').append($('<button class="btn btn-default btn-search" type="button">').append($('<span class="glyphicon glyphicon-search"></span>'))));
			formContainer.append(formContent);			
			dropdown.append(formContainer);
			container.append(dropdown);
			return container;
		}
		
	