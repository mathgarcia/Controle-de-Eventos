package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Atividade extends DAO{

	public static ArrayList<pojo.Atividade> consultaAtividade(int cod_atividade) throws SQLException{
		ArrayList<pojo.Atividade> ativs = new ArrayList<pojo.Atividade>();
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
			pojo.Atividade ativ = new pojo.Atividade(codigo,nome, local, resumo,data,hora,duracao,null);
			ativs.add(ativ);
		}
		fechaConexao();
		return ativs;
	}
	public static ArrayList<pojo.Atividade> consultaAtividadesPorEvento(int cod_evento) throws SQLException{
		ArrayList<pojo.Atividade> ativs = new ArrayList<pojo.Atividade>();
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
			pojo.Atividade ativ = new pojo.Atividade(codigo,nome, local, resumo,data,hora,duracao,null);
			ativs.add(ativ);
		}
		fechaConexao();
		return ativs;
	}
	
	public static ArrayList<pojo.Atividade> consultaTodasAtividades() throws SQLException{
		ArrayList<pojo.Atividade> ativs = new ArrayList<pojo.Atividade>();
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
			pojo.Atividade ativ = new pojo.Atividade(codigo,nome, local, resumo,data,hora,duracao,null);
			ativs.add(ativ);
		}
		fechaConexao();
		return ativs;
	}
	public static void inserir() throws SQLException{
		iniciaConexao(null);
		
		fechaConexao();
	}
	public static void remover() throws SQLException{
		iniciaConexao(null);
		
		fechaConexao();
	}
	public static void atualizar() throws SQLException{
		iniciaConexao(null);
		
		fechaConexao();
	}
}
