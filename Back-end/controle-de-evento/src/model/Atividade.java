package model;

import java.sql.Time;
import java.util.Date;

public class Atividade {
	private int codigo;
	private String nome;
	private String local;
	private String resumo;
	private Date data;
	private Time hora;
	private int duracao;
	private Tipo tipo;
	public Atividade(int cod, String nom, String loc, String res, Date dat, Time hor, int dur, Tipo tipo){
		codigo = cod;
		nome = nom;
		local = loc;
		resumo = res;
		data = dat;
		hora = hor;
		duracao = dur;
		this.tipo = tipo;
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
	public Time getHora() {
		return hora;
	}
	public int getDuracao() {
		return duracao;
	}
	public Tipo getTipo() {
		return tipo;
	}
}
