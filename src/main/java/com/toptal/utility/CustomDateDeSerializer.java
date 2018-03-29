package com.toptal.utility;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.toptal.constants.UserActivityTrackerConstants;

public class CustomDateDeSerializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat(UserActivityTrackerConstants.DATE_FORMAT);
		String date = jsonparser.getText();
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}
}
