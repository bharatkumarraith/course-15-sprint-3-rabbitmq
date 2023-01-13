package com.example.sendmail.Repository;

import com.example.sendmail.model.EmailData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendMailRepository extends JpaRepository<EmailData,String> {
}
