package com.example.aopwithmailserviceapp.mailService;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Aspect
@Component
public class MailSenderBot {
    MailService mailService;

//9fa5af48946037e925e1a20c951e797d

    @Autowired
    public MailSenderBot(MailService mailService) throws MessagingException {
        this.mailService = mailService;

    }


    public void message(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {

        System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
        proceedingJoinPoint.proceed();
    }


    @After("@annotation(MailAspect)")
    public void sendMail() throws MessagingException {




      mailService.sendMail("michal.szymanowski88@gmail.com","test","mail testowy",true);
        System.out.println("Film został dodany");
    }
}
