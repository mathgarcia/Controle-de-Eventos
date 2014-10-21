package controlador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.GestorBD;
import pojo.Material;

@WebServlet("/AnexarMaterial")
public class AnexarMaterial extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public AnexarMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Part arquivo = request.getPart("arquivo");
		int cod_atividade = (Integer) request.getAttribute("cod_atividade");
		InputStream input = arquivo.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		for (int length = 0; (length = input.read(buffer)) > 0;) output.write(buffer, 0, length);	

		Material m = new Material((Integer) null,output.toByteArray(),cod_atividade);
		try {
			GestorBD.anexarMaterial(m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
