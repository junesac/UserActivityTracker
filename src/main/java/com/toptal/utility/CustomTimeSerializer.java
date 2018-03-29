package com.toptal.utility;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.toptal.constants.UserActivityTrackerConstants;

public class CustomTimeSerializer extends JsonSerializer<String> {

	@Override
	public void serialize(String value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {

		StringBuilder sb = new StringBuilder();
		int length = value.length();
		while (length != 4) {
			length++;
			sb.append("0");
		}
		sb.append(value);
		SimpleDateFormat time = new SimpleDateFormat(UserActivityTrackerConstants.TIME_FORMAT);
		try {
			Date dt = time.parse(sb.toString());
			gen.writeString(new SimpleDateFormat(UserActivityTrackerConstants.TIME_FORMAT_SERILAIZE).format(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
