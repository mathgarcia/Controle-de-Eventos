package dao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Participante;

public class ParticipanteDAO extends DAO{
	@SuppressWarnings("unused")
	private synchronized void inserir(Participante p) throws SQLException{
		DAO.iniciaConexao("INSERT INTO participante VALUES(null,?,?,?,?,?,?,?,?,?,?,?)");		
		ps.setString(1, p.getNome());
		ps.setString(2, p.getNomeSocial());
		ps.setString(3, p.getSenha());
		ps.setLong(4, p.getSexo());
		ps.setString(5, p.getCPF());
		ps.setDate(6, p.getDataNasc());
		ps.setString(7, p.getTelefone());
		ps.setString(8, p.getCelular());
		ps.setString(9, p.getEmail());
		ps.setInt(10,p.getGrauist().getCodigo());
		ps.setInt(11, p.getPerfil().getCodigo());
		ps.executeUpdate();
		fechaConexao();
	}
	@SuppressWarnings("unused")
	//A implementar: grau, perfil(?) e endereco
		public void buscar(int codigo) throws SQLException{
			iniciaConexao("SELECT * FROM participante WHERE codigo = ?");
			ps.setInt(1, codigo);
			ps.executeQuery();
			ResultSet res =  (ResultSet) ps.executeQuery();	
			if (res.next()){							
				String nome = res.getString("nome");
				String nomeSocial = res.getString("nomesocial");
				String senha = res.getString("senha");
				String email = res.getString("email");
				char sexo = (char) res.getLong("sexo");
				Date dataNasc = res.getDate("data_nascimento");
				String telefone = res.getString("telefone");
				String celular = res.getString("celular");
				//Participante p = new Participante();
			}
			fechaConexao();
		}
		
		public void remover(int codigo) throws SQLException{
			iniciaConexao("DELETE FROM participante where codigo=?");
			ps.setInt(1, codigo);
			ps.executeUpdate();
			fechaConexao();			
		}

		public void atualizar(Participante p) throws SQLException{
			//Refazer query update 
			iniciaConexao("UPDATE cad_user SET nome_user=?,nomeSocial_user=?,senha_user=?,sexo_user=?,"
					+ "dtnasc_user=?,cod_grauist=?,cod_prefiluser=? "
					+ "WHERE cpf_user=?");
			ps.setString(1, p.getNome());
			ps.setString(2, p.getNomeSocial());
			ps.setString(3, p.getSenha());
			ps.setLong(4, p.getSexo());
			ps.setString(5, p.getCPF());
			ps.setDate(6, p.getDataNasc());
			ps.setString(7, p.getTelefone());
			ps.setString(8, p.getCelular());
			ps.setString(9, p.getEmail());
			ps.setInt(10,p.getGrauist().getCodigo());
			ps.setInt(11, p.getPerfil().getCodigo());			
			ps.executeUpdate();
			fechaConexao();							
		}
		/*
		private void inscreverEvento() throws SQLException{
			iniciaConexao("");
			fechaConexao();
		}	
		private void cancelarinscricaoEvento() throws SQLException{
			iniciaConexao("");
			fechaConexao();
		}
		private void votarAtividade() throws SQLException{
			iniciaConexao("");
			fechaConexao();
		}
		private void compartilharRedesSociais() throws SQLException{
			iniciaConexao("");
			fechaConexao();
		}*/
}
