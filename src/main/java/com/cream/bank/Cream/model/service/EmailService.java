package com.cream.bank.Cream.model.service;

import org.springframework.stereotype.Service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@Service
public class EmailService {

    public void enviarEmail(String assunto, String mensagem, String emailRemetente){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // TLS

        // Autenticação
        String username = "creambanknotifica@gmail.com"; // seu email
        String password = "swlz dizq boce jerj"; // sua senha

        // Obter a sessão do correio
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Criar uma mensagem de email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailRemetente));
            //message.setFrom(new InternetAddress("gustavobomfim432@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailRemetente));
            message.setSubject(assunto);
            message.setText(mensagem);

            // Enviar mensagem
            Transport.send(message);

            System.out.println("E-mail enviado com sucesso!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
