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

@WebServlet("/CancelaInscricaoAtividade")
public class CancelarInscricaoAtividade extends HttpServlet{//cancelar incrição evento

	private static final long serialVersionUID = 1L;
    
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */

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
		String cod = (String) request.getParameter("cod");
		//String local = (String) request.getParameter("local");
		//String resumo = (String) request.getParameter("resumo");
		//String data = (String) request.getParameter("data");
		//String duracao = (String) request.getParameter("duracao");
		//String hora = (String) request.getParameter("hora");
				
		//Atividade a1 = new Atividade ( cod, nom,  loc, res, dat,  hor, dur, cancelado, cod_evento, tipo);
		
		Integer codi=Integer.parseInt(cod);
		try {
			ParticipanteBD.cancelarInscricaoAtividade(codi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		HttpSession session = request.getSession();
		//session.setAttribute("login", login);
		//session.setAttribute("senha", senha);
		response.sendRedirect("turu/evento-selecionado.jsp");
		
	}
	
	
	
}