package controlador;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import pojo.Participante;
import dao.AdministradorBD;
import dao.GestorBD;
import dao.ParticipanteBD;
import dao.RecepcionistaBD;
@WebServlet("/loginParticipante")
public class loginParticipante extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String cpf = (String) request.getParameter("Login");
		String senha = (String) request.getParameter("Senha");
		try {
			ParticipanteBD usuario = null;
			Participante p = ParticipanteBD.consultarPorCPFSenha(cpf, senha);
			if (p.getPerfil().getNome().equals("Gestor"))
				usuario = new GestorBD();
			else if (p.getPerfil().getNome().equals("Recepcionista"))
				usuario = new RecepcionistaBD();
			else if (p.getPerfil().getNome().equals("Administrador"))
				usuario = new AdministradorBD();
			else
				usuario = new ParticipanteBD();				
			session.setAttribute("usuario",usuario);			
			session.setAttribute("usuarioInfo", p);
			session.setMaxInactiveInterval(100);
			session.setAttribute("resposta","Bem Vindo.");	
			response.sendRedirect("turu/index.jsp");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute("resposta","Erro de Login.");	
			response.sendRedirect("turu/index.jsp");
		}
		catch(NullPointerException e){
			session.setAttribute("resposta","Login ou Senha inválidos.");
			response.sendRedirect("turu/index.jsp");
		}
		
	}
}
