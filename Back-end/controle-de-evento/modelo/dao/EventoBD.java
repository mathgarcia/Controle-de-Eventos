package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Atividade;
import pojo.Evento;

public class EventoBD extends DAO{

	public static ArrayList<Evento> consultaTodosEventos() throws SQLException{
		ArrayList<Evento> ev = new ArrayList<Evento>();
		ArrayList<Atividade> ativs = new ArrayList<Atividade>();
		iniciaConexao("SELECT * from evento");
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");
			String descricao = res.getString("descricao");
			Date data_inicio = res.getDate("data_inicio");
			Date data_fim = res.getDate("data_fim");
			String local = res.getString("local");
			ativs = AtividadeBD.consultaAtividadesPorEvento(codigo);
			ev.add(new Evento(codigo, nome, descricao, data_inicio, data_fim, local, ativs));
		}
		fechaConexao();
		return ev;
	}
	public static ArrayList<Evento> consultaEvento(int cod_evento) throws SQLException{
		ArrayList<Evento> ev = new ArrayList<Evento>();
		ArrayList<Atividade> ativs = new ArrayList<Atividade>();
		iniciaConexao("SELECT * from evento WHERE codigo = cod_evento");
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");
			String descricao = res.getString("descricao");
			Date data_inicio = res.getDate("data_inicio");
			Date data_fim = res.getDate("data_fim");
			String local = res.getString("local");
			ativs = AtividadeBD.consultaAtividadesPorEvento(codigo);
			ev.add(new Evento(codigo, nome, descricao, data_inicio, data_fim, local, ativs));
		}
		fechaConexao();
		return ev;
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
