package com.rw.oru.component;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
       Locale locale = Locale.getDefault();
       String str = httpServletRequest.getParameter("locale");//在html页面中中英文设置的键值对，通过key获取请求区域的信息
        if(!StringUtils.isEmpty(str)){

            String[] splits = str.split("_");
            locale = new Locale(splits[0],splits[1]);

        }


        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
