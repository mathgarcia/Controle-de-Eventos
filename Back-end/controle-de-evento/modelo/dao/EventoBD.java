package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Atividade;
import pojo.Evento;

public class EventoBD extends DAO{
	public static Evento consultaEvento(int codigo) throws SQLException{
		Evento e = null;
		ArrayList<Atividade> ativs = new ArrayList<Atividade>();
		iniciaConexao("SELECT * from evento WHERE codigo = ?");
		ps.setInt(1, codigo);
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){			
			String nome = res.getString("nome");
			String descricao = res.getString("descricao");
			Date data_inicio = res.getDate("data_inicio");
			Date data_fim = res.getDate("data_fim");
			String local = res.getString("local");
			//boolean cancelado = res.getBoolean("cancelado");
			ativs = AtividadeBD.consultaAtividadesPorEvento(codigo);
			e = new Evento(codigo, nome, descricao, data_inicio, data_fim, local,false, ativs);
		}
		fechaConexao();
		return e;
	}
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
			//boolean cancelado = res.getBoolean("cancelado");
			ativs = AtividadeBD.consultaAtividadesPorEvento(codigo);
			ev.add(new Evento(codigo, nome, descricao, data_inicio, data_fim, local,false, ativs));
		}
		fechaConexao();
		return ev;
	}
	
	static public synchronized void adicionar(Evento e) throws SQLException{
		iniciaConexao("INSERT into evento(null, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, e.getNome());
		ps.setString(2, e.getDescricao());
		ps.setDate(3, e.getData_inicio());
		ps.setDate(4, e.getData_fim());
		ps.setString(5, e.getLocal());		
		ps.setBoolean(6, e.isCancelado());
		fechaConexao();
	}
	public static synchronized void remover(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM evento WHERE codigo = ?");
		ps.setInt(1, codigo);
		fechaConexao();
	}
	public static synchronized void atualizar(Evento e) throws SQLException{
		iniciaConexao("UPDATE evento SET nome = ?, descricao = ?, data_inicio = ?, data_fim = ?, local = ?"
				+ " WHERE codigo  = ?");
		ps.setString(1, e.getNome());
		ps.setString(2, e.getDescricao());
		ps.setDate(3, e.getData_inicio());
		ps.setDate(4, e.getData_fim());
		ps.setString(5, e.getLocal());	
		ps.setInt(6, e.getCodigo());
		fechaConexao();
	}
	static public void cancelar(int cod_evento) throws SQLException{
		iniciaConexao("UPDATE evento SET cancelado = true WHERE codigo = ?");
		ps.setInt(1, cod_evento);
		ps.executeUpdate();
		fechaConexao();
	}
}
