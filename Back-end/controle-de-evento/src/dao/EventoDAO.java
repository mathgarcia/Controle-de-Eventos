package dao;

import model.*;

public class EventoDAO {
	
	
	private static ConexaoBD conb;
	private static Connection con;
	private static PreparedStatement ps;
	
	protected static void iniciaConexao(String query) throws SQLException{
		conb = new ConexaoBD();
		conb.iniciaBd();
		con = conb.getConexao();
		ps = (PreparedStatement) con.prepareStatement(query);
	}
	
	protected static void fechaConexao() throws SQLException{
		ps.close();
		con.close();
		conb.fechaBd();
	}
	

	public static ArrayList<Evento> consultaEventos() throws SQLException{
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
			ativs = consultaAtividades(codigo);
			ev.add(new Evento(codigo, nome, descricao, data_inicio, data_fim, local, ativs));
		}
		fechaConexao();
		return ev;
	}
	
	
}
