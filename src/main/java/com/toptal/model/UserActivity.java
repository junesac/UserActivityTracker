package com.toptal.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.toptal.utility.CustomDateDeSerializer;
import com.toptal.utility.CustomDateSerializer;
import com.toptal.utility.CustomTimeDeSerializer;
import com.toptal.utility.CustomTimeSerializer;

public class UserActivity {

	private Long uaId;
	private String uaName;
	private Long calories;
	private Date startDate;
	private Long userId;
	private String time;

	@JsonSerialize(using = CustomTimeSerializer.class)
	public String getTime() {
		return time;
	}

	@JsonDeserialize(using = CustomTimeDeSerializer.class)
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "UserActivity [uaId=" + uaId + ", uaName=" + uaName + ", calories=" + calories + ", startDate="
				+ startDate + ", userId=" + userId + ", time=" + time + "]";
	}

	public Long getUaId() {
		return uaId;
	}

	public void setUaId(Long uaId) {
		this.uaId = uaId;
	}

	public String getUaName() {
		return uaName;
	}

	public void setUaName(String uaName) {
		this.uaName = uaName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCalories() {
		return calories;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getStartDate() {
		return startDate;
	}

	@JsonDeserialize(using = CustomDateDeSerializer.class)
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
