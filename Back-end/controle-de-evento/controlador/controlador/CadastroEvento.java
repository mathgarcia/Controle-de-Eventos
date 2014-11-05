package controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestorBD;
import pojo.Atividade;
import pojo.Evento;

/**
 * Servlet implementation class CadastroEvento
 */
public class CadastroEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroEvento() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
		
		String mensagem = null;
		if(!verificaNome(nome)){
			mensagem = "Número de caracteres acima do permitido";
		}
		else if(!verificaDescricao(descricao)){
				mensagem = "Número de caracteres acima do permitido";
			}
			else if(!verificaData(data_inicio)){
				mensagem = "Número de caracteres acima do permitido";
			}
				else if(!verificaData(data_fim)){
					mensagem = "Data inválida";
				}
					else if(!verificaLocal(local)){
						mensagem = "Hora inválida";
					}
		
		Evento evento = new Evento (Integer.parseInt(null), nome, descricao,dt_inicio,dt_fim,local,Boolean.parseBoolean(null),(ArrayList<Atividade>)null);
		
		try {
			GestorBD.cadastrarEvento(evento);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("mensagem", "Cadastro de evento realizado!");
		response.sendRedirect("evento.jsp");
	}

	public boolean verificaNome(String nome){
		char[] arrayNome = nome.toCharArray();
		
		if(arrayNome.length<45){
			return true;
		}
		return false;
	}
	public boolean verificaDescricao(String descricao){
	char[] arrayDescricao = descricao.toCharArray();
					
					if(arrayDescricao.length<100){
						return true;
					}
					return false;
					
	}
	public boolean verificaData(String data){
		
		Calendar dataAt = Calendar.getInstance();
		Calendar atual = Calendar.getInstance();

		
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy"); 
		try {
			dataAt.setTime(format1.parse(data));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

		if(dataAt.get(Calendar.YEAR)<atual.get(Calendar.YEAR))
		{
			if((dataAt.get(Calendar.MONTH)>=1)&&(dataAt.get(Calendar.MONTH)<=12))
			{
				if(dataAt.get(Calendar.MONTH)==2)
				{
					if((dataAt.get(Calendar.YEAR)%4)==0)
					{
						if((dataAt.get(Calendar.DAY_OF_MONTH)>=1)&&(dataAt.get(Calendar.DAY_OF_MONTH)<=29))
						{
							return true;
						}
					}
					else
					{
						if((dataAt.get(Calendar.DAY_OF_MONTH)>=1)&&(dataAt.get(Calendar.DAY_OF_MONTH)<=28))
						{
							return true;
						}
					}
				}
				
				if((dataAt.get(Calendar.MONTH)==1)||(dataAt.get(Calendar.MONTH)==3)||(dataAt.get(Calendar.MONTH)==5)||(dataAt.get(Calendar.MONTH)==7)||(dataAt.get(Calendar.MONTH)==8)||(dataAt.get(Calendar.MONTH)==10)||(dataAt.get(Calendar.MONTH)==12))
				{
					if((dataAt.get(Calendar.DAY_OF_MONTH)>=1)&&(dataAt.get(Calendar.DAY_OF_MONTH)<=31))
					{
						return true;
					}
				}
				
				if((dataAt.get(Calendar.MONTH)==4)||(dataAt.get(Calendar.MONTH)==6)||(dataAt.get(Calendar.MONTH)==9)||(dataAt.get(Calendar.MONTH)==11))
				{
					if((dataAt.get(Calendar.DAY_OF_MONTH)>=1)&&(dataAt.get(Calendar.DAY_OF_MONTH)<=30))
					{
						return true;
					}					
				}
			}
			
			return false;
		}
		
		
		return false;
	}
	
	public boolean verificaLocal(String local){
	char[] arrayLocal = local.toCharArray();
					
					if(arrayLocal.length<45){
						return true;
					}
					return false;
					
	}	
	
}
