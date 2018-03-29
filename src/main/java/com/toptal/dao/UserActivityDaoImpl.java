package com.toptal.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.toptal.constants.UserActivityTrackerConstants;
import com.toptal.model.Filter;
import com.toptal.model.UserActivity;

@Repository("userActivityDao")
public class UserActivityDaoImpl implements UserActivityDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<UserActivity> getUserActivities(Filter filter) {

		boolean addedWhere = false;

		List<Object> list = new ArrayList<>();

		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append("SELECT * FROM UserActivity1 ");

		if (filter.getFromDate() != null) {
			if (!addedWhere) {
				queryBuilder.append(" where ");
				addedWhere = true;
			}
			queryBuilder.append(" startdate > ? and ");
			list.add(filter.getFromDate());
		}

		if (filter.getToDate() != null) {
			if (!addedWhere) {
				queryBuilder.append(" where ");
				addedWhere = true;
			}
			queryBuilder.append(" startdate < ? and ");
			list.add(filter.getToDate());
		}

		if (filter.getFromTime() != null) {
			if (!addedWhere) {
				queryBuilder.append(" where ");
				addedWhere = true;
			}
			queryBuilder.append(" time > ? and ");
			list.add(filter.getFromTime());
		}

		if (filter.getToTime() != null) {
			if (!addedWhere) {
				queryBuilder.append(" where ");
				addedWhere = true;
			}
			queryBuilder.append(" time < ? and ");
			list.add(filter.getToTime());
		}

		String query = queryBuilder.toString();
		if (addedWhere) {
			query = query.substring(0, query.length() - 4);
		}
		Object arr[] = list.toArray();

		System.out.println("Filter : " + filter);
		System.out.println("query :  " + query);
		Arrays.stream(arr).forEach(System.out::println);

		List<UserActivity> userActivities = jdbcTemplate.query(query, arr,
				new BeanPropertyRowMapper<UserActivity>(UserActivity.class));
		System.out.println(userActivities);

		return userActivities;
	}

	@Override
	public UserActivity createUserActivity(UserActivity userActivity) {
		Long id = jdbcTemplate.queryForObject("select max(uaid) from useractivity1", Long.class);
		if (id == null) {
			id = 1l;
		}

		userActivity.setUaId(id + 1);

		String date = new SimpleDateFormat(UserActivityTrackerConstants.DATE_FORMAT)
				.format(userActivity.getStartDate());

		jdbcTemplate.update(
				"INSERT INTO UserActivity1 (uaid, uaname, calories, startdate, time, userId) VALUES (?, ?, ?, TO_DATE(?, 'yyyy-MM-dd'), ?, ?)",
				userActivity.getUaId(), userActivity.getUaName(), userActivity.getCalories(), date,
				getTime(userActivity.getTime()), userActivity.getUserId());

		System.out.println("Person Added!!");
		return userActivity;
	}

	@Override
	public UserActivity getUserActivitiesByUserId(Long id) {
		UserActivity userActivity = (UserActivity) jdbcTemplate.queryForObject(
				"SELECT * FROM UserActivity1 where uaid = ?", new Object[] { id },
				new BeanPropertyRowMapper<UserActivity>(UserActivity.class));

		return userActivity;
	}

	@Override
	public UserActivity updateUserActivity(UserActivity userActivity, Long id) {
		jdbcTemplate.update(
				"update UserActivity1 set uaname = ? , calories = ? , startdate = ?, time = ? WHERE uaid = ? ",
				userActivity.getUaName(), userActivity.getCalories(), userActivity.getStartDate(),
				getTime(userActivity.getTime()), id);
		return userActivity;
	}

	private int getTime(String time) {
		return Integer.parseInt(time);
	}

	@Override
	public void deleteUserActivity(Long id) {
		jdbcTemplate.update("DELETE from UserActivity1 WHERE uaid = ? ", id);
		System.out.println("Person Deleted!!");
	}

}
