package com.example.aopwithmailserviceapp.apect;

import com.example.aopwithmailserviceapp.serviceformail.MailService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Aspect
@Component
public class MailSenderBot {

   public MailService mailService;


    @Autowired
    public MailSenderBot(MailService mailService) throws MessagingException {
        this.mailService = mailService;

    }

    @After("@annotation(MailAspect)")
    public void sendMail() throws MessagingException {

        mailService.sendMail("jabol01@wp.pl","Dodano film","Nowy film został dodany",true);

    }

}
