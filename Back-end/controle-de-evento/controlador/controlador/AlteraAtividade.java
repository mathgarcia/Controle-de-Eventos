package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AlteraAtividade extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
    public AlteraAtividade() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int cod = Integer.parseInt(request.getParameter("cod_atividade"));
		String nom = request.getParameter("nome");
		String loc = request.getParameter("loc");
		String res = request.getParameter("res");
		Date dat = Date.parseDate(request.getParameter("dat"));
		Time hor = Time.parseTime(request.getParameter("hor"));
		int dur = Integer.parseInt(request.getParameter("dur"));	
		int cod_evento = Integer.parseInt(request.getParameter("cod_evento")); 
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		
		if (request.getAttribute("Usuario") instanceof AdministradorBD){				
			Atividade a = new Atividade(cod,nom,loc,res,dat,hor,dur,false,cod_evento,tipo);		
			try{
			AtividadeBD.atualizar(a);
			}
			catch(SQLException e){
				System.out.print("Erro sql");
			}
		}
		else{
			System.out.print("Operação inválida.");
			
		}
	}

}
