package pojo;

import java.sql.Date;

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
	private GrauInstrucao grauist;	
	private String dataNascimento;

	public Participante(int codigo, String nome, String nomeSocial,
			Date date, char sexo, String email, String telefone,
			String celular, Endereco end, String senha, String cpf,Perfil per, GrauInstrucao gr) {
		this.codigo = codigo;
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.dataNasc = date;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
		this.senha = senha;
		this.cpf = cpf;
		this.endereco = end;
		this.perfil = per;
		this.grauist = gr;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo){
		this.codigo = codigo;
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

	public GrauInstrucao getGrauist() {
		return grauist;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public String getDataNascimento(){
		return dataNascimento;
	}
	
	public void setDataNascimento(String data)
	{
		dataNascimento = data;
	}
}
