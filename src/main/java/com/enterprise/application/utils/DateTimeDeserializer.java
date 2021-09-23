package com.enterprise.application.utils;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateTimeDeserializer  extends JsonDeserializer<OffsetDateTime> {

	public static final DateTimeFormatter utc8601Format = new DateTimeFormatterBuilder()
			// date/time
			.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
			// offset +00:00:00 or Z
			.optionalStart().appendOffset("+HH:MM:SS", "Z").optionalEnd()
			// create formatter
			.toFormatter();
	
	
	@Override
	public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		try {
			return OffsetDateTime.parse(p.getText(), utc8601Format);
		}catch (DateTimeParseException e) {
			System.err.println(e);
	        return null;
	    }
	}

}
