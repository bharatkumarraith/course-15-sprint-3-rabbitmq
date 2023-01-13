package com.example.sendmail.rabitmq;

import com.example.sendmail.Service.SendMailService;
import com.example.sendmail.model.EmailData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {
    @Autowired
    private SendMailService sendMailService;
    @RabbitListener(queues = "mail_queue")
    public void getEmailDtoFromQueue(EmailDTO emailDTO)
    {
        EmailData emailData=new EmailData(emailDTO.getReceiverMail(),emailDTO.getMessage(),emailDTO.getBody(),null);
        System.out.println(sendMailService.SendDetails(emailData));
    }
}
