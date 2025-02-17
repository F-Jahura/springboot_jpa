package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    @Override
    public String sendSimpleMail(EmailDetails details) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
            javaMailSender.send(mailMessage);
            return "Email has been sent sucessfully.....";
        }
        catch (Exception e){
            return "Error while sending email.";
        }
    }

    @Override
    public void sendSimpleMailGet(){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo("f_jahura@yahoo.com");
            mailMessage.setText("The data is not correct.");
            mailMessage.setSubject("wrong data");
            javaMailSender.send(mailMessage);
            System.out.println("Email has been sent successfully.....");
        }
        catch (Exception e){
            System.out.println("Error while sending email.");
        }
    }
}
