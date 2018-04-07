package com.toptal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.toptal.dao.UserActivityDao;
import com.toptal.model.Filter;
import com.toptal.model.UserActivity;

@Service("userActivityService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
public class UserActivityService {

	@Autowired
	private UserActivityDao userActivityDao;

	public List<UserActivity> getUserActivities(Long userId, Filter filter) {
		return userActivityDao.getUserActivities(userId, filter);
	}

	public UserActivity createUserActivity(Long userId, UserActivity userActivity) {
		return userActivityDao.createUserActivity(userId, userActivity);
	}

	public UserActivity getUserActivitiesByUserId(Long id) {
		return userActivityDao.getUserActivitiesByUserId(id);
	}

	public UserActivity updateUserActivity(UserActivity userActivity, Long userId) {
		return userActivityDao.updateUserActivity(userActivity, userId);
	}

	public void deleteUserActivity(Long id) {
		userActivityDao.deleteUserActivity(id);
	}

}
