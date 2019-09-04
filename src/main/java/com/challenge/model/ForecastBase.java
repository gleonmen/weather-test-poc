package com.challenge.model;

import com.challenge.commons.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
