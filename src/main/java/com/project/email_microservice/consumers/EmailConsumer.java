package com.project.email_microservice.consumers;

import com.project.email_microservice.core.dtos.EmailDto;
import com.project.email_microservice.core.models.EmailModel;
import com.project.email_microservice.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer
{
    private final EmailService emailService;

    public EmailConsumer(EmailService emailService){
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDto emailDto){
        System.out.println(emailDto.toString());

        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);


        emailService.sendEmail(emailModel);
    }

}
