package com.example.restservice.util;

import com.example.restservice.domain.SimpleEmail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String serialize(SimpleEmail message) {
        String result = null;

        try {
            result = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }
}
