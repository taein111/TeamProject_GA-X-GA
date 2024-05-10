package com.teamproject.gaxga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    // 단순 문자 메일 보내기
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("[GA X GA] 임시 비밀번호 발송" );
        message.setTo("inseon0806@gmail.com");
        message.setText("임시 비밀번호입니다.");

        mailSender.send(message);
    }
}
