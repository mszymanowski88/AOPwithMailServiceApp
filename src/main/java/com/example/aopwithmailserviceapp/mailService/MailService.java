package com.example.aopwithmailserviceapp.mailService;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Aspect
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }

//    @Around("@annotation(MailAspect)")
//    public void soutt()
//    {
//        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
//
//    }

    //    @After("@annotation(MailAspect) ")
//@After("@annotation(MailAspect)&& target(to) && target(text) && target(ishThmlContex) && target(subject)")


    //    @After("@annotation(MailAspect) ")
    //    @After("@annotation(MailAspect) ")
//@After("@annotation(MailAspect)&& args(to) && args(text) && args(ishThmlContex) && args(subject)")

    public void sendMail(String to, String subject, String text, boolean ishThmlContex ) throws MessagingException
    {
        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy!");
        try
        {

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text, ishThmlContex);
            javaMailSender.send(mimeMessage);


        }catch (MessagingException e)
        {

            e.printStackTrace();
        }


    }
//    @After("@annotation(MailAspect)")
    public void test()
    {
        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");


    }

}
