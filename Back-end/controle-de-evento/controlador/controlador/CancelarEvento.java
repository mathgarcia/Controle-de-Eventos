package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestorBD;

/**
 * Servlet implementation class CancelarEvento
 */

public class CancelarEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CancelarEvento() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		int codigo_evento = Integer.parseInt(request.getParameter("codigo_evento"));
		try {
			GestorBD.cancelarEvento(codigo_evento);
		} catch (SQLException e) {
			
			e.printStackTrace();
			sessao.setAttribute("mensagem", "Erro ao cancelar o evento!");
			response.sendRedirect("eventos.jsp");
		}
		
		sessao.setAttribute("mensagem", "Cancelamento realizado com sucesso!");
		response.sendRedirect("turu/eventos.jsp");
	}

}
