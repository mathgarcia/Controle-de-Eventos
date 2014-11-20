package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Perfil;
import dao.AdministradorBD;
import dao.PerfilBD;


public class AtribuirPapel extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
    public AtribuirPapel() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String codigoA = request.getParameter("CodigoAdminitrador");
        String codigoU = request.getParameter("CodigoUsuario");
        String nome = request.getParameter("nome");
        Perfil p = PerfilBD.consultar(Integer.parseInt(codigoA));        
        Perfil p2 = new Perfil(codU,nome)
		if (p.getDescricao.compareTo("Administrado")==0 ){					
			PefilBD pbd = new PefilBD();		
			try{
			pbd.Adicionar(p2);
			}
			catch(SQLException e){
				System.out.print("Erro sql");
			}
		}
		else{
			HttpSession sessao = request.getSession();
			sessao.setAttribute("mensagem", "Atribuição de papel realizada!");
			response.sendRedirect("Adeterminar.jsp");			
		}
	}

}
