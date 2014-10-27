package pojo;

public class Tipo {
	private int codigo;
	private String descricao;

	public Tipo(int cod, String descr){
		codigo = cod;
		descricao = descr;
	}
	public int getCodigo(){
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
}
