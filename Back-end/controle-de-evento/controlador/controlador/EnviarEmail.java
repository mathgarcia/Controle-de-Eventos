package controlador;



import java.util.Properties;

import javax.mail.PasswordAuthentication;



import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EnviarEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
    public EnviarEmail() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int cod = Integer.parseInt(request.getParameter("cod_atividade"));
		String codigo = request.getParameter("codigo");
		String mensagem = request.getParameter("mensagem");
		String assunto = request.getParameter("assunto");

		ParticipanteBD pbd;
		Participante p=pbd.consultar(codigo);
		
		String sen;
		
		////////////////////////////
		Properties pro1 = new Properties();
        pro1.put("mail.smtp.host", "smtp.gmail.com");
        pro1.put("mail.smtp.socketFactory.port", "465");
        pro1.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pro1.put("mail.smtp.auth", "true");
        pro1.put("mail.smtp.port", "465");
        
        
        
        
        
        Session session = Session.getDefaultInstance(pro1, 
        new javax.mail.Authenticator() {
             protected PasswordAuthentication getPasswordAuthentication() 
             {
                   return new PasswordAuthentication("sistemacontroleeventos@gmail.com", sen);
             }
        });

        /** Ativa Debug para sessão */
        session.setDebug(true);

        try {

           Message menssagem = new MimeMessage(session);
           menssagem.setFrom(new InternetAddress("sistemacontroleeventos@gmail.com")); //Remetente

           Address[] toUser = InternetAddress.parse(p.getEmail()); //Destinatário(s)
               

            menssagem.setRecipients(Message.RecipientType.TO, toUser);
            menssagem.setSubject(assunto);//Assunto
            menssagem.setText(mensagem);
  
             Transport.send(menssagem);//Envioar email

            //System.out.println("Feito!!!");
            
            HttpSession sessao = request.getSession();
			sessao.setAttribute("mensagem", "Mansagem enviada");
			response.sendRedirect("ADeterminar.jsp");

           } 
        catch (MessagingException e) {
               throw new RuntimeException(e);
               
            HttpSession sessao = request.getSession();
   			sessao.setAttribute("mensagem", "Erro");
   			response.sendRedirect("ADeterminar.jsp");
         }  
			
		
	}

}
