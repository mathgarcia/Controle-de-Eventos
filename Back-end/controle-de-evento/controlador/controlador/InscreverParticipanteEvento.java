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
		String cod_participante = request.getParameter("codigo_participante");
		String cod_evento = request.getParameter("codigo_evento");		
		try {
			if(ParticipanteBD.consultarInscricaoEvento(Integer.parseInt(cod_participante),Integer.parseInt(cod_evento)) != null)
			{
				sessao.setAttribute("mensagem", "O usuário já está inscrito no evento.");
				response.sendRedirect("turu/eventos.jsp");
			}
			else
			{
				ParticipanteBD.inscreverEvento(Integer.parseInt(cod_participante), 
						Integer.parseInt(cod_evento));
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
