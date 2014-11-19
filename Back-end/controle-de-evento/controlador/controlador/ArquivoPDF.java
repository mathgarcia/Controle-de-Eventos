

package controlador;

import java.awt.print.PageFormat;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.*;
import com.itextpdf.text.pdf.*;

import java.io.*;

import javax.print.attribute.standard.PagesPerMinuteColor;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
	
	Image i2 = Image.getInstance("contorno2.png");
	Image i1 = Image.getInstance("logo.jpg");
	//i1.getInstance(10, 20, a, a);
	
	doc = new Document (PageSize.A4, 72, 72, 72, 72);// cria um documento com as margens indicadas no parametro
	
	o=new FileOutputStream("ola8.pdf");//Criar sream de saida
	PdfPCell pc = new PdfPCell();
	PdfWriter.getInstance(doc, o);//associa ao stream de saida
	doc.open(); 
	//i1.setWidthPercentage(10);
	i1.setAbsolutePosition(55,678);
	i2.setAbsolutePosition(30,0);
	
	
	doc.add(i2);
	doc.add(i1);
	
	//doc.add(pc);
	
	Paragraph p = new Paragraph("\n\n\n\n\n\nComprovante\n\n\n\n"+t);//Adiciona paragrafo
    
    
    
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
		session.setAttribute("mensagem", "Feito");
		//session.setAttribute("senha", senha);
		response.sendRedirect("paginas/pagina1.jsp");
		
	}

}
