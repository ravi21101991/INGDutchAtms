package com.mobiquityinc.backbase.app.configuration;

import com.mobiquityinc.backbase.app.processor.INGDutchAtmCamelProcessor;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.mobiquityinc.backbase.app.constants.HttpConstants.CONTENT_TYPE;
import static com.mobiquityinc.backbase.app.constants.HttpConstants.CONTENT_TYPE_TEXT_HTML;

@Configuration
public class AppCamelConfiguration {

    @Autowired
    private INGDutchAtmCamelProcessor ingDutchAtmCamelProcessor;

    @Bean
    public CamelContext camelContext() throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(getAllINGDutchATMRoute());
        camelContext.start();
        return camelContext;
    }

    @Bean
    public RouteBuilder getAllINGDutchATMRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("servlet:/all")
                        .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                        .to("https://www.ing.nl/api/locator/atms/?bridgeEndpoint=true")
                        .unmarshal()
                        .gzip()
                        .process(ingDutchAtmCamelProcessor)
                        .to("velocity:templates/ATMTemplate.vm")
                        .setHeader(CONTENT_TYPE, constant(CONTENT_TYPE_TEXT_HTML))
                        .marshal()
                        .gzip();
            }
        };
    }
}