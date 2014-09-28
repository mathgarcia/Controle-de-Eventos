package pojo;

public class Endereco {
	private int codigo;
	private String logradouro;
	private int numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	public Endereco(int codigo, String logradouro, int numero, String cep, String bairro,
			String cidade, String estado) {
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public String getCep() {
		return cep;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEstado(){
		return estado;
	}
}
