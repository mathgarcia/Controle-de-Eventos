package pojo;

import java.sql.Time;

import java.sql.Date;

public class Atividade {
	private int codigo;
	private String nome;
	private String local;
	private String resumo;
	private Date data;
	private Time hora;
	private int duracao;
	private boolean cancelado;
	private int cod_evento;
	private Tipo tipo;
	private String dataAtividade;
	public Atividade(int cod, String nom, String loc, String res, Date dat, Time hor, int dur,boolean cancelado, int cod_evento, Tipo tipo){
		codigo = cod;
		nome = nom;
		local = loc;
		resumo = res;
		data = dat;
		hora = hor;
		duracao = dur;
		this.cancelado = cancelado;
		this.tipo = tipo;
		this.cod_evento = cod_evento;
	}
	public int getCodigo(){
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public String getLocal() {
		return local;
	}
	public String getResumo() {
		return resumo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data)
	{
		this.data = data;
	}
	public Time getHora() {
		return hora;
	}
	public int getDuracao() {
		return duracao;
	}
	public boolean isCancelado(){
		return cancelado;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public int getCod_evento() {
		return cod_evento;
	}
	
	public String getDataAtividade()
	{
		this.dataAtividade;
	}
	
	public void setDataAtividade(String data)
	{
		this.dataAtividade = data;
	}
}
