package com.toptal.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.toptal.utility.CustomDateDeSerializer;
import com.toptal.utility.CustomDateSerializer;
import com.toptal.utility.CustomTimeDeSerializer;
import com.toptal.utility.CustomTimeSerializer;

public class Filter {

	private Date fromDate;
	private Date toDate;
	private String fromTime;
	private String toTime;

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getFromDate() {
		return fromDate;
	}

	@JsonDeserialize(using = CustomDateDeSerializer.class)
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getToDate() {
		return toDate;
	}

	@JsonDeserialize(using = CustomDateDeSerializer.class)
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@JsonSerialize(using = CustomTimeSerializer.class)
	public String getFromTime() {
		return fromTime;
	}

	@JsonDeserialize(using = CustomTimeDeSerializer.class)
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	@JsonSerialize(using = CustomTimeSerializer.class)
	public String getToTime() {
		return toTime;
	}

	@JsonDeserialize(using = CustomTimeDeSerializer.class)
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	@Override
	public String toString() {
		return "Filter [fromDate=" + fromDate + ", toDate=" + toDate + ", fromTime=" + fromTime + ", toTime=" + toTime
				+ "]";
	}

}
