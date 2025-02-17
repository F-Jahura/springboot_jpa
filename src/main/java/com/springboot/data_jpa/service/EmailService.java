package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
    public void sendSimpleMailGet();
}
