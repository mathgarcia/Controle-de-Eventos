package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ConsultaParticipante")
public class ConsultaParticipante extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ConsultaParticipante() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String codigo = request.getParameter("codigo");
		
		Participante participante = ParticipanteBD.consultar(Integer.parseInt(codigo));
		
		if(participante!=null)
		{
			String perfil = "Nome Completo: "+participante.getNome()+"\nNome Social: "+participante.getNomeSocial()+"\nCPF: "+participante.getCPF()+
					"\nData de Nascimento: "+participante.getDataNascimento()+"\nSexo: "+participante.getSexo()+"\nE-mail: "+participante.getEmail()+
					"\nTelefone: "+participante.getTelefone()+"\nCelular: "+participante.getCelular()+"\nEndereço: "+participante.getEndereco()+
					"\nPerfil: "+participante.getPerfil()+"\nGrau de Instrucao: "+participante.getGrauInstrucao();
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("perfil", perfil);
			response.sendRedirect("perfil.jsp");
		}
		else
		{
			HttpSession sessao = request.getSession();
			response.sendRedirect("cadastro.jsp");			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
