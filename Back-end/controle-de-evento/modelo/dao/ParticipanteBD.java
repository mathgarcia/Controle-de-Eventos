package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.Endereco;
import pojo.GrauInstrucao;
import pojo.Participante;
import pojo.Perfil;

public class ParticipanteBD extends DAO{

	static public Participante consultar(int codigo) throws SQLException{
		Participante p = null;
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
			String cpf = res.getString("cpf");
			int cod_endereco = res.getInt("cod_endereco");
			int cod_grau = res.getInt("cod_grauist");
			int cod_perfil = res.getInt("cod_perfil");
			Endereco e = EnderecoBD.consultar(cod_endereco);
			Perfil per = PerfilBD.consultar(cod_perfil);
			GrauInstrucao gi = GrauInstrucaoBD.consultar(cod_grau);
			p = new Participante(codigo, nome,nomeSocial,dataNasc,sexo,email,telefone,celular,e,senha,cpf, per,gi);
		}
		fechaConexao();
		return p;
	}	
	static public synchronized void adicionar(Participante p) throws SQLException{
		DAO.iniciaConexao("INSERT INTO participante VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?)");		
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
		ps.setInt(12, p.getEndereco().getCodigo());
		ps.executeUpdate();
		fechaConexao();
	}

	static public synchronized void remover(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM participante where codigo=?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();			
	}

	static public synchronized void atualizar(Participante p) throws SQLException{
		iniciaConexao("UPDATE participante SET nome=?,nomesocial=?,senha=?,sexo=?,"
				+ "cpf = ?, data_nascimento=?, telefone_residencial = ?, telefone_celular = ?, email = ?,cod_grauist = ? "
				+ "WHERE codigo=?");
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
		ps.executeUpdate();
		EnderecoBD.atualizar(p.getEndereco());
		fechaConexao();		
	}
	static public synchronized void inscreverEvento(int cod_participante, int cod_evento) throws SQLException{
		iniciaConexao("INSERT IGNORE INTO inscricao_evento VALUES(null, ?,?)");
		ps.setInt(1, cod_evento);
		ps.setInt(2, cod_participante);
		ps.executeUpdate();
		fechaConexao();
	}

	static public synchronized void cancelarInscricaoEvento(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM inscricao_evento WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
	}

	static public synchronized void inscreverAtividade(int cod_inscricao_evento, int cod_atividade) throws SQLException{
		iniciaConexao("INSERT IGNORE INTO inscricao_atividade VALUES(null, ?,?)");
		ps.setInt(1, cod_atividade);
		ps.setInt(2, cod_inscricao_evento);
		ps.executeUpdate();
		fechaConexao();
	}
	
	static public synchronized void cancelarInscricaoAtividade(int codigo) throws SQLException{
		iniciaConexao("DELETE FROM inscricao_atividade WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeUpdate();
		fechaConexao();
	}

	//		@SuppressWarnings("unused")
	//		private synchronized void votarAtividade() throws SQLException{
	//			iniciaConexao("");
	//			fechaConexao();
	//		}
	//		
	//		@SuppressWarnings("unused")
	//		private synchronized void compartilharRedesSociais() throws SQLException{
	//			iniciaConexao("");
	//			fechaConexao();
	//		}
}