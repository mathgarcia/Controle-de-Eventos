package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Atividade;
import pojo.Palestrante;
import pojo.Participante;
import dao.AtividadeBD;
import dao.GestorBD;
import dao.PalestranteBD;
import email.Enviar;

@WebServlet("/AssociaPalestranteAtividade")
public class AssociaPalestranteAtividade extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public AssociaPalestranteAtividade() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getAttribute("Usuario") instanceof GestorBD){
			session.setAttribute("resposta","Voc� n�o possui permiss�o para esta opera��o.");	
			response.sendRedirect("eventos.jsp");
		}
		else{
			String cod_atividade = request.getParameter("cod_atividade");
			String cod_palestrante = request.getParameter("cod_palestrante");
			try {
				GestorBD.associarPalestranteAtividade(Integer.parseInt(cod_atividade), Integer.parseInt(cod_palestrante));
				
				Palestrante palestrante = PalestranteBD.consultar(Integer.parseInt(cod_palestrante));
				Participante dadosPalestrante = palestrante.getDadosPalestrante();
				
				Atividade atividade = AtividadeBD.consultaAtividade(Integer.parseInt(cod_atividade));				
				new Enviar( 
							"sistemacontroleeventos@gmail.com",
							dadosPalestrante.getEmail(),
							"Confirma��o de Participa��o da Atividade: "+atividade.getNome(),
							"smtp.gmail.com",
							"465",
							"sistemacontroleeventos@gmail.com",
							"sce_2014",
							"Voc� foi confirmado como palestrante nesta atividade.\n Nome: "+atividade.getNome()
							+ "\n Data:"+atividade.getDataAtividade()
							+"\n Hora: "+atividade.getHora()
						  );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute("resposta","Ocorreu um erro ao registrar essa associa��o.");	
//				response.sendRedirect("eventos.jsp");
			}
		session.setAttribute("resposta","Associa��o registrada com sucesso.");	
//		response.sendRedirect("eventos.jsp");
		}
	}
}
