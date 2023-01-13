package com.example.authapp.rabbitmq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange directExchange;


    public void SendingEmailDTOtoQueue(EmailDTO emailDTO)
    {
        rabbitTemplate.convertAndSend(directExchange.getName(),"mail_binding",emailDTO);
    }
}
