package com.example.sendmail.Service;

import com.example.sendmail.Repository.SendMailRepository;
import com.example.sendmail.model.EmailData;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {
    @Autowired
    private SendMailRepository sendMailRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public boolean SendDetails(EmailData emailData) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("bharatkumarraithi5@gmail.com");
        mailMessage.setTo(emailData.getEmailId());
        mailMessage.setSubject(emailData.getSubject());
        mailMessage.setText(emailData.getMessage());
      javaMailSender.send(mailMessage);
        sendMailRepository.save(emailData);
        System.out.println(emailData);
        return true;
    }
}
