package dao;

import java.sql.Connection;
import java.sql.SQLException;

import model.ConexaoBD;

import com.mysql.jdbc.PreparedStatement;

abstract class DAO {
	protected static ConexaoBD conb;
	protected static Connection con;
	protected static PreparedStatement ps;
	
	protected static void iniciaConexao(String query) throws SQLException{
		conb = new ConexaoBD();
		conb.iniciaBd();
		con = conb.getConexao();
		ps = (PreparedStatement) con.prepareStatement(query);
	}
	
	protected static void fechaConexao() throws SQLException{
		ps.close();
		con.close();
		conb.fechaBd();
	}
}
