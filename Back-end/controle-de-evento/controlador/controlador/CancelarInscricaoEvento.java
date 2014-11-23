package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ParticipanteBD;
import pojo.Participante;

@WebServlet("/CancelarInscricaoEvento")
public class CancelarInscricaoEvento extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	public CancelarInscricaoEvento() 
	{
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sessao = request.getSession();				
		Integer inscricao_evento = Integer.parseInt(request.getParameter("inscricao_evento"));
		
		try {
			ParticipanteBD.cancelarInscricaoEvento(inscricao_evento);
			sessao.setAttribute("mensagem", "Cancelamento feito com sucesso.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sessao.setAttribute("mensagem", "Erro ao cancelar a inscrição.");
		}
		response.sendRedirect("turu/eventos.jsp");
	}
}
