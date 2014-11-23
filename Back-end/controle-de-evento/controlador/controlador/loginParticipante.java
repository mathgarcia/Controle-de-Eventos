package controlador;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
				session.setMaxInactiveInterval(1800);
				session.setAttribute("mensagem","Bem Vindo!");

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute("mensagem","Erro de Login.");
		}
		catch(NullPointerException e){
			session.setAttribute("mensagem","Login ou Senha inválidos.");
		}
		finally {
			response.sendRedirect("turu/index.jsp");
		}
		
	}
}
