package com.toptal.utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.toptal.constants.UserActivityTrackerConstants;

public class CustomDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {

		SimpleDateFormat formatter = new SimpleDateFormat(UserActivityTrackerConstants.DATE_FORMAT);
		String formattedDate = formatter.format(value);

		gen.writeString(formattedDate);

	}

}
