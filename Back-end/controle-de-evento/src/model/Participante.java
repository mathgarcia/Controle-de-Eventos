package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import sun.misc.BASE64Encoder;

import com.sun.org.apache.xml.internal.security.encryption.EncryptedData;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;

import model.Evento;
import model.Atividade;

public class Participante {
	private int codigo;
	private String nome;
	private String nomeSocial;
	private String senha;
	private String cpf;
	private Date dataNasc;
	private char sexo;
	private String email;
	private String telefone;
	private String celular;
	private Endereco endereco;
	private Perfil perfil;
	private GrauInstruçao grauist;	
	
	private static ConexaoBD conb;
	private static Connection con;
	private static PreparedStatement ps;
	
	public Participante(int codigo, String nome, String nomeSocial,
			Date dataNasc, char sexo, String email, String telefone,
			String celular, Endereco endereco, String senha, String cpf, Endereco end, Perfil per, GrauInstruçao gr) {
		this.codigo = codigo;
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.endereco = endereco;	
		this.senha = senha;
		this.cpf = cpf;
		this.endereco = end;
		this.perfil = per;
		this.grauist = gr;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public char getSexo() {
		return sexo;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}
	public String getSenha(){
		return senha;
	}
	public String getCPF(){
		return cpf;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public GrauInstruçao getGrauist() {
		return grauist;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
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
	
	private synchronized void cadastrarParticipante() throws SQLException{
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
	public void consultaDados(String email, String senha) throws SQLException{
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
	
	private void alterarDados() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
	private void removerParticipante() throws SQLException{
		iniciaConexao("");
		fechaConexao();
	}
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
