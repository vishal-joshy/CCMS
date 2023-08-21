package com.expl.ccms.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {
    private final ObjectMapper objectMapper= new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> data) {

        String dataJson = null;
        try {
            dataJson = objectMapper.writeValueAsString(data);
        } catch (final JsonProcessingException e) {
        }
        return dataJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dataJson) {

        Map<String, Object> data = null;
        try {
            data = objectMapper.readValue(dataJson,
                    new TypeReference<HashMap<String, Object>>() {});
        } catch (final IOException e) {
        }
        return data;
    }
}
