package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import pojo.Atividade;

public class AtividadeBD extends DAO{

	public static ArrayList<Atividade> consultaAtividade(int cod_atividade) throws SQLException{
		ArrayList<Atividade> ativs = new ArrayList<Atividade>();
//		if (!con.isClosed())
			iniciaConexao("SELECT * from atividade WHERE cod_atividade = ?");
		ps.setInt(1,cod_atividade);
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){			
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");			
			String local = res.getString("local");			
			String resumo = res.getString("resumo");			
			Date data = res.getDate("data");			
			java.sql.Time hora = res.getTime("hora");			
			int duracao = res.getInt("duracao");	
			Atividade ativ = new Atividade(codigo,nome, local, resumo,data,hora,duracao,null);
			ativs.add(ativ);
		}
		fechaConexao();
		return ativs;
	}
	public static ArrayList<Atividade> consultaAtividadesPorEvento(int cod_evento) throws SQLException{
		ArrayList<Atividade> ativs = new ArrayList<Atividade>();
//		if (!con.isClosed())
		iniciaConexao("SELECT * from atividade WHERE cod_evento = ?");
		ps.setInt(1,cod_evento);
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){			
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");			
			String local = res.getString("local");			
			String resumo = res.getString("resumo");			
			Date data = res.getDate("data");			
			java.sql.Time hora = res.getTime("hora");			
			int duracao = res.getInt("duracao");	
			Atividade ativ = new Atividade(codigo,nome, local, resumo,data,hora,duracao,null);
			ativs.add(ativ);
		}
		fechaConexao();
		return ativs;
	}
	
	public static ArrayList<Atividade> consultaTodasAtividades() throws SQLException{
		ArrayList<Atividade> ativs = new ArrayList<Atividade>();
//		if (!con.isClosed())
			iniciaConexao("SELECT * from atividade");
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){			
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");			
			String local = res.getString("local");			
			String resumo = res.getString("resumo");			
			Date data = res.getDate("data");			
			java.sql.Time hora = res.getTime("hora");			
			int duracao = res.getInt("duracao");
			Atividade ativ = new Atividade(codigo,nome, local, resumo,data,hora,duracao,null);
			ativs.add(ativ);
		}
		fechaConexao();
		return ativs;
	}
	public static synchronized void inserir() throws SQLException{
		iniciaConexao(null);
		
		fechaConexao();
	}
	public static synchronized void remover() throws SQLException{
		iniciaConexao(null);
		
		fechaConexao();
	}
	public static synchronized void atualizar() throws SQLException{
		iniciaConexao(null);
		
		fechaConexao();
	}
}
