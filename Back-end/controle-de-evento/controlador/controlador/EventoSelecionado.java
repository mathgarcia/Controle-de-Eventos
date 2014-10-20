package controlador;
//Criado por Marco Aurelio
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Atividade;
import pojo.Evento;

import com.mysql.jdbc.Connection;

import dao.EventoBD;

/**
 * Servlet implementation class EventoSelecionado
 */
public class EventoSelecionado extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventoSelecionado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idEvento = Integer.parseInt(request.getParameter("idEvento"));
		Evento ev = null;
		ArrayList<Atividade> at = null;
		try {
			ev = EventoBD.consultaEvento(idEvento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("evento",ev);
//		session.setAttribute("atividades",at);
		response.sendRedirect("turu/evento-selecionado.jsp");
	}

}
