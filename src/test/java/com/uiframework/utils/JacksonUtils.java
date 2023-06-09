package com.uiframework.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uiframework.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {

    public static <T> T deserializeJson( String fileName, Class<T> T) throws IOException {
        InputStream filePath = JacksonUtils.class.getClassLoader ().getResourceAsStream ( fileName );
        ObjectMapper objectMapper = new ObjectMapper (  );
        return objectMapper.readValue ( filePath,T );
    }

}


