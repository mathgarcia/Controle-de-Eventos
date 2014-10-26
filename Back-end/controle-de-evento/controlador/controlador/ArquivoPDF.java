

package login;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.util.Date;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ArquivoPDF)
public class ArquivosPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArquivosPDF() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String texto = (String) request.getParameter("texto");
		
		
		
		
		
			FileOutputStream o = null;
			Document doc= null;
		
		try{
			

		
		
		
		doc = new Document (PageSize.A4, 72, 72, 72, 72);// cria um documento com as margens indicadas no parametro 
		o=new FileOutputStream("ola8.pdf");//Criar sream de saida
			
		PdfWriter.getInstance(doc, o);//associa ao sream de saida
		
		doc.open(); //Abre ducumento
		Paragraph p = new Paragraph(texto);//Adiciona paragrafo
	    
	    
	    
		doc.add(p);
		
		//o.close();
		//System.out.println("3");
		//doc.close();
		//System.out.println("4");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{	
			if (doc != null)
			{
				doc.close();
				
			}
			if(o != null)
			{
				try{
				o.close();
				}
				catch (Exception e)
				{
					System.out.println("Erro fechamento");
				}
				System.out.println("Procedimento feito");
			}
		}
				
		
		HttpSession session = request.getSession();
		session.setAttribute("login", login);
		session.setAttribute("senha", senha);
		response.sendRedirect("paginas/pagina1.jsp");
		
	}

}
