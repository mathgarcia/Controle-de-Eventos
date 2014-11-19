package email;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Enviar {
	private String remetente;
	private String destinatario;
	private String smtpHost;
	private String porta;
	private String assunto;
	private Properties propriedades;
	private Session sessao;
	private static String usuario;
	private static String senha;

	private static class Autenticacao extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(usuario, senha);
		}
	}

	public Enviar(String remetente, String destinatario, String assunto,
			String smtpHost, String porta, String usuario, String senha, String mensagemEnviar) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.smtpHost = smtpHost;
		this.porta = porta;
		this.usuario = usuario;
		this.senha = senha;
		this.propriedades = System.getProperties();
		this.propriedades.put("mail.smtp.host", this.smtpHost);
		this.propriedades.put("mail.smtp.auth", "true");
		// this.propriedades.put("mail.debug", "true");
		// this.propriedades.put("mail.smtp.debug", "true");
		this.propriedades.put("mail.smtp.port", this.porta);
		this.propriedades.put("mail.smtp.starttls.enable", "true");
		this.propriedades.put("mail.smtp.socketFactory.port", this.porta);
		this.propriedades.put("mail.smtp.socketFactory.fallback", "false");
		this.propriedades.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");

		Authenticator auth = new Autenticacao();
		this.sessao = Session.getDefaultInstance(this.propriedades, auth);

		try {
			Message mensagem = new MimeMessage(this.sessao);
			mensagem.setSubject(this.assunto);
			mensagem.setFrom(new InternetAddress(this.remetente));
			mensagem.addRecipient(Message.RecipientType.TO,
					new InternetAddress(this.destinatario));
			mensagem.setText(mensagemEnviar);
			System.out.println("Enviando mensagem");
			Transport.send(mensagem);
			System.out.println("Mensagem enviada");
		} catch (Exception err) {
			err.printStackTrace();
			System.out.println("Erro ao enviar mensagem");
		}
	}
}
