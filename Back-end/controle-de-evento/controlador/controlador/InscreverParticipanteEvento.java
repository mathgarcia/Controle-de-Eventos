package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParticipanteBD;
import dao.EventoBD;
import pojo.Participante;
import pojo.Evento;

@WebServlet("/InscreverEvento")
public class InscreverParticipanteEvento extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public InscreverParticipanteEvento() 
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
		Participante participante = (Participante)sessao.getAttribute("usuarioInfo");
		Integer cod_participante = participante.getCodigo();
		
		Integer cod_evento = Integer.parseInt(request.getParameter("codigo_evento"));	
		try {
			if(ParticipanteBD.consultarInscricaoEvento(cod_participante,cod_evento) != null)
			{
				sessao.setAttribute("mensagem", "O usuário já está inscrito no evento.");
				response.sendRedirect("turu/eventos.jsp");
			}
			else
			{
				ParticipanteBD.inscreverEvento(cod_participante, cod_evento);
				sessao.setAttribute("mensagem", "O usuário foi inscrito com sucesso no evento.");
			}	
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e){
			sessao.setAttribute("mensagem", "Você Precisa efetuar login no site.");
		}
		finally{
			response.sendRedirect("turu/eventos.jsp");
			
		}
	}

}
