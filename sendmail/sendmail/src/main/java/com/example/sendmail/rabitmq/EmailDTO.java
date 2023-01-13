package com.example.sendmail.rabitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    private String receiverMail;
    private String message;
    private String body;
    private String attachments;
}
