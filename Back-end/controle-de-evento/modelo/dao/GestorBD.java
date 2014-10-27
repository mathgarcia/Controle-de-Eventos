package dao;

import java.sql.SQLException;

import pojo.Atividade;
import pojo.Evento;
import pojo.Material;

public class GestorBD extends RecepcionistaBD {
	
	static public synchronized void cadastrarEvento(Evento e) throws SQLException{
		EventoBD.adicionar(e);
	}
	static public synchronized void alterarEvento(Evento e) throws SQLException{
		EventoBD.atualizar(e);
	}
	static public synchronized void cancelarEvento(int codigo) throws SQLException{
		EventoBD.cancelar(codigo);
	}
	static public synchronized void cadastrarAtividade(Atividade a) throws SQLException{
		AtividadeBD.adicionar(a);
	}	
	static public synchronized void alterarAtividade(Atividade a) throws SQLException{
		AtividadeBD.atualizar(a);
	}	
	static public synchronized void desativarAtividade(int codigo) throws SQLException{
		AtividadeBD.cancelar(codigo);
	}	
	static public synchronized void associarPalestranteAtividade(int cod_atividade, int cod_palestrante) throws SQLException{
		iniciaConexao("INSERT INTO atividade_palestrantes VALUES (null, ?, ?)");
		ps.setInt(1, cod_atividade);
		ps.setInt(2, cod_palestrante);
		ps.executeUpdate();		
		fechaConexao();
	}
	static public synchronized void anexarMaterial(Material m) throws SQLException{
		MaterialBD.adicionar(m);
	}
}
