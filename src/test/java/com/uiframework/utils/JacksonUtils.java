package com.uiframework.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uiframework.objects.BillingAddress;

public class JacksonUtils {

    public static BillingAddress deserializeJson(String filePath, BillingAddress billingAddress) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper (  );
        return objectMapper.readValue ( filePath,billingAddress.getClass () );
    }

}


