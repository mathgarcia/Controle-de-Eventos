	$(document).ready(function(){
	$("#cpf").inputmask("999.999.999-99");
	$("#cep").inputmask("99.999-999");
	$("#cep").inputmask("99.999-999");
	$("#tel1").inputmask({ mask: "(99) 9999-9999", greedy: false });
	$("#tel2").inputmask({ mask: "(99) 9999-9999[9]", greedy: false });
	});