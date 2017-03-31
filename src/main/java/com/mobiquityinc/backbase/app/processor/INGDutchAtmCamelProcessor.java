package com.mobiquityinc.backbase.app.processor;

import com.mobiquityinc.backbase.app.util.JsonUtils;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

import static com.mobiquityinc.backbase.app.constants.AppConstants.ATMS;

@Service("ingDutchAtmCamelProcessor")
public class INGDutchAtmCamelProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String jsonString = exchange.getIn().getBody(String.class);
        exchange.setProperty(ATMS, JsonUtils.mapToIngDutchAtmResponseList(jsonString));
    }
}
