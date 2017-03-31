package com.mobiquityinc.backbase.app.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquityinc.backbase.app.domain.INGDutchAtm;

import java.util.ArrayList;
import java.util.List;

import static com.mobiquityinc.backbase.app.constants.StringConstants.COMMA;

public class JsonUtils {

    private JsonUtils() {

    }

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<INGDutchAtm> mapToIngDutchAtmResponseList(String jsonString) throws Exception {
        jsonString = jsonString.substring(jsonString.indexOf(COMMA) + 1);
        return mapper.readValue(jsonString, new TypeReference<ArrayList<INGDutchAtm>>() {
        });
    }
}