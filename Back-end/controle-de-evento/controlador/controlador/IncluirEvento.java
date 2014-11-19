package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IncluirEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IncluirEvento() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String nome,desc,local;
		Date dataInicio, dataFim;
		boolean cancelado;
		
		int cod = null;
		nome = request.getParameter("nome");
		desc = request.getParameter("desc");
		local = request.getParameter("local");
		dataInicio = Date.parseDate("data_inicio");
		dataFim = Date.parseDate("data_fim");
		ArrayList<Atividade> ativs = null;
		
		Evento e = new Evento(cod,nome,desc,dataInicio,dataFim,local,false,ativs);
		try{
		EventoBD.adicionar(e);
		}
		catch(SQLException e){
			System.out.print("Erro sql");
		}
	}

	
	
}
