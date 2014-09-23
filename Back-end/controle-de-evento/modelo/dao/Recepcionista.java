package dao;

import java.sql.SQLException;

public class Recepcionista  extends Participante {
	
	@SuppressWarnings("unused")
	private void validarPresenca() throws SQLException {
		iniciaConexao("");
		fechaConexao();
	}
}
