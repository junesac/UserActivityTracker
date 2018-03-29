package com.toptal.dao;

import java.util.List;

import com.toptal.model.Filter;
import com.toptal.model.UserActivity;

public interface UserActivityDao {

	List<UserActivity> getUserActivities(Filter filter);

	UserActivity createUserActivity(UserActivity userActivity);

	UserActivity getUserActivitiesByUserId(Long userId);

	UserActivity updateUserActivity(UserActivity userActivity, Long userId);

	void deleteUserActivity(Long id);
}
