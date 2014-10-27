package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AtividadeBD;
import dao.PalestranteBD;
import pojo.Atividade;
import pojo.Palestrante;
@WebServlet("/AtividadeExibe")
public class AtividadeExibe {
	private static final long serialVersionUID = 1L;
	public AtividadeExibe() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod_atividade = (Integer) request.getAttribute("cod_atividade");
		Atividade a = null;
		ArrayList<Palestrante> p = null;
		Date data = new Date();		
		try {
			a = AtividadeBD.consultaAtividade(cod_atividade);
			p = PalestranteBD.consultarPorAtividade(cod_atividade);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("Atividade",a);
		session.setAttribute("listaPalestrante",p);
		response.sendRedirect("turu/eventos.jsp");
	}
}
