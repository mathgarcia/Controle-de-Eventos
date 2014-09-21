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
	
	
	


	
	/*
	private void alterarDados() throws SQLException{
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
	}*/
	
	
	

	
	
	

	
}
