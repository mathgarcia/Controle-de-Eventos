package model;

import java.sql.Date;
import java.sql.SQLException;

public class Gestor extends Recepcionista {
	
	public Gestor(int codigo, String nome, String nomeSocial, Date dataNasc,
			char sexo, String email, String telefone, String celular,
			Endereco endereco, String senha, String cpf, Endereco end,
			Perfil per, GrauInstruçao gr) {
		super(codigo, nome, nomeSocial, dataNasc, sexo, email, telefone, celular,
				endereco, senha, cpf, end, per, gr);
		// TODO Auto-generated constructor stub
	}
	private void cadastrarEvento() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	private void alterarEvento() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	private void cancelarEvento() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	private void cadastrarAtividade() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	private void alterarAtividade() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	private void cancelarAtividade() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	private void associarPalestranteAtividade() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	private void anexarMaterial() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
}
