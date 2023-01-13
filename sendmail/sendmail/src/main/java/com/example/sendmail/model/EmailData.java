package com.example.sendmail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmailData {
    @Id
    private String emailId;
    private String message;
    private String subject;
    private String attachments;
}
