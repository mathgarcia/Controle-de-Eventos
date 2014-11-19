package controlador;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParticipanteBD;
import dao.EventoBD;
import pojo.Participante;
import pojo.Evento;


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
		HttpSession session = request.getSession();
		ParticipanteBD participanteBD = (ParticipanteBD) request.getAttribute("Usuario");
		Participante participante = (Participante) request.getAttribute("UsuarioInfo");
		int codigo_evento;
		int codigo_part = participante.getCodigo();
		
		/*
		ArrayList<Evento> eventos = EventoBD.consultarTodosEventos();
		Iterator<Evento> iterator = eventos.iterator();
		
		while(iterator.hasNext())
		{
			Evento ev = iterator.next();
			int codigo = ev.getCodigo();
			if(request.getAttribute(""+codigo)!=null)
			{
				codigo_evento = codigo;
			}
		}*/
		
		codigo_evento = request.getAttribute("idEvento");
		
		if(participanteBD.consultarInscricaoEvento(codigo_part, codigo_evento))
		{
			session.setAttribute("Aviso", "O usuário já está inscrito no evento.");
			response.sendRedirect("turu/eventos.jsp");
		}
		else
		{
			participanteBD.inscreverEvento(codigo_part, codigo_evento);
			session.setAttribute("Aviso", "O usuário foi inscrito com sucesso no evento.");
			response.sendRedirect("turu/eventos.jsp");
		}	
	}

}
