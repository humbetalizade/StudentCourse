package org.book.studentcourse.service;

import org.book.studentcourse.dto.request.EmailRequestDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
        private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailRequestDto dto){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getTo());
        message.setFrom(dto.getFrom());
        message.setSubject(dto.getSubject());
        message.setText(dto.getText());

        mailSender.send(message);
    }
}
