package com.mobiquityinc.backbase.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mobiquityinc.backbase.app")
@Import(value = {AppCamelConfiguration.class})
public class AppConfiguration extends WebMvcConfigurerAdapter {

}