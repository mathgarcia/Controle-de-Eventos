package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Evento;

@WebServlet("/EventosExibe")
public class EventosExibe extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public EventosExibe() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Evento> todosEventos = null;
		HttpSession session = request.getSession();
		Date data = new Date();		
		try {
			todosEventos = dao.EventoBD.consultarTodosEventos();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < todosEventos.size(); i++) {				
			if (todosEventos.get(i).getData_fim().before(data))
				todosEventos.remove(i);
		}
		session.setAttribute("evento",todosEventos);
		response.sendRedirect("turu/eventos.jsp");
	}
}
