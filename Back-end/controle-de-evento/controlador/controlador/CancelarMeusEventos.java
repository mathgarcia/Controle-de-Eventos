package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CancelaEventos")
public class CancelarMeusEventos extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarMeusEventos() 
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
		
		String cpfusuario = (String) request.getParameter("cpf");
		String nome = (String) request.getParameter("nome");
		String tipo = (String) request.getParameter("tipo");
		String cod = (String) request.getParameter("cod");
		String local = (String) request.getParameter("local");
		String resumo = (String) request.getParameter("resumo");
		String data = (String) request.getParameter("data");
		String duracao = (String) request.getParameter("duracao");
		String hora = (String) request.getParameter("hora");
				
		Participante p1 = new Participante(int codigo, String nome, String nomeSocial,
		Date dataNasc, char sexo, String email, String telefone,
		String celular, Endereco end, String senha, String cpf,Perfil per, GrauInstrucao gr;
		ParticipanteBD pbd = new ParticipantBD()
		
		pbd.consultar(cod);
		
		
		
		
		
		
		HttpSession session = request.getSession();
		//session.setAttribute("login", login);
		//session.setAttribute("senha", senha);
		response.sendRedirect("paginas/pagina1.jsp");
		
	}
	
	
	
}