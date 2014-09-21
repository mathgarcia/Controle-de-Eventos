package dao;

import model.ResultSet;
import model.SQLException;
import model.String;
import model.*;

public class ParticipanteDAO {
	
	
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
	
	
	private synchronized void insereParticipante() throws SQLException{
		this.iniciaConexao("INSERT INTO participante VALUES(null,?,?,?,?,?,?,?,?,?,?,?)");		
		ps.setString(1, nome);
		ps.setString(2, nomeSocial);
		ps.setString(3, senha);
		ps.setLong(4, sexo);
		ps.setString(5, cpf);
		ps.setDate(6, dataNasc);
		ps.setString(7, telefone);
		ps.setString(8, celular);
		ps.setString(9, email);
		ps.setInt(10,grauist.getCodigo());
		ps.setInt(11, perfil.getCodigo());
		ps.executeUpdate();
		fechaConexao();
	}
	
	//A implementar: grau, perfil(?) e endereco
		public void buscaParticipante(String email, String senha) throws SQLException{
			iniciaConexao("SELECT * FROM participante WHERE email = ? and senha = ?");
			ps.setString(1, email);		
			ps.setString(2, senha);
			ps.executeQuery();
			ResultSet res =  (ResultSet) ps.executeQuery();	
			if (res.next()){			
				nome = res.getString("nome");
				nomeSocial = res.getString("nomesocial");
				this.senha = res.getString("senha");
				this.email = res.getString("email");
				sexo = (char) res.getLong("sexo");
				dataNasc = res.getDate("data_nascimento");
				telefone = res.getString("telefone");
				celular = res.getString("celular");
			}
			fechaConexao();
		}
		
		public void deletaParticipante() throws SQLException{
			iniciaConexao("DELETE table cad_user where cpf_user=?");
			ps.setString(1, cpf);
			ps.executeUpdate();
			fechaConexao();			
		}

		
		public void atualizaParticipante() throws SQLException{
			iniciaConexao("UPDATE cad_user SET nome_user=?,nomeSocial_user=?,senha_user=?,sexo_user=?,"
					+ "dtnasc_user=?,cod_grauist=?,cod_prefiluser=? "
					+ "WHERE cpf_user=?");
			ps.setString(1, nome);
			ps.setString(2, nomeSocial);
			ps.setString(3, senha);
			ps.setLong(4, sexo);
		    ps.setDate(5, dataNasc);
			ps.setInt(6,grauist.getCodigo());
			ps.setInt(7, perfil.getCodigo());
			ps.setString(8, cpf);
			ps.executeUpdate();
			fechaConexao();	
			
			
		}
		
		
		
	
}
