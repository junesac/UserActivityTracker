package com.toptal.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.toptal.constants.UserActivityTrackerConstants;

public class UserActivityTrackerHelper {

	protected String getDateToDBFormat(Date date) {
		return "TO_TIMESTAMP('" + new SimpleDateFormat(UserActivityTrackerConstants.DATE_FORMAT).format(date)
				+ "', 'yyyy-mm-dd hh24:mi:ss')";
	}

}
