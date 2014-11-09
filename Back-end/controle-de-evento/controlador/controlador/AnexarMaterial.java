package controlador;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.GestorBD;
import dao.MaterialBD;
import pojo.Material;
@WebServlet("/AnexarMaterial")
@MultipartConfig(maxFileSize = 16177215)
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
		Part arquivo = (Part) request.getPart("arquivo");
		//int cod_atividade = (Integer) request.getAttribute("cod_atividade");
		if (arquivo.getSize() > 16177215){
			session.setAttribute("resposta","Tamanho do arquivo acima do limite permitido");
		}
		else{
			if (arquivo.getContentType().equals("application/x-zip-compressed")){
				InputStream input = arquivo.getInputStream();
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				byte[] buffer = new byte[16177215];

				for (int length = 0; (length = input.read(buffer)) > 0;) output.write(buffer, 0, length);
				Material m = new Material(1,output.toByteArray(),1);
				try {
					GestorBD.anexarMaterial(m);

					//Codigo para baixar o conteudo
					m = null;
					m = MaterialBD.consultar(4);
					response.setContentType("application/x-zip-compressed");
					response.addHeader("Content-Disposition","attachment; filename=conteudoAtividades"+m.getCod_atividade()+".zip");
					OutputStream output1 =  response.getOutputStream();
					output1.write(m.getMaterial());
					output1.close();
					session.setAttribute("resposta","Arquivo Anexado.");
				} catch (SQLException e) {
					e.printStackTrace();
					session.setAttribute("resposta","Erro ao anexar o arquivo.");
				}
			} else {
				session.setAttribute("resposta","O arquivo deve estar em formato '.ZIP'.");	
			}
		}
		response.sendRedirect("NewFile.jsp");
	}
}
