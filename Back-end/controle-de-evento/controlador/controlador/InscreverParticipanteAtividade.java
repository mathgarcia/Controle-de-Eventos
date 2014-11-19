package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ParticipanteBD;
import dao.EventoBD;
import dao.AtividadeBD;
import pojo.Participante;
import pojo.Evento;

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
		HttpSession session = request.getSession();
		ParticipanteBD participanteBD = (ParticipanteBD) request.getAttribute("Usuario");
		Participante participante = (Participante) request.getAttribute("UsuarioInfo");
		int codigo_atividade;
		int codigo_part = participante.getCodigo();
		
		int codigo_evento = session.getAttribute("idEvento");
		
		if(participanteBD.consultarInscricaoEvento==null)
		{
			participanteBD.inscreverEvento(codigo_part, codigo_evento);
		}
		
		codigo_atividade = request.getAttribute("idAtividade");
		/*
		ArrayList<Atividade> lista = AtividadeBD.consultaAtividadesPorEvento(codigo_evento);
		Iterator iterator = lista.iterator();
		Atividade atividade;
		
		while(Iterator.hasNext())
		{
			atividade = iterator.next();
			int codigo = atividade.getCodigo();
			if(request.getAttribute(""+codigo))
			{
				codigo_atividade = codigo;
			}
		}
		*/
		
		if(participanteBD.consultarInscricaoAtividade(codigo_part, codigo_atividade))
		{
			session.setAttribute("Aviso", "O usuário já está inscrito nesta atividade.");
			response.sendRedirect("turu/evento-selecionado.jsp");
		}
		else
		{
			int cod_inscrEvento = participanteBD.consultarInscricaoEvento(cod_part, codigo_evento);
			participanteBD.inscreverAtividade(cod_inscrEvento, codigo_atividade);
			session.setAttribute("Aviso", "O usuário foi inscrito com sucesso nesta atividade.");
			response.sendRedirect("turu/evento-selecionado.jsp");			
		}
	}

}
