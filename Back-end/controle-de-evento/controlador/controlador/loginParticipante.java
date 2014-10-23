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
@WebServlet("/Login")
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
		String nome = (String) request.getAttribute("nome");
		String senha = (String) request.getAttribute("senha");
		try {
			ParticipanteBD usuario = null;
			Participante p = ParticipanteBD.consultarPorNomeSenha(nome, senha);		
			if (p.getPerfil().getNome() == "Gestor")
				usuario = new GestorBD();
			else
				if (p.getPerfil().getNome() == "Recepcionista")
					usuario = new RecepcionistaBD();
				else
					if (p.getPerfil().getNome() == "Administrador")
						usuario = new AdministradorBD();
					else
						usuario = new ParticipanteBD();
			usuario = new GestorBD();
			if (usuario instanceof GestorBD){
				JOptionPane.showMessageDialog(null, "sim");	
				response.sendRedirect("eventos.jsp");
			}
			else
				JOptionPane.showMessageDialog(null, "nao");
			session.setAttribute("Usuario",usuario);
			session.setAttribute("UsuarioInfo", p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.setAttribute("resposta","Usuário Inválido.");	
			//			response.sendRedirect("eventos.jsp");
		}
	}
}
