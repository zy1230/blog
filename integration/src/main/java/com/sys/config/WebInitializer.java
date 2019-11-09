package com.sys.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.*;
import java.util.EnumSet;

public class WebInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException{
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic config = servletContext.addServlet("DispatcherServlet",servlet);
        config.setLoadOnStartup(1);
        config.addMapping("/");
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        FilterRegistration.Dynamic filterRegistration
                =servletContext.addFilter("encodingFilter",encodingFilter);
        filterRegistration.setInitParameter("encoding","UTF-8");
        filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/");

    }
}
