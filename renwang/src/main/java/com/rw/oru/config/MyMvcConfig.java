package com.rw.oru.config;



import com.rw.oru.component.LoginHandlerInterceptor;
import com.rw.oru.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
//    @Resource
//    LocaleResolver myLocaleResolver;
//    @Autowired
//    HandlerInterceptor handlerInterceptor;

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //添加一个拦截器
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/hello","/asserts/**","/login","/login.html","/user/login","/static/**","/webjars/**");

            }
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //添加视图映射
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
        };
    }
    @Bean
    public LocaleResolver myLocaleResolve(){
       return new MyLocaleResolver();
    }
//    @Bean(name={"myLocaleResolve"})
//    @NonNull
//    public LocaleResolver myLocaleResolve(){
//        return  myLocaleResolver;
//    }
}
