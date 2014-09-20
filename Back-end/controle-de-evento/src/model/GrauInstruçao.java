package model;

public class GrauInstruçao {
	private int codigo;
	private String nome;
	public GrauInstruçao(int codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	
}
