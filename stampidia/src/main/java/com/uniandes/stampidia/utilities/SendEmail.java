package com.uniandes.stampidia.utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void send() {
		final String username = "stampidia@gmail.com";
		final String password = "miso4204";
		final String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.password", password);

		Session session = Session.getInstance(props, new GMailAuthenticator(username, password));
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tachu.salamanca@gmail.com"));
			message.setSubject("Stampidia Sharer");
			message.setText("Thank you for sharing our products! Keep shopping...");

	        Transport transport = session.getTransport("smtp");
	        transport.connect(host, username, password);
	        message.saveChanges();
	        Transport.send(message);
	        transport.close();

			System.out.println("Email enviado al comprador");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
