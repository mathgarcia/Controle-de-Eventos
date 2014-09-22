package model;

import java.sql.Date;

public class Administrador extends Gestor {
	
	public Administrador(int codigo, String nome, String nomeSocial,
			Date dataNasc, char sexo, String email, String telefone,
			String celular, Endereco endereco, String senha, String cpf,
			Endereco end, Perfil per, GrauInstruçao gr) {
		super(codigo, nome, nomeSocial, dataNasc, sexo, email, telefone, celular,
				endereco, senha, cpf, end, per, gr);
		// TODO Auto-generated constructor stub
	}
	/*
	private void cadastraTipoPerfil() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	private void alteraPerfilUsuario() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	*/
}
