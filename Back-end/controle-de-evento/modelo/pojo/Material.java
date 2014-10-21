package pojo;
public class Material {
	private int codigo;
	private byte[] material;
	private int cod_atividade;
	public Material(int codigo, byte[] mat, int cod_ativ){
		
		this.codigo = codigo;
		material = mat;
		cod_atividade = cod_ativ;
	}
	public int getCodigo() {
		return codigo;
	}
	public byte[] getMaterial() {
		return material;
	}
	public int getCod_atividade() {
		return cod_atividade;
	}
	
}
