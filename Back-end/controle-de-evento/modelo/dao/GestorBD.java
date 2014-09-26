package dao;

import java.sql.SQLException;

public class GestorBD extends RecepcionistaBD {
	
	@SuppressWarnings("unused")
	private synchronized void cadastrarEvento() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	
	@SuppressWarnings("unused")
	private synchronized void alterarEvento() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	
	@SuppressWarnings("unused")
	private synchronized void cancelarEvento() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	
	@SuppressWarnings("unused")
	private synchronized void cadastrarAtividade() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	
	@SuppressWarnings("unused")
	private synchronized void alterarAtividade() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	
	@SuppressWarnings("unused")
	private synchronized void desativarAtividade() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	
	@SuppressWarnings("unused")
	private synchronized void associarPalestranteAtividade() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	
	@SuppressWarnings("unused")
	private synchronized void anexarMaterial() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
}
