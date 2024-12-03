package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Passport;
import com.springboot.data_jpa.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassportServiceImpl implements PassportService {
    @Autowired
    PassportRepository passportRepository;


    @Override
    public void savePassport(Passport passport) {
        passportRepository.save(passport);
    }
}
