package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Evento extends DAO{

	public static ArrayList<pojo.Evento> consultaTodosEventos() throws SQLException{
		ArrayList<pojo.Evento> ev = new ArrayList<pojo.Evento>();
		ArrayList<pojo.Atividade> ativs = new ArrayList<pojo.Atividade>();
		iniciaConexao("SELECT * from evento");
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");
			String descricao = res.getString("descricao");
			Date data_inicio = res.getDate("data_inicio");
			Date data_fim = res.getDate("data_fim");
			String local = res.getString("local");
			ativs = Atividade.consultaAtividadesPorEvento(codigo);
			ev.add(new pojo.Evento(codigo, nome, descricao, data_inicio, data_fim, local, ativs));
		}
		fechaConexao();
		return ev;
	}
	public static ArrayList<pojo.Evento> consultaEvento(int cod_evento) throws SQLException{
		ArrayList<pojo.Evento> ev = new ArrayList<pojo.Evento>();
		ArrayList<pojo.Atividade> ativs = new ArrayList<pojo.Atividade>();
		iniciaConexao("SELECT * from evento WHERE codigo = cod_evento");
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");
			String descricao = res.getString("descricao");
			Date data_inicio = res.getDate("data_inicio");
			Date data_fim = res.getDate("data_fim");
			String local = res.getString("local");
			ativs = Atividade.consultaAtividadesPorEvento(codigo);
			ev.add(new pojo.Evento(codigo, nome, descricao, data_inicio, data_fim, local, ativs));
		}
		fechaConexao();
		return ev;
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
