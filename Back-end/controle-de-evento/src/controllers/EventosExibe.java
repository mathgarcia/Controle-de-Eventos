package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EventoDAO;
import model.Evento;

@WebServlet("/EventosExibe")
public class EventosExibe extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public EventosExibe() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Evento> ev = null;
		try {
			ev = EventoDAO.consultaTodosEventos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("evento",ev);
//		response.sendRedirect("pagina.jsp");
		response.sendRedirect("eventos.jsp");

	}
}
