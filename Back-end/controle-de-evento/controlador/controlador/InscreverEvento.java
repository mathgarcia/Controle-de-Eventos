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


@WebServlet("/InscreverEvento")
public class InscreverEvento extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
    public InscreverEvento() 
    {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cod_participante = request.getParameter("codigo_participante");
		String cod_evento = request.getParameter("codigo_evento");
		System.out.println(cod_participante);
		System.out.println(cod_evento);
		//Participante participante = ParticipanteBD.consultar(cod_participante);
		//Evento evento = EventoBD.consultar(cod_evento);
		
		try {
			ParticipanteBD.inscreverEvento(Integer.parseInt(cod_participante), 
											Integer.parseInt(cod_evento));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("mensagem", "Inscrição em evento efetuada com sucesso.");
		
		if(request.getRequestURL().equals("home.jsp"))
		{
			response.sendRedirect("home.jsp");
		}
		
		if(request.getRequestURL().equals("eventos.jsp"))
		{
			response.sendRedirect("eventos.jsp");
		}
		
		if(request.getRequestURL().equals("evento_especifico.jsp"))
		{
			response.sendRedirect("evento_especifico.jsp");
		}
		
	}

}
