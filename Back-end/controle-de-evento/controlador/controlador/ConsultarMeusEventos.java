
package controlador;


import java.io.IOException;

import javax.servlet.*;
import dao.*;
import pojo.*;

@WebServlet("/ConsultaEventosInscritos")

public class ConsultarMeusEventos extends HTTPServlet{
	
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarMeusEventos() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//String login = (String) request.getParameter("login");
		//String senha = (String) request.getParameter("senha");
		
		//String cpfusuario = (String) request.getParameter("cpf");
		//String nome = (String) request.getParameter("nome");
		//String tipo = (String) request.getParameter("tipo");
		//String cod = (String) request.getParameter("cod");
		Participante p = (Participante) request.getAttribute("Usuario");
		//String local = (String) request.getParameter("local");
		//String resumo = (String) request.getParameter("resumo");
		//String data = (String) request.getParameter("data");
		//String duracao = (String) request.getParameter("duracao");
		//String hora = (String) request.getParameter("hora");
			
		
		
		EventosBD ebd = new EventosBD();
		int codi = p.getCodigo();
		
		ArrayList<Evento> results = ebd.consultarMeusEventos(cod);
		
		HttpSession session = request.getSession();
		session.setAttribute("eventos", results);
		//session.setAttribute("login", login);
		//session.setAttribute("senha", senha);
		response.sendRedirect("turu/calendario.jsp");
		
	}
	
}