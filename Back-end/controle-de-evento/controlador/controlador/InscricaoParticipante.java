package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Data;

import dao.EnderecoBD;
import dao.GrauInstrucaoBD;
import dao.ParticipanteBD;
import dao.PerfilBD;
import pojo.Endereco;
import pojo.Participante;
import pojo.Perfil;

@WebServlet("/InscricaoParticipante")
public class InscricaoParticipante extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public InscricaoParticipante() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cpf = request.getParameter("cpf");
		String nomeCompleto = request.getParameter("nomeCompleto");
		String nomeSocial = request.getParameter("nomeSocial");
		Calendar dataNascimento = null;
		try {
			dataNascimento = verificaDataNasc(request.getParameter("dataNascimento"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		char sexo = request.getParameter("sexo").charAt(0);
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String cep = request.getParameter("cep");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		int grauInstrucao = Integer.parseInt(request.getParameter("grauInstrucao"));
		
		Endereco endereco = null;
		if(numero > 0)
		{
			endereco = new Endereco(0, logradouro, numero, cep, bairro, cidade, estado);
			try {
				EnderecoBD.adicionar(endereco);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Perfil perfil = new Perfil(0, "participante");
		try {
			PerfilBD.adicionar(perfil);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//GrauInstrucao grauInstrucao = new GrauInstrucao(null, grauInstrucao);
		//grauInstrucao = GrauInstrucaoBD.adicionar(grauInstrucao);
		
		int indicador = 0;
		String mensagem = null;
		
		if(!verificaCpf(cpf))
		{
			indicador = 1;
			mensagem = mensagem + "Número de CPF inválido.\n";
		}
		
		if(!verificaNomeCompleto(nomeCompleto))
		{
			indicador = 1;
			mensagem = mensagem + "Quantidade de caracteres do Nome Completo está acima do permitido.";
		}
		
		if(!verificaNomeSocial(nomeSocial))
		{
			indicador = 1;
			mensagem = mensagem + "Quantidade de caracteres do Nome Social está acima do permitido.";
		}
		
		if(dataNascimento == null)
		{
			indicador = 1;
			mensagem = mensagem + "Data de Nascimento inválida.\n";
		}
		
		if(!verificaTelefone(telefone))
		{
			indicador = 1;
			mensagem = mensagem + "Quantidade de caracteres do telefone está acima do permitido.";
		}
		
		if(!verificaCelular(celular))
		{
			indicador = 1;
			mensagem = mensagem + "Quantidade de caracteres do celular está acima do permitido.";
		}
		
		if(numero<=0)
		{
			indicador = 1;
			mensagem = mensagem + "Número do endereço inválido.";
		}
			
		if(!verificaCep(cep))
		{
			indicador = 1;
			mensagem = mensagem + "Quantidade de caracteres do cep está acima do permitido.";
		}
		
		if(indicador==0)
		{
			Participante participante = null;
			try {
				participante = new Participante(0, nomeCompleto, nomeSocial, (java.sql.Date) dataNascimento.getTime(), sexo, email, telefone, celular, endereco, senha, cpf, perfil, GrauInstrucaoBD.consultar(grauInstrucao));
				ParticipanteBD.adicionar(participante);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("mensagem", "Seja Bem Vindo "+nomeSocial+"!!!");
			sessao.setAttribute("idLog", "");
			response.sendRedirect("painelParticipante.jsp");
			
		}
		else
		{
			HttpSession sessao = request.getSession();
			sessao.setAttribute("mensagem", mensagem);
			response.sendRedirect("cadastroParticipante.jsp");
		}
		
	}
	
	public boolean verificaNomeCompleto(String nomeCompleto) 

	{
		char[] vetorNomeCompleto = nomeCompleto.toCharArray();
		
		if(vetorNomeCompleto.length<=20)
		{
			return true;
		}
				
		return false;
	}

	public boolean verificaCpf(String cpf)
	{
		int i, j=10, soma=0;
		int resto, dig1, dig2;
		
		char vetorCpf[] = cpf.toCharArray();
		
		//Verificando o primeiro dígito verificador.
		
		for(i=0; i<9; i++)
		{
			soma = soma + (Character.getNumericValue(vetorCpf[i])*j);
			j--;
		}
		
		resto = soma%11;
		
		if(resto<2)
		{
			dig1 = 0;
		}
		else
		{
			dig1 = 11 - resto;
		}
		
		//Verificando o segundo dígito verificador.
		
		j=11;
		soma = 0;
		
		for(i=0; i<9; i++)
		{
			soma = soma + (Character.getNumericValue(vetorCpf[i])*j);
			j--;
		}
		
		soma = soma + dig1*j;
		
		resto = soma%11;
		
		if(resto<2)
		{
			dig2 = 0;
		}
		else
		{
			dig2 = 11 - resto;
		}
		
		//Fazendo a comparação entre os dois CPFs.
		
		String gerado=null;
		
		for(i=0; i<9; i++)
		{
			gerado = gerado + vetorCpf[i];
		}
		
		gerado = gerado + dig1 + dig2;
		
		if(gerado.equalsIgnoreCase(cpf))
		{
			return true;
		}
		
		return false;
	}

	
	public Calendar verificaDataNasc(String dataNasc) throws ParseException
	{
		Calendar dataNascimento = Calendar.getInstance();
		Calendar atual = Calendar.getInstance();
		
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		dataNascimento.setTime(formato.parse(dataNasc));
		
		if(dataNascimento.get(Calendar.YEAR)<atual.get(Calendar.YEAR))
		{
			if((dataNascimento.get(Calendar.MONTH)>=1)&&(dataNascimento.get(Calendar.MONTH)<=12))
			{
				if(dataNascimento.get(Calendar.MONTH)==2)
				{
					if((dataNascimento.get(Calendar.YEAR)%4)==0)
					{
						if((dataNascimento.get(Calendar.DAY_OF_MONTH)>=1)&&(dataNascimento.get(Calendar.DAY_OF_MONTH)<=29))
						{
							return dataNascimento;
						}
					}
					else
					{
						if((dataNascimento.get(Calendar.DAY_OF_MONTH)>=1)&&(dataNascimento.get(Calendar.DAY_OF_MONTH)<=28))
						{
							return dataNascimento;
						}
					}
				}
				
				if((dataNascimento.get(Calendar.MONTH)==1)||(dataNascimento.get(Calendar.MONTH)==3)||(dataNascimento.get(Calendar.MONTH)==5)||(dataNascimento.get(Calendar.MONTH)==7)||(dataNascimento.get(Calendar.MONTH)==8)||(dataNascimento.get(Calendar.MONTH)==10)||(dataNascimento.get(Calendar.MONTH)==12))
				{
					if((dataNascimento.get(Calendar.DAY_OF_MONTH)>=1)&&(dataNascimento.get(Calendar.DAY_OF_MONTH)<=31))
					{
						return dataNascimento;
					}
				}
				
				if((dataNascimento.get(Calendar.MONTH)==4)||(dataNascimento.get(Calendar.MONTH)==6)||(dataNascimento.get(Calendar.MONTH)==9)||(dataNascimento.get(Calendar.MONTH)==11))
				{
					if((dataNascimento.get(Calendar.DAY_OF_MONTH)>=1)&&(dataNascimento.get(Calendar.DAY_OF_MONTH)<=30))
					{
						return dataNascimento;
					}					
				}
			}
			
			return null;
		}
		
		
		return null;
		
	}


	public boolean verificaNomeSocial(String nomeSocial)
	{
		char[] vetorNomeSocial = nomeSocial.toCharArray();
		
		if(vetorNomeSocial.length<=20)
		{
			return true;
		}
		
		return false;	
	}

	public boolean verificaTelefone(String telefone)
	{
		char[] vetorTelefone = telefone.toCharArray();
	
		if(vetorTelefone.length<=12)
		{
			return true;
		}
	
		return false;		
	}
	
	public boolean verificaCelular(String celular)
	{
		char[] vetorCelular = celular.toCharArray();
		
		if(vetorCelular.length<=13)
		{
			return true;
		}
		
		return false;		
	}
	
	public boolean verificaCep(String cep)
	{
		char[] vetorCep = cep.toCharArray();
		
		if(vetorCep.length<=9)
		{
			return true;
		}
		
		return false;		
	}

}
