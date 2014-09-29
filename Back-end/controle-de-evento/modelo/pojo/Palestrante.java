package pojo;

import java.sql.Blob;

public class Palestrante {
	private int codigo;
	private Blob curriculo;
	private String lattes;
	private int cod_participante;
	public Palestrante(int cod, Blob curriculo, String lattes,int cod_part){
		codigo = cod;
		this.curriculo = curriculo;
		this.lattes = lattes;
		cod_participante = cod_part;
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
	public int getCod_participante() {
		return cod_participante;
	}
	
}
