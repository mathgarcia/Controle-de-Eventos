package model;

import java.sql.Date;
public class Recepcionista extends Participante {
	public Recepcionista(int codigo, String nome, String nomeSocial,
			Date dataNasc, char sexo, String email, String telefone,
			String celular, Endereco endereco, String senha, String cpf,
			Endereco end, Perfil per, GrauInstruçao gr) {
		super(codigo, nome, nomeSocial, dataNasc, sexo, email, telefone, celular,
				endereco, senha, cpf, end, per, gr);
		// TODO Auto-generated constructor stub
	}
	/*
	private void validarPresenca() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	*/
}
