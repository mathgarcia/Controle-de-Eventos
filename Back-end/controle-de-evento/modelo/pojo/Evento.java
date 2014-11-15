package pojo;

import java.util.ArrayList;
import java.sql.Date;

public class Evento {
	private int codigo;
	private String nome;
	private String descricao;
	private Date data_inicio;
	private Date data_fim;
	private String local;
	private boolean cancelado;
	private String dataInicioFormatada;
	private String dataFinalFormatada;
	private ArrayList<Atividade> atividades;
	
	public Evento(int cod, String nom, String des, Date dati, Date datf, String loc,boolean cancelado, ArrayList<Atividade> ativs){
		codigo = cod;
		nome = nom;
		descricao = des;
		data_inicio = dati;
		data_fim = datf;
		local = loc;
		this.cancelado = cancelado;
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
	public boolean isCancelado(){
		return cancelado;
	}
	public ArrayList<Atividade> getAtividades(){
		return atividades;
	}
	
	public String getDataInicioFormatada()
	{
		return this.dataInicioFormatada;
	}
	
	public String getDataFinalFormatada()
	{
		return this.dataFinalFormatada;
	}
	
	public void setDataInicioFormatada(String data)
	{
		this.dataInicioFormatada = data;
	}
	
	public void setDataFinalFormatada(String data)
	{
		this.dataFinalFormatada = data;
	}
}
