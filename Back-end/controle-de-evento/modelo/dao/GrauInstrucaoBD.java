package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.GrauInstrucao;

public class GrauInstrucaoBD extends DAO{
	static public GrauInstrucao consultar(int codigo) throws SQLException{
		GrauInstrucao gi = null;
		iniciaConexao("SELECT * FROM grau_instrucao WHERE codigo = ?");
		ps.setInt(1, codigo);		
		ResultSet rs = (ResultSet) ps.executeQuery();
		if (rs.next()){				
			String nome = rs.getString("nome");			
			gi = new GrauInstrucao(codigo,nome);
		}	
		fechaConexao();
		return gi;
	}
	static public synchronized void adicionar(GrauInstrucao gi) throws SQLException{
		iniciaConexao("INSERT INTO grau_instrucao VALUES (null, ?)");
		ps.setString(1, gi.getNome());
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void remover(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM grau_instrucao WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
	}
	static public synchronized void atualizar(GrauInstrucao gi) throws SQLException{
		iniciaConexao("UPDATE grau_instrucao SET nome = ? WHERE codigo = ?");
		ps.setString(1, gi.getNome());
		ps.setInt(2, gi.getCodigo());
		ps.executeUpdate();
		fechaConexao();
	}	
}

