package com.secandMail.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component

public class BookHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private JavaMailSender javaMailSender ;

    private static final SimpleDateFormat dateFormate = new SimpleDateFormat("DD/MM/yyyy HH:mm:ss");


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getParameter("bookId") != null){
            System.out.println("preHandler() method sending book access mail ..");

            sendEmail(request.getParameter("bookId"),"Book accessed");

            System.out.println("Done");
        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        if(request.getParameter("bookId") != null){
            System.out.println("PostHandler() method sending book access mail ..");

            sendEmail(request.getParameter("bookId"),"Book access complete");

            System.out.println("Done");
        }



    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (request.getParameter("bookId") != null) {
            System.out.println(" sending book Request and Response Completion mail ..");

            sendEmail(request.getParameter("bookId"), "Request and Response complete");

            System.out.println("Done");
        }
    }
    private void sendEmail(String bookId , String mesgText) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("nabil.nader00@gmail.com");

        msg.setSubject("Book related Activity for book :"+bookId);
        msg.setText(mesgText +" : " +dateFormate.format(new Date()));
        javaMailSender.send(msg);

    }


}
