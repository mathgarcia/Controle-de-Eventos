package pojo;

import java.util.ArrayList;
import java.util.Date;

public class Evento {
	private int codigo;
	private String nome;
	private String descricao;
	private Date data_inicio;
	private Date data_fim;
	private String local;
	private ArrayList<Atividade> atividades;
	
	public Evento(int cod, String nom, String des, Date dati, Date datf, String loc, ArrayList<pojo.Atividade> ativs){
		codigo = cod;
		nome = nom;
		descricao = des;
		data_inicio = dati;
		data_fim = datf;
		local = loc;
		atividades = ativs;
	}
	public String getNome() {
		return nome;
	}
	public int getCodigo(){
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public Date getData_inicio() {
		return data_inicio;
	}
	public Date getData_fim() {
		return data_fim;
	}
	public String getLocal() {
		return local;
	}	
	public ArrayList<Atividade> getAtividades(){
		return atividades;
	}
}
