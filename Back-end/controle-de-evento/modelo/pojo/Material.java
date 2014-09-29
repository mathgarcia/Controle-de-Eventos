package pojo;

import java.sql.Blob;

public class Material {
	private int codigo;
	private Blob material;
	private int cod_atividade;
	public Material(int codigo, Blob mat, int cod_ativ){
		this.codigo = codigo;
		material = mat;
		cod_atividade = cod_ativ;
	}
	public int getCodigo() {
		return codigo;
	}
	public Blob getMaterial() {
		return material;
	}
	public int getCod_atividade() {
		return cod_atividade;
	}
	
}
