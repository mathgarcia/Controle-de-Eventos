package dao;

import java.sql.SQLException;
import pojo.Perfil;

public class AdministradorBD extends GestorBD{
	
	static public synchronized void cadastraTipoPerfil(Perfil p) throws SQLException{
		PerfilBD.adicionar(p);
	}
	
	static public synchronized void alteraPerfilUsuario(int cod_participante,int cod_perfil) throws SQLException{
		iniciaConexao("UPDATE participante SET cod_perfil = ? WHERE codigo = ?");
		ps.setInt(1, cod_perfil);
		ps.setInt(2, cod_participante);
		ps.executeUpdate();
		fechaConexao();
	}
}
