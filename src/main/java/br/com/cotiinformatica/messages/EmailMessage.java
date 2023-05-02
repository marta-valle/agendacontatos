package br.com.cotiinformatica.messages;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class EmailMessage {

	// ATRIBUTOS DO EMAIL QUE SERÁ USADO PARA DISPARAR O EMAIL PARA OS USUARIOS.
	private final String account = "cotiaulajava@outlook.com";
	private final String password = "@Admin123456";
	private final String smtp = "smtp-mail.outlook.com";
	private final Integer port = 587;


	// MÉTODO PARA FAZER O ENVIO DE UMA MENSAGEM POR EMAIL;
	public void sendMessage(final String emailTo, final String subject, final String message) throws Exception {

		// CONFIGURANDO A CONTA QUE IRA FAZER O ENVIO DOS EMAILS
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setUsername(account);
		senderImpl.setPassword(password);
		senderImpl.setHost(smtp);
		senderImpl.setPort(port);

		// ADICIONAR OPUTRAS CONFIFURAÇÕES PARA ENIAR OS EMAILS
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.transport.protocol", "smtp");
		senderImpl.setJavaMailProperties(properties);

		// MONTANDO O CONTEUDO DO EMAIL
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
				helper.setFrom(account);
				helper.setTo(emailTo);
				helper.setSubject(subject);
				helper.setText(message);
			}

		};

		// ENVIANDO EMAIL
		senderImpl.send(preparator);

	}

}
