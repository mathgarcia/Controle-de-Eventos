package dao;

import java.sql.SQLException;
import pojo.Tipo;

public class TipoBD extends DAO{
	static public void consultar(int codigo) throws SQLException{
		iniciaConexao("SELECT * FROM tipo WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeQuery();
		fechaConexao();
	}
	static public synchronized void  adicionar(Tipo t) throws SQLException{
		iniciaConexao("INSERT INTO tipo VALUES (null, ?)");
		ps.setString(1, t.getDescricao());
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void  atualizar(Tipo t) throws SQLException{
		iniciaConexao("UPDATE tipo SET descricao = ? WHERE codigo = ?");
		ps.setString(1, t.getDescricao());
		ps.setInt(2, t.getCodigo());
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void remover(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM tipo WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
	}
}
