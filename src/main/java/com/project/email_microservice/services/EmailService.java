package com.project.email_microservice.services;

import com.project.email_microservice.core.enums.StatusEmail;
import com.project.email_microservice.core.models.EmailModel;
import com.project.email_microservice.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class EmailService
{
    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender){
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel){
        try {
            emailModel.setEmailId(UUID.randomUUID().toString());
            emailModel.setEmailFrom(emailFrom);
            emailModel.setSendDateTimeEmail(OffsetDateTime.now());
            emailModel.setStatusEmail(StatusEmail.SENT);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getEmailSubject());
            message.setText(emailModel.getEmailBody());
            javaMailSender.send(message);

        }
        catch (MailException exception){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
        finally {
            System.out.println(emailModel.getStatusEmail());
            return emailRepository.save(emailModel);
        }
    }
}
