package dao;

import model.ArrayList;
import model.Atividade;
import model.ConexaoBD;
import model.Date;
import model.ResultSet;
import model.SQLException;
import model.String;
import model.Time;
import model.*;


public class AtividadeDAO {
	
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
	

	public static ArrayList<Atividade> consultaAtividades(int cod_evento) throws SQLException{
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
			Time hora = res.getTime("hora");			
			int duracao = res.getInt("duracao");	
			System.out.println(codigo);
			Atividade ativ = new Atividade(codigo,nome, local, resumo,data,hora,duracao,null);
			ativs.add(ativ);
		}
		fechaConexao();
		return ativs;
	}
	
}
