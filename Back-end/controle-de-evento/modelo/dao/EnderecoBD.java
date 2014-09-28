package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Endereco;

public class EnderecoBD extends DAO{
	public static Endereco consultar(int codigo) throws SQLException{
		Endereco e = null;
		iniciaConexao("SELECT * FROM endereco WHERE codigo = ?");
		ps.setInt(1, codigo);
		ResultSet rs = (ResultSet) ps.executeQuery();
		if (rs.next()){				
			String cep = rs.getString("cep");
			String logr = rs.getString("logradouro");
			int num = rs.getInt("numero");
			String bairro = rs.getString("bairro");
			String cidade = rs.getString("cidade");
			String estado = rs.getString("estado");
			e = new Endereco(codigo,logr ,num,cep, bairro, cidade, estado);
		}		
		fechaConexao();
		return e;
	}
	public static synchronized void adicionar(Endereco e) throws SQLException{
		iniciaConexao("INSERT INTO perfil VALUES (null, ?,?,?,?,?,?)");
		ps.setString(1, e.getCep());
		ps.setString(2, e.getLogradouro());
		ps.setInt(3, e.getNumero());
		ps.setString(4, e.getBairro());
		ps.setString(5, e.getCidade());
		ps.setString(6, e.getEstado());
		ps.executeUpdate();
		fechaConexao();
	}
	public static synchronized void remover(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM endereco WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
	}
	public static synchronized void atualizar(Endereco e) throws SQLException{
		iniciaConexao("UPDATE endereco SET cep = ?, logradouro = ?, numero = ?, bairro = ?, cidade = ?, estado = ? WHERE codigo = ?");	
		ps.setString(1, e.getCep());
		ps.setString(2, e.getLogradouro());
		ps.setInt(3, e.getNumero());
		ps.setString(4, e.getBairro());
		ps.setString(5, e.getCidade());
		ps.setString(6, e.getEstado());
		ps.setInt(6, e.getCodigo());
		ps.executeUpdate();
		fechaConexao();
	}
}
