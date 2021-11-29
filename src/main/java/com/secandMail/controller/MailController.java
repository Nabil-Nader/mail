/*

package com.secandMail.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Configuration
public class MailController implements CommandLineRunner {

    @Autowired
    private JavaMailSender javaMailSender ;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Sending mail....");
//        sendEmail();
        sendEmailWithAttachment();
        System.out.println("Donde");
    }

    private void sendEmailWithAttachment() throws MessagingException {

        MimeMessage mimeMsg = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMsg,true);

        mimeMessageHelper.setTo("nabil.nader00@gmail.com");
        mimeMessageHelper.setSubject("Luffy");
        mimeMessageHelper.setText("Take a look at Luffy");
        mimeMessageHelper.addAttachment("king of pirates.jpg",new ClassPathResource("image.jpg"));

        javaMailSender.send(mimeMsg);

    }

    private void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("nabil.x.nader94@gmail.com");

        msg.setSubject("Email sent By spring boot");
        msg.setText("Hello!\n\n it is me");
        javaMailSender.send(msg);

    }


}


*/
