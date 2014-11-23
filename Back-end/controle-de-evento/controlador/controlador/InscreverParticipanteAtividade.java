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
import dao.EventoBD;
import dao.AtividadeBD;
import pojo.Participante;
import pojo.Evento;

@WebServlet("/InscreverAtividade")
public class InscreverParticipanteAtividade extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public InscreverParticipanteAtividade() 
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
		
		Integer cod_evento = Integer.parseInt(request.getParameter("codigo_evento"));	
		Integer codigo_atividade = Integer.parseInt(request.getParameter("codigo_atividade"));

		try {
			Integer cod_inscrEvento = ParticipanteBD.consultarInscricaoEvento(participante.getCodigo(),cod_evento);
			if(cod_inscrEvento == null)
				ParticipanteBD.inscreverEvento(participante.getCodigo(), cod_evento);

			if(ParticipanteBD.consultarInscricaoAtividade(participante.getCodigo(), codigo_atividade) != null)
				sessao.setAttribute("mensagem", "O usuário já está inscrito nesta atividade.");
			else
			{
				ParticipanteBD.inscreverAtividade(cod_inscrEvento, codigo_atividade);
				sessao.setAttribute("mensagem", "O usuário foi inscrito com sucesso nesta atividade.");	
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			response.sendRedirect("turu/evento-selecionado.jsp");			
		}
	}

}
