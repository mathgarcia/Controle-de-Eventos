package pojo;

import javax.servlet.http.Part;

public class Material {
	private int codigo;
	private Part material;
	private int cod_atividade;
	public Material(int codigo, Part mat, int cod_ativ){
		this.codigo = codigo;
		material = mat;
		cod_atividade = cod_ativ;
	}
	public int getCodigo() {
		return codigo;
	}
	public Part getMaterial() {
		return material;
	}
	public int getCod_atividade() {
		return cod_atividade;
	}
	
}
