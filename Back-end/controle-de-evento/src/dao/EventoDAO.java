package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.*;

public class EventoDAO extends DAO{

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
			ativs = AtividadeDAO.consultaAtividadesPorEvento(codigo);
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
			ativs = AtividadeDAO.consultaAtividadesPorEvento(codigo);
			ev.add(new Evento(codigo, nome, descricao, data_inicio, data_fim, local, ativs));
		}
		fechaConexao();
		return ev;
	}
	
	private void inserirEvento() throws SQLException{
		iniciaConexao("INSERT into Evento (codigo,nome,descricao,data_inico,data_fim,local,)"
				+ " VALUES(?,?,?,?,?,?)");
		
		ps.setInt(1, codigo);
		ps.setString(2, descricao);
		ps.setDate(3, data_inicio);
		ps.setDate(4, data_fim);
		ps.setString(5, local);
		ps.executeUpdate();
		fechaConexao();
		
	}	
	
	private void removerEvento() throws SQLException{
		
		iniciaConexao("DELETE FROM Evento where codigo=?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
		
	}
	
}
