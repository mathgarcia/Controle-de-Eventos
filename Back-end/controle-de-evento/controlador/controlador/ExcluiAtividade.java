package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExcluiAtividade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluiAtividade() {
		super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod_atividade"));
		
		if (request.getAttribute("Usuario") instanceof GestorBD){				
			Atividade a = new Atividade(cod,nom,loc,res,dat,hor,dur,false,cod_evento,tipo);		
			try{			
				GestorBD.removerAtividade(cod);
				System.out.print("Atividade excluída com exito.");
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
