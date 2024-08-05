package org.book.studentcourse.controller;


import org.book.studentcourse.dto.request.EmailRequestDto;
import org.book.studentcourse.service.EmailService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }


    @RequestMapping("/send/simple")
    public void sendEmail(@RequestBody EmailRequestDto email){
        emailService.sendEmail(email);
    }
}
