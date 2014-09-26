package dao;

import java.sql.SQLException;

public class AdministradorBD extends GestorBD{

	@SuppressWarnings("unused")
	private synchronized void cadastraTipoPerfil() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	
	@SuppressWarnings("unused")
	private synchronized void alteraPerfilUsuario() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
}
