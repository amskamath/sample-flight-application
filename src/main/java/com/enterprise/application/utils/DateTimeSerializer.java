package com.enterprise.application.utils;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateTimeSerializer extends JsonSerializer<OffsetDateTime>{
	
	public static final DateTimeFormatter utc8601Format = new DateTimeFormatterBuilder()
			// date/time
			.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
			// offset +00:00:00 or Z
			.optionalStart().appendOffset("+HH:MM:SS", "Z").optionalEnd()
			// create formatter
			.toFormatter();

	@Override
	public void serialize(OffsetDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		try {
	          String s = value.format(utc8601Format);
	          gen.writeString(s);
	      } catch (DateTimeParseException e) {
	          System.err.println(e);
	          gen.writeString("");
	      }
		
	}

}
