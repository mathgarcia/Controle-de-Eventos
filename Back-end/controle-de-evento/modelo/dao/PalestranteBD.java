package dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Palestrante;

public class PalestranteBD extends DAO{
	static public Palestrante consultar(int codigo) throws SQLException{
		Palestrante p = null;
		iniciaConexao("SELECT * FROM palestrante WHERE codigo = ?");
		ps.setInt(1, codigo);
		ResultSet rs = (ResultSet) ps.executeQuery();
		if (rs.next()){
			Blob curriculo = rs.getBlob("curriculo");
			String lattes = rs.getString("lattes");
			int cod_part = rs.getInt("cod_participante");
			p = new Palestrante(codigo, curriculo, lattes, cod_part);
		}
		fechaConexao();
		return p;
	}		
	static public synchronized void adicionar(Palestrante p) throws SQLException{
		iniciaConexao("INSERT IGNORE INTO palestrante VALUES (null, ?, ?, ?)");
		ps.setBlob(1, p.getCurriculo());
		ps.setString(2, p.getLattes());
		ps.setInt(3, p.getCod_participante());
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void remover(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM palestrante WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void atualizar(Palestrante p) throws SQLException{
		iniciaConexao("UPDATE palestrante SET curriculo = ?, lattes = ? WHERE codigo = ?");
		ps.setBlob(1, p.getCurriculo());
		ps.setString(2, p.getLattes());
		ps.setInt(3, p.getCodigo());
		ps.executeUpdate();
		fechaConexao();
	}
}