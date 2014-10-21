package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Perfil;
import dao.AdministradorBD;
import dao.GestorBD;

@WebServlet("/CadastraTipoPerfil")
public class CadastraTipoPerfil extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public CadastraTipoPerfil() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getAttribute("Usuario") instanceof AdministradorBD){
			session.setAttribute("resposta","Voc� n�o possui permiss�o para esta opera��o.");	
//			response.sendRedirect("eventos.jsp");
		}
		else{			
			String descricao = request.getParameter("descricao");
			
			try {				
				AdministradorBD.cadastraTipoPerfil(new Perfil((Integer) null, descricao));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute("resposta","Ocorreu um erro ao registrar essa associa��o.");	
//				response.sendRedirect("eventos.jsp");
			}
		}
		session.setAttribute("resposta","Cadastro registrado com sucesso.");	
//		response.sendRedirect("eventos.jsp");
	}
}
