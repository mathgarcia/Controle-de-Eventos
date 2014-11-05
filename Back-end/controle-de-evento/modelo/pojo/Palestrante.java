package pojo;

import java.sql.Blob;

public class Palestrante {
	private int codigo;
	private Blob curriculo;
	private String lattes;
	private Participante dados_palestrante;
	public Palestrante(int cod, Blob curriculo, String lattes,Participante p){
		codigo = cod;
		this.curriculo = curriculo;
		this.lattes = lattes;
		dados_palestrante = p;
	}
	public int getCodigo() {
		return codigo;
	}
	public Blob getCurriculo() {
		return curriculo;
	}
	public String getLattes() {
		return lattes;
	}
	public Participante getDadosPalestrante() {
		return dados_palestrante;
	}
	
}
