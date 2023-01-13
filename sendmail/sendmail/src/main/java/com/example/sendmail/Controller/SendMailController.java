package com.example.sendmail.Controller;

import com.example.sendmail.Service.SendMailService;
import com.example.sendmail.model.EmailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reciever-Mail")
public class SendMailController {
    @Autowired
    private SendMailService sendMailService;

    //http://localhost:9992/reciever-Mail/Sending-Mail
    @PostMapping("/Sending-Mail")
    public ResponseEntity<?> SendingData(@RequestBody EmailData emailData)
    {
        boolean emailData1=sendMailService.SendDetails(emailData);
        System.out.println(emailData1);
        return new ResponseEntity<>("The mail Send Sucessfully", HttpStatus.OK);
    }
}
