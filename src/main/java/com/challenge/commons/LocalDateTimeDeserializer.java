package com.challenge.commons;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    public LocalDateTimeDeserializer() {
    }

    @Override
    public LocalDateTime deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException {
        long timeAsLong = arg0.getLongValue();
        LocalDateTime localDateTime =
                LocalDateTime.ofInstant(Instant.ofEpochSecond(timeAsLong), ZoneId.systemDefault());
        return localDateTime;
    }
}
