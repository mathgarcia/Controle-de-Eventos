package dao;

import java.sql.SQLException;

public class RecepcionistaBD  extends ParticipanteBD {
	
	@SuppressWarnings("unused")
	private synchronized void validarPresenca() throws SQLException {
		iniciaConexao("");
		fechaConexao();
	}
}
