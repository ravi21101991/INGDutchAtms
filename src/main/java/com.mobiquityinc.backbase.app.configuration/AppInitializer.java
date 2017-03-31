package com.mobiquityinc.backbase.app.configuration;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import static com.mobiquityinc.backbase.app.constants.PathConstants.CAMEL_SERVLET_MAPPING;
import static com.mobiquityinc.backbase.app.constants.PathConstants.ROOT;

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext context) throws ServletException {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppConfiguration.class);
        applicationContext.setServletContext(context);

        ServletRegistration.Dynamic servlet = context.addServlet("dispatcher",
                new DispatcherServlet(applicationContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping(ROOT);

        ServletRegistration.Dynamic camelServlet = context.addServlet("CamelServlet", new CamelHttpTransportServlet());
        camelServlet.addMapping(CAMEL_SERVLET_MAPPING);
        camelServlet.setLoadOnStartup(1);
    }
}