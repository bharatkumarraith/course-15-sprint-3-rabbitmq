package com.example.sendmail.Service;

import com.example.sendmail.model.EmailData;

public interface SendMailService {
    public abstract boolean SendDetails(EmailData emailData);
}
