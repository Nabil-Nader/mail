package com.secandMail.config;

 import com.secandMail.interceptors.BookHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebAppConfig implements WebMvcConfigurer {


    @Autowired
    BookHandlerInterceptor bookHandlerInterceptor ;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(bookHandlerInterceptor);
    }
}
