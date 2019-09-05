package com.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public abstract class ForecastBase {

    public ForecastBase() {
    }

    //@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    //private LocalDateTime time;
    private long time;
    private String summary;
    private String icon;
}
