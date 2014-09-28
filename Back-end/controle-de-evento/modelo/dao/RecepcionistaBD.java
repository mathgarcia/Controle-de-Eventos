package dao;

import java.sql.SQLException;

public class RecepcionistaBD  extends ParticipanteBD {

	@SuppressWarnings("unused")
	private synchronized void validarPresenca(int cod_inscricao_evento, int cod_atividade) throws SQLException {
		iniciaConexao("UPDATE inscricao_atividade SET validado = 1 WHERE cod_inscricao_evento = ? AND cod_atividade = ?");
		ps.setInt(1, cod_inscricao_evento);
		ps.setInt(2, cod_atividade);
		ps.executeUpdate();
		fechaConexao();
	}
}
