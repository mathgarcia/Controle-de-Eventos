package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

import pojo.Atividade;
import pojo.Tipo;

public class AtividadeBD extends DAO{
	public static Atividade consultaAtividade(int codigo) throws SQLException{
		Atividade a = null;
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		iniciaConexao("SELECT * from atividade WHERE codigo = ?");
		ps.setInt(1,codigo);
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){						
			String nome = res.getString("nome");			
			String local = res.getString("local");			
			String resumo = res.getString("resumo");			
			Date data = (res.getDate("data"));			
			Time hora = res.getTime("hora");		
			boolean cancelado = res.getBoolean("cancelado");
			int duracao = res.getInt("duracao");	
			int cod_evento = res.getInt("cod_evento");
			int cod_tipo = res.getInt("cod_tipo");
			Tipo t = TipoBD.consultar(cod_tipo);
			a = new Atividade(codigo,nome, local, resumo,data,hora,duracao,cancelado, cod_evento, t);
			String dataFormatada = df1.format(data);
			a.setDataAtividade(dataFormatada);
		}
		fechaConexao();
		return a;
	}
	public static ArrayList<Atividade> consultaAtividadesPorEvento(int cod_evento) throws SQLException{
		ArrayList<Atividade> ativs = new ArrayList<Atividade>();
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		iniciaConexao("SELECT * from atividade WHERE cod_evento = ? ORDER BY data ASC");
		ps.setInt(1,cod_evento);
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){			
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");			
			String local = res.getString("local");			
			String resumo = res.getString("resumo");			
			Date data = res.getDate("data");			
			Time hora = res.getTime("hora");			
			int duracao = res.getInt("duracao");
			int cod_tipo = res.getInt("cod_tipo");
			Tipo t = TipoBD.consultar(cod_tipo);
			boolean cancelado = res.getBoolean("cancelado");
			Atividade ativ = new Atividade(codigo,nome, local, resumo,data,hora,duracao,cancelado,cod_evento, t);
			String dataFormatada = df1.format(data);
			ativ.setDataAtividade(dataFormatada);
			ativs.add(ativ);
		}
		fechaConexao();
		return ativs;
	}

	public static ArrayList<Atividade> consultaTodasAtividades() throws SQLException{
		ArrayList<Atividade> ativs = new ArrayList<Atividade>();
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		iniciaConexao("SELECT * from atividade ORDER BY data ASC");
		ResultSet res =  (ResultSet) ps.executeQuery();		
		while (res.next()){			
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");			
			String local = res.getString("local");			
			String resumo = res.getString("resumo");			
			Date data = res.getDate("data");			
			Time hora = res.getTime("hora");			
			int duracao = res.getInt("duracao");
			int cod_evento = res.getInt("cod_evento");
			int cod_tipo = res.getInt("cod_tipo");
			Tipo t = TipoBD.consultar(cod_tipo);
			boolean cancelado = res.getBoolean("cancelado");
			Atividade ativ = new Atividade(codigo,nome, local, resumo,data,hora,duracao,cancelado, cod_evento, t);
			String dataFormatada = df1.format(data);
			ativ.setDataAtividade(dataFormatada);
			ativs.add(ativ);
		}
		fechaConexao();
		return ativs;
	}
	public static synchronized void adicionar(Atividade a) throws SQLException{
		iniciaConexao("INSERT INTO atividade VALUES (null,?,?,?,?,?,?,?,?)");
		ps.setString(1, a.getNome());
		ps.setString(2, a.getLocal());
		ps.setString(3, a.getResumo());
		ps.setDate(4, a.getData());
		ps.setTime(5, a.getHora());
		ps.setInt(6, a.getCod_evento());
		ps.setInt(7, a.getTipo().getCodigo());
		ps.setBoolean(8, false);
		ps.executeUpdate();
		fechaConexao();
	}
	public static synchronized void remover(int codigo) throws SQLException{
		iniciaConexao("REMOVE FROM atividade WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
	}
	public static synchronized void atualizar(Atividade a) throws SQLException{
		iniciaConexao("UPDATE atividade SET nome = ?, local = ?, resumo = ?, data = ?, hora = ?, cod_evento = ?, cod_tipo = ?"
				+ " WHERE codigo = ?");
		ps.setString(1, a.getNome());
		ps.setString(2, a.getLocal());
		ps.setString(3, a.getResumo());
		ps.setDate(4, a.getData());
		ps.setTime(5, a.getHora());
		ps.setInt(6, a.getCod_evento());
		ps.setInt(7, a.getTipo().getCodigo());
		ps.setInt(8, a.getCodigo());
		fechaConexao();
	}
	static public void cancelar(int cod_atividade) throws SQLException{
		iniciaConexao("UPDATE atividade SET cancelado = true WHERE codigo = ?");
		ps.setInt(1, cod_atividade);
		ps.executeUpdate();
		fechaConexao();
	}
}
