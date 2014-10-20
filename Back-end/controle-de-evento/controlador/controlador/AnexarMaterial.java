package controlador;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
		InputStream inputStream = arquivo.getInputStream();
		Material m = new Material((Integer) null,arquivo,cod_atividade);
	}
}
