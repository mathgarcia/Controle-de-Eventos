package controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Data;

import dao.GestorBD;
import pojo.Atividade;

/**
 * Servlet implementation class CadastrarAtividade
 */
public class CadastrarAtividade extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarAtividade() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		
		 String nome = request.getParameter("nome");
		 String local = request.getParameter("local");
		 String resumo = request.getParameter("resumo");
		 String data = request.getParameter("data");
		 String hora = request.getParameter("hora");
		// String descricao = request.getParameter(descricao);
		 int duracao = Integer.parseInt(request.getParameter("duracao"));
		 int cod_evento = Integer.parseInt(request.getParameter("cod_evento"));
		 int cod_tipo = Integer.parseInt(request.getParameter("cod_tipo"));
		 
			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy"); 
			Date dt =null;
			try {
				dt = (Date) format1.parse(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 Time hr = Time.valueOf(hora);
		
			String mensagem = null;
			if(!verificaNome(nome)){
				mensagem = "Número de caracteres acima do permitido";
			}
			else if(!verificaLocal(local)){
					mensagem = "Número de caracteres acima do permitido";
				}
				else if(!verificaResumo(resumo)){
					mensagem = "Número de caracteres acima do permitido";
				}
//					else if(!verificaData(data)){
//						mensagem = "Data inválida";
//					}


			
			
			Atividade atividade = new Atividade (Integer.parseInt(null),nome,local,resumo, dt, hr,duracao,Boolean.parseBoolean(null), cod_evento, cod_tipo);
	
			try {
				GestorBD.cadastrarAtividade(atividade);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			sessao.setAttribute("mensagem", "Cadastro de atividade realizado!");
			response.sendRedirect("evento.jsp");
	}

			public boolean verificaNome(String nome){
				char[] arrayNome = nome.toCharArray();
				
				if(arrayNome.length<45){
					return true;
				}
				return false;
			}
			public boolean verificaLocal(String local){
			char[] arrayLocal = local.toCharArray();
							
							if(arrayLocal.length<25){
								return true;
							}
							return false;
							
			}
			public boolean verificaResumo(String resumo){
				char[] arrayResumo = resumo.toCharArray();
				
				if(arrayResumo.length<100){
					return true;
				}
				return false;
			}
//			public boolean verificaData(String data){
//				
//				Calendar dataAt = Calendar.getInstance();
//				Calendar atual = Calendar.getInstance();
//
//				
//				SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy"); 
//				try {
//					dataAt.setTime(format1.parse(data));
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//
//				
//
//				if(dataAt.get(Calendar.YEAR)<atual.get(Calendar.YEAR))
//				{
//					if((dataAt.get(Calendar.MONTH)>=1)&&(dataAt.get(Calendar.MONTH)<=12))
//					{
//						if(dataAt.get(Calendar.MONTH)==2)
//						{
//							if((dataAt.get(Calendar.YEAR)%4)==0)
//							{
//								if((dataAt.get(Calendar.DAY_OF_MONTH)>=1)&&(dataAt.get(Calendar.DAY_OF_MONTH)<=29))
//								{
//									return true;
//								}
//							}
//							else
//							{
//								if((dataAt.get(Calendar.DAY_OF_MONTH)>=1)&&(dataAt.get(Calendar.DAY_OF_MONTH)<=28))
//								{
//									return true;
//								}
//							}
//						}
//						
//						if((dataAt.get(Calendar.MONTH)==1)||(dataAt.get(Calendar.MONTH)==3)||(dataAt.get(Calendar.MONTH)==5)||(dataAt.get(Calendar.MONTH)==7)||(dataAt.get(Calendar.MONTH)==8)||(dataAt.get(Calendar.MONTH)==10)||(dataAt.get(Calendar.MONTH)==12))
//						{
//							if((dataAt.get(Calendar.DAY_OF_MONTH)>=1)&&(dataAt.get(Calendar.DAY_OF_MONTH)<=31))
//							{
//								return true;
//							}
//						}
//						
//						if((dataAt.get(Calendar.MONTH)==4)||(dataAt.get(Calendar.MONTH)==6)||(dataAt.get(Calendar.MONTH)==9)||(dataAt.get(Calendar.MONTH)==11))
//						{
//							if((dataAt.get(Calendar.DAY_OF_MONTH)>=1)&&(dataAt.get(Calendar.DAY_OF_MONTH)<=30))
//							{
//								return true;
//							}					
//						}
//					}
//					
//					return false;
//				}
//				
//				
//				return false;
//			}

}
