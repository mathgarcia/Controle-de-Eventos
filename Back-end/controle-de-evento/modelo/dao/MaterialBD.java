package dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Material;

public class MaterialBD extends DAO {
	static public synchronized Material consultar(int codigo) throws SQLException{
		Material m = null;
		iniciaConexao("SELECT * FROM material WHERE codigo = ?");
		ps.setInt(1, codigo);
		ResultSet rs =(ResultSet) ps.executeQuery();
		if (rs.next()){
			Blob material = rs.getBlob("material");
			int cod_atividade = rs.getInt("cod_atividade");
			m = new Material(codigo, material, cod_atividade);
		}
		fechaConexao();
		return m;
	}
	static public synchronized Material consultarPorMaterial(int codigo) throws SQLException{
		Material m = null;
		iniciaConexao("SELECT * FROM material WHERE cod_atividade = ?");
		ps.setInt(1, codigo);
		ResultSet rs =(ResultSet) ps.executeQuery();
		if (rs.next()){
			Blob material = rs.getBlob("material");
			int cod_atividade = rs.getInt("cod_atividade");
			m = new Material(codigo, material, cod_atividade);
		}
		fechaConexao();
		return m;
	}
	static public synchronized void adicionar(Material m) throws SQLException{
		iniciaConexao("INSERT INTO material VALUES (null, ?, ?)");
		ps.setBlob(1, m.getMaterial());
		ps.setInt(1, m.getCod_atividade());
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void remover(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM material WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void atualizar(Material m) throws SQLException{
		iniciaConexao("UPDATE material SET material = ? where codigo = ?");
		ps.setBlob(1, m.getMaterial());		
		ps.executeUpdate();
		fechaConexao();
	}
}
