package com.toptal.utility;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSeriliaze {

	public static void main(String[] args) throws IOException {

//		UserActivity userActivity = new UserActivity();
//		userActivity.setUaId(1l);
//		userActivity.setCalories(12l);
//		userActivity.setUaName("name");
//		userActivity.setUserId(1L);
//		userActivity.setStartDate(new Date());
//
//		ObjectMapper mapper = new ObjectMapper();
//		String str = mapper.writeValueAsString(userActivity);
//
//		System.out.println(str);
//
//		UserActivity uActivity = mapper.readValue(str, UserActivity.class);
//		System.out.println(uActivity);
//
//		str = mapper.writeValueAsString(uActivity);
//		System.out.println(str);
		
		System.out.println("---------------------");
		
		StringBuilder sb = new StringBuilder();
		if("102".length() == 3) {
			sb.append("0");
		}
		sb.append("102");
		SimpleDateFormat time = new SimpleDateFormat("HHmm");
		try {
			Date dt =  time.parse(sb.toString());
			System.out.println(new SimpleDateFormat("HH:mm").format(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		

	}

}
