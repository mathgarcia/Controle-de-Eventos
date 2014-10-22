 
package controlador;


import java.io.IOException;

@WebServlet("/ConsultaAtividadesInscritas")
public class ConsultarAtividadesInscritas extends HTTPServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarAtividadesInscritas() 
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
		String cod_evento = (String) request.getParameter("cod_evento");
		//String local = (String) request.getParameter("local");
		//String resumo = (String) request.getParameter("resumo");
		//String data = (String) request.getParameter("data");
		//String duracao = (String) request.getParameter("duracao");
		//String hora = (String) request.getParameter("hora");
			
		
		
		//AtividadeBD a1 = new AtividadeBD(cod);
		int codi=Integer.parseInt(cod);
		
		ArrayList results = a1.ConsultaAtividadesPorEvento(cod_evento);
		
		
		
		
		
		
		HttpSession session = request.getSession();
		//session.setAttribute("login", login);
		//session.setAttribute("senha", senha);
		response.sendRedirect("paginas/pagina1.jsp");
		
	}
	
	
	


}