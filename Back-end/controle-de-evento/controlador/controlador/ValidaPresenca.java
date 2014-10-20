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
import dao.RecepcionistaBD;

@WebServlet("/ValidaPresenca")
public class ValidaPresenca extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public ValidaPresenca() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getAttribute("Usuario") instanceof RecepcionistaBD){
			session.setAttribute("resposta","Você não possui permissão para esta operação.");	
//			response.sendRedirect("eventos.jsp");
		}
		else{
			int cod_inscricao_evento = Integer.parseInt(request.getParameter("cod_inscricao_evento"));
			int cod_atividade = Integer.parseInt(request.getParameter("cod_palestrante"));
			try {
				RecepcionistaBD.validarPresenca(cod_inscricao_evento, cod_atividade);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute("resposta","Ocorreu um erro ao registrar essa associação.");	
//				response.sendRedirect("eventos.jsp");
			}
		}
		session.setAttribute("resposta","Validação registrada com sucesso.");	
//		response.sendRedirect("eventos.jsp");
	}
}
