package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Perfil;

public class PerfilBD extends DAO{
	static public synchronized void  adicionar(Perfil p) throws SQLException{
		iniciaConexao("INSERT INTO perfil VALUES (null, ?)");
		ps.setString(1, p.getNome());
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void  atualizar(Perfil p) throws SQLException{
		iniciaConexao("UPDATE perfil SET nome = ? WHERE codigo = ?");
		ps.setString(1, p.getNome());
		ps.setInt(2, p.getCodigo());
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void remover(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM perfil WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
	}
	static public Perfil consultar(int codigo) throws SQLException{
		Perfil p = null;
		iniciaConexao("SELECT * FROM perfil WHERE codigo = ?");
		ps.setInt(1, codigo);		
		ResultSet rs = (ResultSet) ps.executeQuery();
		if (rs.next()){				
			String nome = rs.getString("nome");			
			p = new Perfil(codigo,nome);
		}	
		fechaConexao();
		return p;
	}
}
