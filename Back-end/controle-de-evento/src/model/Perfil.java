package model;

public class Perfil {
	private int codigo;
	private String nome;
	
	public Perfil(int codigo, String nome) {
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
