package com.ecommit.orquestrador.rest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public final class JsonResponseUtils {

    public static Map<?, ?> toMap(ResponseEntity<String> response, String key) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        final HashMap<?, ?> jsonToHashMap = objectMapper.readValue(response.getBody(), HashMap.class);
        return (Map<?, ?>) jsonToHashMap.get(key);
    }
}
