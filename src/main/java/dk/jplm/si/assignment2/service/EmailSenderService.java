package dk.jplm.si.assignment2.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {


    private final JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String sendEmail(String toEmail,
                            String subject,
                            String body,
                            String fileToAttach) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("admin@selself.com");
        message.setText(body);
        message.setTo(toEmail);
        message.setSubject(subject);

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
                mimeMessage.setFrom(new InternetAddress("admin@selself.com"));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(body);

                FileSystemResource file = new FileSystemResource(new File(fileToAttach));
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.addAttachment("attachment", file);
            }
        };
        try {
            mailSender.send(message);
            return "Mail sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public void sendSimpleEmail(String toEmail,
                                String subject,
                                String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("admin@selself.com");
        message.setText(body);
        message.setTo(toEmail);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("mail sent successfully");
    }

}

