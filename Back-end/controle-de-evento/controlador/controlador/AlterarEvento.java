package controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Atividade;
import pojo.Evento;
import dao.GestorBD;

/**
 * Servlet implementation class AlterarEvento
 */
public class AlterarEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AlterarEvento() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo_evento = Integer.parseInt(request.getParameter("codigo_evento"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String data_inicio =  request.getParameter("data_inicio");
		String data_fim = request.getParameter("data_fim");
		String local = request.getParameter("local");
		
		//validar atributos
		 
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dt_inicio = null;
		Date dt_fim = null;
		try {
			dt_inicio = (Date) format.parse(data_inicio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dt_fim = (Date) format.parse(data_fim);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		Evento evento = new Evento (codigo_evento, nome, descricao,dt_inicio,dt_fim,local,Boolean.parseBoolean(null),(ArrayList<Atividade>)null);
		
		try {
			GestorBD.alterarEvento(evento);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("mensagem", "Cadastro de evento realizado!");
		response.sendRedirect("evento.jsp");
	}

}
