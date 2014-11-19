package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.PreparedStatement;

import pojo.Endereco;
import pojo.GrauInstrucao;
import pojo.Participante;
import pojo.Perfil;

public class ParticipanteBD extends DAO{

	static public Participante consultar(int codigo) throws SQLException{
		Participante p = null;
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		iniciaConexao("SELECT * FROM participante WHERE codigo = ?");
		ps.setInt(1, codigo);
		ps.executeQuery();
		ResultSet res =  (ResultSet) ps.executeQuery();	
		if (res.next()){							
			String nome = res.getString("nome");
			String nomeSocial = res.getString("nomesocial");
			String senha = res.getString("senha");
			String email = res.getString("email");
			String sexo =  res.getString("sexo");
			Date dataNasc = res.getDate("data_nascimento");
			String telefone = res.getString("telefone_residencial");
			String celular = res.getString("telefone_celular");
			String cpf = res.getString("cpf");
			int cod_endereco = res.getInt("cod_endereco");
			int cod_grau = res.getInt("cod_grauist");
			int cod_perfil = res.getInt("cod_perfil");
			Endereco e = EnderecoBD.consultar(cod_endereco);
			Perfil per = PerfilBD.consultar(cod_perfil);
			GrauInstrucao gi = GrauInstrucaoBD.consultar(cod_grau);
			p = new Participante(codigo, nome,nomeSocial,dataNasc,sexo.charAt(0),email,telefone,celular,e,senha,cpf, per,gi);
			String dataNascimentoForm = df1.format(dataNasc);
			p.setDataNascimento(dataNascimentoForm);
		}
		fechaConexao();
		return p;
	}	
	static public Participante consultarPorCPFSenha(String cpf, String senhaRecebida) throws SQLException{
		Participante p = null;
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		iniciaConexao("SELECT * FROM participante WHERE cpf = ? AND senha = ?");
		ps.setString(1, cpf);
		ps.setString(2, senhaRecebida);
		ps.executeQuery();
		ResultSet res =  (ResultSet) ps.executeQuery();	
		if (res.next()){
			int codigo = res.getInt("codigo");
			String nome = res.getString("nome");
			String nomeSocial = res.getString("nomesocial");
			String senha = res.getString("senha");
			String email = res.getString("email");
			String sexo = res.getString("sexo");
			Date dataNasc = res.getDate("data_nascimento");
			String telefone = res.getString("telefone_residencial");
			String celular = res.getString("telefone_celular");
//			String cpf = res.getString("cpf");
			int cod_endereco = res.getInt("cod_endereco");
			int cod_grau = res.getInt("cod_grauist");
			int cod_perfil = res.getInt("cod_perfil");
			Endereco e = EnderecoBD.consultar(cod_endereco);
			Perfil per = PerfilBD.consultar(cod_perfil);
			GrauInstrucao gi = GrauInstrucaoBD.consultar(cod_grau);
			p = new Participante(codigo, nome,nomeSocial,dataNasc,sexo.toCharArray()[0],email,telefone,celular,e,senha,cpf, per,gi);
			String dataNascimentoForm = df1.format(dataNasc);
			p.setDataNascimento(dataNascimentoForm);
		}
		fechaConexao();
		return p;
	}
	static private synchronized Participante retornaUltimoId(Participante p) throws SQLException{
		DAO.iniciaConexao("SELECT LAST_INSERT_ID() id FROM participante");
		ResultSet res =  (ResultSet) ps.executeQuery();	
		p.setCodigo(res.getInt("id"));
		return p;
	}
	static public synchronized Participante adicionar(Participante p) throws SQLException{
		DAO.iniciaConexao("INSERT INTO participante VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?)");		
		ps.setString(1, p.getNome());
		ps.setString(2, p.getNomeSocial());
		ps.setString(3, p.getSenha());
		ps.setString(4, String.valueOf(p.getSexo()));
		ps.setString(5, p.getCPF());
		ps.setDate(6, p.getDataNasc());
		ps.setString(7, p.getTelefone());
		ps.setString(8, p.getCelular());
		ps.setString(9, p.getEmail());
		ps.setInt(10,p.getGrauist().getCodigo());
		ps.setInt(11, p.getPerfil().getCodigo());
		ps.setInt(12, p.getEndereco().getCodigo());
		ps.executeUpdate();
		ps = (PreparedStatement) con.prepareStatement("SELECT LAST_INSERT_ID() id FROM participante");
		ResultSet res =  (ResultSet) ps.executeQuery();	
		if (res.next()){
			p.setCodigo(res.getInt("id"));
		}
		fechaConexao();
		return p;
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
	
	static public synchronized int consultarInscricaoEvento(int cod_part, int cod_evento) throws SQLException{
		iniciaConexao("SELECT * FROM inscricao_evento WHERE cod_participante = ? and cod_evento = ?");
		ps.setInt(1, cod_part);
		ps.setInt(2, cod_evento);
		ps.executeQuery();
		ResultSet res = (ResultSet) ps.executeQuery();
		if(res.next())
		{
			int cod_inscrEvento = res.getInt("codigo");
			return cod_inscrEvento;
		}
		fechaConexao();
		return (Integer) null;
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
	
	static public synchronized boolean consultarInscricaoAtividade(int cod_part, int cod_atividade) throws SQLException
	{
		iniciaConexao("SELECT * FROM inscricao_evento WHERE cod_participante = ? and cod_evento = ?");
		ps.setInt(1, cod_part);
		ps.setInt(2, cod_atividade);
		ps.executeQuery();
		ResultSet res = (ResultSet) ps.executeQuery();
		if(res.next())
		{
			return true;
		}
		fechaConexao();
		return false;
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
